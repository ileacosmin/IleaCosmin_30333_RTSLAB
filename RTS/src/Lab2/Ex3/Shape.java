package Lab2.Ex3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Shape extends JPanel {
    private int x, y;
    private String shapeType;

    private final int SHAPE_SIZE = 50;
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 6;

    public Shape(int x, int y, String shape) {
        this.x = x;
        this.y = y;
        this.shapeType = shape;
        setPreferredSize(new Dimension(SHAPE_SIZE, SHAPE_SIZE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (shapeType.equals("s")) {
            g.setColor(Color.RED);
            g.fillRect(0, 0, getWidth(), getHeight());
        } else if (shapeType.equals("c")) {
            g.setColor(Color.BLUE);
            g.fillOval(0, 0, getWidth(), getHeight());
        }
    }

    public void move() {
        int speed = new Random().nextInt(MAX_SPEED - MIN_SPEED + 1) + MIN_SPEED;
        y += speed;
        setBounds(x, y, SHAPE_SIZE, SHAPE_SIZE);
    }
}
