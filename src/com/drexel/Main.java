package com.drexel;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    private Properties configProp = new Properties();

    public static void main(String[] args) throws IOException {

        Main sample = new Main();
        sample.loadProps2();
        sample.sayHello();

        if (sample.getlineCountPostiion().equals("top")) {
            String input = sample.consoleInput();
            ArrayList<String> output = sample.shiftWords(input);
            if (sample.outputType().equals("true")) {
                sample.writeToFile(output);
            } else {
                sample.printLineCount(output);
                sample.printConsole(output);
            }
        } else {
            String input = sample.consoleInput();
            ArrayList<String> output = sample.shiftWords(input);
            sample.printConsole(output);
            sample.printLineCount(output);

        }
    }

    public void loadProps2() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("resources/app.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sayHello() {
        System.out.println(configProp.getProperty("hello.world"));
    }

    public String getlineCountPostiion() {
        return configProp.getProperty("line.count");
    }

    public String outputType() {
        return configProp.getProperty("output.file");
    }

    public String consoleInput() {
        System.out.println("Enter line of text.");
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }

    public ArrayList<String> shiftWords(String input) {
        ArrayList<String> shiftedLines = new ArrayList<>();
        String[] words = input.split("\\s+");
        int counter = words.length;
        for (int i = 0; i < counter; i++) {
            input = input.substring(input.indexOf(words[1], words[0].length())) + " " + words[0];
            input = input.charAt(0) + input.substring(1);
            shiftedLines.add(input);
//            System.out.println("arry = " + shiftedLines.get(i));
            words = input.split("\\s+");
        }
        return shiftedLines;
    }

    public void printConsole(ArrayList<String> arrayList) {
        Collections.sort(arrayList);
        for (String sorted : arrayList) {
            System.out.println(sorted);
        }
    }

    public void printLineCount(ArrayList<String> array) {
        System.out.println("number of lines " + array.size());
    }

    public void writeToFile(ArrayList<String> array) throws IOException {
        String filename = "output.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(String.valueOf(array));
        writer.close();
    }
}