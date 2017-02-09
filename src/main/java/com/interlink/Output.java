package com.interlink;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Output {

    private YearMonth yearMonth;

    private final String[] daysOfWeek = {"Mon", "Tue", "Wen", "Thu", "Fri", "Sat", "Sun"};

    private final String[][] dates;

    public Output(YearMonth yearMonth, String[][] dates) {

        this.yearMonth = yearMonth;
        this.dates = dates;
    }

    public void printCalendar() {

        System.out.println("Calendar for " + yearMonth.toString());

        printHeader();

        printRows(dates);

        printFooter();

    }

    private void printFooter() {
        System.out.println("---------------------------------");
    }

    private void printHeader() {
        System.out.println("---------------------------------");

        System.out.print("|");
        Arrays.asList(daysOfWeek).forEach(i -> System.out.print("\t" + i));
        System.out.println("\t|");
    }

    public void printDates(int week, int day) {
        if (day == 0) System.out.print("|");

        if (dates[week][day] != null) {
            System.out.print(dates[week][day]);
        } else {
            System.out.print("\t");
        }

        if (day == dates[0].length - 1) {
            System.out.println("\t|");
        }
    }

    private void printRows(String[][] dates) {
        IntStream.range(0, dates.length).forEach(i -> IntStream.range(0, dates[i].length).forEach(y -> printDates(i, y)));
    }

}
