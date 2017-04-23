package lockheed.martin.interview.feras.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProcessFiles {
    private ArrayList<String> dictionary;
    private ArrayList<String> textList;

    public ProcessFiles(ArrayList<String> dictionary, ArrayList<String> textList) {
        this.dictionary = dictionary;
        this.textList = textList;
    }

    public HashMap<String, Boolean> processFiles() throws InterruptedException {
        List<SpellChecker> spellCheckers = new ArrayList<SpellChecker>();
        for (String wordToCheck : textList) {
            SpellChecker spellchecker = new SpellChecker(dictionary, wordToCheck);
            spellCheckers.add(spellchecker);
            spellchecker.start();
        }
        for (SpellChecker spellChecker : spellCheckers) {
            spellChecker.join();
        }

        HashMap<String, Boolean> checkedTextList = new HashMap<String, Boolean>();
        for (SpellChecker spellChecker : spellCheckers) {
            checkedTextList.put(spellChecker.getWordToCheck(), spellChecker.isCorrect());
            System.out.println(spellChecker.getWordToCheck() + spellChecker.isCorrect());
        }
        return checkedTextList;

    }
}
