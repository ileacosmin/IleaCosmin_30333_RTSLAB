package Lab2.Ex3part2;

import Lab2.Ex3.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class ShapePanel extends JPanel {
    private List<Shape> shapes;

    public ShapePanel() {
        shapes = new ArrayList<>();
        // Add initial shapes
        for (int i = 0; i < 3; i++) {
            shapes.add(new Square());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public synchronized void moveShapes() {
        for (Shape shape : shapes) {
            shape.move();
        }
        repaint();
    }

    public synchronized void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    public synchronized void removeShape(Shape shape) {
        shapes.remove(shape);
        repaint();
    }
}