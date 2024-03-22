import javax.swing.*;

public class Iconos {
    public static void main(String[] args) {

        ImageIcon iconoEditor = new ImageIcon("path/to/editor_icon.png");
        ImageIcon iconoDibujo = new ImageIcon("path/to/drawing_icon.png");
        ImageIcon iconoEmail = new ImageIcon("path/to/email_icon.png");

        JOptionPane.showMessageDialog(null, "Icono de editor", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoEditor);
        JOptionPane.showMessageDialog(null, "Icono de dibujo", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoDibujo);
        JOptionPane.showMessageDialog(null, "Icono de email", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoEmail);
    }
}