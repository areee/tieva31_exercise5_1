
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 *
 * @author ylhaart
 */
public class Painting extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int size = Math.min(getWidth(), getHeight()) / 2;

        drawHouse(g2, size);
        g2.translate(size, 0);
        drawHouse(g2, size);
        g2.translate(size, 0);
        drawHouse(g2, size);

    }

    private void drawHouse(Graphics2D g2, int size) {
        AffineTransform transform = g2.getTransform();

        g2.scale(size / 16.0, size / 16.0);

        // draw the roof:
        DrawTriangle(g2);

        // draw the walls:
        drawSquare(g2);

        g2.setTransform(transform);
    }

    private void drawSquare(Graphics2D g2) {
        g2.setColor(Color.blue);
        g2.fillRect(2, 10, 10, 10);
    }

    private void DrawTriangle(Graphics2D g2) {
        g2.setColor(Color.orange);
        int[] xPoints = new int[]{2, 7, 12};
        int[] yPoints = new int[]{10, 2, 10};
        g2.fillPolygon(xPoints, yPoints, 3);
    }
}
