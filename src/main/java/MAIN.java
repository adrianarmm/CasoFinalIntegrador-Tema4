import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MAIN extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuArchivo, menuHerramientas;
    private JMenuItem menuItemEditor, menuItemDibujo, menuItemValidadorEmail;

    public MAIN() {
        inicializarUI();
    }

    private void inicializarUI() {
        setTitle("Aplicación Multifuncional");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        menuArchivo = new JMenu("Archivo");
        menuHerramientas = new JMenu("Herramientas");

        menuItemEditor = new JMenuItem("Editor de Texto");
        menuItemDibujo = new JMenuItem("Herramienta de Dibujo");
        menuItemValidadorEmail = new JMenuItem("Validador de Email");

        menuArchivo.add(menuItemEditor);
        menuHerramientas.add(menuItemDibujo);
        menuHerramientas.add(menuItemValidadorEmail);

        menuBar.add(menuArchivo);
        menuBar.add(menuHerramientas);

        setJMenuBar(menuBar);

        // Listeners para los items del menú
        menuItemEditor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se llamaría a la funcionalidad del editor de texto
            }
        });

        menuItemDibujo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se llamaría a la funcionalidad de dibujo
            }
        });

        menuItemValidadorEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se llamaría a la funcionalidad de validación de email
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MAIN().setVisible(true);
        });
    }
}
