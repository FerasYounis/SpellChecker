package lockheed.martin.interview.feras.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import lockheed.martin.interview.feras.fileio.FileIO;
import lockheed.martin.interview.feras.model.SpellChecker;

public class SpellCheckerTest {

	private ArrayList<String> dictionary;
	private String wordToCheck;
	private SpellChecker spellChecker;

	@Test
	public void FileReader_FindAword_test() {
		FileIO fileIO = new FileIO();
		File file = new File("C://Users//f_youni//git//SpellChecker//dictionary.txt");
		dictionary = new ArrayList<String>();
		dictionary = fileIO.read(file);
		System.out.println(dictionary);
		spellChecker = new SpellChecker(dictionary, "dog");
		spellChecker.checkIfWordExistInTheList();
		assertTrue(spellChecker.isCorrect());

	}
}
