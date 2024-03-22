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

        // Cargar y escalar iconos
        ImageIcon iconoEditor = new ImageIcon(escalarImagen(new ImageIcon("/Users/adrianareyesmorera/Documents/desarrollo-web.png"), 20, 20));
        ImageIcon iconoDibujo = new ImageIcon(escalarImagen(new ImageIcon("/Users/adrianareyesmorera/Documents/computadora.png"), 20, 20));
        ImageIcon iconoEmail = new ImageIcon(escalarImagen(new ImageIcon("/Users/adrianareyesmorera/Documents/email.png"), 20, 20));

        menuItemEditor = new JMenuItem("Editor de Texto", iconoEditor);
        menuItemDibujo = new JMenuItem("Herramienta de Dibujo", iconoDibujo);
        menuItemValidadorEmail = new JMenuItem("Validador de Email", iconoEmail);

        menuArchivo.add(menuItemEditor);
        menuHerramientas.add(menuItemDibujo);
        menuHerramientas.add(menuItemValidadorEmail);

        menuBar.add(menuArchivo);
        menuBar.add(menuHerramientas);

        setJMenuBar(menuBar);

        // Configurar acción para abrir el editor de texto
        menuItemEditor.addActionListener(e -> {
            EditorDocumento editor = new EditorDocumento(); // Crear una instancia del editor
            editor.setVisible(true); // Hacer visible el editor
        });

        menuItemDibujo.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de dibujo aún no implementada.", "Información", JOptionPane.INFORMATION_MESSAGE));
        menuItemValidadorEmail.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de validación de email aún no implementada.", "Información", JOptionPane.INFORMATION_MESSAGE));
    }

    private Image escalarImagen(ImageIcon iconoOriginal, int anchoDeseado, int altoDeseado) {
        return iconoOriginal.getImage().getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MAIN().setVisible(true));
    }
}

class EditorDocumento extends JFrame {
    private JTextArea areaDeTexto;

    public EditorDocumento() {
        setTitle("Nuevo Documento");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        areaDeTexto = new JTextArea();
        add(new JScrollPane(areaDeTexto));
    }
}

