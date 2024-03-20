import java.io.*;

public class ArchivoComparador {

    public static void compareFiles(File file1, File file2) throws IOException {
        boolean areFilesIdentical = true;
        String line1, line2;

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {

            while (true) {
                line1 = reader1.readLine();
                line2 = reader2.readLine();

                // Si ambas líneas son null, los archivos terminaron al mismo tiempo
                if (line1 == null && line2 == null) {
                    break;
                }

                // Si una línea es null (pero no ambas), los archivos tienen diferente longitud
                if (line1 == null || line2 == null || !line1.equals(line2)) {
                    areFilesIdentical = false;
                    System.out.println("Diferencia encontrada:");
                    System.out.println("Archivo 1: " + (line1 != null ? line1 : "EOF"));
                    System.out.println("Archivo 2: " + (line2 != null ? line2 : "EOF"));
                    // Si una línea es null, no necesitamos seguir comparando
                    break;
                }
            }
        } catch (IOException e) {
            throw new IOException("Error al leer los archivos: " + e.getMessage());
        }

        if (areFilesIdentical) {
            System.out.println("Los archivos son idénticos.");
        } else {
            System.out.println("Los archivos no son idénticos.");
        }
    }

    public static void main(String[] args) {
        File file1 = new File("ruta/al/archivo1.txt");
        File file2 = new File("ruta/al/archivo1.txt");

        try {
            compareFiles(file1, file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
