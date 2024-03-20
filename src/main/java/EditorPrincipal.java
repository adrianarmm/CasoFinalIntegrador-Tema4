import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorPrincipal extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem abrirNuevoDocumento;

    public EditorPrincipal() {
        setTitle("Editor de Textos - Ventana Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        menu = new JMenu("Archivo");
        abrirNuevoDocumento = new JMenuItem("Abrir Nuevo Documento");

        abrirNuevoDocumento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirNuevoDocumento();
            }
        });

        menu.add(abrirNuevoDocumento);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void abrirNuevoDocumento() {
        EditorDocumento nuevoDocumento = new EditorDocumento();
        nuevoDocumento.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EditorPrincipal ventanaPrincipal = new EditorPrincipal();
            ventanaPrincipal.setVisible(true);
        });
    }
}
