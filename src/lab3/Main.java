package lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * C3 = 1 (Тип 'StringBuilder')
 * C17 = 1 (Дія з рядком "Вивести всі речення заданого тексту в порядку зростання кількості слів у них.")
 */

public class Main {
    static String defaultText = """
            StringBuilder в Java - клас, що представляє послідовність символів. Він дуже схожий на StringBuffer у всьому, крім потокобезпеки.
            StringBuilder надає API, аналогічний API StringBuffer!
            Різниця лише в тому, що StringBuffer є потокобезпечним, і всі його методи синхронізовані, а StringBuilder — ні. Це єдина особливість?""";

    public static void main(String[] args) {
        System.out.println("Program started");

        StringBuilder text = inputTextFromFile(Path.of("E:\\JavaLabs\\src\\lab3\\Text.txt"));

        List<Sentence> sentences = getListWithSentences(text);

        System.out.println("\nДо сотування:");
        for (Sentence sentence : sentences) {
            System.out.print(sentence);
        }

        Collections.sort(sentences);

        System.out.println("\nПісля сотування:");
        for (Sentence sentence : sentences) {
            System.out.print(sentence);
        }

        System.out.println("Program finished");
    }

    private static StringBuilder inputTextFromFile(Path filePath) {
        try {
            String text = new String(Files.readAllBytes(filePath));
            return new StringBuilder(text);
        } catch (IOException ioException) {
            System.out.println("File not found! Used default text.");
            return new StringBuilder(defaultText);
        }
    }

    private static List<Sentence> getListWithSentences(StringBuilder text) {
        List<Sentence> list = new ArrayList<>();
        String[] sentencesString = text.toString().split("(?<=[.!?])\s?");
        for (String s : sentencesString) {
            String[] words = s.split("\s");
            Sentence sentence = new Sentence(new StringBuilder(s.replaceAll("\n", "")), words.length);
            list.add(sentence);
        }
        return list;
    }
}
