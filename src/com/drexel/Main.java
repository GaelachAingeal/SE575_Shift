package com.drexel;


import com.drexel.Input.InputConsole;
import com.drexel.Input.InputFile;
import com.drexel.Ouput.OutputData;
import com.drexel.exceptions.FileInputException;
import com.drexel.exceptions.FileOutputException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Main extends ObjectLoader {
    private Properties configProp = new Properties();
    private static ProcessInput processInput = new ProcessInput();
    private static OutputData outputData = new OutputData();
    private static InputConsole inputConsole = new InputConsole();
    private static InputFile inputFile = new InputFile();

    public static void main(String[] args) throws FileOutputException, FileInputException {

        Main sample = new Main();
        sample.loadProps();

        ObjectLoader objectLoader = new ObjectLoader();


        String input = null;
        ArrayList<String> shiftedOutput;

        if (sample.getInputType().equals("console")) {
            inputConsole.displayMessage();
            input = inputConsole.consoleInput();
        }

        if (sample.getInputType().equals("file")) {
            inputFile.displayMessage();
            input = inputFile.fileInput();
        }


        assert input != null;
        shiftedOutput = processInput.shiftWords(input);

        if (sample.getCaseSensitivity().equals("true")) {
            shiftedOutput.replaceAll(new MyOperator());
        }

        if (sample.getHeader().equals("true")) {
            outputData.displayMessage(sample.getHeaderFooterData());
        }

        if (sample.getlinesCountPosition().equals("top")) {
            outputData.printLineCount(shiftedOutput);
        }


        if (sample.getOutputType().equals("console")) {
            outputData.printConsole(shiftedOutput);
        }

        if (sample.getStopWordsEnabled().equals("true")) {
            outputData.writeToFileStop(shiftedOutput, sample.getStopWords(), true);
        }

        if (sample.getlinesCountPosition().equals("bottom")) {
            outputData.printLineCount(shiftedOutput);
        }

        if (sample.getFooter().equals("true")) {
            outputData.displayMessage(sample.getHeaderFooterData());
        }

        if (sample.getOutputType().equals("file")) {
            outputData.displayMessage();
            outputData.writeToFile(shiftedOutput);
        }

    }

    public void loadProps() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("resources/app.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getlinesCountPosition() {
        return configProp.getProperty("line.count");
    }

    public String getCaseSensitivity() {
        return configProp.getProperty("case.sensitivity");
    }

    public String getInputType() {
        return configProp.getProperty("input.type");
    }

    public String getOutputType() {
        return configProp.getProperty("output.type");
    }

    public String getHeader() {
        return configProp.getProperty("header.enable");
    }

    public String getFooter() {
        return configProp.getProperty("footer.enable");
    }

    public String getHeaderFooterData() {
        return configProp.getProperty("text");
    }

    public String getStopWordsEnabled() {
        return configProp.getProperty("stop.words.enable");
    }

    public String getStopWords() {
        return configProp.getProperty("stop.words");
    }

}