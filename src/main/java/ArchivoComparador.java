import java.io.*;

public class ArchivoComparador {

    public static void compareFiles(File file1, File file2) throws IOException {
        boolean areFilesIdentical = true;
        String line1 = "", line2 = "";

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {

            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    areFilesIdentical = false;
                    // Aquí puedes implementar una lógica para manejar las diferencias
                    System.out.println("Diferencia encontrada:");
                    System.out.println("Archivo 1: " + line1);
                    System.out.println("Archivo 2: " + line2);
                }
            }

            // Verificar si alguno de los archivos todavía tiene contenido por leer
            if (reader1.readLine() != null || reader2.readLine() != null) {
                areFilesIdentical = false;
                System.out.println("Los archivos tienen diferente longitud.");
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
        File file1 = new File("");
        File file2 = new File("ruta/al/archivo2.txt");

        try {
            compareFiles(file1, file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
