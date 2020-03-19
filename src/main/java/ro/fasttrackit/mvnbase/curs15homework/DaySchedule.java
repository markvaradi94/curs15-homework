package ro.fasttrackit.mvnbase.curs15homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaySchedule {
    private WeekDays weekDay;
    private List<String> activities = new ArrayList<>();

    public DaySchedule(WeekDays weekDay, String activity) {
        this.weekDay = weekDay;
        addActivity(activity);
    }

    protected void addActivity(String activity) {
        if (!isActivityOnList(activity)) {
            this.activities.add(activity);
        }
    }

    private boolean isActivityOnList(String activity) {
        return this.activities.contains(activity);
    }

    public WeekDays getWeekDay() {
        return weekDay;
    }

    public List<String> getActivities() {
        return new ArrayList<>(this.activities);
    }

    protected void removeActivity(String activity) {
        if (isActivityOnList(activity)) {
            this.activities.remove(activity);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaySchedule schedule = (DaySchedule) o;
        return weekDay == schedule.weekDay &&
                Objects.equals(activities, schedule.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weekDay, activities);
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "weekDay = " + weekDay +
                ", activities = " + activities +
                '}';
    }
}