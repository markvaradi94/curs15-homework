package ro.fasttrackit.mvnbase.curs15homework.exceptions;

public class NoActivityException extends RuntimeException {

    public NoActivityException() {
        super("Invalid activity.");
    }
}
