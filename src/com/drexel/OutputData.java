package com.drexel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class OutputData {

    public void printConsole(ArrayList<String> arrayList) {
        Collections.sort(arrayList);
        for (String sorted : arrayList) {
            System.out.println(sorted);
        }
    }

    public void writeToFile(ArrayList<String> array) throws IOException {
        String filename = "output.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        System.out.println(array.size());
        writer.write(String.valueOf(array));
        writer.close();
    }

    public void printLineCount(ArrayList<String> array) {
        System.out.println("number of lines " + array.size());
    }


}