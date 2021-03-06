package lockheed.martin.interview.feras.ui;


import lockheed.martin.interview.feras.model.UiEventListener;

import java.util.ArrayList;

public class SelectDictionaryFileActionListener extends SelectTextFileActionListener {
    public SelectDictionaryFileActionListener(UiEventListener eventListener) {
        super(eventListener);
    }

    @Override
    protected void notifyListenerFileLoaded(ArrayList<String> newdictionary) {
        eventListener.loadDictionaryDone(newdictionary);
    }
}
