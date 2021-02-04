//package com.drexel;
//
//import java.io.File;
//import java.util.Scanner;
//
//public class InputData {
//    private static Scanner scanner = new Scanner(System.in);
//
//    public String consoleInput() {
//        System.out.println("Enter line of text.");
//        return scanner.nextLine();
//    }
//
//    public void fileInput() {
//        System.out.print("Enter input file path and name:");
//        String inFile = scanner.next();
//        System.out.println("You entered: " + inFile);
//        try (Scanner scanner = new Scanner(new File(inFile))) {
//            scanner.useDelimiter(("(?m:^$)"));
//            int lineToken = 0;
//            while (scanner.hasNext()) {
//                String sent = scanner.next();
//                lineToken++;
//                System.out.println("\n" + sent);
////
//            }
//        } catch (Exception e) {
//            System.out.print(e);
//        }
//    }
//}
