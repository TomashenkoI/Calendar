package com.interlink;

import java.time.YearMonth;
import java.util.Scanner;

public class InputDate {

    private YearMonth yearMonth;

    public void inputValues() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the year:");
        int numberOfYear = enterNumberOfYear(scanner);

        System.out.println("Enter the number of the month:");
        int numberOfMonth = enterNumberOfMonth(scanner);

        this.yearMonth = YearMonth.of(numberOfYear, numberOfMonth);
    }

    private int enterNumberOfYear(Scanner scanner) {

        boolean isItCorrectNumber = false;
        int enteredNumber = 0;

        while (!isItCorrectNumber) {

            try {
                enteredNumber = Integer.parseInt(scanner.nextLine());
                if (enteredNumber > 0) {
                    isItCorrectNumber = true;
                } else {
                    System.out.println("The number should be > 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("It should be a digit > 0!");
            }
        }
        return enteredNumber;
    }

    private int enterNumberOfMonth(Scanner scanner) {

        boolean isItCorrectNumber = false;
        final int numberOfMonths = 12;
        int enteredNumber = 0;

        while (!isItCorrectNumber) {

            try {
                enteredNumber = Integer.parseInt(scanner.nextLine());
                if (enteredNumber > 0 & enteredNumber <= numberOfMonths) {
                    isItCorrectNumber = true;
                } else {
                    System.out.println("The number should be > 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("It should be a digit 1-12 !");
            }
        }
        return enteredNumber;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }
}

