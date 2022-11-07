package lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

/**
 * C3 = 1 (Тип 'StringBuilder')
 * C17 = 1 (Дія з рядком "Вивести всі речення заданого тексту в порядку зростання кількості слів у них.")
 */

public class Main {
    static String defaultText = """
            StringBuilder в Java - клас, що представляє послідовність символів. Він дуже схожий на StringBuffer у всьому, крім потокобезпеки.
            StringBuilder надає API, аналогічний API StringBuffer!
            Різниця лише в тому, що StringBuffer є потокобезпечним, і всі його методи синхронізовані, а StringBuilder — ні. Це єдина особливість?""";
    static String filePath = "E:\\JavaLabs\\src\\lab3\\Text.txt";

    public static void main(String[] args) {
        System.out.println("Program started");

        StringBuilder text = inputTextFromFile(filePath);
        StringBuilder[] sentences = splitSentences(text);
        Arrays.stream(sentences).sorted(Comparator.comparing(Main::getAmountOfWords)).forEach(Main::printSentence);
        System.out.println("Program finished");
    }

    private static StringBuilder inputTextFromFile(String filePath) {
        try {
            String text = new String(Files.readAllBytes(Path.of(filePath)));
            return new StringBuilder(text);
        } catch (IOException ioException) {
            System.out.println("File not found! Used default text.");
            return new StringBuilder(defaultText);
        }
    }

    private static StringBuilder[] splitSentences(StringBuilder text) {
        String[] stringSentences = text.toString().replaceAll("\n", "").split("(?<=[.!?])\s?");
        StringBuilder[] sentences = new StringBuilder[stringSentences.length];
        Arrays.setAll(sentences, i -> new StringBuilder(stringSentences[i]));
        return sentences;
    }

    private static int getAmountOfWords(StringBuilder sentence) {
        return sentence.toString().split("\s").length;
    }

    private static void printSentence(StringBuilder sentence) {
        System.out.println(sentence + " [" + getAmountOfWords(sentence) + " words]");
    }
}
