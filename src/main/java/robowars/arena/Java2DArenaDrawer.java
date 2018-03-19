package robowars.arena;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Java2DArenaDrawer extends JPanel {

    public static final BufferedImage ROBOT_IMG = loadImage("tank.png");
    private final JFrame frame;

    AffineTransform identity = new AffineTransform();

    private Arena arena;

    public Java2DArenaDrawer(Arena arena) {
        this.arena = arena;

        frame = new JFrame("Robo Wars");
        frame.setSize(arena.width, arena.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, arena.width, arena.height);
        for (Robot robot : arena.robots) {
            drawRobot(g, robot);
        }
        repaint();
    }

    private void drawRobot(Graphics g, Robot robot) {
        Graphics2D g2s = (Graphics2D) g;

        AffineTransform trans = new AffineTransform();
        trans.setTransform(identity);
        trans.translate(robot.x, robot.y);
        trans.rotate(robot.angle + Math.PI/2);
        trans.scale((double) arena.robotSize/ROBOT_IMG.getWidth(), (double) arena.robotSize/ROBOT_IMG.getHeight());
        trans.translate(-ROBOT_IMG.getWidth()/2, -ROBOT_IMG.getHeight()/2);

        g2s.drawImage(ROBOT_IMG, trans, null);

        g2s.drawString(robot.getName(), robot.x - arena.robotSize / 2, robot.y - arena.robotSize);
    }


    private static BufferedImage loadImage(String name) {
        try {
            String imgFileName = "images/" + name;
            return ImageIO.read(new File(imgFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
