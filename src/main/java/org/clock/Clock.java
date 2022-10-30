package org.clock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock {
    private int duration;
    private int remaining_secs;
    private int remaining_mins;
    private int remaining_hours;
    public Clock(int duration){
        this.duration = duration;
    }
    public void start(){
        for (int i = duration; i >= 0; i--) {
            remaining_secs = i % 60;
            remaining_mins = i / 60;
            remaining_hours = i / 3600;
            LocalTime remain = LocalTime.of(remaining_hours, remaining_mins, remaining_secs);
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

}

