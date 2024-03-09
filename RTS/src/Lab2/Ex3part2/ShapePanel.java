package Lab2.Ex3part2;
import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


class ShapePanel extends JPanel {
    private static final int NUM_SHAPES = 3;
    private static final int MAX_SPEED = 7;
    private static final int MIN_SPEED = 3;

    private Thread[] shapeThreads;
    private Shape[] shapes;

    public ShapePanel() {
        setPreferredSize(new Dimension(400, 400)); // Fixed size window
        setBackground(Color.WHITE);

        shapes = new Shape[NUM_SHAPES];
        shapeThreads = new Thread[NUM_SHAPES];

        for (int i = 0; i < NUM_SHAPES; i++) {
            shapes[i] = new Shape(20 + 150 * i); // Fixed x-coordinate
            shapeThreads[i] = new Thread(new ShapeMover(shapes[i]));
        }
    }

    public void start() {
        for (Thread thread : shapeThreads) {
            thread.start();
        }
    }
    public void stop() {
        System.exit(0);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    private class Shape {
        private int x, y;
        private int speed;

        public Shape(int initialX) {
            this.x = initialX;
            this.y = 0;
            this.speed = new Random().nextInt(MAX_SPEED - MIN_SPEED + 1) + MIN_SPEED;
        }

        public void move() {
            y += speed;
        }

        public void draw(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, 50, 50);
        }

        public boolean isOutOfBounds(int height) {
            return y > height;
        }

        public void reset(int height) {
            y = -50; // Reset y-coordinate above the window
            speed = new Random().nextInt(MAX_SPEED - MIN_SPEED + 1) + MIN_SPEED; // Randomize speed again
        }
    }

    private class ShapeMover implements Runnable {
        private Shape shape;
        private int n;

        public ShapeMover(Shape shape) {
            this.shape = shape;
            this.n=0;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    shape.move();
                    if (shape.isOutOfBounds(getHeight())) {
                        shape.reset(getHeight());
                        n++;
                        // Stop the thread for this shape
                        Thread.currentThread().interrupt();
                        // Create a new thread for this shape
                        Thread newThread = new Thread(new ShapeMover(shape));
                        newThread.start();
                        // Exit the current thread
                        return;
                    }
                    if(n>3)
                        stop();
                    repaint();
                    Thread.sleep(5); // Adjust this to control speed
                }
            } catch (InterruptedException e) {
                // Thread interrupted, stopping movement
            }
        }
    }
}