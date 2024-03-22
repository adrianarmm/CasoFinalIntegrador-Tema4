import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MAIN extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuArchivo, menuHerramientas;
    private JMenuItem menuItemEditor, menuItemDibujo, menuItemValidadorEmail, menuItemAgenda, menuItemBusquedaPalabras, menuItemDocConBarraDesplazamiento, menuItemTextEditorConListing, menuItemSeguimientoRaton;

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
        ImageIcon iconoBusqueda = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Downloads/busqueda-por-palabras.png"), 30, 30);
        ImageIcon iconoDocConBarraDesplazamiento = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Downloads/desplacese-hacia-abajo.png"), 30, 30);
        ImageIcon iconoTextEditorConListing = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Downloads/lista-de-texto.png"), 30, 30);
        ImageIcon iconoSeguimientoRaton = escalarImagen(cargarIcono("/Users/adrianareyesmorera/Downloads/bola-de-seguimiento.png"), 30, 30);



        menuItemEditor = new JMenuItem("Editor de Texto", iconoEditor);
        menuItemDibujo = new JMenuItem("Herramienta de Dibujo", iconoDibujo);
        menuItemValidadorEmail = new JMenuItem("Validador de Email", iconoEmail);
        menuItemAgenda = new JMenuItem("Agenda de Contactos", iconoAgenda);
        menuItemBusquedaPalabras = new JMenuItem("Búsqueda de Palabras");
        menuItemDocConBarraDesplazamiento = new JMenuItem("Documento con Barra de Desplazamiento");
        menuItemTextEditorConListing = new JMenuItem("Editor de Texto con Listado");
        menuItemSeguimientoRaton = new JMenuItem("Seguimiento del Ratón");

        menuArchivo.add(menuItemEditor);
        menuHerramientas.add(menuItemDibujo);
        menuHerramientas.add(menuItemValidadorEmail);
        menuHerramientas.add(menuItemAgenda);
        menuHerramientas.add(menuItemBusquedaPalabras);
        menuHerramientas.add(menuItemDocConBarraDesplazamiento);
        menuHerramientas.add(menuItemTextEditorConListing);
        menuHerramientas.add(menuItemSeguimientoRaton);



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

        menuItemBusquedaPalabras.addActionListener(e -> {
            BusquedaPalabras busqueda = new BusquedaPalabras();
            busqueda.setVisible(true);
        });

        menuItemDocConBarraDesplazamiento.addActionListener(e -> {

        });

        menuItemTextEditorConListing.addActionListener(e -> {

        });

        menuItemSeguimientoRaton.addActionListener(e -> {
            abrirSeguimientoRaton();
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

    private void mostrarMensajeBienvenida() {
    JOptionPane.showMessageDialog(this, "Bienvenido, seleccione la opción que quiera.", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
    }

    private void realizarBusquedaPalabras() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("/Users/adrianareyesmorera/Documents/MENUSTARTASDEQUESO.txt")));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            String searchWord = JOptionPane.showInputDialog(this, "Ingrese la palabra a buscar:");

            if (searchWord != null && !searchWord.isEmpty()) {
                try {
                    int occurrences = BusquedaPalabras.countBusquedaPalabras(selectedFile, searchWord);
                    JOptionPane.showMessageDialog(this, "La palabra \"" + searchWord + "\" aparece " + occurrences + " veces en el documento.",
                            "Resultado de la Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al leer el archivo: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar una palabra para buscar.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    private void abrirSeguimientoRaton() {
        SeguimientoRaton seguimiento = new SeguimientoRaton();
        seguimiento.setVisible(true);
    }

public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MAIN().setVisible(true));
    }
}
