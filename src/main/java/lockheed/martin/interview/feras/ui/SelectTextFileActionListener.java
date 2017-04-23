package lockheed.martin.interview.feras.ui;

import lockheed.martin.interview.feras.fileio.FileIO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class SelectTextFileActionListener implements ActionListener {
    protected UiEventListener eventListener;
    JFileChooser fileChooser;

    public SelectTextFileActionListener(UiEventListener eventListener) {
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        this.eventListener = eventListener;
    }

    public void actionPerformed(ActionEvent e) {

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            eventListener.setSourceTextFilePath(selectedFile.getAbsolutePath());
            ArrayList<String> newdictionary = FileIO.read(selectedFile);
            this.notifyListenerFileLoaded(newdictionary);
        }
    }

    protected void notifyListenerFileLoaded(ArrayList<String> newdictionary) {
        eventListener.loadTextFileDone(newdictionary);
    }

}
