package ru.progwards.java2.lessons.basetypes;

public class test {
    public static void main(String[] args) {
        DoubleHashTable<HashValue, String> dht = new DoubleHashTable<>();

        for ( int i = 0; i < 500; i++ ) {
            IntKey key = new IntKey(i);
            String item = "цыфра " + i;

            dht.add(key, item);

            StringKey sk = new StringKey(String.valueOf(i));
            String val = "символ " + i;

            dht.add(sk, val);
        }

        for ( int j = 0; j < dht.table.length; j++ ) {
            if ( dht.table[j] != null ) {
                System.out.println(j + " - " + dht.table[j]);
            }
        }

        for (String item: dht) {
            System.out.println(item);
        }

        System.out.println("=================================================");

        System.out.println(dht.get(StringKey.Instance("3")));
        System.out.println(dht.get(StringKey.Instance("5")));
        System.out.println(dht.get(StringKey.Instance("1")));

        System.out.println("-------------------------------------------------");

        System.out.println(dht.get(IntKey.Instance(3)));
        System.out.println(dht.get(IntKey.Instance(5)));
        System.out.println(dht.get(IntKey.Instance(1)));

        System.out.println("=================================================");

        for (String item: dht) {
            System.out.println(item);
        }

        System.out.println("=================================================");

        dht.remove(IntKey.Instance(1));
        dht.remove(IntKey.Instance(10));
        dht.remove(IntKey.Instance(15));

        dht.remove(StringKey.Instance("1"));
        dht.remove(StringKey.Instance("10"));
        dht.remove(StringKey.Instance("15"));

        for (String item: dht) {
            System.out.println(item);
        }

        System.out.println("=================================================");

        for ( int j = 0; j < dht.table.length; j++ ) {
            if ( dht.table[j] != null ) {
                System.out.println(j + " - " + dht.table[j]);
            }
        }

        System.out.println("=================================================");

        dht.change(IntKey.Instance(5), StringKey.Instance("105"));
        dht.change(IntKey.Instance(7), StringKey.Instance("107"));
        dht.change(IntKey.Instance(9), StringKey.Instance("109"));
        dht.change(IntKey.Instance(14), StringKey.Instance("114"));
        dht.change(IntKey.Instance(2), StringKey.Instance("102"));

        dht.change(StringKey.Instance("8"), StringKey.Instance("80"));
        dht.change(StringKey.Instance("7"), StringKey.Instance("70"));
        dht.change(StringKey.Instance("6"), StringKey.Instance("60"));

        dht.change(IntKey.Instance(11), IntKey.Instance(1011));
        dht.change(IntKey.Instance(12), IntKey.Instance(1012));
        dht.change(IntKey.Instance(13), IntKey.Instance(1013));

        dht.change(StringKey.Instance("12"), IntKey.Instance(512));
        dht.change(StringKey.Instance("13"), IntKey.Instance(513));
        dht.change(StringKey.Instance("14"), IntKey.Instance(514));

        for ( int j = 0; j < dht.table.length; j++ ) {
            if ( dht.table[j] != null ) {
                System.out.println(j + " - " + dht.table[j]);
            }
        }

        for (String item: dht) {
            System.out.println(item);
        }

        System.out.println("=================================================");

    }
}
