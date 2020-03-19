package ro.fasttrackit.mvnbase.curs15homework;

import ro.fasttrackit.mvnbase.curs15homework.exceptions.NoActivitiesForDayException;
import ro.fasttrackit.mvnbase.curs15homework.exceptions.NoActivityException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {
    private List<DaySchedule> schedules = new ArrayList<>();

    public void addActivity(WeekDays day, String activity) {
        if (activity == null) {
            throw new NoActivityException();
        }
        DaySchedule schedule = getScheduleByDay(day);
        if (schedule == null) {
            schedule = new DaySchedule(day, activity);
            addToPlanner(schedule);
        }
        addActivityToSchedule(schedule, activity);
    }

    public void removeActivity(WeekDays day, String activity) {
        DaySchedule schedule = getScheduleByDay(day);
        if (schedule == null) {
            throw new NoActivityException();
        }
        removeActivityFromSchedule(schedule, activity);
        if (noActivitiesInSchedule(schedule)) {
            removeFromPlanner(schedule);
        }
    }

    public List<String> getActivities(WeekDays day) {
        DaySchedule schedule = getScheduleByDay(day);
        if (schedule == null) {
            return List.of();
        }
        return schedule.getActivities();
    }

    public Map<WeekDays, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<WeekDays, List<String>> result = new HashMap<>();
        for (DaySchedule schedule : this.schedules) {
            result.put(schedule.getWeekDay(), schedule.getActivities());
        }
        if (result.keySet().size() < WeekDays.values().length) {
            throw new NoActivitiesForDayException();
        }
        return result;
    }

    private void removeFromPlanner(DaySchedule schedule) {
        if (isOnScheduleList(schedule)) {
            this.schedules.remove(schedule);
        }
    }

    private boolean isOnScheduleList(DaySchedule schedule) {
        return this.schedules.contains(schedule);
    }

    private boolean noActivitiesInSchedule(DaySchedule schedule) {
        return schedule.getActivities().isEmpty();
    }

    private void removeActivityFromSchedule(DaySchedule schedule, String activity) {
        schedule.removeActivity(activity);
    }

    private DaySchedule getScheduleByDay(WeekDays day) {
        for (DaySchedule schedule : this.schedules) {
            if (schedule.getWeekDay().equals(day)) {
                return schedule;
            }
        }
        return null;
    }

    private void addToPlanner(DaySchedule schedule) {
        this.schedules.add(schedule);
    }

    private void addActivityToSchedule(DaySchedule schedule, String activity) {
        schedule.addActivity(activity);
    }

    public List<DaySchedule> getSchedules() {
        return schedules;
    }
}
