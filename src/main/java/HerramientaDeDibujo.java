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
        setTitle("Herramienta de Dibujo ");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu shapeMenu = new JMenu("Formas");
        String[] shapeOptions = {"Punto", "Línea", "Rectángulo", "Círculo" , "Hexagono", "Heptagono", "Octagono", "Estrella", "Flecha", "Rombo", "Romboide", "Trapecio", "Paralelogramo", "Trapezoide"};
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

            case "Triangulo":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, startPoint.x}, new int[] {startPoint.y, endPoint.y, endPoint.y}, 3));
                break;
            case "Cuadrado":
                shapes.add(new Rectangle(x, y, width, width));
                break;

            case "Hexagono":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, endPoint.x, (startPoint.x + endPoint.x) / 2, startPoint.x, startPoint.x}, new int[] {startPoint.y, (startPoint.y + endPoint.y) / 2, endPoint.y, endPoint.y, (startPoint.y + endPoint.y) / 2, startPoint.y}, 6));
                break;
            case "Heptagono":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, endPoint.x, (startPoint.x + endPoint.x) / 2, startPoint.x, startPoint.x, (startPoint.x + endPoint.x) / 2}, new int[] {startPoint.y, (startPoint.y + endPoint.y) / 2, endPoint.y, endPoint.y, (startPoint.y + endPoint.y) / 2, startPoint.y, startPoint.y}, 7));
                break;
            case "Octagono":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, endPoint.x, (startPoint.x + endPoint.x) / 2, startPoint.x, startPoint.x, (startPoint.x + endPoint.x) / 2, endPoint.x}, new int[] {startPoint.y, (startPoint.y + endPoint.y) / 2, endPoint.y, endPoint.y, (startPoint.y + endPoint.y) / 2, startPoint.y, startPoint.y, (startPoint.y + endPoint.y) / 2}, 8));
                break;
            case "Estrella":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, (startPoint.x + endPoint.x) / 2, startPoint.x, endPoint.x}, new int[] {startPoint.y, startPoint.y, (startPoint.y + endPoint.y) / 2, endPoint.y, endPoint.y}, 5));
                break;

            case "Flecha":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, endPoint.x, (startPoint.x + endPoint.x) / 2, startPoint.x, startPoint.x + (endPoint.x - startPoint.x) / 4, startPoint.x + (endPoint.x - startPoint.x) / 4, startPoint.x + 3 * (endPoint.x - startPoint.x) / 4, startPoint.x + 3 * (endPoint.x - startPoint.x) / 4}, new int[] {startPoint.y, (startPoint.y + endPoint.y) / 2, endPoint.y, (startPoint.y + endPoint.y) / 2, endPoint.y, (startPoint.y + endPoint.y) / 2, endPoint.y - (endPoint.y - startPoint.y) / 4, endPoint.y, startPoint.y}, 9));
                break;
            case "Rombo":
                shapes.add(new Polygon(new int[] {startPoint.x, (startPoint.x + endPoint.x) / 2, endPoint.x, (startPoint.x + endPoint.x) / 2}, new int[] {(startPoint.y + endPoint.y) / 2, startPoint.y, (startPoint.y + endPoint.y) / 2, endPoint.y}, 4));
                break;
            case "Romboide":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, endPoint.x - (endPoint.x - startPoint.x) / 4, startPoint.x - (endPoint.x - startPoint.x) / 4}, new int[] {startPoint.y, startPoint.y, endPoint.y, endPoint.y}, 4));
                break;
            case "Trapecio":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, endPoint.x - (endPoint.x - startPoint.x) / 4, startPoint.x - (endPoint.x - startPoint.x) / 4}, new int[] {startPoint.y, startPoint.y, endPoint.y - (endPoint.y - startPoint.y) / 4, endPoint.y - (endPoint.y - startPoint.y) / 4}, 4));
                break;
            case "Paralelogramo":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, endPoint.x - (endPoint.x - startPoint.x) / 4, startPoint.x - (endPoint.x - startPoint.x) / 4}, new int[] {startPoint.y, startPoint.y, endPoint.y, endPoint.y}, 4));
                break;
            case "Trapezoide":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, endPoint.x - (endPoint.x - startPoint.x) / 4, startPoint.x - (endPoint.x - startPoint.x) / 4}, new int[] {startPoint.y, startPoint.y, endPoint.y - (endPoint.y - startPoint.y) / 4, endPoint.y - (endPoint.y - startPoint.y) / 4}, 4));
                break;
            case "Pentagono":
                shapes.add(new Polygon(new int[] {startPoint.x, endPoint.x, endPoint.x - (endPoint.x - startPoint.x) / 4, (startPoint.x + endPoint.x) / 2, startPoint.x + (endPoint.x - startPoint.x) / 4}, new int[] {startPoint.y, startPoint.y, endPoint.y - (endPoint.y - startPoint.y) / 4, endPoint.y, endPoint.y - (endPoint.y - startPoint.y) / 4}, 5));
                break;

        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HerramientaDeDibujo().setVisible(true));
    }
}

