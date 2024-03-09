package Lab2.Ex3part2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        ShapePanel shapePanel = new ShapePanel();
        frame.add(shapePanel);

        frame.setVisible(true);

        // Start the threads for moving shapes
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new ShapeThread(shapePanel));
            thread.start();
        }
    }
}
