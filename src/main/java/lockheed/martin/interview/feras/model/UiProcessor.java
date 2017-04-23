package lockheed.martin.interview.feras.model;


import lockheed.martin.interview.feras.fileio.FileIO;
import lockheed.martin.interview.feras.ui.UiEventListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UiProcessor implements UiEventListener {
    private ArrayList<String> textList;
    private ArrayList<String> dictionaryList;
    private String textFilePath;
    private HashMap<String, Boolean> processWordsHash;

    public void loadDictionaryDone(ArrayList<String> dictionary) {
        this.dictionaryList = dictionary;
        processFiles();
    }

    public void loadTextFileDone(ArrayList<String> textList) {
        this.textList = textList;
        processFiles();

    }

    public void setSourceTextFilePath(String sourceTextFilePath) {
        this.textFilePath = sourceTextFilePath;

    }

    private void processFiles() {

        if (dictionaryList != null && textList != null) {
            ProcessFiles processFiles = new ProcessFiles(dictionaryList, textList);
            try {
                processWordsHash = processFiles.processFiles();
                correctWordsAndWrite();

            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    private void correctWordsAndWrite() {
        HashMap<String, String> correctedWordsHash = new HashMap<String, String>();
        System.out.println("Start correcting file");
        for (Map.Entry<String, Boolean> entry : processWordsHash.entrySet()) {
            String key = entry.getKey();
            Boolean value = entry.getValue();
            if (!value) {
                String correctValue = JOptionPane.showInputDialog(null, "Please replace " + key, null);
                correctedWordsHash.put(key, correctValue);
            }

        }
        // write to file
        System.out.println(correctedWordsHash);
        FileIO.saveChanges(textFilePath.toString(), correctedWordsHash);

    }
}
