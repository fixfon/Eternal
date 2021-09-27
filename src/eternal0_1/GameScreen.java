package eternal0_1;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameScreen extends JFrame implements KeyListener, MouseMotionListener, MouseListener, ActionListener {
    //define variables
    private int mouse_X, mouse_Y;
    Timer fireTimer;

    //define components
    private javax.swing.JLabel close_icon;
    private javax.swing.JLabel minimize_icon;
    private javax.swing.JPanel dragPanel;
    private javax.swing.JPanel bgimage;
    private javax.swing.JPanel spaceShip1;
    private javax.swing.JPanel alienships;
    private javax.swing.JPanel powerups;
    private javax.swing.JLabel infoLabel;
    private String info;

    public GameScreen(){
        this.setMaximumSize(new Dimension(1280, 720));
        this.setMinimumSize(new Dimension(1280, 720));
        this.setUndecorated(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setFocusable(true);

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        components();

        this.setLocationRelativeTo(null);

        this.mouse_X = 0;
        this.mouse_Y = 0;
        this.info = "";


        if(StartScreen.getLevel() == 1){
            fireTimer = new Timer(16, this);
            fireTimer.start();
        }
        else if(StartScreen.getLevel() == 2){
            fireTimer = new Timer(12, this);
            fireTimer.start();
        }
        else if(StartScreen.getLevel() == 3){
            fireTimer = new Timer(8, this);
            fireTimer.start();
        }
    }

    private void components(){
        close_icon = new javax.swing.JLabel();
        minimize_icon = new javax.swing.JLabel();
        dragPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();

        close_icon.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        Border close_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        close_icon.setBorder(close_i_border);
        close_icon.setForeground(new java.awt.Color(255, 255, 255));
        close_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close_icon.setText("X");
        close_icon.setToolTipText(null);
        close_icon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        close_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_iconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_iconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_iconMouseExited(evt);
            }
        });
        getContentPane().add(close_icon);
        close_icon.setBounds(1200, 10, 50, 40);

        minimize_icon.setFont(new java.awt.Font("Kristen ITC", 1, 40)); // NOI18N
        Border minimize_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        minimize_icon.setBorder(minimize_i_border);
        minimize_icon.setForeground(new java.awt.Color(255, 255, 255));
        minimize_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize_icon.setText("-");
        minimize_icon.setToolTipText(null);
        minimize_icon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minimize_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize_iconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimize_iconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimize_iconMouseExited(evt);
            }
        });
        getContentPane().add(minimize_icon);
        minimize_icon.setBounds(1140, 10, 40, 40);

        dragPanel.setMaximumSize(new java.awt.Dimension(1280, 30));
        dragPanel.setMinimumSize(new java.awt.Dimension(1280, 30));
        dragPanel.setOpaque(false);
        dragPanel.setPreferredSize(new java.awt.Dimension(1280, 30));
        dragPanel.setFocusable(false);
        dragPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragPanelMouseDragged(evt);
            }
        });
        dragPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dragPanelMousePressed(evt);
            }
        });
        getContentPane().add(dragPanel);
        dragPanel.setBounds(0, 0, 1280, 30);

        spaceShip1 = new SpaceShip();
        getContentPane().add(spaceShip1);

        alienships = new AlienShipPaint();
        getContentPane().add(alienships);

        infoLabel.setBackground(new Color(0,0,0,125));
        infoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(204, 204, 204));
        infoLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(infoLabel);
        infoLabel.setBounds(1130, 610, 140, 95);
        infoLabel.setOpaque(true);

        bgimage = new BackgroundImage();
        getContentPane().add(bgimage);
        bgimage.setBounds(0, 0, 1280, 720);
        pack();
    }

    // frame events

    @Override
    public void actionPerformed(ActionEvent e) {

        StartScreen.tempTime = System.nanoTime();
        StartScreen.tempTime -= StartScreen.startTime;

        if(!SpaceShip.getFireBalls().isEmpty()){
            for (SS_FireBall fb : SpaceShip.getFireBalls()){
                fb.moveBall();
            }
        }
        boolean val = true;
        int k = 0;
        while (val){
            if(k < SpaceShip.getFireBalls().size()){
                SS_FireBall fb = SpaceShip.getFireBalls().get(k);
                if(fb.getXcoor() <= 0 || fb.getXcoor() >= 1250){
                    SpaceShip.getFireBalls().remove(fb);
                    k--;
                }
                else if(fb.getYcoor() <= 0 || fb.getYcoor() >=720){
                    SpaceShip.getFireBalls().remove(fb);
                    k--;
                }
                if(SpaceShip.getFireBalls().isEmpty()){
                    val = false;
                }
                k++;
            }
            else{
                break;
            }
        }

        if(SpaceShip.getHP() <= 0){
            fireTimer.stop();
            dispose();
            StartScreen.endScreen();
        }
        else if(AlienShipPaint.getAlienS_list().isEmpty()){
            fireTimer.stop();
            dispose();
            StartScreen.nextLevel();
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int typed = e.getKeyCode();

        if(typed == KeyEvent.VK_A){
            if(SpaceShip.getSpaceship_lastX() <= 0){
                SpaceShip.setSpaceship_lastX(0);
            }
            else{
                SpaceShip.setSpaceship_lastX(SpaceShip.getSpaceship_lastX() - SpaceShip.getSpaceShip_dirX());
            }
        }
        else if(typed == KeyEvent.VK_D){
            if(SpaceShip.getSpaceship_lastX() >= 1200){
                SpaceShip.setSpaceship_lastX(1200);
            }
            else{
                SpaceShip.setSpaceship_lastX(SpaceShip.getSpaceship_lastX() + SpaceShip.getSpaceShip_dirX());
            }
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent evt) {
        SpaceShip.setMouse_Xcoor(evt.getX());
        SpaceShip.setMouse_Ycoor(evt.getY());
        if(!SpaceShip.getFireBalls().isEmpty()){
            SS_FireBall fb = SpaceShip.getFireBalls().get(SpaceShip.getFireBalls().size() - 1);
            fb.setMouse_Xcoor(evt.getX());
            fb.setMouse_Ycoor(evt.getY());
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SpaceShip.getFireBalls().add(new SS_FireBall(SpaceShip.getSpaceShip_trX() + (Math.cos(Math.toRadians(SpaceShip.getDegrees())) * SpaceShip.spaceShip_image.getWidth()/2) - 15, SpaceShip.getSpaceShip_trY() + (Math.sin(Math.toRadians(SpaceShip.getDegrees())) * SpaceShip.spaceShip_image.getWidth()/2) - 15, e.getX(), e.getY()));
        SpaceShip.setSpent_fb(SpaceShip.getSpent_fb()+1);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent evt) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //component events
    private void minimize_iconMouseClicked(java.awt.event.MouseEvent evt) {
        this.setState(GameScreen.ICONIFIED);
    }

    private void minimize_iconMouseEntered(java.awt.event.MouseEvent evt) {
        Border minimize_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(95, 255, 255));
        minimize_icon.setBorder(minimize_i_border);
        minimize_icon.setForeground(new java.awt.Color(95, 255, 255));
    }

    private void minimize_iconMouseExited(java.awt.event.MouseEvent evt) {
        Border minimize_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255));
        minimize_icon.setBorder(minimize_i_border);
        minimize_icon.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void close_iconMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void close_iconMouseEntered(java.awt.event.MouseEvent evt) {

        Border close_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(95, 255, 255));
        close_icon.setBorder(close_i_border);
        close_icon.setForeground(new java.awt.Color(95, 255, 255));
    }

    private void close_iconMouseExited(java.awt.event.MouseEvent evt) {

        Border close_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255));
        close_icon.setBorder(close_i_border);
        close_icon.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void dragPanelMousePressed(java.awt.event.MouseEvent evt) {
        mouse_X = evt.getX();
        mouse_Y = evt.getY();
    }

    private void dragPanelMouseDragged(java.awt.event.MouseEvent evt) {
        this.setLocation(this.getX() + evt.getX() - mouse_X, this.getY() + evt.getY() - mouse_Y);
    }

    public static void main(String[] args) {
        GameScreen gs = new GameScreen();
        gs.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gs.setSize(1280, 720);
        gs.setVisible(true);

    }
}