package lab5.text;

import java.util.Arrays;
import java.util.Comparator;

public class Text {
    private final Sentence[] sentences;

    public Text(String text, boolean showNumberOfWords) {
        String[] sentencesString = text.split("(?<=[.!?])\\s?");
        sentences = new Sentence[sentencesString.length];
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = new Sentence(sentencesString[i], showNumberOfWords);
        }
    }

    public void sortByAmountOfWords() {
        Arrays.sort(sentences, Comparator.comparing(Sentence::getAmountOfWords));
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < sentences.length - 1; i++) {
            text.append(sentences[i]).append(" ");
        }
        text.append(sentences[sentences.length - 1]);
        return text.toString();
    }
}
