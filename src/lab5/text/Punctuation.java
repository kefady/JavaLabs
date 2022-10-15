package lab5.text;

public class Punctuation implements SentenceElement {
    private final String punctuation;

    public Punctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        return punctuation;
    }
}
