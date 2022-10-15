package lab5.text;

import java.util.ArrayList;

public class Sentence {
    private final SentenceElement[] sentenceElements;
    private final boolean showNumberOfWords;

    public Sentence(String sentence, boolean showNumberOfWords) {
        this.showNumberOfWords = showNumberOfWords;
        //String[] sentenceElementStrings = sentence.split("(?=\\p{Punct})| ");
        ArrayList<String> sentenceElementStrings = separateSentence(sentence);
        sentenceElements = new SentenceElement[sentenceElementStrings.size()];
        for (int i = 0; i < sentenceElementStrings.size(); i++) {
            if (sentenceElementStrings.get(i).matches("\\p{Punct}") || sentenceElementStrings.get(i).matches("[«»— \n]"))
                sentenceElements[i] = new Punctuation(sentenceElementStrings.get(i));
            else
                sentenceElements[i] = new Word(sentenceElementStrings.get(i));
        }
    }

    public int getAmountOfWords() {
        int amountOfWords = 0;
        for (SentenceElement sentenceElement : sentenceElements) {
            if (sentenceElement instanceof Word) amountOfWords++;
        }
        return amountOfWords;
    }

    private ArrayList<String> separateSentence(String sentence) {
        ArrayList<String> sentenceElements = new ArrayList<>();
        String[] elements = sentence.split("(?=[\\W\\w])");
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < elements.length - 1; i++) {
            String element = elements[i];
            String nextElement = elements[i + 1];
            if (element.matches("[\\p{Punct}«»— \n]")) {
                if (element.matches("['-]") && !nextElement.matches("[\\p{Punct}«»— ]")) {
                    word.append(element);
                } else if ((element.equals(nextElement) || (i > 0 && element.equals(elements[i - 1]))) && element.matches("[+-.]")) {
                    word.append(element);
                    if (i + 1 == elements.length - 1) sentenceElements.add(word.toString());
                } else {
                    if (word.length() > 0) {
                        sentenceElements.add(word.toString());
                        word.delete(0, word.length());
                    }
                    sentenceElements.add(element);
                }

            } else {
                word.append(element);
                if (i + 1 == elements.length - 1) sentenceElements.add(word.toString());
            }
        }
        sentenceElements.add(elements[elements.length - 1]);
        return sentenceElements;
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (SentenceElement sentenceElement : sentenceElements) {
            sentence.append(sentenceElement.toString());
        }
        if (showNumberOfWords) sentence.append("[").append(getAmountOfWords()).append(" words]");
        return sentence.toString();
    }
}
