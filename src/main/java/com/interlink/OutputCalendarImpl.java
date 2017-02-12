package com.interlink;

import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OutputCalendarImpl implements OutputCalendar {

    private YearMonth yearMonth;

    private final String[][] dates;

    public OutputCalendarImpl(YearMonth yearMonth, String[][] dates) {

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
        printShortNamesOfDaysOfWeek();
        System.out.println("\t|");
    }

    private void printShortNamesOfDaysOfWeek() {
        Stream.of(DayOfWeek.values()).forEach(i -> System.out.print("\t" + i.toString().substring(0, 3)));
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
