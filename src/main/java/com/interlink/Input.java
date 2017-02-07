package com.interlink;

import java.util.Scanner;

public class Input {

    private int numberOfYear;
    private int numberOfMonth;

    public void inputValues() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the year:");
        boolean numberForMonth = false;
        this.numberOfYear = enteringValidNumber(scanner, numberForMonth);

        System.out.println("Enter the number of the month:");
        numberForMonth = true;
        this.numberOfMonth = enteringValidNumber(scanner, numberForMonth);
    }

    private int enteringValidNumber(Scanner scanner, boolean numberForMonth) {

        boolean isItCorrectNumber = false;
        final int numberOfMonths = 12;
        int enteredNumber = 0;

        while (!isItCorrectNumber) {

            try {
                enteredNumber = Integer.parseInt(scanner.nextLine());
                if (enteredNumber > 0) {
                    isItCorrectNumber = true;
                    if (numberForMonth) {
                        if (enteredNumber > numberOfMonths) {
                            isItCorrectNumber = false;
                            System.out.println("Enter the number 1-12: ");
                        }
                    }
                } else {
                    System.out.println("The number should be > 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("It should be a digit > 0!");
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
