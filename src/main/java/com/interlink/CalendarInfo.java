package com.interlink;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class CalendarInfo {

    private final static int ROWS = 6;
    private final static int COLUMNS = 7;

    private String[][] dates;

    private final static String RED = "\u001B[31m";
    private final static String GREEN = "\u001B[32m";
    private final static String BLACK = "\u001B[0m";

    private int currentDate;

    private YearMonth yearMonth;

    public CalendarInfo(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
        this.currentDate = LocalDate.now().getDayOfMonth();
        this.dates = fillTheArraysOfDates();
    }

    private String[][] fillTheArraysOfDates() {

        String[][] dates = new String[ROWS][COLUMNS];

        for (int i = 0, date = 1; i < ROWS; i++) {

            short firstDayInMonth = 1;
            int numberOfFirstDayOfWeekInMonth = yearMonth.atDay(firstDayInMonth).getDayOfWeek().getValue();
            int firstDatePosition = i > 0 ? 0 : numberOfFirstDayOfWeekInMonth - 1;

            for (int y = firstDatePosition; y < COLUMNS && date <= yearMonth.lengthOfMonth(); y++, date++) {

                if (date == currentDate && yearMonth.equals(YearMonth.now())) {
                    setColorNumber(GREEN, i, y, date, dates);
                } else {
                    if (isWeekend(y)) {
                        setColorNumber(RED, i, y, date, dates);
                    } else {
                        setColorNumber(BLACK, i, y, date, dates);
                    }
                }

            }

        }

        return dates;

    }

    private boolean isWeekend(int y) {
        return y >= (DayOfWeek.SATURDAY.getValue() - 1);
    }

    private void setColorNumber(String color, int i, int y, int date, String[][] dates) {
        dates[i][y] = "\t" + color + date + BLACK;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public String[][] getDates() {
        return dates;
    }
}
