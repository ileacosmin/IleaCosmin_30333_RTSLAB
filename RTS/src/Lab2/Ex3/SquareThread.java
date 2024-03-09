package Lab2.Ex3;

public class SquareThread implements Runnable {
    private Shape shape;
    private final int WINDOW_HEIGHT = 600;
    public SquareThread( Shape shape) {
        this.shape = shape;
    }

    @Override
    public void run() {
        while (shape.getY() < WINDOW_HEIGHT-100) {
            try {
                Thread.sleep(15); // Adjust the delay as needed
                shape.move();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
