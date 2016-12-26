package com.interlink;

import java.time.LocalDate;
import java.time.YearMonth;

public class CalendarInfo {

    private int numberOfTheFirstDayOfTheWeekInTheMonth;
    private int lengthOfSelectedMonth;
    private int currentDate;
    private YearMonth yearMonth;
    private boolean isItCurrentMonth;

    public CalendarInfo(Input input) {

        setYearMonth(getMonthByNumber(input.getNumberOfYear(), input.getNumberOfMonth()));
        setLengthOfSelectedMonth();
        setNumberOfTheFirstDayOfTheWeekInMonth();
        setCurrentDate();

        if (YearMonth.now().equals(this.getYearMonth())) this.isItCurrentMonth = true;

    }

    public YearMonth getMonthByNumber(int enteredNumberOfYear ,int enteredNumberOfMonth) {
        return YearMonth.of(enteredNumberOfYear, enteredNumberOfMonth);
    }

    public int getNumberOfTheFirstDayOfTheWeek() {
        return numberOfTheFirstDayOfTheWeekInTheMonth;
    }

    private void setNumberOfTheFirstDayOfTheWeekInMonth() {
        this.numberOfTheFirstDayOfTheWeekInTheMonth = yearMonth.atDay(1).getDayOfWeek().getValue();
    }

    public int getLengthOfSelectedMonth() {
        return lengthOfSelectedMonth;
    }

    public void setLengthOfSelectedMonth() {
        this.lengthOfSelectedMonth = yearMonth.lengthOfMonth();
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public int getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate() {
        this.currentDate = LocalDate.now().getDayOfMonth();
    }

    public boolean isItCurrentMonth() {
        return isItCurrentMonth;
    }
}
