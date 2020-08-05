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
                start = LocalDateTime.of(LocalDate.parse(strStart, dtf), LocalTime.of(0, 0, 0)).atZone(ZoneId.of("Europe/Moscow"));
                break;
            case LONG:
                dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                start = LocalDateTime.parse(strStart, dtf).atZone(ZoneId.of("Europe/Moscow"));
                break;
            case FULL:
                dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                start = ZonedDateTime.parse(strStart);
                break;
            default:
                dtf = null;
                break;
        }
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
        ZonedDateTime clzdt;
        ZonedDateTime nzdt = ZonedDateTime.now(start.getZone());

        boolean result = false;

        if (lzdt.isBefore(nzdt) || nzdt.equals(lzdt)) {
            if (duration == null) {
                result = true;
            }
            else {
                clzdt = lzdt.plusNanos(duration.toNanos());
                if (clzdt.isAfter(nzdt) || clzdt.equals(nzdt)) {
                    result = true;
                }
            }
        }

        return result;
    }

    @Override
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

    public static void main(String[] args) {

    }
}
