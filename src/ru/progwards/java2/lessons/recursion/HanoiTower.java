package ru.progwards.java2.lessons.recursion;

import java.util.*;

public class HanoiTower {
    final int size;
    final int pos;

    int lastPin = 0;
    boolean debug = false;
    int step = 0;

    List<List<String>> pins = new ArrayList<>();

    public HanoiTower(int size, int pos) {
        this.size = size;
        this.pos = pos;

        int sz = size;
        for(int i = 0; i < 3; i++) {
            List<String> pin = new ArrayList<>();
            if(i == (pos)) {
                for(int j = 0; j < size; j++) {
                    pin.add(String.valueOf(sz--));
                }
            }
            else {
                for(int j = 0; j < size; j++) {
                    pin.add("0");
                }
            }

            pins.add(pin);
        }
    }

    private void moveB(int p1, int p2) {
        List<String> sL1 = pins.get(p1);
        List<String> sL2 = pins.get(p2);

        int pin1 = sL1.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .reduce(-1, (i1, i2) -> i2 > 0 ? ++i1 : i1);

        int pin2 = sL2.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .reduce(-1, (i1, i2) -> i2 > 0 ? ++i1 : i1);

        String zn1 = sL1.get(pin1);
        pin2 = -1 == pin2 ? 0 : pin2;
        String zn2 = sL2.get(pin2);

        if (0 == Integer.parseInt(zn2.trim()) || Integer.parseInt(zn1.trim()) < Integer.parseInt(zn2.trim())) {
            pin2 = 0 < Integer.parseInt(zn2.trim()) ? pin2 + 1 : pin2;

            sL1.set(pin1, "0");
            sL2.set(pin2, zn1);

            pins.set(p1, sL1);
            pins.set(p2, sL2);

            lastPin = p2;
            step++;

            if(debug) {
                print();
            }
        }
    }

    public void print() {
        List<List<String>> ssL = new ArrayList<>();
        for(int i = size; i > 0; i--) {
            List<String> sL = new ArrayList<>();
            for(int j = 0; j < 3; j++) {
                sL.add(pins.get(j).get(i - 1));
            }
            ssL.add(sL);
        }

        ssL.forEach(HanoiTower::printPin);
    }

    private static void printPin(List<String> sL) {
        System.out.println(sL.stream()
                .reduce("", (s1, s2) -> s1 + " " + (s2.equals("0") ? "  I  " : "<" + String.format("%03d", Integer.parseInt(s2)) + ">")));
    }

    public void setTrace(boolean on) {
        debug = on;
    }

    public void move(int p1, int p2) {
        int temp = 3 - (p1 + p2);

        moveTower(size, p1, p2, temp);
    }

    private void moveTower(int amount, int p1, int p2, int temp ) {
        if(amount == 0) {
            return;
        }

        moveTower(amount - 1, p1, temp, p2);
        moveB(p1, p2);
        moveTower(amount - 1, temp, p2, p1);
    }

    public static void main(String[] args) {

        HanoiTower HT = new HanoiTower(3,2);

        HT.setTrace(true);

        HT.print();

        HT.move(2, 1);
    }
}

