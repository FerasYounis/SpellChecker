package lockheed.martin.interview.feras.ui;

import javax.swing.JButton;
import javax.swing.JFrame;

import lockheed.martin.interview.feras.model.UiProcessor;

public class MainWindow {

	public static void main(String[] args) throws InterruptedException {
		JFrame f = new JFrame();// creating instance of JFrame

		JButton loadDictionaryButton = new JButton("Load dictionary");// creating
																		// instance
																		// of
																		// JButton

		JButton loadTextButton = new JButton("Load Text file");// creating
																// instance
																// of JButton

		loadDictionaryButton.setBounds(100, 100, 200, 40);
		loadTextButton.setBounds(100, 150, 200, 40);

		f.add(loadDictionaryButton);// adding button in JFrame
		f.add(loadTextButton);// adding button in JFrame

		f.setSize(400, 500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible

		UiProcessor uiProcessor = new UiProcessor();
		loadDictionaryButton.addActionListener(new SelectDictionaryFileActionListener(uiProcessor));
		loadTextButton.addActionListener(new SelectTextFileActionListener(uiProcessor));

	}

}