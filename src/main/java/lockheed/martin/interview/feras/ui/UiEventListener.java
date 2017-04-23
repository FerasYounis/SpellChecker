package lockheed.martin.interview.feras.ui;


import java.util.ArrayList;

public interface UiEventListener {
    void loadDictionaryDone(ArrayList<String> dictionary);

    void loadTextFileDone(ArrayList<String> dictionary);

    void setSourceTextFilePath(String sourceTextFilePath);


}
