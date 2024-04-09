import java.io.*;

/**
 * Esta clase proporciona una funcionalidad para buscar una palabra específica
 * en un documento de texto y contar cuántas veces aparece.
 */
public class BusquedaPalabras {

    /**
     * Cuenta cuántas veces aparece una palabra específica en un documento.
     *
     * @param file El archivo en el que buscar la palabra.
     * @param searchWord La palabra a buscar.
     * @return El número de veces que la palabra aparece en el documento.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static int countBusquedaPalabras(File file, String searchWord) throws IOException {
        int count = 0; // Contador para almacenar el número de apariciones de la palabra.
        String line; // Variable para almacenar cada línea leída del archivo.

        // Convierte la palabra buscada a minúsculas para realizar una búsqueda insensible a mayúsculas/minúsculas.
        searchWord = searchWord.toLowerCase();

        // Crea un BufferedReader para leer el archivo.
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) { // Lee el archivo línea por línea.
                line = line.toLowerCase(); // Convierte cada línea a minúsculas.

                // Divide la línea en palabras usando espacios y puntuación como delimitadores.
                // "\\W+" es una expresión regular que representa uno o más caracteres no alfabéticos.
                String[] words = line.split("\\W+");

                // Comprueba cada palabra para ver si coincide con la palabra buscada.
                for (String word : words) {
                    if (word.equals(searchWord)) {
                        count++; // Incrementa el contador si encuentra una coincidencia.
                    }
                }
            }
        }

        return count; // Devuelve el número total de apariciones de la palabra.
    }

    public static void main(String[] args) {

        File file = new File("/Users/adrianareyesmorera/Documents/TARTAS-QUESO.txt");
        String searchWord = "tarta"; // Palabra que quieres buscar en el documento.

        try {
            int occurrences = countBusquedaPalabras(file, searchWord);
            System.out.println("La palabra \"" + searchWord + "\" aparece " + occurrences + " veces en el documento.");
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
}


