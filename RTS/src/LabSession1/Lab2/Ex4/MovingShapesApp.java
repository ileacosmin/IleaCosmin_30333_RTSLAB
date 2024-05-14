package LabSession1.Lab2.Ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MovingShapesApp extends JFrame {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;
    private static final int SQUARE_SIZE = 50;
    private static final int TANK_SIZE = 50;

    private Square[] squares;
    private Tank tank;
    private int score;
    private int gameCount;

    public MovingShapesApp() {
        setTitle("Moving Shapes");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        squares = new Square[3];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square();
            Thread thread = new Thread(squares[i]);
            thread.start();
        }

        tank = new Tank();
        addKeyListener(new TankKeyListener());

        Thread supervisorThread = new Thread(new Supervisor());
        supervisorThread.start();

        score = 0;
        gameCount = 0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Square square : squares) {
            square.draw(g);
        }
        tank.draw(g);
    }

    private class Square implements Runnable {
        private int x;
        private int y;
        private int dx;
        private int dy;
        private boolean alive;

        public Square() {
            Random random = new Random();
            x = random.nextInt(WINDOW_WIDTH - SQUARE_SIZE);
            y = random.nextInt(WINDOW_HEIGHT - SQUARE_SIZE);
            dx = random.nextInt(5) + 1;
            dy = random.nextInt(5) + 1;
            alive = true;
        }

        public void draw(Graphics g) {
            if (alive) {
                g.setColor(Color.RED);
                g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
            }
        }

        @Override
        public void run() {
            while (alive) {
                move();
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void move() {
            x += dx;
            y += dy;
            if (x <= 0 || x >= WINDOW_WIDTH - SQUARE_SIZE) {
                dx = -dx;
            }
            if (y <= 0 || y >= WINDOW_HEIGHT - SQUARE_SIZE) {
                dy = -dy;
            }
            if (x < -SQUARE_SIZE || x > WINDOW_WIDTH || y < -SQUARE_SIZE || y > WINDOW_HEIGHT) {
                x = WINDOW_WIDTH / 2;
                y = WINDOW_HEIGHT / 2;
            }
        }

        public void shoot() {
            alive = false;
            score++;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, SQUARE_SIZE, SQUARE_SIZE);
        }
    }

    private class Tank {
        private int x;
        private final int y = WINDOW_HEIGHT - TANK_SIZE - 10;
        private final int speed = 5;

        public Tank() {
            x = WINDOW_WIDTH / 2 - TANK_SIZE / 2;
        }

        public void moveLeft() {
            if (x > 0)
                x -= speed;
        }

        public void moveRight() {
            if (x < WINDOW_WIDTH - TANK_SIZE)
                x += speed;
        }

        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, TANK_SIZE, TANK_SIZE);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, TANK_SIZE, TANK_SIZE);
        }
    }

    private class TankKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                tank.moveLeft();
            } else if (key == KeyEvent.VK_RIGHT) {
                tank.moveRight();
            } else if (key == KeyEvent.VK_SPACE) {
                for (Square square : squares) {
                    if (square.getBounds().intersects(tank.getBounds())) {
                        square.shoot();
                        break;
                    }
                }
            }
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }

    private class Supervisor implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (gameCount >= 3) {
                    JOptionPane.showMessageDialog(null, "Game Over! You have played three times.");
                    break;
                }
                boolean collision = false;
                for (Square square : squares) {
                    if (square.getBounds().intersects(tank.getBounds())) {
                        collision = true;
                        break;
                    }
                }
                if (collision) {
                    for (Square square : squares) {
                        square.shoot();
                    }
                    JOptionPane.showMessageDialog(null, "Collision occurred! Game Over!");
                    gameCount++;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MovingShapesApp app = new MovingShapesApp();
            app.setVisible(true);
        });
    }
}
