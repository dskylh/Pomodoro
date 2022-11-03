package org.sessions;

public record Session(int sessionDuration, SessionType sessionType, String tag) {
    public Session(int sessionDuration, SessionType sessionType){
        this(sessionDuration, sessionType, "default");
    }
}
