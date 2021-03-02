package com.drexel;

import java.util.ArrayList;

public class LineCount {

    public int calculateLineCount(ArrayList<String> array) {
        int lineCount = array.size();
        return lineCount;
    }

    public void printLineCount(ArrayList<String> array) {
        System.out.println("number of lines " + array.size());
    }
}
