package eternal0_1;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class PowerUps extends JPanel implements ActionListener {
    protected static BufferedImage healup;
    protected static BufferedImage powerup;
    protected static BufferedImage powerdown;
    protected static long lastPowerupTime;
    protected static int rand1;
    protected static int rand2;
    protected static int randomXCoor;
    protected static int yCoor;
    protected Timer powerupTimer;
    protected static boolean painted;
    protected static boolean poweredup;
    protected static String info;

    public PowerUps(){
        this.setSize(1280, 720);
        this.setOpaque(false);

        lastPowerupTime = 0;
        rand1 = 0;
        rand2 = 0;
        randomXCoor = 0;
        yCoor = 550;
        painted = false;
        poweredup = false;
        info = "";
        this.powerupTimer = new Timer(1000, this);

        try {
            InputStream url = this.getClass().getResourceAsStream("/healup.png");
            healup = ImageIO.read(url);
//            healup = ImageIO.read(new FileImageInputStream(new File("resources/healup.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream url = this.getClass().getResourceAsStream("/powerup.png");
            powerup = ImageIO.read(url);
//            powerup = ImageIO.read(new FileImageInputStream(new File("resources/powerup.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream url = this.getClass().getResourceAsStream("/powerdown.png");
            powerdown = ImageIO.read(url);
//            powerdown = ImageIO.read(new FileImageInputStream(new File("resources/powerdown.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        powerupTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(!poweredup){
            if(rand1 >= 8){
                if(rand2 == 1){
                    if (new Rectangle((int) SpaceShip.getSpaceShip_trX(), (int) SpaceShip.getSpaceShip_trY(), SpaceShip.getSpaceShipWidth(), SpaceShip.getSpaceShipHeight()).intersects(randomXCoor, yCoor, healup.getWidth(), healup.getHeight())) {
                        SpaceShip.setHP(SpaceShip.getHP() + 50);
                        info = "+50HP Gained!";
                        g.setColor(Color.white);
                        g.setFont(new Font("Tahoma", 1, 36));
                        g.drawString(info, 600, 400);
                        poweredup = true;
//                        System.out.println("Healed up! " + SpaceShip.getHP() + " " + SpaceShip.getAP());
                    } else{
                        g.drawImage(healup, randomXCoor, yCoor, null);
                    }
                } else if(rand2 == 2){
                    if (new Rectangle((int) SpaceShip.getSpaceShip_trX(), (int) SpaceShip.getSpaceShip_trY(), SpaceShip.getSpaceShipWidth(), SpaceShip.getSpaceShipHeight()).intersects(randomXCoor, yCoor, powerup.getWidth(), powerup.getHeight())) {
                        SpaceShip.setAP(SpaceShip.getAP() + 15);
                        info = "+15 Attack Power Gained!";
                        g.setColor(Color.white);
                        g.setFont(new Font("Tahoma", 1, 36));
                        g.drawString(info, 600, 400);
                        poweredup = true;
//                        System.out.println("Powered up! " + SpaceShip.getHP() + " " + SpaceShip.getAP());
                    } else {
                        g.drawImage(powerup, randomXCoor, yCoor, null);
                    }
                } else if (rand2 == 3) { //powerdown
                    if (new Rectangle((int) SpaceShip.getSpaceShip_trX(), (int) SpaceShip.getSpaceShip_trY(), SpaceShip.getSpaceShipWidth(), SpaceShip.getSpaceShipHeight()).intersects(randomXCoor, yCoor, powerdown.getWidth(), powerdown.getHeight())) {
                        SpaceShip.setAP(SpaceShip.getAP() - 10);
                        info = "-10 Attack Power Lost!";
                        g.setColor(Color.white);
                        g.setFont(new Font("Tahoma", 1, 36));
                        g.drawString(info, 600, 400);
                        poweredup = true;
//                        System.out.println("Powered down! " + SpaceShip.getHP() + " " + SpaceShip.getAP());
                    } else {
                        g.drawImage(powerdown, randomXCoor, yCoor, null);
                    }
                }
            }
        } else if(poweredup && rand2 == 1){
            info = "+50HP Gained!";
            g.setColor(Color.white);
            g.setFont(new Font("Tahoma", 1, 36));
            g.drawString(info, 600, 400);
        }
        else if (poweredup && rand2 == 2){
            info = "+15 Attack Power Gained!";
            g.setColor(Color.white);
            g.setFont(new Font("Tahoma", 1, 36));
            g.drawString(info, 600, 400);
        }
        else if (poweredup && rand2 == 3){
            info = "-10 Attack Power Lost!";
            g.setColor(Color.white);
            g.setFont(new Font("Tahoma", 1, 36));
            g.drawString(info, 600, 400);
        }
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        long convert = TimeUnit.SECONDS.convert(StartScreen.tempTime, TimeUnit.NANOSECONDS);

        if(convert %5 == 1){
            rand1 = (int)(Math.random() * 10) + 1;
            rand2 = (int)(Math.random() * 3) + 1; // which powerup-downs are shown
            randomXCoor = (int)(Math.random() * 1120) + 1; // x coor between 1-1120
//            String str = rand1 + " " + rand2 + " " + poweredup + " " + convert;
//            System.out.println(str);
            poweredup = false;
        }
        repaint();
    }
}
