package com.drexel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OutputData implements ReceiveInput {

    private static Scanner scanner = new Scanner(System.in);
    Context context = new Context(new OutputFileName());
    private static String prefixLineCount = "Line count is ";
    Footer footer = new Footer();
    Header header = new Header();
    LineCount counter = new LineCount();


    public void printConsole(ArrayList<String> arrayList) {
        OptionReader.readOptions();
        String lineCount = OptionReader.getString("line.count");

        Collections.sort(arrayList);
        System.out.println(header.getHeader());
        if (lineCount.equals("top")) {
            System.out.println(prefixLineCount + counter.calculateLineCount(arrayList) + "\n");
        }

        for (String sorted : arrayList) {
            System.out.println(sorted);
        }
        if (lineCount.equals("bottom")) {
            System.out.println("\n" + prefixLineCount + counter.calculateLineCount(arrayList));
        }
        System.out.println(footer.getFooter());
    }

    public void writeToFile(ArrayList<String> array) throws FileOutputException {
        OptionReader.readOptions();
        String lineCount = OptionReader.getString("line.count");


        String outFile = scanner.next();
        try {
            context.executeStrategy(outFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            Collections.sort(array);
            writer.write(header.getHeader());
            if (lineCount.equals("top")) {
                writer.write(prefixLineCount + counter.calculateLineCount(array) + "\n");
            }
            for (String str : array) {
                writer.write(str + System.lineSeparator());
            }
            if (lineCount.equals("bottom")) {
                writer.write("\n" + prefixLineCount + counter.calculateLineCount(array));
            }
            writer.write(footer.getFooter());
            writer.close();
        } catch (Exception errorMessage) {
            throw new FileOutputException("Error trying to write file.");
        }

    }


    @Override
    public void displayMessage() {
        System.out.println("Enter file name for output: ");
    }
}
