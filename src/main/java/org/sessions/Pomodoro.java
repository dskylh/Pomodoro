package org.sessions;

import org.clock.Clock;

import java.util.ArrayList;

public class Pomodoro {
    private final ArrayList<Session> pomodoro;
    private final int workSessionCount;
    private final int workDuration;
    private final int shortBreakDuration;
    private final int longBreakDuration;


    public Pomodoro() {
        workSessionCount = 4;
        workDuration = 25;
        shortBreakDuration = 5;
        longBreakDuration = 15;
        pomodoro = setUpPomodoro(workSessionCount, workDuration, shortBreakDuration, longBreakDuration);
    }

    public Pomodoro(int workSessionCount, int workDuration, int shortBreakDuration, int longBreakDuration) {
        this.workSessionCount = workSessionCount;
        this.workDuration = workDuration;
        this.shortBreakDuration = shortBreakDuration;
        this.longBreakDuration = longBreakDuration;
        pomodoro = setUpPomodoro(this.workSessionCount, this.workDuration, this.shortBreakDuration, this.longBreakDuration);
    }

    private ArrayList<Session> setUpPomodoro(int workSessionCount, int workDuration, int shortBreakDuration, int longBreakDuration) {
        ArrayList<Session> sessions = new ArrayList<>();
        Session workSession = new Session(workDuration, SessionType.Work);
        Session shortBreakSession = new Session(shortBreakDuration, SessionType.ShortBreak);
        Session longBreakSession = new Session(longBreakDuration, SessionType.LongBreak);
        for (int i = 0; i < workSessionCount; i++) {
            sessions.add(workSession);
            if (i == workSessionCount - 1)
                break;
            else
                sessions.add(shortBreakSession);
        }
        sessions.add(longBreakSession);
        return sessions;
    }

    public void startPomodoro() {
        for (Session session :
                pomodoro) {
            if (session.sessionType() == SessionType.Work) {
                System.out.println("Work Session: ");
                Clock clock = new Clock(session.sessionDuration() * 60);
                clock.start();
            } else if (session.sessionType() == SessionType.ShortBreak) {
                System.out.println("Short Break Time: ");
                Clock clock = new Clock(session.sessionDuration() * 60);
                clock.start();
            } else {
                System.out.println("Long Break Time: ");
                Clock clock = new Clock(session.sessionDuration() * 60);
                clock.start();
            }

        }

    }


    public ArrayList<Session> getPomodoro() {
        return pomodoro;
    }

    public int getWorkSessionCount() {
        return workSessionCount;
    }

    public int getWorkDuration() {
        return workDuration;
    }

    public int getShortBreakDuration() {
        return shortBreakDuration;
    }

    public int getLongBreakDuration() {
        return longBreakDuration;
    }
}
