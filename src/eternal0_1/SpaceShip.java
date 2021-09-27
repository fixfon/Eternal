package eternal0_1;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SpaceShip extends JPanel{

    protected static int HP;
    protected static int AP;
    protected static int spaceShip_inX;
    protected static int spaceShip_y;
    protected static int spaceship_lastX;
    protected static int spaceShip_dirX;
    protected static double spaceShip_trX;
    protected static double spaceShip_trY;
    protected static double degrees;
    protected static double angleTheta;
    protected static int mouse_Xcoor;
    protected static int mouse_Ycoor;
    protected static ArrayList<SS_FireBall> SSFireBalls;
    protected static int spent_fb;
    protected static BufferedImage spaceShip_image;

    public SpaceShip(){
        HP = 350;
        AP = 35;
        spaceShip_inX = 580;
        spaceShip_y = 510;
        spaceship_lastX = spaceShip_inX;
        spaceShip_dirX = 10;
        degrees = 0;
        mouse_Xcoor = 0;
        mouse_Ycoor = 0;
        SSFireBalls = new ArrayList<SS_FireBall>();
        spent_fb = 0;
        this.setSize(1280, 720);
        this.setOpaque(false);

        try {
            InputStream url = this.getClass().getResourceAsStream("/uzaygemisi.png");
            spaceShip_image = ImageIO.read(url);
//            spaceShip_image = ImageIO.read(new FileImageInputStream(new File("resources/uzaygemisi.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void calculateRadian(){
        double deltaX = mouse_Xcoor - spaceship_lastX - (spaceShip_image.getWidth() / 2f);
        double deltaY = mouse_Ycoor - spaceShip_y;

        double theta = Math.atan2(deltaY, deltaX);
        theta += Math.PI/2d;
        angleTheta = theta;
        degrees = Math.toDegrees(theta);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;

        AffineTransform tr = new AffineTransform();
        calculateRadian();

        if (degrees > -90 && degrees < 90){
            tr.translate(spaceship_lastX, spaceShip_y);
            tr.rotate(
                    Math.toRadians(degrees),
                    spaceShip_image.getWidth() / 2f,
                    spaceShip_image.getHeight() / 2f
            );
        }
        else if (degrees >= 90 && degrees <= 180){
            degrees = 90;
            tr.translate(spaceship_lastX, spaceShip_y);
            tr.rotate(
                    Math.toRadians(degrees),
                    spaceShip_image.getWidth() / 2f,
                    spaceShip_image.getHeight() / 2f
            );
        }
        else if (degrees <= -90 || degrees > 180){
            degrees = -90;
            tr.translate(spaceship_lastX, spaceShip_y);
            tr.rotate(
                    Math.toRadians(degrees),
                    spaceShip_image.getWidth() / 2f,
                    spaceShip_image.getHeight() / 2f
            );
        }
        g2d.drawImage(spaceShip_image, tr, null);
        spaceShip_trX = tr.getTranslateX();
        spaceShip_trY = tr.getTranslateY();

        printInfoToScreen(g2d);

        g.setColor(Color.ORANGE);
        if(!SSFireBalls.isEmpty()){
            for(SS_FireBall fb : SSFireBalls){
                g.fillOval((int)fb.getXcoor(), (int)fb.getYcoor(), 20, 20);
            }
        }

        boolean val2 = true;
        int l = 0;
        while(val2){
            if(l < SpaceShip.getFireBalls().size()){
                SS_FireBall fb = SpaceShip.getFireBalls().get(l);
                if(!AlienShipPaint.getAlienS_list().isEmpty()){
                    boolean val3 = true;
                    int y = 0;
                    while(val3){
                        if(y < AlienShipPaint.getAlienS_list().size()){
                            AlienShip as = AlienShipPaint.getAlienS_list().get(y);

                            if(new Rectangle(as.getFinalX(),as.getInitial_Y_coor(), as.getAlienShipWidth() - 25, as.getAlienShipHeight() - 25).intersects(new Rectangle((int)fb.getXcoor(), (int)fb.getYcoor(), 20, 20))){

                                as.setHP(as.getHP() - SpaceShip.getAP());
                                StartScreen.setScore(StartScreen.getScore() + 20);
                                if(as.getHP() <= 0){
                                    StartScreen.setScore(StartScreen.getScore() + 35);
                                    AlienShipPaint.setTempAS(AlienShipPaint.getAlienS_list().get(y));
                                    AlienShipPaint.setAlienShipTurn(1);
                                    AlienShipPaint.getAlienS_list().remove(y);
                                    y--;
                                }
                                SpaceShip.getFireBalls().remove(l);
                                l--;
                                if(SpaceShip.getFireBalls().isEmpty()){
                                    val2 = false;
                                    val3 = false;
                                }
                            }
                            y++;
                        }
                        else{
                            break;
                        }
                    }
                }
                l++;
            }
            else{
                break;
            }
        }
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public static void printInfoToScreen(Graphics g){
        int degreeint = (int) degrees;
        long convert = TimeUnit.SECONDS.convert(StartScreen.tempTime, TimeUnit.NANOSECONDS);
        g.setFont(new java.awt.Font("Tahoma", 1, 14));
        g.setColor(Color.WHITE);

        String info = "HP: " + SpaceShip.getHP();
        g.drawString(info, 1140, 630);

        info = "Degree: " + degreeint;
        g.drawString(info, 1140, 650);

        info = "Score: " + StartScreen.getScore();
        g.drawString(info, 1140, 670);

        info = "Elapsed Time: " + convert;
        g.drawString(info, 1140, 690);
    }

    //* get and set methods.
    public static int getHP() {
        return HP;
    }

    public static void setHP(int HP) {
        SpaceShip.HP = HP;
    }

    public static int getAP() {
        return AP;
    }

    public static void setAP(int AP) {
        SpaceShip.AP = AP;
    }

    public static int getSpaceShip_inX() {
        return spaceShip_inX;
    }

    public static void setSpaceShip_inX(int spaceShip_inX) {
        SpaceShip.spaceShip_inX = spaceShip_inX;
    }

    public static int getSpaceShip_y() {
        return spaceShip_y;
    }

    public static void setSpaceShip_y(int spaceShip_y) {
        SpaceShip.spaceShip_y = spaceShip_y;
    }

    public static int getSpaceship_lastX() {
        return spaceship_lastX;
    }

    public static void setSpaceship_lastX(int spaceship_lastX) {
        SpaceShip.spaceship_lastX = spaceship_lastX;
    }

    public static int getSpaceShip_dirX() {
        return spaceShip_dirX;
    }

    public static void setSpaceShip_dirX(int spaceShip_dirX) {
        SpaceShip.spaceShip_dirX = spaceShip_dirX;
    }

    public static double getDegrees() {
        return degrees;
    }

    public static void setDegrees(double degrees) {
        SpaceShip.degrees = degrees;
    }

    public static int getMouse_Xcoor() {
        return mouse_Xcoor;
    }

    public static void setMouse_Xcoor(int mouse_X) {
        SpaceShip.mouse_Xcoor = mouse_X;
    }

    public static int getMouse_Ycoor() {
        return mouse_Ycoor;
    }

    public static void setMouse_Ycoor(int mouse_Y) {
        SpaceShip.mouse_Ycoor = mouse_Y;
    }

    public static int getSpaceShipWidth(){return spaceShip_image.getWidth();}

    public static int getSpaceShipHeight(){return spaceShip_image.getHeight();}

    public static ArrayList<SS_FireBall> getFireBalls() {
        return SSFireBalls;
    }

    public static void setFireBalls(ArrayList<SS_FireBall> SSFireBalls) {
        SpaceShip.SSFireBalls = SSFireBalls;
    }

    public static int getSpent_fb() {
        return spent_fb;
    }

    public static void setSpent_fb(int spent_fb) {
        SpaceShip.spent_fb = spent_fb;
    }

    public static double getSpaceShip_trX() {
        return spaceShip_trX;
    }

    public static void setSpaceShip_trX(double spaceShip_trX) {
        SpaceShip.spaceShip_trX = spaceShip_trX;
    }

    public static double getSpaceShip_trY() {
        return spaceShip_trY;
    }

    public static void setSpaceShip_trY(double spaceShip_trY) {
        SpaceShip.spaceShip_trY = spaceShip_trY;
    }
}
