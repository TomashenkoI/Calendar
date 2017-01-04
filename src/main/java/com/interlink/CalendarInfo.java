package com.interlink;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class CalendarInfo {

    private int numberOfTheFirstDayOfTheWeekInTheMonth;
    private int lengthOfSelectedMonth;
    private int currentDate;
    private YearMonth yearMonth;
    private boolean isItCurrentMonth;

    public CalendarInfo(Input input) {

        this.yearMonth = getMonthByNumber(input.getNumberOfYear(), input.getNumberOfMonth());
        this.lengthOfSelectedMonth = yearMonth.lengthOfMonth();
        this.numberOfTheFirstDayOfTheWeekInTheMonth = setNumberOfTheFirstDayOfTheWeekInTheMonth();
        this.currentDate = LocalDate.now().getDayOfMonth();

        if (YearMonth.now().equals(this.yearMonth)) this.isItCurrentMonth = true;

    }

    private int setNumberOfTheFirstDayOfTheWeekInTheMonth() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek().getValue();
    }

    public YearMonth getMonthByNumber(int enteredNumberOfYear ,int enteredNumberOfMonth) {
        return YearMonth.of(enteredNumberOfYear, enteredNumberOfMonth);
    }

    public int getNumberOfTheFirstDayOfTheWeekInTheMonth() {
        return numberOfTheFirstDayOfTheWeekInTheMonth;
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
