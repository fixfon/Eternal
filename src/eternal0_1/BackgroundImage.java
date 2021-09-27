package eternal0_1;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackgroundImage extends JPanel {
    Image bgImage;

    public BackgroundImage(){
        this.setFocusable(false);

        try {
            InputStream url = this.getClass().getResourceAsStream("/background.jpg");
            bgImage = ImageIO.read(url);
//            bgImage = ImageIO.read(new FileImageInputStream(new File("resources/background.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(BackgroundImage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bgImage, 0, 0, this);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

}
