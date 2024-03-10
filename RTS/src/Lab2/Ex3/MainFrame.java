package Lab2.Ex3;
import javax.swing.*;

public class MainFrame extends JFrame {
    private ShapePanel shapePanel;

    public MainFrame() {
        setTitle("Moving Shapes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400); // Fixed size window

        shapePanel = new ShapePanel();
        add(shapePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
            frame.shapePanel.start();
        });

    }
}
