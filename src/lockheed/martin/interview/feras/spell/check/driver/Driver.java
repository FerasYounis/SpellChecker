package lockheed.martin.interview.feras.spell.check.driver;

import java.util.ArrayList;

import lockheed.martin.interview.feras.fileio.FileIO;
import lockheed.martin.interview.feras.model.SpellChecker;

public class Driver {

	public static void main(String[] args) {
		
		FileIO fileDictionary = new FileIO();
		ArrayList<String> listDictionary = fileDictionary.read("dictionary.txt");
		
		/*for(String word: listDictionary){
			System.out.println(word);
		}*/
		
		SpellChecker spellChecker2 = new SpellChecker(listDictionary,"dog");
		
		spellChecker2.checkIfwordExistInTheList();
		System.out.println(spellChecker2.isCorrect());
		
	/*	Thread t1 = new Thread((new SpellChecker(listDictionary, "dog").checkIfwordExistInTheList));
		Thread t2 = new Thread(new SpellChecker(listDictionary, "sun"));*/


	}

}
