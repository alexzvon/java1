package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

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
        for (var us: sessions.values()) {
            if(!checkSessionValid(us)) {
                sessions.remove(us.getSessionHandle());
            }
        }
    }

    private boolean checkSessionValid(UserSession us) {
        boolean result = false;
        Duration dur = Duration.between(us.getLastAccess(), ZonedDateTime.now());
        if (dur.toSeconds() <= sessionValid) {
            result = true;
        }

        return result;
    }

    static class UserSession {
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
    }

    public static void main(String[] args) {

    }
}

//Реализовать класс для хранения пользовательских сессий для сервера, который проверяет
// аутентификацию пользователей. Менеджер работает по следующему принципу: при логине
// (считаем что проверка логин-пароль уже прошла) данные о сессии пользователя заносятся в список
// и возвращается хэндл сессии. Затем пользователи запрашивают информацию используя хэндл,
// авторизация идет по хендлу сессии, который валиден определенное время, с момента крайнего запроса.
// Проверка сессии по хендлу должна работать максимально быстро. У каждого пользователя может быть только
// одна сессия.

//Протестировать следующим образом:
//
//Создать сессию по userName, для этого
//- сделать find,
//- убедиться что вернется null
//- создать новую сессию
//- добавить используя add
//
//Вызвать несколько раз get
//
//Подождать (Thread.sleep) время, большее, чем время валидности
//
//Проверить что сессии нет через метод get
//
//Создать еще одну сессию
//
//Подождать половину времени валидности сессии
//
//Создать еще одну сессию
//
//Подождать еще раз половину времени валидности сессии
//
//Вызвать deleteExpired()
//
//Убедиться, что одна сессия удалена, вторая нет
//
//Удалить оставшуюся через метод delete
//
//Убедиться что удаление прошло
