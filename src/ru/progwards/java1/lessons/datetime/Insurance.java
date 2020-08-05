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
                LocalDateTime ldt = LocalDateTime.parse(strDuration, dtf);
                LocalDateTime ldtE = LocalDateTime.ofEpochSecond (0, 0, ZoneOffset.ofHours(0));
                LocalDateTime ldtD = ldtE.plusYears(ldt.getYear())
                    .plusMonths(ldt.getMonthValue())
                    .plusDays(ldt.getDayOfMonth())
                    .plusHours(ldt.getHour())
                    .plusMinutes(ldt.getMinute())
                    .plusSeconds(ldt.getSecond());

                duration = Duration.between(ldtE, ldtD);
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

        if (this.checkValid(ZonedDateTime.now())) {
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
