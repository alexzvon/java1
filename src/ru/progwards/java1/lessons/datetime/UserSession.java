package ru.progwards.java1.lessons.datetime;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UserSession {
    private int sessionHandle;
    private String userName;
    private ZonedDateTime lastAccess;

    private Random random = new Random();

    public UserSession(String userName) {
        this.userName = userName;
        updateLastAccess();
        sessionHandle = Integer.valueOf(random.nextInt()).hashCode();
    }

    public void updateLastAccess() {
        lastAccess = ZonedDateTime.now();
    }

    public int getSessionHandle() {
        return sessionHandle;
    }

    public String getUserName() {
        return userName;
    }

    public ZonedDateTime getLastAccess() {
        return lastAccess;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        return sessionHandle + "\t\t" + userName + "\t\t" + lastAccess.format(dtf);
    }
}
