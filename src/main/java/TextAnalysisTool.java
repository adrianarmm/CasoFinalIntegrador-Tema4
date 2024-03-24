import java.io.*;
import java.util.*;

public class TextAnalysisTool {

    public static Map<String, Integer> analyzeText(File file) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Suponiendo que las palabras están separadas por espacios
                String[] words = line.split("\\s+"); // "\\s+" es una expresión regular que representa uno o más espacios
                for (String word : words) {
                    if (word.isEmpty()) continue; // Ignora strings vacíos que puedan surgir de múltiples espacios seguidos
                    word = word.toLowerCase(); // Considera las palabras en minúsculas para la frecuencia
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    wordCount++;
                }
            }
        }

        System.out.println("Número total de palabras: " + wordCount);
        return wordFrequency;
    }

    public static void main(String[] args) {
        File file = new File("/Users/adrianareyesmorera/Documents/TARTAS-QUESO.txt");

        try {
            Map<String, Integer> wordFrequency = analyzeText(file);
            wordFrequency.forEach((word, frequency) -> System.out.println(word + ": " + frequency));
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
}
