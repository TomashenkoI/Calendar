package com.interlink;

import java.util.stream.IntStream;

public class Output {

    private String monthAndYear;
    private int lengthOfTheMonth;
    private int numberOfTheFirstDayOfTheWeekInTheMonth;

    private String currentDate = "";

    private final static int ROWS = 6;
    private final static int COLUMNS = 7;

    private final static String RED = "\u001B[31m";
    private final static String GREEN = "\u001B[32m";

    private final String[] daysOfWeek = {"Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "Sun"};

    private final String[][] dates = new String[ROWS][COLUMNS];

    public Output(CalendarInfo calendarInfo) {

        this.monthAndYear = calendarInfo.getYearMonth().toString();
        this.lengthOfTheMonth = calendarInfo.getLengthOfSelectedMonth();
        this.numberOfTheFirstDayOfTheWeekInTheMonth = calendarInfo.getNumberOfTheFirstDayOfTheWeekInTheMonth();

        if (calendarInfo.isItCurrentMonth()) this.currentDate = String.valueOf(calendarInfo.getCurrentDate());

    }

    public void run() {

        hideNullPositions(dates);
        fillingTheArraysOfDates();

        System.out.println("Calendar for " + monthAndYear);

        System.out.println("---------------------------------");

        System.out.print("|");
        IntStream.range(0, daysOfWeek.length).forEach(i -> System.out.print("\t" + daysOfWeek[i]));
        System.out.println("\t|");

        IntStream.range(0, ROWS).forEach(i -> IntStream.range(0, COLUMNS).forEach(y -> printRows(i, y)));

        System.out.println("---------------------------------");

    }

    private void printRows(int i, int y){

        if (y == 0) System.out.print("|");

        if (currentDate.equals(dates[i][y])) {
            printColorNumber(GREEN, i, y);
        } else {
            if (isWeekend(y)) {
                printColorNumber(RED, i ,y);
            } else {
                System.out.print("\t" + dates[i][y]);
            }
        }

        if (y == COLUMNS - 1) System.out.println("\t|");
    }

    private boolean isWeekend(int y) {
        return y > 4;
    }

    private void printColorNumber(String color, int i, int y) {
        System.out.print("\t" + color + dates[i][y] + "\u001B[0m");
    }

    private void hideNullPositions(String[][] dates){
        IntStream.range(0, ROWS).forEach(i ->
                IntStream.range(0, COLUMNS).forEach(y -> dates[i][y] = " "));
    }

    private void fillingTheArraysOfDates() {
        for (int i = 0, date = 1; i < ROWS; i++) {
            int firstDatePosition = i > 0 ? 0 : numberOfTheFirstDayOfTheWeekInTheMonth - 1;
            for (int y = firstDatePosition; y < COLUMNS && date <= lengthOfTheMonth; y++, date++) {
                    dates[i][y] = String.valueOf(date);
            }
        }
    }
}
