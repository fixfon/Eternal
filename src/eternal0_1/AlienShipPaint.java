package eternal0_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AlienShipPaint extends JPanel implements ActionListener{
    private static ArrayList<AlienShip> alienS_list;
    private static int alienShipTurn;
    private static AlienShip tempAS;
    private Timer asFireTimer;

    public AlienShipPaint(){
        alienS_list = new ArrayList<AlienShip>();
        this.setSize(1280, 720);
        this.setOpaque(false);
        tempAS = null;
        alienShipTurn = 1;

        if(StartScreen.getLevel() == 1){
            asFireTimer = new Timer(15, this);
            asFireTimer.start();
            for (int i = 0; i < 3; i++) {
                alienS_list.add(new AlienShip());
                alienS_list.get(i).setFinalX(alienS_list.get(i).getInitial_X_coors().get(i));
            }
        }
        else if(StartScreen.getLevel() == 2){
            asFireTimer = new Timer(8, this);
            asFireTimer.start();
            for (int i = 0; i < 4; i++) {
                alienS_list.add(new AlienShip());
                alienS_list.get(i).setFinalX(alienS_list.get(i).getInitial_X_coors().get(i));
            }
        }
        else if(StartScreen.getLevel() == 3){
            asFireTimer = new Timer(5, this);
            asFireTimer.start();
            for (int i = 0; i < 5; i++) {
                alienS_list.add(new AlienShip());
                alienS_list.get(i).setFinalX(alienS_list.get(i).getInitial_X_coors().get(i));
            }
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(48, 179, 222));
        if(!alienS_list.isEmpty()){
            for (int i = 0; i < alienS_list.size(); i++) {

                g.drawImage(alienS_list.get(i).getAlienShip_image(), alienS_list.get(i).getFinalX(), alienS_list.get(i).getInitial_Y_coor(), null);

                if(!alienS_list.get(i).getASFireBalls().isEmpty()){
                    for (int j = 0; j < alienS_list.get(i).getASFireBalls().size(); j++) {
                        g.fillOval((int)alienS_list.get(i).getASFireBalls().get(j).getX(), (int)alienS_list.get(i).getASFireBalls().get(j).getY(), 20, 20);
                        //giving damage to spaceship
                        if(new Rectangle((int) alienS_list.get(i).getASFireBalls().get(j).getX(), (int) alienS_list.get(i).getASFireBalls().get(j).getY(), 20, 20).intersects(new Rectangle((int)SpaceShip.getSpaceShip_trX(), (int)SpaceShip.getSpaceShip_trY(), SpaceShip.getSpaceShipWidth() - 15, SpaceShip.getSpaceShipHeight() - 15))){
                            alienS_list.get(i).getASFireBalls().remove(j);
                            j--;
                            SpaceShip.setHP(SpaceShip.getHP() - alienS_list.get(i).getAP());
                        }
                    }
                }
            }
        }
    }

    public static ArrayList<AlienShip> getAlienS_list() {
        return alienS_list;
    }

    public static void setAlienS_list(ArrayList<AlienShip> alienS_listt) {
        alienS_list = alienS_listt;
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(!alienS_list.isEmpty() && alienShipTurn <= alienS_list.size()){

            if(alienS_list.get(alienShipTurn - 1).getASFireBalls().isEmpty()){
                alienS_list.get(alienShipTurn-1).getASFireBalls().add(new AS_FireBall(alienS_list.get(alienShipTurn - 1).getFinalX() + alienS_list.get(alienShipTurn - 1).getAlienShip_image().getWidth() / 2d - 12, alienS_list.get(alienShipTurn - 1).getInitial_Y_coor() + alienS_list.get(alienShipTurn - 1).getAlienShip_image().getWidth() / 2d + 5, SpaceShip.getSpaceShip_trX() + (Math.cos(Math.toRadians(SpaceShip.getDegrees())) * SpaceShip.spaceShip_image.getWidth()/2), SpaceShip.getSpaceShip_trY() + (Math.sin(Math.toRadians(SpaceShip.getDegrees())) * SpaceShip.spaceShip_image.getWidth()/2d)));

            }
            for (int j = 0; j < alienS_list.get(alienShipTurn-1).getASFireBalls().size(); j++) {

                alienS_list.get(alienShipTurn-1).getASFireBalls().get(j).moveBall();
            }

            if(alienS_list.get(alienShipTurn-1).equals(alienS_list.get(alienS_list.size()-1))){
                alienShipTurn = 1;
            }
            else{
                alienShipTurn++;
            }

            boolean val = true;
            int j = 0;
            while (val){
                if(j < alienS_list.get(alienShipTurn - 1).getASFireBalls().size() && !alienS_list.get(alienShipTurn - 1).equals(tempAS)){
                    AS_FireBall fb = alienS_list.get(alienShipTurn - 1).getASFireBalls().get(j);
                    if(fb.getX() <= 0 || fb.getX() >= 1280){
                        alienS_list.get(alienShipTurn - 1).getASFireBalls().remove(fb);
                        j--;
                    }
                    else if(fb.getY() <= 0 || fb.getY() >=700){
                        alienS_list.get(alienShipTurn - 1).getASFireBalls().remove(fb);
                        j--;
                    }
                    j++;
                    if(j > alienS_list.size()){
                        break;
                    }
                    else if(alienS_list.get(alienShipTurn - 1).getASFireBalls().isEmpty()){
                        val = false;
                    }
                }
                else{
                    break;
                }
            }

            if(StartScreen.getLevel() == 1 && alienS_list.size() < 2){
                asFireTimer.setDelay(25);
            }
            else if(StartScreen.getLevel() == 2 && alienS_list.size() <= 2){
                asFireTimer.setDelay(15);
            }
            else if(StartScreen.getLevel() == 3 && alienS_list.size() <= 3){
                asFireTimer.setDelay(12);
            }
        }
        else if(alienS_list.isEmpty()){
            asFireTimer.stop();
        }
        repaint();
    }

    public static int getAlienShipTurn() {
        return alienShipTurn;
    }

    public static void setAlienShipTurn(int alienShipTurn) {
        AlienShipPaint.alienShipTurn = alienShipTurn;
    }

    public static AlienShip getTempAS() {
        return tempAS;
    }

    public static void setTempAS(AlienShip tempAS) {
        AlienShipPaint.tempAS = tempAS;
    }
}
