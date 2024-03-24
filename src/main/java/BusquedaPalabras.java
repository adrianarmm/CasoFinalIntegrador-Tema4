import java.io.*;

public class BusquedaPalabras {

    /**
     * Busca una palabra específica en un documento y cuenta cuántas veces aparece.
     *
     * @param   /Users/adrianareyesmorera/Documents/TARTAS-QUESO.txt El archivo en el que buscar la palabra.
     * @param searchWord La palabra a buscar.
     * @return El número de veces que la palabra aparece en el documento.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static int countBusquedaPalabras(File file, String searchWord) throws IOException {
        int count = 0;
        String line;
        searchWord = searchWord.toLowerCase(); // Convierte la palabra buscada a minúsculas para una búsqueda insensible a mayúsculas/minúsculas.

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                // Convierte cada línea a minúsculas para hacer la búsqueda insensible a mayúsculas/minúsculas.
                line = line.toLowerCase();
                // Divide la línea en palabras usando espacios y puntuación como delimitadores.
                String[] words = line.split("W+"); // "\\W+" es una expresión regular que representa uno o más caracteres no alfabéticos.
                for (String word : words) {
                    if (word.equals(searchWord)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        File file = new File("/Users/adrianareyesmorera/Documents/TARTAS-QUESO.txt"); // La ruta del archivo en el que buscar la palabra.
        String searchWord = "Tarta"; // La palabra que quieres buscar en el documento.

        try {
            int occurrences = countBusquedaPalabras(file, searchWord);
            System.out.println("La palabra \"" + searchWord + "\" aparece " + occurrences + " veces en el documento.");
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }



}

