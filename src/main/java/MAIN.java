import javax.swing.*;
import java.awt.*;

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

        menuItemEditor.addActionListener(e -> {
            EditorDocumento editor = new EditorDocumento(); // Crear una instancia de tu editor
            editor.setVisible(true); // Hacer visible el editor
        });

        menuItemDibujo.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de dibujo aún no implementada.", "Información", JOptionPane.INFORMATION_MESSAGE));

        menuItemValidadorEmail.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de validación de email aún no implementada.", "Información", JOptionPane.INFORMATION_MESSAGE));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MAIN().setVisible(true));
    }
}

