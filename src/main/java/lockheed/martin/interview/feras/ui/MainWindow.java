package lockheed.martin.interview.feras.ui;

import lockheed.martin.interview.feras.model.UiProcessor;

import javax.swing.*;

public class MainWindow {

    public static void main(String[] args) throws InterruptedException {
        JFrame f = new JFrame();// creating instance of JFrame

        JButton loadDictionaryButton = new JButton("load dictionary");// creating

        // of
        // JButton
        JButton loadTextButton = new JButton("load Text");// creating instance
        // of JButton
        loadDictionaryButton.setBounds(130, 100, 100, 40);// x axis, y axis,
        // width, height
        loadTextButton.setBounds(130, 150, 100, 40);// x axis, y axis, width,


        f.add(loadDictionaryButton);// adding button in JFrame
        f.add(loadTextButton);// adding button in JFrame

        // f.add(textField);

        f.setSize(400, 500);// 400 width and 500 height
        f.setLayout(null);// using no layout managers
        f.setVisible(true);// making the frame visible


        UiProcessor uiProcessor = new UiProcessor();
        loadDictionaryButton.addActionListener(new SelectDictionaryFileActionListener(uiProcessor));
        loadTextButton.addActionListener(new SelectTextFileActionListener(uiProcessor));


    }


}