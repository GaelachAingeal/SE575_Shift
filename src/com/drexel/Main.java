package com.drexel;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    private Properties configProp = new Properties();
    private static ProcessInput processInput = new ProcessInput();
    private static OutputData outputData = new OutputData();
    private static InputData inputData = new InputData();

    public static void main(String[] args) throws IOException {

        Main sample = new Main();
        sample.loadProps();


        if (sample.getlineCountPostiion().equals("top")) {
            String input = inputData.consoleInput();
            ArrayList<String> output = processInput.shiftWords(input);
            if (sample.outputType().equals("true")) {
                outputData.writeToFile(output);
            } else {
                outputData.printLineCount(output);
                outputData.printConsole(output);
            }
        } else {
            String input = inputData.consoleInput();
            ArrayList<String> output = processInput.shiftWords(input);
            outputData.printConsole(output);
            outputData.printLineCount(output);

        }
//        if (sample.getCaseSensitivity().equals("true")) {
//            String input sample.consoleInput();
//            ArrayList<String> output = sample.replaceToUpperCase(input);
//            ArrayList<String> shifted = sample.shiftWords(output);
//        }
    }

    public void loadProps() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("resources/app.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getlineCountPostiion() {
        return configProp.getProperty("line.count");
    }

    public String outputType() {
        return configProp.getProperty("output.file");
    }

    public String getCaseSensitivity() {
        return configProp.getProperty("case.sensitivity");
    }

}