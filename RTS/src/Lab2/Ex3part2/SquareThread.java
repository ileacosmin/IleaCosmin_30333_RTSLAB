package Lab2.Ex3part2;

import Lab2.Ex3.Shape;

class ShapeThread implements Runnable {
    private ShapePanel shapePanel;

    public ShapeThread(ShapePanel shapePanel) {
        this.shapePanel = shapePanel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50); // Adjust speed of updating
                shapePanel.moveShapes();
                for (Shape shape : shapePanel.shapes) {
                    if (shape.isOutOfBounds()) {
                        shapePanel.removeShape(shape);
                        shapePanel.addShape(new Square());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}