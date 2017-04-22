package lockheed.martin.interview.feras.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import lockheed.martin.interview.feras.controller.ProcessFiles;
import lockheed.martin.interview.feras.fileio.FileIO;

public class MainWindow {

	public static void main(String[] args) throws InterruptedException {
		JFrame f = new JFrame();// creating instance of JFrame

		JButton loadDictionaryButtom = new JButton("load dictionary");// creating
		final JTextField textField = new JTextField(200); // instance
		final JTextField textField2 = new JTextField(200); // instance

		// of
		// JButton
		JButton loadTextButtom = new JButton("load Text");// creating instance
															// of JButton
		JButton processButtom = new JButton("process Files");
		loadDictionaryButtom.setBounds(130, 100, 100, 40);// x axis, y axis,
															// width, height
		loadTextButtom.setBounds(130, 150, 100, 40);// x axis, y axis, width,
		processButtom.setBounds(200, 150, 100, 40);

		textField.setBounds(130, 200, 300, 200); // height

		f.add(loadDictionaryButtom);// adding button in JFrame
		f.add(loadTextButtom);// adding button in JFrame
		f.add(processButtom);// adding button in JFrame

		// f.add(textField);

		f.setSize(400, 500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible

		final ArrayList<String> textDictionary = new ArrayList<>();
		final ArrayList<String> listDictionary = new ArrayList<>();
		final StringBuffer dictionaryfilePath = new StringBuffer();
		final StringBuffer textfilePath = new StringBuffer();

		loadDictionaryButtom.addActionListener(new SelectFileActionListener(listDictionary, dictionaryfilePath));
		loadTextButtom.addActionListener(new SelectFileActionListener(textDictionary, textfilePath));
		final HashMap<String, Boolean> processfileHash = new HashMap<>();
		final HashMap<String, String> correctedHash = new HashMap<>();
		processButtom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ProcessFiles processFiles = new ProcessFiles(listDictionary, textDictionary);
				try {
					processfileHash.putAll(processFiles.processFiles());

					textField.setText(processfileHash.toString());

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent e) {

			}

			public void removeUpdate(DocumentEvent e) {
				System.out.println("Start correcting file removeUpdate");

			}

			public void insertUpdate(DocumentEvent e) {
				System.out.println("Start correcting file");
				for (Entry<String, Boolean> entry : processfileHash.entrySet()) {
					String key = entry.getKey();
					Boolean value = entry.getValue();
					if (!value) {
						String correctValue = JOptionPane.showInputDialog(null, "Please replace " + key, null);
						correctedHash.put(key, correctValue);
					}

				}
				// write to file
				System.out.println(correctedHash);
				FileIO.saveChanges(textfilePath.toString(), correctedHash);

			}
		});
	}
}