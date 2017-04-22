package lockheed.martin.interview.feras.model;

import java.util.ArrayList;

public class SpellChecker extends Thread {

	private ArrayList<String> dictionary;
	private String wordToCheck;
	private boolean correct;

	public SpellChecker(ArrayList<String> dictionary, String wordToCheck) {

		this.dictionary = dictionary;
		this.wordToCheck = wordToCheck;
		this.correct = false;
	}

	public void checkIfwordExistInTheList() {

		for (String wordFromDictionary : dictionary) {
			if (wordToCheck.equalsIgnoreCase(wordFromDictionary)) {
				setCorrect(true);
				System.out.println("Found it!");
				System.out.println("Word To Check: " + wordToCheck + ". Word from dictionary: " + wordFromDictionary);
			}
		}

	}

	/**
	 * @return the wordToCheck
	 */
	public String getWordToCheck() {
		return wordToCheck;
	}

	/**
	 * @param wordToCheck
	 *            the wordToCheck to set
	 */
	public void setWordToCheck(String wordToCheck) {
		this.wordToCheck = wordToCheck;
	}

	/**
	 * @return the correct
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * @param correct
	 *            the correct to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	/**
	 * @param dictionary
	 *            the dictionary to set
	 */
	public void setDictionary(ArrayList<String> dictionary) {
		this.dictionary = dictionary;
	}

	@Override
	public void run() {
		checkIfwordExistInTheList();

	}

}
