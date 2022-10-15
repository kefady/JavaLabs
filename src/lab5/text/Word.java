package lab5.text;

public class Word implements SentenceElement {
    private final Letter[] letters;

    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter);
        }
        return word.toString();
    }
}
