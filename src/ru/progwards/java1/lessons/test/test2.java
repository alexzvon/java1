package ru.progwards.java1.lessons.test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class test2 {
    public static enum FormatStyle {SHORT, LONG, FULL};


    public static void main(String[] args) {
        test2 t = new test2();
        System.out.println(t.createDate());

//        LocalDateTime ldt1= LocalDateTime.now();
//        LocalDateTime ldt2= ldt1.plusDays(4);
//        Duration duration = Duration.between(ldt1,ldt2);
//        System.out.println(duration.toHours());


        Date now = new Date();
        Long unixTS = now.getTime()/1000L;

        LocalDateTime ldt1= LocalDateTime.now();
        LocalDateTime ldt2= ldt1.plusDays(4);
        Duration duration = Duration.between(ldt1,ldt2);
        System.out.println(duration.toHours());


        ZoneId zid1 = ZoneId.of("Europe/Moscow");
        System.out.println(zid1.getRules().getOffset(Instant.now()));


        System.out.println(t.createInstant());

        String str =  "01.01.2020 16:27:14.444 +0300 Moscow Standard Time";

//        String str = "2020-01-01T16:27:14.444+03:00[Europe/Moscow]";

        System.out.println(t.parseZDT(str));


        LocalDateTime l1 = LocalDateTime.of(2020, 1, 1, 22, 25);
        LocalDateTime l2 = LocalDateTime.of(2020, 1, 3, 12, 32);


        System.out.println(duration);

        String sttrr = "0000-06-03T10:00:00";

        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        ZonedDateTime zdt1 = ZonedDateTime.of(0, 1, 1, 0, 0, 0, 0, ZoneId.of("Europe/Moscow"));

        LocalDateTime ldt = LocalDateTime.parse(sttrr, dtf);
        ZonedDateTime zdt2 = ZonedDateTime.of(ldt, ZoneId.of("Europe/Moscow"));

        Duration dur = Duration.between(zdt1, zdt2);

        System.out.println(dur);

        FormatStyle ppp = FormatStyle.LONG;

        Integer iii = switch (ppp) {
            case LONG -> {
                int i1 = 1;
                int i2 = 2;
                yield i1 + i2;
            }
            case SHORT -> 100;
            case FULL -> 111;
        };

        System.out.println(iii);

        Instant lins = Instant.now().plusNanos(100L);
        Instant nins = Instant.now();

        System.out.println(nins.isAfter(lins));

    }

    Date createDate() {
        Calendar calendar = new GregorianCalendar(1986, 1, 28, 0, 0, 0);
        return calendar.getTime();
    }

    Instant createInstant() {
        ZoneId zid = ZoneId.of("Europe/Moscow");
        ZonedDateTime zdt = ZonedDateTime.of(2020, 1, 1, 15, 0, 0, 1, zid);
//        ZoneOffset zo = ZoneOffset.of("Z");
        LocalDateTime ldt = zdt.toLocalDateTime();

        return ldt.toInstant(zdt.getOffset());
    }

    ZonedDateTime parseZDT(String str) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS Z 'Moscow Standard Time'");
        LocalDateTime ldt = LocalDateTime.parse(str, dtf);
        return ldt.atZone(ZoneId.of("Europe/Moscow"));
    }

//    Напишите метод, с сигнатурой ZonedDateTime parseZDT(String str), который возвращает ZonedDateTime,
//    парся строку вида "01.01.2020 16:27:14.444 +0300 Moscow Standard Time"

}
