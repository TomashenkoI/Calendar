package com.interlink;

import java.time.DayOfWeek;
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

    public void printDate(int week, int dayOfWeek) {
        if (dayOfWeek == DayOfWeek.MONDAY.getValue()) System.out.print("|");

        if (dates[week][dayOfWeek] != null) {
            System.out.print(dates[week][dayOfWeek]);
        } else {
            System.out.print("\t");
        }

        if (dayOfWeek == DayOfWeek.SUNDAY.getValue()) {
            System.out.println("\t|");
        }
    }

    private void printRows(String[][] dates) {
        short firstWeek = 1;
        IntStream.range(firstWeek, dates.length).forEach(week ->
                IntStream.range(DayOfWeek.MONDAY.getValue(), dates[week].length).forEach(day -> printDate(week, day)));
    }

}
