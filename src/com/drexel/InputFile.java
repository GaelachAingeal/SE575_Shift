package com.drexel;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InputFile implements ReceiveInput {

    private static Scanner scanner = new Scanner(System.in);
    Context context = new Context(new InputFileName());
    private ArrayList<String> wordList;


    @Override
    public void displayMessage() {
        System.out.println("Enter file name and path.");
    }



    public String fileInput() throws FileInputException {
        String inFile = scanner.next();
        context.executeStrategy(inFile);
        String words = null;
        try {
            Scanner scanner = new Scanner(new File(inFile));
            scanner.useDelimiter(("(?m:^\\s\\n$)"));
            int lineToken = 0;
            while (scanner.hasNext()) {
                words = scanner.next();
                lineToken++;
//                System.out.println("\n" + words);
            }
        } catch (FileNotFoundException errorMessage ) {
            throw new FileInputException("Error reading file. Check path & file name.");
        }
        return words;
    }

    public String getWholeLine() {
        String aLine = "";
        for (String s:wordList) {
            aLine=aLine+s+" ";
        }
        return aLine;
    }

    public String fileInputLine() throws FileInputException {
        String inFile =  "test.txt";
        BufferedReader reader;
        ArrayList<String> lines = new ArrayList<>();
        String aLine = "";
        int token = 0;
        try {
            reader = new BufferedReader(new FileReader(inFile));
            String line = reader.readLine();
            while (line != null) {
                getWholeLine();
                System.out.println(line + "Line " + token);
                lines.add(line);
                line = reader.readLine();
                token++;

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aLine;
    }

}