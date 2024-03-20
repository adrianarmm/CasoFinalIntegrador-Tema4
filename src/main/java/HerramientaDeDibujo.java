import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class HerramientaDeDibujo extends JFrame {
    private ArrayList<Point> puntos = new ArrayList<>();

    public HerramientaDeDibujo() {
        setTitle("Herramienta de Dibujo");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                for (Point punto : puntos) {
                    g2.fillOval(punto.x, punto.y, 4, 4);
                }
            }
        };

        panelDibujo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                agregarPunto(e.getPoint());
            }
        });

        panelDibujo.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                agregarPunto(e.getPoint());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        add(panelDibujo);
    }

    private void agregarPunto(Point punto) {
        puntos.add(punto);
        repaint(); // Ahora llama correctamente a repaint en HerramientaDeDibujo, que repintará todo el JFrame incluido el panelDibujo
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HerramientaDeDibujo().setVisible(true));
    }
}
