import javax.swing.*;
        import java.awt.*;
        import java.io.*;
        import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TextEditorConListing extends JFrame {
    private JTextArea textArea;
    private JList<File> fileList;
    private JSplitPane splitPane;
    private DefaultListModel<File> listModel;
    private File currentDirectory;

    public TextEditorConListing() {
        setTitle("Editor de Texto con Listado de Documentos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Asumiendo un directorio fijo para los documentos
        currentDirectory = new File("/Users/adrianareyesmorera/Documents/");
        if (currentDirectory.exists()) {
            File[] files = currentDirectory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    listModel.addElement(file);
                }
            }
        }

        fileList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    openFile(fileList.getSelectedValue());
                }
            }
        });

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(fileList), new JScrollPane(textArea));
        splitPane.setDividerLocation(150);
        add(splitPane);
    }

    private void openFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.read(reader, null);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TextEditorConListing().setVisible(true);
        });


    }
}
