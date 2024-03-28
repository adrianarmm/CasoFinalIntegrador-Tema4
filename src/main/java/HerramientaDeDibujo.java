import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class HerramientaDeDibujo extends JFrame {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Point startPoint = null;
    private String selectedShapeType = "Punto"; // Tipos: Punto, Línea, Rectángulo, Círculo

    public HerramientaDeDibujo () {
        setTitle("Herramienta de Dibujo Mejorada");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu shapeMenu = new JMenu("Formas");
        String[] shapeOptions = {"Punto", "Línea", "Rectángulo", "Círculo"};
        for (String shapeOption : shapeOptions) {
            JMenuItem item = new JMenuItem(shapeOption);
            item.addActionListener(e -> selectedShapeType = shapeOption);
            shapeMenu.add(item);
        }
        menuBar.add(shapeMenu);
        setJMenuBar(menuBar);

        JPanel panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                for (Shape shape : shapes) {
                    g2.draw(shape);
                }
            }
        };

        panelDibujo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                if ("Punto".equals(selectedShapeType)) {
                    agregarForma(new Point(startPoint));
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!"Punto".equals(selectedShapeType)) {
                    Point endPoint = e.getPoint();
                    agregarForma(startPoint, endPoint);
                }
            }
        });

        add(panelDibujo);
    }

    private void agregarForma(Point punto) {
        shapes.add(new Ellipse2D.Float(punto.x, punto.y, 4, 4));
        repaint();
    }

    private void agregarForma(Point startPoint, Point endPoint) {
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);

        switch (selectedShapeType) {
            case "Línea":
                shapes.add(new Line2D.Float(startPoint, endPoint));
                break;
            case "Rectángulo":
                shapes.add(new Rectangle(x, y, width, height));
                break;
            case "Círculo":
                shapes.add(new Ellipse2D.Float(x, y, width, width)); // Asumiendo que queremos mantener la proporción para que sea un círculo
                break;
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HerramientaDeDibujo().setVisible(true));
    }
}

