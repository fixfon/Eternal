package eternal0_1;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AlienShip {
    protected int HP;
    protected int AP;
    protected ArrayList<Integer> initial_X_coors;
    protected int initial_Y_coor;
    protected int finalX;
    protected int randomNumber;
    protected ArrayList<AS_FireBall> ASFireBalls;
    protected BufferedImage alienShip_image;

    public AlienShip() {

        this.initial_Y_coor = 20;
        this.ASFireBalls = new ArrayList<AS_FireBall>();
        this.randomNumber = (int)(Math.random() * 10) + 1;

        if(StartScreen.getLevel() == 1){
            initial_X_coors = new ArrayList<Integer>();
            initial_X_coors.add(177);
            initial_X_coors.add(544);
            initial_X_coors.add(911);

            if(this.randomNumber <=7){
                this.HP = 275;
                this.AP = 30;
                try {
                    InputStream url = this.getClass().getResourceAsStream("/ufo2.png");
                    alienShip_image = ImageIO.read(url);
//                    alienShip_image = ImageIO.read(new FileImageInputStream(new File("resources/ufo2.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                this.HP = 325;
                this.AP = 40;
                try {
                    InputStream url = this.getClass().getResourceAsStream("/ufo1.png");
                    alienShip_image = ImageIO.read(url);
//                    alienShip_image = ImageIO.read(new FileImageInputStream(new File("resources/ufo1.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(StartScreen.getLevel() == 2){
            initial_X_coors = new ArrayList<Integer>();
            initial_X_coors.add(104);
            initial_X_coors.add(398);
            initial_X_coors.add(692);
            initial_X_coors.add(986);
            if(this.randomNumber <=6){
                this.HP = 275;
                this.AP = 30;
                try {
                    InputStream url = this.getClass().getResourceAsStream("/ufo2.png");
                    alienShip_image = ImageIO.read(url);
//                    alienShip_image = ImageIO.read(new FileImageInputStream(new File("resources/ufo2.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                this.HP = 325;
                this.AP = 40;
                try {
                    InputStream url = this.getClass().getResourceAsStream("/ufo1.png");
                    alienShip_image = ImageIO.read(url);
//                    alienShip_image = ImageIO.read(new FileImageInputStream(new File("resources/ufo1.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(StartScreen.getLevel() == 3){
            initial_X_coors = new ArrayList<Integer>();
            initial_X_coors.add(55);
            initial_X_coors.add(300);
            initial_X_coors.add(545);
            initial_X_coors.add(790);
            initial_X_coors.add(1035);
            if(this.randomNumber <=5){
                this.HP = 275;
                this.AP = 30;
                try {
                    InputStream url = this.getClass().getResourceAsStream("/ufo2.png");
                    alienShip_image = ImageIO.read(url);
//                    alienShip_image = ImageIO.read(new FileImageInputStream(new File("resources/ufo2.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                this.HP = 325;
                this.AP = 40;
                try {
                    InputStream url = this.getClass().getResourceAsStream("/ufo1.png");
                    alienShip_image = ImageIO.read(url);
//                    alienShip_image = ImageIO.read(new FileImageInputStream(new File("resources/ufo1.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAP() {
        return AP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }

    public ArrayList<Integer> getInitial_X_coors() {
        return initial_X_coors;
    }

    public void setInitial_X_coors(ArrayList<Integer> initial_X_coors) {
        this.initial_X_coors = initial_X_coors;
    }

    public int getInitial_Y_coor() {
        return initial_Y_coor;
    }

    public void setInitial_Y_coor(int initial_Y_coor) {
        this.initial_Y_coor = initial_Y_coor;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public BufferedImage getAlienShip_image() {
        return alienShip_image;
    }

    public void setAlienShip_image(BufferedImage alienShip_image) {
        this.alienShip_image = alienShip_image;
    }

    public ArrayList<AS_FireBall> getASFireBalls() {
        return ASFireBalls;
    }

    public void setASFireBalls(ArrayList<AS_FireBall> ASFireBalls) {
        this.ASFireBalls = ASFireBalls;
    }

    public void setFinalX(int finalX) {
        this.finalX = finalX;
    }

    public int getFinalX() {
        return finalX;
    }

    public int getAlienShipWidth(){
        return alienShip_image.getWidth();
    }

    public int getAlienShipHeight(){
        return alienShip_image.getHeight();
    }
}
