package lab5;

import lab5.text.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    static final String defaultText = """
            StringBuilder в Java - клас, що представляє послідовність символів.
            
            Він дуже схожий на StringBuffer у всьому, крім потокобезпеки.
            
            StringBuilder надає API, аналогічний API StringBuffer!
            
            Різниця лише в тому, що StringBuffer є потокобезпечним, і всі його методи синхронізовані, а StringBuilder — ні.
            
            Це єдина особливість?""";
    static final String filePath = "E:\\JavaLabs\\src\\lab5\\Text.txt";

    public static void main(String[] args) {
        Text text = new Text(inputTextFromFile(filePath), true);
        System.out.println("До сортування:");
        System.out.println(text);
        text.sortByAmountOfWords();
        System.out.println("\nПісля сортування:");
        System.out.println(text);
    }

    private static String inputTextFromFile(String path) {
        try {
            return new String(Files.readAllBytes(Path.of(path)));
        } catch (IOException ioException) {
            System.out.println("File not found! Used default text.");
            return defaultText;
        }
    }
}
