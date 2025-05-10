import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class DrawingPad extends JFrame {
    private int brushSize = 5;
    private Color brushColor = Color.BLACK;
    private BufferedImage canvas;
    private Graphics2D g2;

    public DrawingPad() {
        setTitle("Drawing Pad");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create canvas
        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g2 = canvas.createGraphics();
        g2.setColor(Color.WHITE); // Background color
        g2.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g2.setColor(brushColor);

        // Canvas panel
        JPanel drawPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(canvas, 0, 0, null);
            }
        };

        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                g2.setColor(brushColor);
                g2.fillOval(e.getX() - brushSize / 2, e.getY() - brushSize / 2, brushSize, brushSize);
                repaint();
            }
        });

        // Toolbar
        JPanel toolbar = new JPanel();

        JButton colorBtn = new JButton("Choose Color");
        colorBtn.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(null, "Pick a Color", brushColor);
            if (selectedColor != null) {
                brushColor = selectedColor;
            }
        });

        JSlider brushSlider = new JSlider(1, 50, brushSize);
        brushSlider.addChangeListener(e -> {
            brushSize = brushSlider.getValue();
        });

        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> {
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            g2.setColor(brushColor);
            repaint();
        });

        toolbar.add(colorBtn);
        toolbar.add(new JLabel("Brush Size:"));
        toolbar.add(brushSlider);
        toolbar.add(clearBtn);

        add(toolbar, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DrawingPad();
    }
}
