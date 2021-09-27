package eternal0_1;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class EndScreen extends JFrame {
    private javax.swing.JPanel bgimage;
    private javax.swing.JLabel close_icon;
    private javax.swing.JLabel minimize_icon;
    private javax.swing.JPanel dragPanel;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JLabel result_info;
    private javax.swing.JLabel statement_info;
    private javax.swing.JLabel username_info;
    private javax.swing.JLabel score_info;
    private javax.swing.JLabel time_info;


    private int mouse_X, mouse_Y;
    private long elapsedTime; // for gaining score with elapsed timae.
    private int finalScore;

    public EndScreen(){
        elapsedTime = 0;
        long tempTime = TimeUnit.SECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
        elapsedTime = tempTime - TimeUnit.SECONDS.convert(StartScreen.startTime, TimeUnit.NANOSECONDS);;

        finalScore = StartScreen.getScore() + 1000/(int)elapsedTime;
        Components();

        Border close_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        close_icon.setBorder(close_i_border);

        Border minimize_i_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        minimize_icon.setBorder(minimize_i_border);
    }

    private void Components(){
        close_icon = new javax.swing.JLabel();
        minimize_icon = new javax.swing.JLabel();
        dragPanel = new javax.swing.JPanel();
        resultPanel = new javax.swing.JPanel();
        result_info = new javax.swing.JLabel();
        statement_info = new javax.swing.JLabel();
        username_info = new javax.swing.JLabel();
        score_info = new javax.swing.JLabel();
        time_info = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

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

        resultPanel.setMaximumSize(new java.awt.Dimension(950, 500));
        resultPanel.setMinimumSize(new java.awt.Dimension(950, 500));
        resultPanel.setPreferredSize(new java.awt.Dimension(950, 500));
        resultPanel.setFocusable(false);
        resultPanel.setBackground(new Color(0,0,0,140));
        resultPanel.setLayout(null);

        result_info.setFont(new java.awt.Font("Kristen ITC", 1, 52)); // NOI18N
        result_info.setForeground(Color.white);
        result_info.setPreferredSize(new java.awt.Dimension(180, 52));
        resultPanel.add(result_info);
        result_info.setBounds(260,20,180,52);

        username_info.setFont(new java.awt.Font("Kristen ITC", 1, 36)); // NOI18N
        username_info.setForeground(Color.white);
        username_info.setPreferredSize(new java.awt.Dimension(200, 36));
        resultPanel.add(username_info);
        username_info.setBounds(250,120,200,36);

        statement_info.setFont(new java.awt.Font("Kristen ITC", 1, 20)); // NOI18N
        statement_info.setForeground(Color.white);
        statement_info.setPreferredSize(new java.awt.Dimension(520, 20));
        resultPanel.add(statement_info);
        statement_info.setBounds(90,180,520,20);
        if(StartScreen.isResult()){
            result_info.setText("WIN!");
            username_info.setText(StartScreen.getUser_name() + "!");
            statement_info.setText("Eternal War is over! The enemy has been defeated!");
        }
        else{
            result_info.setText("LOSE!");
            username_info.setText(StartScreen.getUser_name() + "!");
            statement_info.setText("Eternal War is over. Our only planet has been lost!");
        }

        score_info.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        score_info.setForeground(Color.white);
        score_info.setPreferredSize(new java.awt.Dimension(120, 18));
        score_info.setText("Your Score: " + finalScore + " points");
        resultPanel.add(score_info);
        score_info.setBounds(40,250,300,16);

        time_info.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        time_info.setForeground(Color.white);
        time_info.setPreferredSize(new java.awt.Dimension(280, 18));
        time_info.setText("Elapsed Time: " + elapsedTime + " seconds");
        resultPanel.add(time_info);
        time_info.setBounds(40,280,300,16);

        getContentPane().add(resultPanel);
        resultPanel.setBounds(290, 160, 700, 320);

        bgimage = new BackgroundImage();
        getContentPane().add(bgimage);
        bgimage.setBounds(0, 0, 1280, 720);

        pack();

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
        EndScreen end = new EndScreen();
        end.setDefaultCloseOperation(EXIT_ON_CLOSE);
        end.setSize(1280, 720);
        end.setVisible(true);

    }
}
