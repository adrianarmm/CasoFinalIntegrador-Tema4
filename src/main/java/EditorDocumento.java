import javax.swing.*;

public class EditorDocumento extends JFrame {
    private JTextArea areaDeTexto;

    public EditorDocumento() {
        setTitle("Nuevo Documento");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        areaDeTexto = new JTextArea();
        add(new JScrollPane(areaDeTexto));
    }

    public void rellenarContenido(String contenidoPlantilla) {
    }
}
