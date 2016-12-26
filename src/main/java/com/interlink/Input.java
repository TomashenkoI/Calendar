package com.interlink;

import java.util.Scanner;

public class Input {

    private int numberOfYear;
    private int numberOfMonth;

    public Input() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the year:");
        this.numberOfYear = enteringValidNumbers(scanner, false);

        System.out.println("Enter the number of the month:");
        this.numberOfMonth = enteringValidNumbers(scanner, true);

    }

    private int enteringValidNumbers(Scanner scanner, boolean numberForMonth) {

        boolean isItCorrectNumber = false;
        int enteredNumber = 0;

        while (!isItCorrectNumber) {

            try {
                enteredNumber = Integer.parseInt(scanner.nextLine());
                if (enteredNumber > 0) {
                    isItCorrectNumber = true;
                    if (numberForMonth) {
                        if (enteredNumber > 12) {
                            isItCorrectNumber = false;
                            System.out.println("Enter the number 1-12: ");
                        }
                    }
                } else {
                    System.out.println("The number should be > 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("It should be the digit > 0!");
            }
        }
        return enteredNumber;
    }

    public int getNumberOfYear() {
        return numberOfYear;
    }

    public int getNumberOfMonth() {
        return numberOfMonth;
    }
}
