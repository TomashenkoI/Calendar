package com.interlink;

import java.util.stream.IntStream;

    public class Output {

        private String monthAndYear;
        private int lengthOfTheMonth;
        private int numberOfFirstDayOfWeekInMonth;

        private String currentDate = "";

        private final static int ROWS = 6;
        private final static int COLUMNS = 7;

        private final static String RED = "\u001B[31m";
        private final static String GREEN = "\u001B[32m";
        private final static String BLACK = "\u001B[0m";

        private final String[] daysOfWeek = {"Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "Sun"};

        private final String[][] dates = new String[ROWS][COLUMNS];

        public Output(CalendarInfo calendarInfo) {

            this.monthAndYear = calendarInfo.getYearMonth().toString();
            this.lengthOfTheMonth = calendarInfo.getLengthOfSelectedMonth();
            this.numberOfFirstDayOfWeekInMonth = calendarInfo.getNumberOfFirstDayOfWeekInMonth();

            if (calendarInfo.isItCurrentMonth()) this.currentDate = String.valueOf(calendarInfo.getCurrentDate());
            fillingTheArraysOfDates();
        }

        public void printCalendar() {

            System.out.println("Calendar for " + monthAndYear);

            System.out.println("---------------------------------");

            System.out.print("|");
            IntStream.range(0, daysOfWeek.length).forEach(i -> System.out.print("\t" + daysOfWeek[i]));
            System.out.println("\t|");

            IntStream.range(0, ROWS).forEach(i -> IntStream.range(0, COLUMNS).forEach(y -> printRows(i, y)));

            System.out.println("---------------------------------");

        }

        private void printRows(int i, int y) {

            if (y == 0) System.out.print("|");

            if (dates[i][y] != null) {
                if (currentDate.equals(dates[i][y])) {
                    printColorNumber(GREEN, i, y);
                } else {
                    if (isWeekend(y)) {
                        printColorNumber(RED, i ,y);
                    } else {
                        System.out.print("\t" + dates[i][y]);
                    }
                }
            } else {
                System.out.print("\t");
            }

            if (y == COLUMNS - 1) System.out.println("\t|");
        }

        private boolean isWeekend(int y) {
            short dayOfTheWeek = 5;
            return y >= dayOfTheWeek;
        }

        private void printColorNumber(String color, int i, int y) {
            System.out.print("\t" + color + dates[i][y] + BLACK);
        }

        private void fillingTheArraysOfDates() {
            for (int i = 0, date = 1; i < ROWS; i++) {
                int firstDatePosition = i > 0 ? 0 : numberOfFirstDayOfWeekInMonth - 1;
                for (int y = firstDatePosition; y < COLUMNS && date <= lengthOfTheMonth; y++, date++) {
                        dates[i][y] = String.valueOf(date);
                }
            }
        }
    }
