package com.interlink;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class CalendarInfo {

    private final static int ROWS = 7;
    private final static int COLUMNS = (DayOfWeek.values().length + 1);

    private String[][] arrayOfDates;

    private final static String RED = "\u001B[31m";
    private final static String GREEN = "\u001B[32m";
    private final static String BLACK = "\u001B[0m";

    private YearMonth yearMonth;

    public CalendarInfo(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
        this.arrayOfDates = fillTheArraysOfDates();
    }

    private String[][] fillTheArraysOfDates() {

        String[][] arrayOfDates = new String[ROWS][COLUMNS];
        short firstDayOfMonth = 1;
        short firstWeek = 1;
        int numberOfFirstDayOfWeekInMonth = yearMonth.atDay(firstDayOfMonth).getDayOfWeek().getValue();

        for (int week = firstWeek, date = firstDayOfMonth; week < ROWS; week++) {

            int firstDayOfWeek = week > firstWeek ? DayOfWeek.MONDAY.getValue() : numberOfFirstDayOfWeekInMonth;

            for (int dayOfWeek = firstDayOfWeek; dayOfWeek < COLUMNS && date <= yearMonth.lengthOfMonth(); dayOfWeek++, date++) {

                if (date == LocalDate.now().getDayOfMonth() && yearMonth.equals(YearMonth.now())) {
                    setColorNumber(GREEN, week, dayOfWeek, date, arrayOfDates);
                } else {
                    if (isWeekend(dayOfWeek)) {
                        setColorNumber(RED, week, dayOfWeek, date, arrayOfDates);
                    } else {
                        setColorNumber(BLACK, week, dayOfWeek, date, arrayOfDates);
                    }
                }

            }

        }

        return arrayOfDates;

    }

    private boolean isWeekend(int dayOfWeek) {
        return dayOfWeek >= (DayOfWeek.SATURDAY.getValue());
    }

    private void setColorNumber(String color, int i, int y, int date, String[][] dates) {
        dates[i][y] = "\t" + color + date + BLACK;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public String[][] getArrayOfDates() {
        return arrayOfDates;
    }
}
