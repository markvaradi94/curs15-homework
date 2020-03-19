package ro.fasttrackit.mvnbase.curs15homework.exceptions;

public class NoActivitiesForDayException extends Exception {

    public NoActivitiesForDayException() {
        super("No activities for day.");
    }

    public String getMessage() {
        return "Not all days have scheduled activities.";
    }
}
