import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AgendaDeContactos extends JFrame {
    private JTextField txtNombre, txtEmail, txtTelefono, txtApellidos;
    private JButton btnAgregar;
    private JList<Contacto> listaContactos;
    private DefaultListModel<Contacto> modeloLista;
    private ArrayList<Contacto> contactos;

    public AgendaDeContactos() {
        super("Agenda de Contactos");
        setLayout(new FlowLayout());

        contactos = new ArrayList<>();
        modeloLista = new DefaultListModel<>();
        listaContactos = new JList<>(modeloLista);

        txtNombre = new JTextField(20);
        txtEmail = new JTextField(20);
        txtTelefono = new JTextField(20);
        btnAgregar = new JButton("Agregar Contacto");

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarContacto();
            }
        });

        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Apellidos:"));
        add(txtApellidos);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Teléfono:"));
        add(txtTelefono);
        add(btnAgregar);
        add(new JScrollPane(listaContactos));

        setSize(240, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void agregarContacto() {
        String nombre = txtNombre.getText();
        String email = txtEmail.getText();
        String telefono = txtTelefono.getText();
        String apellidos = txtApellidos.getText();

        Contacto nuevoContacto = new Contacto(nombre, email, telefono);
        contactos.add(nuevoContacto);
        modeloLista.addElement(nuevoContacto);

        txtNombre.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtApellidos.setText("");
    }

    public static void main(String[] args) {
        new AgendaDeContactos();
    }
}
