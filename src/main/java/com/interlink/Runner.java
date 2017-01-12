package com.interlink;

public class Runner {

    public static void main(String[] args) {

        Input input = new Input();

        CalendarInfo calendarInfo = new CalendarInfo(input);

        Output output = new Output(calendarInfo);
        output.run();

    }
}
