package com.drexel;


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    private static ProcessInput processInput = new ProcessInput();
    private static OutputData outputData = new OutputData();
    private static InputConsole inputConsole = new InputConsole();
    private static InputFile inputFile = new InputFile();

    public static void main(String[] args) throws FileOutputException, FileInputException, FileNotFoundException {
        OptionReader.readOptions();
        String inputType = OptionReader.getString("input.type");
        String outputType = OptionReader.getString("output.type");
        String sensitivity = OptionReader.getString("case.sensitivity");

        String input = null;
        ArrayList<String> shiftedOutput;

        if (inputType.equals("console")) {
            inputConsole.displayMessage();
            input = inputConsole.consoleInput();
        }

        if (inputType.equals("file")) {
            inputFile.displayMessage();
            input = inputFile.fileInput();
        }

        assert input != null;
        shiftedOutput = processInput.shiftWords(input);

        if (sensitivity.equals("true")) {
            shiftedOutput.replaceAll(new MyOperator());
        }

        if (outputType.equals("console")) {
            outputData.printConsole(shiftedOutput);
        }

        if (outputType.equals("file")) {
            outputData.displayMessage();
            outputData.writeToFile(shiftedOutput);
        }

    }


}