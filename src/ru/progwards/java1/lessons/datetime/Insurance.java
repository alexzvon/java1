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
        DateTimeFormatter dtf = switch (style) {
            case SHORT -> DateTimeFormatter.ISO_LOCAL_DATE;
            case LONG -> DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            case FULL -> DateTimeFormatter.ISO_ZONED_DATE_TIME;
        };

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
        duration = switch (style) {
            case SHORT -> Duration.ofMillis(Long.parseLong(strDuration));
            case LONG -> {
                DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                LocalDateTime ldt1 = LocalDateTime.of(0, 1, 1, 0, 0, 0);
                LocalDateTime ldt2 = LocalDateTime.parse(strDuration, dtf);
                yield Duration.between(ldt1, ldt2);
            }
            case FULL -> Duration.parse(strDuration);
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
