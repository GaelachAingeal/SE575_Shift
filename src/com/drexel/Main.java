package com.drexel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static processInput processInput = new processInput();

    public static void main(String[] args) throws IOException {

        boolean quit = false;
        printMenu();
        int selection = 0;
        while (!quit) {
            System.out.println("\nSelect your choice: ");
            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 0:
                    printMenu();
                    break;

                case 1:
                    addItem();
                    break;

                case 2:
                    System.out.print("Enter input file path and name:");
                    String inFile = scanner.next();
                    System.out.println("You entered: " + inFile);
                    try (Scanner scanner = new Scanner(new File(inFile))) {
                        scanner.useDelimiter(("(?m:^$)"));
                        int lineToken = 0;
                        while (scanner.hasNext()) {
                            String sent = scanner.next();
                            lineToken++;
//                        String words[] = sent.split(" ");
//                        for (String word : words) {
//                            System.out.println("\nnew words: " + word);
//                        }
                            System.out.println("\n" + sent);
//
                        }
                    } catch (Exception e) {
                        System.out.print(e);
                    }
//                try {
//                    FileInputStream fs = new FileInputStream(inFile);
//                    int i = 0;
//                    while((i=fs.read())!=-1) {
//                        System.out.print((char)i);
//
//                    }
//                    DataInputStream in = new DataInputStream(fs);
//                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
//                    String strLine;
//                    while ((strLine = br.readLine()) != null)   {
//                        String[] array = strLine.split(" ");
//
//                        System.out.println(array.);
//                    }
//                    fs.close();
//                } catch (Exception e) {
//                    System.out.println(e);
//                }

                    break;

                case 3:
                    processInput.printInputData();
                    break;

                case 4:
                    System.out.println("Enter File Name: ");
                    writeFile();
                    break;

                case 5:
                    System.out.println("Exiting menu.");
                    quit = true;
                    break;

                case 8:
                    System.out.println("Enter input");
                    String consoleInput = scanner.nextLine();
                    String[] array = consoleInput.split(" ");
                    System.out.println("output string: " + Arrays.toString(array));
//                    for (int i =0; i < array.length; i++) {
//                        System.out.println(array[i]+"\n");
//                    }
                    shiftArray(array);
//                    reverseArray(array);
                    System.out.println("output string: " + Arrays.toString(array));
                    break;

                default:
                    System.out.println("Option from menu not selected.");
                    quit = true;
                    break;
            }
        }
        scanner.close();

    }

    public static void printMenu() {
        System.out.println("Choose from these choices");
        System.out.println("-------------------------");
        System.out.println("Press 0 to display menu selections.");
        System.out.println("Press 1 to enter data on the console.");
        System.out.println("Press 2 to enter a text file.");
        System.out.println("Press 3 to confirm console input.");
        System.out.println("Press 4 to write to file.");
        System.out.println("Press 5 to exit.");
    }

    public static void addItem() {
        System.out.println("Enter your data: ");
        processInput.addItem(scanner.nextLine());
    }

    public static void writeFile() throws IOException {
        String filename = scanner.nextLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        System.out.println("Enter data for file ");
        writer.write(scanner.nextLine());
        writer.close();
    }

    public static void reverseArray(String[] array) {
        int maxIndex = array.length - 1; //represents max length of the array
        int halfLength = array.length / 2; //represents only half the length of array because swapping half the numbers
        for (int i =0; i < halfLength; i++) {
            String temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
            System.out.println(Arrays.toString(array));

        }

    }

    public static void shiftArray(String[] array) {
        int maxIndex = array.length - 1; //represents max length of the array
        int halfLength = array.length -2; //represents only half the length of array because swapping half the numbers
        for (int i =0; i < array.length; i++) {
            String temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;

        }
    }


    }