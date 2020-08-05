package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Insurance {
    public static enum FormatStyle {SHORT, LONG, FULL};

    private ZonedDateTime start;
    private Duration duration;

    public Insurance(ZonedDateTime start) {
        this.start = start;
    }

    public Insurance(String strStart, FormatStyle style) {
        DateTimeFormatter dtf;

        switch(style) {
            case SHORT:
                dtf = DateTimeFormatter.ISO_LOCAL_DATE;
                break;
            case LONG:
                dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                break;
            case FULL:
                dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                break;
            default:
                dtf = null;
                break;
        }

        start = LocalDateTime.parse(strStart, dtf).atZone(ZoneId.of("Europe/Moscow"));
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration) {
        duration = Duration.between(start, expiration);
    }

    public void setDuration(int months, int days, int hours) {
        duration = Duration.between(start, start.plusMonths(months).plusDays(days).plusHours(hours));
    }

    public void setDuration(String strDuration, FormatStyle style) {
        switch (style) {
            case SHORT:
                duration = Duration.ofMillis(Long.parseLong(strDuration));
                break;
            case LONG:
                DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                LocalDateTime ldt1 = LocalDateTime.of(0, 1, 1, 0, 0, 0);
                LocalDateTime ldt2 = LocalDateTime.parse(strDuration, dtf);
                duration = Duration.between(ldt1, ldt2);
                break;
            case FULL:
                duration = Duration.parse(strDuration);
                break;
        };
    }

    public boolean checkValid(ZonedDateTime dateTime){
        ZonedDateTime lzdt = start;
        ZonedDateTime nzdt = ZonedDateTime.now(start.getZone());

        Instant lins;
        Instant nins;

        boolean result = false;

        if (duration == null) {
            result = true;
        }
        else {
            lzdt.plusNanos(duration.toNanos());

            lins = lzdt.toInstant();
            nins = nzdt.toInstant();

            if (nins.isAfter(lins) && nins.equals(lins)) {
                result = true;
            }
        }

        return result;
    }

    public String toString() {
        String validStr;

        if (duration == null || this.checkValid(ZonedDateTime.now())) {
            validStr = " is valid";
        }
        else {
            validStr = " is not valid";
        }

        return "Insurance issued on " + start + validStr;
    }
}
