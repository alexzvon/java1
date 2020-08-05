package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class SessionManager {
    private Map<Integer, UserSession> sessions = new Hashtable<>();
    private int sessionValid;

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession) {
        if(userSession != null) {
            sessions.put(userSession.getSessionHandle(), userSession);
        }
    }

    public UserSession find(String userName) {
        UserSession result = null;

        if(!userName.equals("")) {
            for (var us: sessions.values()) {
                if (us.getUserName().equals(userName) && checkSessionValid(us)) {
                    us.updateLastAccess();
                    result = us;
                    break;
                }
            }
        }

        return result;
    }

    public UserSession get(int sessionHandle) {
        UserSession us = sessions.get(sessionHandle);

        if (us != null && checkSessionValid(us)) {
            us.updateLastAccess();
        }
        else {
            us = null;
        }

        return us;
    }

    public void delete(int sessionHandle) {
        sessions.remove(sessionHandle);
    }

    public void deleteExpired() {
        List<Integer> lus = new ArrayList<>();

        for (var us: sessions.values()) {
            if(!checkSessionValid(us)) {
                lus.add(us.getSessionHandle());
            }
        }

        for (Integer sh: lus) {
            sessions.remove(sh);
        }
    }

    private boolean checkSessionValid(UserSession us) {
        boolean result = false;
        Duration dur = Duration.between(us.getLastAccess(), ZonedDateTime.now());
        if (dur.toSeconds() < sessionValid) {       //TODO строгое ограничение время доступа к сессии
            result = true;
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "";

        for (var us: sessions.values()) {
            result += us.toString() + "\n";
        }

        return result;
    }

    class UserSession {
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

    public static void main(String[] args) {
        int sv = 10;
        String name1 = "Иванов";
        String name2 = "Сидоров";
        String name3 = "Петров";

        SessionManager sm = new SessionManager(sv);

        try {
            if (sm.find(name1) == null) {
                var session1 = sm.new UserSession(name1);
                sm.add(session1);

                System.out.println(sm.get(session1.getSessionHandle()));
                System.out.println(sm.get(session1.getSessionHandle()));
                System.out.println(sm.get(session1.getSessionHandle()));

                TimeUnit.SECONDS.sleep(15);

                if (sm.find(name1) == null) {
                    var session2 = sm.new UserSession(name2);
                    sm.add(session2);
                    System.out.println(sm.sessions);

                    TimeUnit.SECONDS.sleep(5);
                    var session3 = sm.new UserSession(name3);
                    sm.add(session3);
                    System.out.println(sm.sessions);

                    TimeUnit.SECONDS.sleep(6);
                    sm.deleteExpired();
                    System.out.println(sm.sessions);

                    sm.delete(session3.getSessionHandle());
                    System.out.println(sm.sessions);
                }
                else {
                    System.out.println("Ошибка поиска сессии по имени после времени доступа к сессии ");
                }
            } else {
                System.out.println("Ошибка поиска сессии по имени");
            }
        }
        catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
