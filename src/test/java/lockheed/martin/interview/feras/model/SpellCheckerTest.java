package lockheed.martin.interview.feras.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class SpellCheckerTest {

	private ArrayList<String> dictionary;
	private SpellChecker spellChecker;
@Before
public void setup(){
	dictionary = new ArrayList<String>();
	dictionary.add("aaa");
	dictionary.add("bbbb");
	dictionary.add("dog");
}
	@Test
	public void checkIfWordExistInTheListTest() {

		System.out.println(dictionary);
		spellChecker = new SpellChecker(dictionary, "dog");
		spellChecker.checkIfWordExistInTheList();
		assertTrue(spellChecker.isCorrect());

	}

	@Test
	public void checkIfWordExistInTheListTesNotOnDictionary() {

		System.out.println(dictionary);
		spellChecker = new SpellChecker(dictionary, "ccc");
		spellChecker.checkIfWordExistInTheList();
		assertFalse(spellChecker.isCorrect());

	}
}

