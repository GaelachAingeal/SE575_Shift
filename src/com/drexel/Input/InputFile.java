package com.drexel.Input;

import com.drexel.Context;
import com.drexel.ReceiveInput;
import com.drexel.exceptions.FileInputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFile implements ReceiveInput {

    private static Scanner scanner = new Scanner(System.in);
    Context context = new Context(new InputFileName());


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

}