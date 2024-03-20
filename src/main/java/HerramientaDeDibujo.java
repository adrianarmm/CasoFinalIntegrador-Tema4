import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class HerramientaDeDibujo extends JFrame {
    private JPanel panelDibujo;

    public HerramientaDeDibujo() {
        setTitle("Herramienta de Dibujo");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelDibujo = new JPanel() {
            // Lista para guardar los puntos por donde pasa el ratón
            private ArrayList<Point> puntos = new ArrayList<>();

            // Sobreescribir el método paintComponent para dibujar
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Point punto : puntos) {
                    // Dibujar un pequeño círculo en cada punto
                    g.fillOval(punto.x, punto.y, 4, 4);
                }
            }

            // Método para agregar un punto a la lista y repintar
            private void agregarPunto(Point punto) {
                puntos.add(punto);
                repaint();
            }
        };

        // Añadir listeners al panel de dibujo para manejar los eventos del ratón
        panelDibujo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Agregar un punto inicial cuando se presiona el ratón
                panelDibujo.agregarPunto(e.getPoint());
            }
        });

        panelDibujo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Agregar puntos a medida que se arrastra el ratón
                panelDibujo.agregarPunto(e.getPoint());
            }
        });

        add(panelDibujo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HerramientaDeDibujo().setVisible(true));
    }
}
