package com.interlink;

public class Runner {

    public static void main(String[] args) {

        InputDate inputDate = new InputDateImpl();
        inputDate.inputValues();

        CalendarInfo calendarInfo = new CalendarInfoImpl(inputDate.getYearMonth());

        OutputCalendar output = new OutputCalendarImpl(calendarInfo.getYearMonth(), calendarInfo.getArrayOfDates());
        output.printCalendar();

    }

}
