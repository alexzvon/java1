package ru.progwards.java1.lessons.test;

interface Remove {
    void Play();
    void Stop();
}

interface RR {
    void Up();
    void Down();
}

class TvSet implements Remove, RR {

    @Override
    public void Play() {
        System.out.println("TvSet Play");
    }

    @Override
    public void Stop() {
        System.out.println("TvSet Stop");
    }

    @Override
    public void Up() {
        System.out.println("TvSet Up");
    }

    @Override
    public void Down() {
        System.out.println("TvSet Down");
    }
}

public class test3 {
    public static void main(String[] args) {
        TvSet tv = new TvSet();

        run(tv);
        run1(tv);
    }

    public static void run1(RR rr) {
        rr.Down();
        rr.Up();
    }

    public static void run(Remove remove) {
        remove.Play();
        remove.Stop();
    }
}
