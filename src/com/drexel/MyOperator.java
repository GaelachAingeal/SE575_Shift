package com.drexel;

import java.util.function.UnaryOperator;

public class MyOperator implements UnaryOperator<String>  {

    @Override
    public String apply(String t) {
        return t.toUpperCase();
    }
}
