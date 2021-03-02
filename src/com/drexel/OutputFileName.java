package com.drexel;

public class OutputFileName implements Strategy {

    @Override
    public String enterFileName(String fileName) {
        return fileName;
    }
}
