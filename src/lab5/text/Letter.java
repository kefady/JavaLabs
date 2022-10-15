package lab5.text;

public class Letter {
    private final char letter;

    public Letter(char letter) {
        this.letter = letter;
    }

    @Override
    public String toString() {
        return Character.toString(letter);
    }
}
