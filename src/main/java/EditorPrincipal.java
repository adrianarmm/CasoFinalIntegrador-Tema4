import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorPrincipal extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuArchivos, menuOpciones;
    private JMenuItem abrirNuevoDocumento, seleccionarPlantilla, cambiarModoOscuro;
    private JTextArea areaDeTexto;


    public EditorPrincipal() {
        setTitle("Editor de Textos - Ventana Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        menuArchivos = new JMenu("Archivo");
        abrirNuevoDocumento = new JMenuItem("Abrir Nuevo Documento");
        abrirNuevoDocumento.addActionListener(e -> abrirNuevoDocumento());


        cambiarModoOscuro = new JMenuItem("Cambiar a Modo Oscuro");
        cambiarModoOscuro.addActionListener(e -> cambiarAModoOscuro());


        menuArchivos.add(abrirNuevoDocumento);
        menuArchivos.add(seleccionarPlantilla);
        menuArchivos.add(cambiarModoOscuro);

        menuOpciones = new JMenu("Opciones");
        cambiarModoOscuro = new JMenuItem("Cambiar a Modo Oscuro");
        cambiarModoOscuro.addActionListener(e -> cambiarAModoOscuro());

        menuBar.add(menuArchivos);
        menuBar.add(menuOpciones);

        setJMenuBar(menuBar);

    }




    private void cambiarAModoOscuro() {
        getContentPane().setBackground(Color.DARK_GRAY);
        areaDeTexto.setBackground(Color.BLACK);
        areaDeTexto.setForeground(Color.WHITE);
    }

    private void abrirNuevoDocumento() {
        EditorDocumento nuevoDocumento = new EditorDocumento();
        nuevoDocumento.setVisible(true);
    }


    private String obtenerContenidoPlantilla(String plantilla) {
        switch (plantilla) {
            case "Carta":
                return "Estimado [nombre]:\n\n...";
            case "Informe":
                return "Título del Informe\n\nIntroducción\n...";
            case "Artículo":
                return "Título del Artículo\n\nResumen\n...";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EditorPrincipal().setVisible(true);
        });
    }


}
