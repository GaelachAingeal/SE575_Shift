package com.drexel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile implements ReceiveInput {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMessage() {
        System.out.println("Enter file name and path.");
    }

    public String fileInput() throws FileNotFoundException {
        String inFile = scanner.next();
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
        } catch (Exception e) {
            System.out.print(e);
        }
        return words;
    }
}