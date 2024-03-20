import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame {
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem openItem, saveItem;

    public TextEditor() {
        setTitle("Editor de Texto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Área de texto
        textArea = new JTextArea();
        add(new JScrollPane(textArea));

        // Barra de menú
        menuBar = new JMenuBar();
        menu = new JMenu("Archivo");
        openItem = new JMenuItem("Abrir");
        saveItem = new JMenuItem("Guardar");

        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());

        menu.add(openItem);
        menu.add(saveItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TextEditor().setVisible(true);
        });
    }
}
