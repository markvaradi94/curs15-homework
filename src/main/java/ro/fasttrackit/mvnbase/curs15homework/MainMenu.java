package ro.fasttrackit.mvnbase.curs15homework;

import ro.fasttrackit.mvnbase.curs15homework.exceptions.NoActivitiesForDayException;

import java.util.Scanner;

public class MainMenu {
    private DailyPlanner planner;

    public MainMenu(DailyPlanner planner) {
        this.planner = planner;
    }

    public void run() throws NoActivitiesForDayException {
        int input = 0;
        do {
            printMainMenu();
            input = getInput();
            executeInput(input);
        } while (input != 4);
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("===========================================================================");
        System.out.println("(1) List all current activities for the day");
        System.out.println("(2) Add activity");
        System.out.println("(3) Remove activity");
        System.out.println("(4) End planning");
        System.out.println("===========================================================================");
    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select your option: ");
        return scanner.nextInt();
    }

    private void executeInput(int input) throws NoActivitiesForDayException {
        switch (input) {
            case 1:
                handleGetAllActivities();
                break;

            case 2:
                handleAddActivity();
                break;

            case 3:
                handleRemoveActivity();
                break;

            case 4:
                handleEndPlanning();
                break;

            default:
                System.out.println("Invalid option");
        }
    }

    private void handleGetAllActivities() {
        System.out.println(planner.getActivities(getDay()));
    }

    private void handleAddActivity() {
        planner.addActivity(getDay(), getActivity());
    }

    private void handleRemoveActivity() {
        planner.removeActivity(getDay(), getActivity());
    }

    private void handleEndPlanning() {
        try {
            for (WeekDays key : planner.endPlanning().keySet()) {
                System.out.println(key + ": " + planner.endPlanning().get(key));
            }
        } catch (NoActivitiesForDayException nafde) {
            System.err.println(nafde.getMessage());
        }
    }

    private WeekDays getDay() {
        System.out.print("Select day: ");
        return WeekDays.valueOf(new Scanner(System.in).next().toUpperCase());
    }

    private String getActivity() {
        System.out.print("Select activity: ");
        return new Scanner(System.in).nextLine();
    }
}
