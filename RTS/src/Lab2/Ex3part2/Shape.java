package Lab2.Ex3part2;

import java.awt.*;

abstract class Shape {
    protected int x, y;
    protected int speed;

    public Shape() {
        // Set initial position and speed
        x = (int) (Math.random() * 700); // Adjust the range based on window size
        y = 0;
        speed = (int) (Math.random() * 5) + 1; // Random speed between 1 and 5
    }

    public abstract void draw(Graphics g);

    public void move() {
        y += speed;
    }

    public boolean isOutOfBounds() {
        return y > 600; // Assuming window height is 600
    }
}