package com.interlink;

public class Runner {

    public static void main(String[] args) {

        InputDate inputDate = new InputDate();
        inputDate.inputValues();

        CalendarInfo calendarInfo = new CalendarInfo(inputDate.getYearMonth());

        Output output = new Output(calendarInfo.getYearMonth(), calendarInfo.getArrayOfDates());
        output.printCalendar();

    }
}
