package ohtu;

import java.util.*;

public class Submission {

    private String student_number;
    private int hours;
    private int week;
    private ArrayList<Boolean> tasks = new ArrayList<>();

    public String getStudent_number() {
        return student_number;
    }

    public int getHours() {
        return hours;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public void addSubmission(boolean done) {
        tasks.add(done);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("viikko ");
        sb.append(week);
        sb.append(": tehtyjä tehtäviä yhteensä: ");
        sb.append(doneCount());
        sb.append(" (maksimi ");
        sb.append(tasks.size());
        sb.append("), aikaa kului ");
        sb.append(hours);
        sb.append(" tuntia, tehdyt tehtävät:");
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i)) {
                sb.append(" ").append(i + 1);
            }
        }
        return sb.toString();
    }

    public int doneCount() {
        return (int) tasks.stream().filter(e -> e).count();
    }

}
