package com.interlink;

import java.util.stream.IntStream;

public class Output {

    private String monthAndYear;
    private int lengthOfTheMonth;
    private int numberOfTheFirstDayOfTheWeekInTheMonth;

    private String currentDate = "";

    private int rows = 6;
    private int columns = 7;

    String[] daysOfWeek = {"Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "  Sun"};

    String[][] dates = new String[rows][columns];

    public Output(CalendarInfo calendarInfo) {

        this.monthAndYear = calendarInfo.getYearMonth().toString();
        this.lengthOfTheMonth = calendarInfo.getLengthOfSelectedMonth();
        this.numberOfTheFirstDayOfTheWeekInTheMonth = calendarInfo.getNumberOfTheFirstDayOfTheWeekInTheMonth();

        if (calendarInfo.isItCurrentMonth()) this.currentDate = String.valueOf(calendarInfo.getCurrentDate());

    }

    public void run() {

        hideNullPositions(dates);
        fillTheArraysOfDates();

        System.out.println("Calendar for " + monthAndYear);

        System.out.println("--------------------------------");

        System.out.print("|");
        IntStream.range(0, daysOfWeek.length).forEach(i -> System.out.printf("%4s", daysOfWeek[i]));
        System.out.println(" |");

        IntStream.range(0, rows).forEach(i -> IntStream.range(0, columns).forEach(y -> printRows(i, y)));

        System.out.println("--------------------------------");

    }

    private void printRows(int i, int y){

        if (y == 0) System.out.print("|");
        if (!currentDate.equals(dates[i][y])) {
            if (y == 5) {
                System.out.printf("%s %3s %s", "\u001B[31m", dates[i][y], "\u001B[0m");
            } else if (y == 6){
                System.out.printf("%s %2s %s", "\u001B[31m", dates[i][y], "\u001B[0m");
            } else {
                System.out.printf("%4s", dates[i][y]);
            }
        } else {
            if (y == 5) {
                System.out.printf("%s %3s %s", "\u001B[33m", dates[i][y], "\u001B[0m");
            } else if (y == 6){
                System.out.printf("%s %2s %s", "\u001B[33m", dates[i][y], "\u001B[0m");
            } else {
                System.out.printf("%s %2s %s", "\u001B[33m", dates[i][y], "\u001B[0m");
            }
        }
        if (y == columns - 1) System.out.println(" |");

    }

    private void hideNullPositions(String[][] dates){
        IntStream.range(0,rows).forEach(i ->
                IntStream.range(0, columns).forEach(y -> dates[i][y] = " "));
    }

    private void fillTheArraysOfDates() {
        for (int i = 0, date = 1; i < rows; i++) {
            for (int y = i != 0 ? 0 : numberOfTheFirstDayOfTheWeekInTheMonth - 1; y < columns && date <= lengthOfTheMonth; y++, date++) {
                    dates[i][y] = String.valueOf(date);
            }
        }
    }
}
