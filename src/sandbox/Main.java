package sandbox;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Dimension size = new Dimension(640, 480);
        frame.setPreferredSize(size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        MyPanel panel = new MyPanel(image);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        for (int i = 0; i < 300; i++) {
            image.setRGB(i, i, Color.RED.getRGB());

            frame.update(frame.getGraphics());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyPanel extends JPanel {

    private BufferedImage image;

    MyPanel(BufferedImage image) {
        this.image = image;
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}