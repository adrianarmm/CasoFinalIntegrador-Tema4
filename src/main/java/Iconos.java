import javax.swing.*;

public class Iconos {
    public static void main(String[] args) {

        ImageIcon iconoEditor = new ImageIcon("documentos/desarrollo-web.png");
        ImageIcon iconoDibujo = new ImageIcon("documentos/computadora.png");
        ImageIcon iconoEmail = new ImageIcon("documentos/email.png");

        JOptionPane.showMessageDialog(null, "Icono de editor", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoEditor);
        JOptionPane.showMessageDialog(null, "Icono de dibujo", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoDibujo);
        JOptionPane.showMessageDialog(null, "Icono de email", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoEmail);
    }
}