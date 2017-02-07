package com.interlink;

public class Runner {

    public static void main(String[] args) {

        Input input = new Input();
        input.inputValues();

        CalendarInfo calendarInfo = new CalendarInfo(input);

        Output output = new Output(calendarInfo);
        output.printCalendar();

    }
}
