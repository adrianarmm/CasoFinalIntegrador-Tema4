import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class MAIN extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuArchivo, menuHerramientas;
    private JMenuItem menuItemEditor, menuItemDibujo, menuItemValidadorEmail, menuItemAgenda, menuItemBusquedaPalabras, menuItemDocConBarraDesplazamiento, menuItemTextEditorConListing, menuItemSeguimientoRaton, menuItemTextEditor;

    public MAIN() {
        inicializarUI();
        mostrarMensajeBienvenida(); // Llama al método que muestra el mensaje de bienvenida
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
        ImageIcon iconoBusquedaPalabras = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Downloads/busqueda-por-palabra-clave.png"), 30, 30);
        ImageIcon iconoDocConBarraDesplazamiento = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Downloads/desplacese-hacia-abajo.png"), 30, 30);
        ImageIcon iconoTextEditorConListing = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Downloads/lista-de-texto.png"), 30, 30);
        ImageIcon iconoSeguimientoRaton = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Downloads/bola-de-seguimiento.png"), 30, 30);
        ImageIcon iconoTextEditor = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Downloads/editor-de-texto.png"), 30, 30);



        menuItemEditor = new JMenuItem("Block de Notas", iconoEditor);
        menuItemDibujo = new JMenuItem("Herramienta de Dibujo", iconoDibujo);
        menuItemValidadorEmail = new JMenuItem("Validador de Email", iconoEmail);
        menuItemAgenda = new JMenuItem("Agenda de Contactos", iconoAgenda);
        menuItemBusquedaPalabras = new JMenuItem("Búsqueda de Palabras", iconoBusquedaPalabras);
        menuItemDocConBarraDesplazamiento = new JMenuItem("Documento con Barra de Desplazamiento", iconoDocConBarraDesplazamiento);
        menuItemTextEditorConListing = new JMenuItem("Editor de Texto con Listado", iconoTextEditorConListing);
        menuItemSeguimientoRaton = new JMenuItem("Seguimiento del Ratón", iconoSeguimientoRaton);
        menuItemTextEditor = new JMenuItem("Editor de Texto", iconoTextEditor);

        menuArchivo.add(menuItemEditor);
        menuHerramientas.add(menuItemDibujo);
        menuHerramientas.add(menuItemValidadorEmail);
        menuHerramientas.add(menuItemAgenda);
        menuHerramientas.add(menuItemBusquedaPalabras);
        menuHerramientas.add(menuItemDocConBarraDesplazamiento);
        menuHerramientas.add(menuItemTextEditorConListing);
        menuHerramientas.add(menuItemSeguimientoRaton);
        menuHerramientas.add(menuItemTextEditor);



        menuBar.add(menuArchivo);
        menuBar.add(menuHerramientas);

        setJMenuBar(menuBar);

        menuItemEditor.addActionListener(e -> {
            EditorDocumento editor = new EditorDocumento();
            editor.setVisible(true);
        });
        menuItemDibujo.addActionListener(e -> new HerramientaDeDibujo().setVisible(true));

        menuItemDibujo.addActionListener(e -> JOptionPane.showMessageDialog(this, "BIENVENIDO", "Información", JOptionPane.INFORMATION_MESSAGE));
        menuItemValidadorEmail.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de validación de email aún no implementada.", "Información", JOptionPane.INFORMATION_MESSAGE));

        menuItemAgenda.addActionListener(e -> {
            AgendaDeContactos agenda = new AgendaDeContactos();
            agenda.setVisible(true);
        });

        menuItemBusquedaPalabras.addActionListener(e -> realizarBusquedaPalabras());
    {
        };

        menuItemDocConBarraDesplazamiento.addActionListener(e -> {
            DocumentoConBarraDeDesplazamiento documento = new DocumentoConBarraDeDesplazamiento();
            documento.setVisible(true);

        });

        menuItemTextEditorConListing.addActionListener(e -> {
            TextEditorConListing editorConListado = new TextEditorConListing();
            editorConListado.setVisible(true);

        });

        menuItemSeguimientoRaton.addActionListener(e -> {
            abrirSeguimientoRaton();
        });

        menuItemTextEditor.addActionListener(e -> {
            TextEditor textEditor = new TextEditor();
            textEditor.setVisible(true);
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

    private void realizarBusquedaPalabras() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath()); // Para depuración
            try {
                Map<String, Integer> wordFrequency = TextAnalysisTool.analyzeText(selectedFile);
                StringBuilder results = new StringBuilder();
                wordFrequency.forEach((word, frequency) -> results.append(word).append(": ").append(frequency).append("\n"));

                System.out.println("Resultados:\n" + results); // Para depuración

                JTextArea textArea = new JTextArea(20, 30);
                textArea.setText(results.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(null, scrollPane, "Frecuencia de Palabras", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Selección de archivo cancelada."); // Para depuración
        }
    }




    private static ImageIcon escalarImagen(ImageIcon iconoOriginal, int anchoDeseado, int altoDeseado) {
        if (iconoOriginal == null) return null;
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }

    private void mostrarMensajeBienvenida() {
    JOptionPane.showMessageDialog(this, "Bienvenido, seleccione la opción que quiera.", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
    }


    private void abrirSeguimientoRaton() {
        SeguimientoRaton seguimiento = new SeguimientoRaton();
        seguimiento.setVisible(true);
    }



public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MAIN().setVisible(true));
    }
}
