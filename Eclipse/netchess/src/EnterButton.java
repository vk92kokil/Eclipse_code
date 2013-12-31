import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EnterButton extends JButton {

    private Polygon shape;

    public EnterButton() {
        this.shape = new Polygon();
        // initialisiere Form
        this.initialize();
    }

    protected void initialize() {
        Point p1, p2, p3, p4, p5, p6;

        this.setSize(90, 120);

        p1 = new Point(0, 0);
        p2 = new Point(0, 60);
        p3 = new Point(30, 60);
        p4 = new Point(30, 120);
        p5 = new Point(90, 120);
        p6 = new Point(90, 0);

        this.shape.addPoint((int) Math.round(p1.getX()),
                (int) Math.round(p1.getY()));
        this.shape.addPoint((int) Math.round(p2.getX()),
                (int) Math.round(p2.getY()));
        this.shape.addPoint((int) Math.round(p3.getX()),
                (int) Math.round(p3.getY()));
        this.shape.addPoint((int) Math.round(p4.getX()),
                (int) Math.round(p4.getY()));
        this.shape.addPoint((int) Math.round(p5.getX()),
                (int) Math.round(p5.getY()));
        this.shape.addPoint((int) Math.round(p6.getX()),
                (int) Math.round(p6.getY()));
        this.setMinimumSize(this.getSize());
        this.setMaximumSize(this.getSize());
        this.setPreferredSize(this.getSize());
    }

    // Hit detection
    public boolean contains(int x, int y) {
        return this.shape.contains(x, y);
    }

    // Zeichne den Button
    protected void paintComponent(Graphics g) {
        Graphics2D gCopy = (Graphics2D) g.create();
        gCopy.fillPolygon(this.shape);

    }

    // zeichne die Border
    protected void paintBorder(Graphics g) {

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        EnterButton button = new EnterButton();

        panel.add(button);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);

    }

}