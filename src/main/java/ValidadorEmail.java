import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class ValidadorEmail extends JFrame {
    private JTextField textFieldEmail;
    private JLabel labelEstadoValidacion;

    public ValidadorEmail() {
        super("Validador de Email");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLayout(new FlowLayout());

        textFieldEmail = new JTextField(20);
        labelEstadoValidacion = new JLabel();
        add(textFieldEmail);
        add(labelEstadoValidacion);

        // Añadir un DocumentListener al JTextField para validar el email en tiempo real
        textFieldEmail.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { validar(); }
            public void removeUpdate(DocumentEvent e) { validar(); }
            public void changedUpdate(DocumentEvent e) { validar(); }
        });
    }

    private void validar() {
        String texto = textFieldEmail.getText();
        if (texto.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            labelEstadoValidacion.setText("Email válido");
            labelEstadoValidacion.setForeground(Color.GREEN);
        } else {
            labelEstadoValidacion.setText("Email no válido");
            labelEstadoValidacion.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ValidadorEmail().setVisible(true));
    }
}
