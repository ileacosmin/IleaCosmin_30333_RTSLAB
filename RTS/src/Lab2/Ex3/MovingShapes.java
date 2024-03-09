package Lab2.Ex3;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MovingShapes extends JFrame {
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 600;
    private JPanel shapesPanel;
    public MovingShapes() {
        setTitle("Moving Shapes");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        shapesPanel = new JPanel();
        shapesPanel.setLayout(null);
        add(shapesPanel, BorderLayout.CENTER);

        createSquare(100, 50);
        createCircle(250, 50);
        createSquare(400, 50);
    }
    private void createSquare(int x, int y) {
        Shape square = new Shape(x, y,"s");
        shapesPanel.add(square);
        Thread thread = new Thread(new SquareThread(square));
        thread.start();
    }
    private void createCircle(int x, int y) {
        Shape square = new Shape(x, y,"c");
        shapesPanel.add(square);
        Thread thread = new Thread(new SquareThread(square));
        thread.start();
    }


}
