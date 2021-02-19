package com.drexel.Ouput;

import com.drexel.Context;
import com.drexel.ReceiveInput;
import com.drexel.exceptions.FileOutputException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OutputData implements ReceiveInput {

    private static Scanner scanner = new Scanner(System.in);
    Context context = new Context(new OutputFileName());

    public void printConsole(ArrayList<String> arrayList) {
        Collections.sort(arrayList);
        for (String sorted : arrayList) {
            System.out.println(sorted);
        }
    }

    public void writeToFile(ArrayList<String> array) throws FileOutputException {
        String outFile = scanner.next();
        try {
            context.executeStrategy(outFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            Collections.sort(array);
                writer.write("number of lines " + array.size());
                for (String str : array) {
                    writer.write(str + System.lineSeparator());
                }
                writer.close();
        } catch (Exception errorMessage) {
            throw new FileOutputException("Error trying to write file.");
        }
    }

    public void writeToFileStop(ArrayList<String> array, String stopWords, boolean stopWordsEnable) throws FileOutputException {
        String outFile = scanner.next();
        try {
            context.executeStrategy(outFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            Collections.sort(array);
            for (String str : array) {
                if (stopWordsEnable){
                    if (array.get(0).contains(stopWords))
                            array.remove(0);

                }
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (Exception errorMessage) {
            throw new FileOutputException("Error trying to write file.");
        }
    }

    public void printLineCount(ArrayList<String> array) {
        System.out.println("number of lines " + array.size());
    }


    @Override
    public void displayMessage() {
        System.out.println("Enter file name for output: ");
    }

    public void displayMessage(String headerFooterData) {
        System.out.println(headerFooterData);
    }
}
