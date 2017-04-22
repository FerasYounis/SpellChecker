package lockheed.martin.interview.feras.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lockheed.martin.interview.feras.model.SpellChecker;

public class ProcessFiles {
	private ArrayList<String> dictionary;
	private ArrayList<String> textList;

	public ProcessFiles(ArrayList<String> dictionary, ArrayList<String> textList) {
		this.dictionary = dictionary;
		this.textList = textList;
	}

	public HashMap<String, Boolean> processFiles() throws InterruptedException {
		List<SpellChecker> spellCheckeerList = new ArrayList<>();
		for (String wordToCheck : textList) {
			SpellChecker spellchecker = new SpellChecker(dictionary, wordToCheck);
			spellCheckeerList.add(spellchecker);
			spellchecker.start();
		}
		for (SpellChecker spellChecker : spellCheckeerList) {
			spellChecker.join();
		}

		HashMap<String, Boolean> checkedTextList = new HashMap<>();
		for (SpellChecker spellChecker : spellCheckeerList) {
			checkedTextList.put(spellChecker.getWordToCheck(), spellChecker.isCorrect());
			System.out.println(spellChecker.getWordToCheck() + spellChecker.isCorrect());
		}
		return checkedTextList;

	}
}
