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

//    class StatisticInfo implements Comparable<StatisticInfo> {
//        public String sectionName;
//        public int fullTime;
//        public int selfTime;
//        public int count;
//
//        private String parentSectionName;
//        private ZonedDateTime startSection;
//        private ZonedDateTime endSection;
//
//        public StatisticInfo(String sectionName) {
//            fullTime = 0;
//            selfTime = 0;
//
//            this.sectionName = sectionName;
//            startSection = ZonedDateTime.now();
//            endSection = null;
//            parentSectionName = ParentSectionName(getStatisticInfo());
//            count = 1;
//        }
//
//        public void StartSection() {
//            endSection = null;
//            startSection = ZonedDateTime.now();
//            parentSectionName = ParentSectionName(getStatisticInfo());
//            count++;
//        }
//
//        public void EndSection() {
//            endSection = ZonedDateTime.now();
//            fullTime += (int)Duration.between(startSection, endSection).toMillis();
//            selfTime = SelfTime(getStatisticInfo());
//        }
//
//        private int SelfTime(List<StatisticInfo> lsi) {
//            int siSelfTime = 0;
//
//            for (var si: lsi) {
//                if (si.getParentSectionName().equals(sectionName)) {
//                    siSelfTime += si.fullTime;
//                }
//            }
//
//            return fullTime - siSelfTime;
//        }
//
//        private String ParentSectionName(List<StatisticInfo> lsi) {
//            String pSN = "";
//            Collections.sort(lsi);
//            for (var si: lsi) {
//                if (!si.sectionName.equals(sectionName) && si.getEndSection() == null)  {
//                    pSN =  si.sectionName;
//                }
//            }
//
//            return pSN;
//        }
//
//        @Override
//        public int compareTo(StatisticInfo o) {
//            return startSection.compareTo(o.startSection);
//        }
//
//        @Override
//        public String toString() {
//            return sectionName + "\t\t" + fullTime + "\t\t" + selfTime + "\t\t" + count;
//        }
//
//        public String getParentSectionName() {
//            return parentSectionName;
//        }
//
//        public ZonedDateTime getEndSection() {
//            return endSection;
//        }
//    }

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

