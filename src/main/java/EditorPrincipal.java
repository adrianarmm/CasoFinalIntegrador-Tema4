import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorPrincipal extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem abrirNuevoDocumento;
    private Component areaDeTexto;


    public EditorPrincipal() {
        setTitle("Editor de Textos - Ventana Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        menu = new JMenu("Archivo");


        JMenuItem plantillasMenuItem = new JMenuItem("Seleccionar Plantilla");
        plantillasMenuItem.addActionListener(e -> seleccionarPlantilla());
        menu.add(plantillasMenuItem);
        
        
        menuBar = new JMenuBar();
        menu = new JMenu("Archivo");
        abrirNuevoDocumento = new JMenuItem("Abrir Nuevo Documento");
        abrirNuevoDocumento.addActionListener(e -> abrirNuevoDocumento());



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

    private void seleccionarPlantilla() {
        String[] plantillas = {"Carta", "Informe", "Artículo"};
        String seleccion = (String) JOptionPane.showInputDialog(this, "Selecciona una plantilla:",
                "Plantillas", JOptionPane.QUESTION_MESSAGE, null, plantillas, plantillas[0]);
        if (seleccion != null) {
            // Aquí puedes definir el contenido de cada plantilla
            String contenidoPlantilla = obtenerContenidoPlantilla(seleccion);
            EditorDocumento documento = new EditorDocumento();
            documento.rellenarContenido(contenidoPlantilla);
            documento.setVisible(true);
        }
    }

    private void cambiarAModoOscuro() {
        getContentPane().setBackground(Color.DARK_GRAY);
        areaDeTexto.setBackground(Color.BLACK);
        areaDeTexto.setForeground(Color.WHITE);
        menuBar.setBackground(Color.GRAY);
        menuBar.setForeground(Color.WHITE);
        // Actualiza el resto de componentes según sea necesario
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
