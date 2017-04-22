package lockheed.martin.interview.feras.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import lockheed.martin.interview.feras.fileio.FileIO;

public class SelectFileActionListener implements ActionListener {
	private ArrayList<String> dictionary;
	final JFileChooser fileChooser = new JFileChooser();
	private StringBuffer filePath;

	public SelectFileActionListener(ArrayList<String> dictionary, StringBuffer filePath) {
		this.dictionary = dictionary;
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		this.filePath = filePath;
	}

	public void actionPerformed(ActionEvent e) {

		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			filePath.append(selectedFile.getAbsolutePath());
			ArrayList<String> newdictionary = FileIO.read(selectedFile);
			this.dictionary.addAll(newdictionary);
		}
	}

}
