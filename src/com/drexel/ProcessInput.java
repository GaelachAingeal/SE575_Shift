package com.drexel;

import java.util.ArrayList;

public class ProcessInput {
    private ArrayList<String> inputData = new ArrayList<>();

    public void addItem(String item) {
        inputData.add(item);

    }

    public void printInputData() {
        System.out.println("You have " + inputData.size() + " data.");
        for (int i = 0; i < inputData.size(); i++) {
            System.out.println(i + 1 + ". " + inputData.get(i));
        }
    }

    public ArrayList<String> shiftWords(String input) {
        ArrayList<String> shiftedLines = new ArrayList<>();
        String[] words = input.split("\\s+");
        int counter = words.length;
        for (int i = 0; i < counter; i++) {
            input = input.substring(input.indexOf(words[1], words[0].length())) + " " + words[0];
            input = input.charAt(0) + input.substring(1);
            shiftedLines.add(input);
            words = input.split("\\s+");
        }
        return shiftedLines;
    }

}
