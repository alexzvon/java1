package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SalesInfo {
    private final Map<String, Double> goods;
    private final Map<String, AbstractMap.SimpleEntry<Double, Integer>> customers;
    private final List<Trade> listTrade;

    public SalesInfo() {
        goods = new TreeMap<>();
        customers = new TreeMap<>();
        listTrade = new ArrayList<>();
    }

    public int loadOrders(String fileName) {
        FileReader reader = null;
        Scanner scanner;
        String inline;
        String[] arrInline;

        String fio;
        String product;
        int count;
        double summa;

        int c = 0;

        try {
            reader = new FileReader(fileName);
            scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                inline = scanner.nextLine();

                if (!inline.equals("")) {
                    arrInline = inline.split(",");

                    if (arrInline.length == 4) {
                        fio = arrInline[0];
                        product = arrInline[1];
                        count = Integer.parseInt(arrInline[2].trim());
                        summa = Double.parseDouble(arrInline[3].trim());

                        if (fio.length() > 1 && product.length() > 1 && count > 0 && summa > 0) {
                            listTrade.add(new Trade(fio, product, count, summa));
                            c++;
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return c;
    }

    public Map<String, Double> getGoods() {
        double summa;

        goods.clear();
        for (Trade t: listTrade) {
            summa = goods.getOrDefault(t.getProduct(), 0.0);
            goods.put(t.getProduct(), summa + t.getSumma());
        }

        return goods;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        AbstractMap.SimpleEntry<Double, Integer> ase;
        double nsumma;
        int ncount;

        customers.clear();
        for (Trade t: listTrade) {
            ase = customers.getOrDefault(t.getFIO(), new AbstractMap.SimpleEntry<Double, Integer>(0.0, 0));
            nsumma = ase.getKey() + t.getSumma();
            ncount = ase.getValue();
            ncount++;
            customers.put(t.getFIO(), new AbstractMap.SimpleEntry<Double, Integer>(nsumma, ncount));
        }

        return customers;
    }

    static class Trade {
        private final String fio;
        private final String product;
        private final int count;
        private final double summa;

        public Trade(String fio, String product, int count, double summa) {
            this.fio = fio;
            this.product = product;
            this.count = count;
            this.summa = summa;
        }

        public String getProduct() {
            return product;
        }

        public double getSumma() {
            return summa;
        }

        public String getFIO() {
            return fio;
        }
    }

    public static void main(String[] args) {
        String fileName = "proba.txt";

        SalesInfo si = new SalesInfo();

        si.loadOrders(fileName);

        System.out.println(si.getGoods());
        System.out.println(si.getCustomers());

    }
}
