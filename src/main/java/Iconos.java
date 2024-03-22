import javax.swing.*;
import java.awt.*;

public class Iconos {
    public static void main(String[] args) {
        // Escalar y mostrar el icono de editor
        ImageIcon iconoEditorOriginal = new ImageIcon("/Users/adrianareyesmorera/Documents/desarrollo-web.png");
        ImageIcon iconoEditorEscalado = escalarImagen(iconoEditorOriginal, 50, 50); // Ajusta el tamaño deseado aquí
        JOptionPane.showMessageDialog(null, "Icono de editor", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoEditorEscalado);

        // Escalar y mostrar el icono de dibujo
        ImageIcon iconoDibujoOriginal = new ImageIcon("/Users/adrianareyesmorera/Documents/computadora.png");
        ImageIcon iconoDibujoEscalado = escalarImagen(iconoDibujoOriginal, 50, 50); // Ajusta el tamaño deseado aquí
        JOptionPane.showMessageDialog(null, "Icono de dibujo", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoDibujoEscalado);

        // Escalar y mostrar el icono de email
        ImageIcon iconoEmailOriginal = new ImageIcon("/Users/adrianareyesmorera/Documents/email.png");
        ImageIcon iconoEmailEscalado = escalarImagen(iconoEmailOriginal, 50, 50); // Ajusta el tamaño deseado aquí
        JOptionPane.showMessageDialog(null, "Icono de email", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoEmailEscalado);
    }

    // Método auxiliar para escalar la imagen
    private static ImageIcon escalarImagen(ImageIcon iconoOriginal, int anchoDeseado, int altoDeseado) {
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
}
