package lockheed.martin.interview.feras.ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CorrectWordPopUp {

	public CorrectWordPopUp() {
	}

	public String showPopUp() {
		final JFrame parent = new JFrame();
		JButton button = new JButton();
		final StringBuffer nameBuffer = new StringBuffer();

		button.setText("Click me to show dialog!");
		parent.add(button);
		parent.pack();
		parent.setVisible(true);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nameBuffer.append(JOptionPane.showInputDialog(parent, "What is your name?", null));
			}
		});

		return nameBuffer.toString();
	}
}