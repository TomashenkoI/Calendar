package com.interlink;

import java.time.LocalDate;
import java.time.YearMonth;

public class CalendarInfo {

    private int numberOfFirstDayOfWeekInMonth;
    private int lengthOfSelectedMonth;
    private int currentDate;
    private YearMonth yearMonth;
    private boolean isItCurrentMonth;

    public CalendarInfo(Input input) {

        this.yearMonth = getMonthByNumber(input.getNumberOfYear(), input.getNumberOfMonth());
        this.lengthOfSelectedMonth = yearMonth.lengthOfMonth();
        this.numberOfFirstDayOfWeekInMonth = setNumberOfTheFirstDayOfTheWeekInTheMonth();
        this.currentDate = LocalDate.now().getDayOfMonth();

        if (YearMonth.now().equals(this.yearMonth)) this.isItCurrentMonth = true;

    }

    private int setNumberOfTheFirstDayOfTheWeekInTheMonth() {
        int firstDay = 1;
        return yearMonth.atDay(firstDay).getDayOfWeek().getValue();
    }

    public YearMonth getMonthByNumber(int enteredNumberOfYear ,int enteredNumberOfMonth) {
        return YearMonth.of(enteredNumberOfYear, enteredNumberOfMonth);
    }

    public int getNumberOfFirstDayOfWeekInMonth() {
        return numberOfFirstDayOfWeekInMonth;
    }

    public int getLengthOfSelectedMonth() {
        return lengthOfSelectedMonth;
    }

    public int getCurrentDate() {
        return currentDate;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public boolean isItCurrentMonth() {
        return isItCurrentMonth;
    }
}
