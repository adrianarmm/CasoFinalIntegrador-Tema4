import javax.swing.*;
import java.awt.*;

public class MAIN extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuArchivo, menuHerramientas;
    private JMenuItem menuItemEditor, menuItemDibujo, menuItemValidadorEmail, menuItemAgenda;

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

        // Intenta cargar los iconos
        ImageIcon iconoEditor = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Documents/desarrollo-web.png"), 30, 30);
        ImageIcon iconoDibujo = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Documents/computadora.png"), 30, 30);
        ImageIcon iconoEmail = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Documents/email.png"), 30, 30);
        ImageIcon iconoAgenda = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Downloads/agenda-de-contactos.png"), 30, 30);

        menuItemEditor = new JMenuItem("Editor de Texto", iconoEditor);
        menuItemDibujo = new JMenuItem("Herramienta de Dibujo", iconoDibujo);
        menuItemValidadorEmail = new JMenuItem("Validador de Email", iconoEmail);
        menuItemAgenda = new JMenuItem("Agenda de Contactos", iconoAgenda);

        menuArchivo.add(menuItemEditor);
        menuHerramientas.add(menuItemDibujo);
        menuHerramientas.add(menuItemValidadorEmail);
        menuHerramientas.add(menuItemAgenda);

        menuBar.add(menuArchivo);
        menuBar.add(menuHerramientas);

        setJMenuBar(menuBar);

        menuItemEditor.addActionListener(e -> {
            EditorDocumento editor = new EditorDocumento();
            editor.setVisible(true);
        });

        menuItemDibujo.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de dibujo aún no implementada.", "Información", JOptionPane.INFORMATION_MESSAGE));
        menuItemValidadorEmail.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de validación de email aún no implementada.", "Información", JOptionPane.INFORMATION_MESSAGE));

        menuItemAgenda.addActionListener(e -> {
            AgendaDeContactos agenda = new AgendaDeContactos();
            agenda.setVisible(true);
        });
    }

    private ImageIcon cargarIcono(String ruta) {
        ImageIcon icono = new ImageIcon(ruta);
        if (icono.getIconWidth() == -1) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el icono: " + ruta, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return icono;
    }

    private static ImageIcon escalarImagen(ImageIcon iconoOriginal, int anchoDeseado, int altoDeseado) {
        if (iconoOriginal == null) return null;
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MAIN().setVisible(true));
    }
}
