package lab3;

public class Sentence implements Comparable<Sentence> {

    private final StringBuilder sentence;
    private final Integer amountOfWords;

    public Sentence(StringBuilder sentence, Integer amountOfWords) {
        this.sentence = sentence;
        this.amountOfWords = amountOfWords;
    }

    @Override
    public int compareTo(Sentence o) {
        return this.amountOfWords.compareTo(o.amountOfWords);
    }

    @Override
    public String toString() {
        return "(Кількість слів: " + amountOfWords + ") " + sentence.toString() + "\n";
    }
}
