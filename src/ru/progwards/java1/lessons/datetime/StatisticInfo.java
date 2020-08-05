package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

public class StatisticInfo implements Comparable<StatisticInfo> {
    public String sectionName;
    public int fullTime;
    public int selfTime;
    public int count;

    private String parentSectionName;
    private ZonedDateTime startSection;
    private ZonedDateTime endSection;

    public StatisticInfo(String sectionName) {
        fullTime = 0;
        selfTime = 0;

        this.sectionName = sectionName;
        startSection = ZonedDateTime.now();
        endSection = null;
        parentSectionName = ParentSectionName(Profiler.getStatisticInfo());
        count = 1;
    }

    public void StartSection() {
        endSection = null;
        startSection = ZonedDateTime.now();
        parentSectionName = ParentSectionName(Profiler.getStatisticInfo());
        count++;
    }

    public void EndSection() {
        endSection = ZonedDateTime.now();
        fullTime += (int) Duration.between(startSection, endSection).toMillis();
        selfTime = SelfTime(Profiler.getStatisticInfo());
    }

    private int SelfTime(List<StatisticInfo> lsi) {
        int siSelfTime = 0;

        for (var si: lsi) {
            if (si.getParentSectionName().equals(sectionName)) {
                siSelfTime += si.fullTime;
            }
        }

        return fullTime - siSelfTime;
    }

    private String ParentSectionName(List<StatisticInfo> lsi) {
        String pSN = "";
        Collections.sort(lsi);
        for (var si: lsi) {
            if (!si.sectionName.equals(sectionName) && si.getEndSection() == null)  {
                pSN =  si.sectionName;
            }
        }

        return pSN;
    }

    @Override
    public int compareTo(StatisticInfo o) {
        return startSection.compareTo(o.startSection);
    }

    @Override
    public String toString() {
        return sectionName + "\t\t" + fullTime + "\t\t" + selfTime + "\t\t" + count;
    }

    public String getParentSectionName() {
        return parentSectionName;
    }

    public ZonedDateTime getEndSection() {
        return endSection;
    }

}
