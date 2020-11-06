package ru.progwards.java2.lessons.basetypes;

import java.util.Objects;

public class StringKey implements HashValue {
    private final String key;

    public static StringKey Instance(String key) {
        return new StringKey(key);
    }

    public StringKey(String key) {
        this.key = key;
    }

    @Override
    public int getHash() {
        return hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringKey stringKey = (StringKey) o;
        return Objects.equals(key, stringKey.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return key;
    }
}