package com.drexel.Input;

import com.drexel.ReceiveInput;

import java.util.Scanner;

public class InputConsole implements ReceiveInput {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMessage() {
        System.out.println("Enter text via console");
    }

    public String consoleInput() {
        return scanner.nextLine();
    }
}
