package com.drexel.Ouput;

import com.drexel.Strategy;

public class OutputFileName implements Strategy {

    @Override
    public String enterFileName(String fileName) {
        return fileName;
    }
}
