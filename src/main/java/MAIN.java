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

        ImageIcon iconoEditorOriginal = escalarImagen(new ImageIcon("/Users/adrianareyesmorera/Documents/desarrollo-web.png"), 20, 20);
        ImageIcon iconoDibujoOriginal = escalarImagen(new ImageIcon("/Users/adrianareyesmorera/Documents/computadora.png"), 20, 20);
        ImageIcon iconoEmailOriginal = escalarImagen(new ImageIcon("/Users/adrianareyesmorera/Documents/email.png"), 20, 20);
        ImageIcon iconoAgendaOriginal = escalarImagen(new ImageIcon("/Users/adrianareyesmorera/Downloads/agenda-de-contactos.png"), 20, 20);


        menuItemEditor = new JMenuItem("Editor de Texto");
        menuItemDibujo = new JMenuItem("Herramienta de Dibujo");
        menuItemValidadorEmail = new JMenuItem("Validador de Email");
        menuItemAgenda = new JMenuItem("Agenda de Contactos"); // Nuevo ítem de menú para la agenda

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
            AgendaDeContactos agenda = new AgendaDeContactos(); // Instanciar la agenda de contactos
            agenda.setVisible(true); // Hacer visible la agenda
        });
    }

    private static ImageIcon escalarImagen(ImageIcon iconoOriginal, int anchoDeseado, int altoDeseado) {
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MAIN().setVisible(true));
    }
}
