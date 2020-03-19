package ro.fasttrackit.mvnbase.curs15homework;

import ro.fasttrackit.mvnbase.curs15homework.exceptions.NoActivitiesForDayException;

public class Main {
    public static void main(String[] args) throws NoActivitiesForDayException {
        DailyPlanner planner = new DailyPlanner();
        MainMenu menu = new MainMenu(planner);
        menu.run();
    }
}
