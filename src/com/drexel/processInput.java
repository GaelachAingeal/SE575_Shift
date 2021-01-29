package com.drexel;

import java.util.ArrayList;

public class processInput {
    private ArrayList<String> inputData = new ArrayList<>();
    private String inputConsole;

    public void addItem(String item) {
        inputData.add(item);

    }

    public void printInputData() {
        System.out.println("You have " + inputData.size() + " data.");
        for (int i = 0; i < inputData.size(); i++) {
            System.out.println(i + 1 + ". " + inputData.get(i));
        }
    }

    public void shiftConsoleData(String item) {

    }

}
