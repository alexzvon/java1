package ru.progwards.java2.lessons.basetypes;

import java.util.Objects;

public class IntKey implements HashValue {
    private final int key;

    public static IntKey Instance(int key) {
        return new IntKey(key);
    }

    public IntKey(int key) {
        this.key = key;
    }

    @Override
    public int getHash() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntKey intKey = (IntKey) o;
        return key == intKey.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}