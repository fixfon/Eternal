package eternal0_1;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;

public class StartScreen extends JFrame {
    private javax.swing.JPanel bgimage;
    private javax.swing.JPanel borderPanel;
    private javax.swing.JLabel close_icon;
    private javax.swing.JPanel dragPanel;
    private javax.swing.JLabel game_name;
    private javax.swing.JLabel game_name2;
    private javax.swing.JPanel insidePanel;
    private javax.swing.JLabel minimize_icon;
    private javax.swing.JTextField name_field;
    private javax.swing.JLabel name_label;
    private javax.swing.JLabel how_to_play;
    private javax.swing.JButton start_btn;

    private int m_X, m_Y;
    protected static String user_name;
    protected static int level;
    protected static int score;
    protected static long startTime;
    protected static long tempTime;
    protected static long endTime;
    protected static boolean result;

    public StartScreen() {
        level = 1;
        score = 0;
        startTime = 0;
        tempTime = 0;
        endTime = 0;
        result = false;

        Components();

        Border close_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        close_icon.setBorder(close_i_border);

        Border minimize_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        minimize_icon.setBorder(minimize_i_border);
//        Border border_pan = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white);
//        borderPanel.setBorder(border_pan);
    }

    private void Components(){
        borderPanel = new javax.swing.JPanel();
        dragPanel = new javax.swing.JPanel();
        insidePanel = new javax.swing.JPanel();
        minimize_icon = new javax.swing.JLabel();
        close_icon = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        how_to_play = new javax.swing.JLabel();
        name_field = new javax.swing.JTextField();
        start_btn = new javax.swing.JButton();
        game_name = new javax.swing.JLabel();
        game_name2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        borderPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        borderPanel.setMinimumSize(new java.awt.Dimension(1280, 720));
        borderPanel.setPreferredSize(new java.awt.Dimension(1280, 720));
        borderPanel.setLayout(null);

        dragPanel.setBackground(null);
        dragPanel.setToolTipText(null);
        dragPanel.setOpaque(false);
        dragPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                setLocation(getX() + evt.getX() - m_X, getY() + evt.getY() - m_Y);
            }
        });
        dragPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                m_X = evt.getX();
                m_Y = evt.getY();
            }
        });
        borderPanel.add(dragPanel);
        dragPanel.setBounds(0, 0, 1280, 20);

        insidePanel.setBackground(new java.awt.Color(255, 255, 255));
        insidePanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        insidePanel.setMinimumSize(new java.awt.Dimension(1280, 720));
        insidePanel.setPreferredSize(new java.awt.Dimension(1280, 720));
        insidePanel.setLayout(null);

        minimize_icon.setFont(new java.awt.Font("Kristen ITC", 1, 40)); // NOI18N
        minimize_icon.setForeground(new java.awt.Color(255, 255, 255));
        minimize_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize_icon.setText("-");
        minimize_icon.setToolTipText(null);
        minimize_icon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minimize_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setState(StartScreen.ICONIFIED);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Border minimize_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(95, 255, 255));
                minimize_icon.setBorder(minimize_i_border);
                minimize_icon.setForeground(new java.awt.Color(95, 255, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Border minimize_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255));
                minimize_icon.setBorder(minimize_i_border);
                minimize_icon.setForeground(new java.awt.Color(255, 255, 255));
            }
        });
        insidePanel.add(minimize_icon);
        minimize_icon.setBounds(1140, 10, 40, 40);

        close_icon.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        close_icon.setForeground(new java.awt.Color(255, 255, 255));
        close_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close_icon.setText("X");
        close_icon.setToolTipText(null);
        close_icon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        close_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Border close_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(95, 255, 255));
                close_icon.setBorder(close_i_border);
                close_icon.setForeground(new java.awt.Color(95, 255, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Border close_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255));
                close_icon.setBorder(close_i_border);
                close_icon.setForeground(new java.awt.Color(255, 255, 255));
            }
        });
        insidePanel.add(close_icon);
        close_icon.setBounds(1200, 10, 50, 40);

        how_to_play.setBackground(new Color(0,0,0,125));
        how_to_play.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        how_to_play.setForeground(new java.awt.Color(204, 204, 204));
        how_to_play.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insidePanel.add(how_to_play);
        how_to_play.setBounds(20, 500, 200, 200);
        how_to_play.setText("<html>" + "<body>" +
                "<h1 style=\"text-align:center\">How to Play</h1><br>" +
                "<h3>Left Movement: A</h3>" +
                "<h3>Right Movement: D</h3>" +
                "<h3>Shooting: Mouse Click</h3>" + "</body>" +
                "</html>");
        how_to_play.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        how_to_play.setOpaque(true);

        name_label.setBackground(new Color(0,0,0,125));
        name_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        name_label.setForeground(new java.awt.Color(204, 204, 204));
        name_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name_label.setText("Enter Your Name");
        name_label.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insidePanel.add(name_label);
        name_label.setBounds(575, 490, 130, 30);
        name_label.setOpaque(true);

        name_field.setBackground(new Color(0,0,0,110));
        name_field.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name_field.setForeground(new java.awt.Color(255, 255, 255));
        name_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        insidePanel.add(name_field);
        name_field.setBounds(560, 550, 160, 30);
        name_field.setOpaque(false);

        start_btn.setBackground(new Color(102,102,102,85));
        start_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        start_btn.setForeground(new java.awt.Color(255, 255, 255));
        start_btn.setText("Start Game");
        start_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        start_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        start_btn.setMaximumSize(new java.awt.Dimension(150, 40));
        start_btn.setMinimumSize(new java.awt.Dimension(150, 40));
        start_btn.setOpaque(false);
        start_btn.setPreferredSize(new java.awt.Dimension(150, 40));
        start_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(name_field.getText().equals("")){
                    JOptionPane.showMessageDialog(getContentPane(), "Please enter a name.");
                }
                else{
                    user_name = name_field.getText();
                    setVisible(false);
                    if(level == 1){
                        startTime = System.nanoTime();
                        GameScreen newGame = new GameScreen();
                        newGame.setVisible(true);
                    }
                }
            }
        });
        insidePanel.add(start_btn);
        start_btn.setBounds(565, 610, 150, 40);

        game_name.setBackground(new java.awt.Color(255, 255, 255));
        game_name.setFont(new java.awt.Font("Kristen ITC", 1, 52)); // NOI18N
        game_name.setForeground(new java.awt.Color(204, 204, 204));
        game_name.setText("Eternal");
        game_name.setPreferredSize(new java.awt.Dimension(120, 50));
        insidePanel.add(game_name);
        game_name.setBounds(540, 90, 200, 50);

        game_name2.setBackground(new java.awt.Color(255, 255, 255));
        game_name2.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        game_name2.setForeground(new java.awt.Color(204, 204, 204));
        game_name2.setText("We must protect our world!");
        game_name2.setPreferredSize(new java.awt.Dimension(120, 50));
        insidePanel.add(game_name2);
        game_name2.setBounds(450, 160, 380, 25);

        bgimage = new BackgroundImage();
        insidePanel.add(bgimage);
        bgimage.setBounds(0, 0, 1280, 720);

        borderPanel.add(insidePanel);
        insidePanel.setBounds(0, 0, 1280, 720);

        getContentPane().add(borderPanel);
        borderPanel.setBounds(0, 0, 1280, 720);

        pack();
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int levell) {
        level = levell;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        StartScreen.score = score;
    }

    public static String getUser_name() {
        return user_name;
    }

    public static boolean isResult() {
        return result;
    }

    public static void setResult(boolean result) {
        StartScreen.result = result;
    }

    public static void nextLevel(){
        if (StartScreen.getLevel() == 1){
            StartScreen.setScore(StartScreen.getScore() + 50);
            StartScreen.setLevel(2);
            GameScreen level2 = new GameScreen();
            level2.setVisible(true);
        }
        else if(StartScreen.getLevel() == 2){
            StartScreen.setScore(StartScreen.getScore() + 55);
            StartScreen.setLevel(3);
            GameScreen level3 = new GameScreen();
            level3.setVisible(true);
        }
        else if(StartScreen.getLevel() == 3){
            StartScreen.setScore(StartScreen.getScore() + 60);
            StartScreen.endScreen();
        }
    }

    public static void endScreen(){ // end frame screen.
        if(AlienShipPaint.getAlienS_list().isEmpty() && SpaceShip.getHP() > 0){
            setResult(true);
            EndScreen win = new EndScreen();
            win.setVisible(true);
        }
        else{
            setResult(false);
            EndScreen lose = new EndScreen();
            lose.setVisible(true);
        }
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartScreen().setVisible(true);
            }
        });
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
