package org.clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock {
    private final int duration;
    private int remaining_secs;
    private int remaining_mins;
    private int remaining_hours;
    public Clock(int duration){
        this.duration = duration;
    }
    public void start(){
        // todo implement stopping functionality
        for (int i = getDuration(); i >= 0; i--) {
            remaining_secs = i % 60;
            remaining_mins = i / 60;
            remaining_hours = i / 3600;
            LocalTime remain = LocalTime.of(getRemaining_hours(), getRemaining_mins(), getRemaining_secs());
            System.out.print("\r" + remain.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            System.out.flush();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("\nThe timer is up");

    }

    public int getDuration() {
        return duration;
    }

    public int getRemaining_secs() {
        return remaining_secs;
    }

    public int getRemaining_mins() {
        return remaining_mins;
    }

    public int getRemaining_hours() {
        return remaining_hours;
    }
}

