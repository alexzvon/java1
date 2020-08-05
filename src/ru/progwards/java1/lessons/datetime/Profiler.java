package ru.progwards.java1.lessons.datetime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Profiler {
    private static List<StatisticInfo> lsi = new ArrayList();

    public static List<StatisticInfo> getStatisticInfo() {
        return lsi;
    }

    public static void enterSection(String name) {
        for (StatisticInfo si: lsi) {
            if (si.sectionName.equals(name)) {
                si.StartSection();
                return;
            }
        }
        lsi.add(new StatisticInfo(name));
    }

    public static void exitSection(String name) {
        for (var si: lsi) {
            if (si.sectionName.equals(name)) {
                si.EndSection();
            }
        }
    }

    public static void main(String[] args) {

        try {
            enterSection("1");

            TimeUnit.SECONDS.sleep(1);

            for(int i = 0; i < 10; i++) {
                enterSection("2");

                TimeUnit.SECONDS.sleep(1);

                enterSection("3");

                TimeUnit.SECONDS.sleep(1);

                exitSection("3");

                TimeUnit.SECONDS.sleep(1);

                exitSection("2");
            }

            TimeUnit.SECONDS.sleep(1);

            enterSection("4");

            TimeUnit.SECONDS.sleep(1);

            exitSection("4");

            TimeUnit.SECONDS.sleep(1);

            exitSection("1");

            for (StatisticInfo si: getStatisticInfo()) {
                System.out.println(si);
            }

            System.out.println(getStatisticInfo());

        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}

