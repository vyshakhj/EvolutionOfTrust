package com.bootcamp;

import java.util.Scanner;

public class ScannerWrapper {
    public String readInput() {
        System.out.print("Enter a string : ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println("String read from console is : \n" + inputString);
        return inputString;
    }
}
