
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

        // Escalar y mostrar el icono de agenda
        ImageIcon iconoAgendaOriginal = new ImageIcon("/Users/adrianareyesmorera/Downloads/agenda-de-contactos.png");
        ImageIcon iconoAgendaEscalado = escalarImagen(iconoAgendaOriginal, 50, 50); // Ajusta el tamaño deseado aquí
        JOptionPane.showMessageDialog(null, "Icono de agenda", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoAgendaEscalado);

        // Escalar y mostrar el icono de busqueda de palabras
        ImageIcon iconoBusquedaPalabrasOriginal = new ImageIcon("/Users/adrianareyesmorera/Downloads/busqueda-por-palabra-clave.png");
        ImageIcon iconoBusquedaPalabrasEscalado = escalarImagen(iconoBusquedaPalabrasOriginal, 50, 50); // Ajusta el tamaño deseado aquí
        JOptionPane.showMessageDialog(null, "Icono de búsqueda de palabras", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoBusquedaPalabrasEscalado);

        // Escalar y mostrar el icono de documento con barra de desplazamiento
        ImageIcon iconoDocConBarraDesplazamientoOriginal = new ImageIcon("/Users/adrianareyesmorera/Downloads/desplacese-hacia-abajo.png");
        ImageIcon iconoDocConBarraDesplazamientoEscalado = escalarImagen(iconoDocConBarraDesplazamientoOriginal, 50, 50); // Ajusta el tamaño deseado aquí
        JOptionPane.showMessageDialog(null, "Icono de documento con barra de desplazamiento", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoDocConBarraDesplazamientoEscalado);

        // Escalar y mostrar el icono de editor de texto con listado
        ImageIcon iconoTextEditorConListingOriginal = new ImageIcon("/Users/adrianareyesmorera/Downloads/lista-de-texto.png");
        ImageIcon iconoTextEditorConListingEscalado = escalarImagen(iconoTextEditorConListingOriginal, 50, 50); // Ajusta el tamaño deseado aquí
        JOptionPane.showMessageDialog(null, "Icono de editor de texto con listado", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoTextEditorConListingEscalado);

        // Escalar y mostrar el icono de seguimiento de raton
        ImageIcon iconoSeguimientoRatonOriginal = new ImageIcon("/Users/adrianareyesmorera/Downloads/bola-de-seguimiento.png");
        ImageIcon iconoSeguimientoRatonEscalado = escalarImagen(iconoSeguimientoRatonOriginal, 50, 50); // Ajusta el tamaño deseado aquí
        JOptionPane.showMessageDialog(null, "Icono de seguimiento de ratón", "Icono", JOptionPane.INFORMATION_MESSAGE, iconoSeguimientoRatonEscalado);
 }

    // Método auxiliar para escalar la imagen
    private static ImageIcon escalarImagen(ImageIcon iconoOriginal, int anchoDeseado, int altoDeseado) {
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
}
