package com.drexel;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy (String filename) {
        return strategy.enterFileName(filename);
    }
}
