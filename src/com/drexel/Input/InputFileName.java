package com.drexel.Input;

import com.drexel.Strategy;

public class InputFileName implements Strategy {

    @Override
    public String enterFileName(String fileName) {
        return fileName;
    }
}
