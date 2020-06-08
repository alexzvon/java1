package ru.progwards.java1.lessons.arrays;

public class DIntArray {
    private int[] a;

    public static void main(String[] args) {
        //
    }

    public DIntArray() {
        //
    }

    public void add(int num) {
        if(null == a) {
            a = new int[1];
            a[0] = num;
        }
        else {
            int[] a_copy = new int[a.length];
            System.arraycopy(a, 0, a_copy, 0, a.length);
            a = new int[a_copy.length + 1];
            System.arraycopy(a_copy, 0, a, 0, a_copy.length);
            a[a.length - 1] = num;
        }
    }

    public void atInsert(int pos, int num) {
        if (null == a) {
            a = new int[pos];
            a[pos - 1] = num;
        }
        else if (pos > a.length) {
            int[] a_copy = new int[a.length];
            System.arraycopy(a, 0, a_copy, 0, a.length);
            a = new int[pos + 1];
            System.arraycopy(a_copy, 0, a, 0, a_copy.length);
            a[pos] = num;
        }
        else
        {
            int[] a_copy = new int[a.length];
            System.arraycopy(a, 0, a_copy, 0, a.length);
            a = new int[a_copy.length + 1];
            System.arraycopy(a_copy, 0, a, 0, pos);
            System.arraycopy(a_copy, pos, a, pos + 1, a_copy.length - pos);
            a[pos] = num;
        }
    }

    public void atDelete(int pos) {
        if(null == a || pos > a.length) {
            return;
        }
        else {
            int[] a_copy = new int[a.length];
            System.arraycopy(a, 0, a_copy, 0, a.length);
            if(0 < a_copy.length - 1) {
                a = new int[a_copy.length - 1];
                System.arraycopy(a_copy, 0, a, 0, pos);
                System.arraycopy(a_copy, pos + 1, a, pos, a_copy.length - pos - 1);
            }
            else {
                a= null;
            }
        }
    }

    public int at(int pos) {
        return a[pos];
    }

}
