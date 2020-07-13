package ru.progwards.java1.lessons.sets;

import java.util.*;

public class ProductAnalytics {
    private List<Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops = shops;
        this.products = products;
    }

    /**
     * товары из products, которые имеются во всех магазинах
     * @return
     */
    public Set<Product> existInAll() {
        Set<Product> shops_products = new HashSet<>();
        Set<Product> all_products = new HashSet<>(products);

        Iterator<Shop> ishops = shops.iterator();
        shops_products.addAll(ishops.next().getProducts());

        while(ishops.hasNext()) {
            shops_products.retainAll(ishops.next().getProducts());
        }

        all_products.retainAll(shops_products);
        return all_products;
    }

    /**
     * товары из products, которые имеются хотя бы в одном магазине
     * @return
     */
    public Set<Product> existAtListInOne() {
        Set<Product> shops_products = new HashSet<>();
        Set<Product> all_products = new HashSet<>(products);

        for (Shop shop: shops) {
            shops_products.addAll(shop.getProducts());
        }

        all_products.retainAll(shops_products);
        return all_products;
    }

    /**
     * товары из products, которых нет ни в одном магазине
     * @return
     */
    public Set<Product> notExistInShops() {
        Set<Product> all_products = new HashSet<>(products);
        all_products.removeAll(existAtListInOne());

        return all_products;
    }

    /**
     * товары из products, которые есть только в одном магазине
     * @return
     */
    public Set<Product> existOnlyInOne() {
        Set<Product> all_products = new HashSet<>(products);

        for (Iterator<Product> iproduct = all_products.iterator(); iproduct.hasNext(); ) {
            if(1 != countProductInShops(iproduct.next())) {
                iproduct.remove();
            }
        }

        return all_products;
    }

    /**
     * Количество товара в магазинах
     * @param product
     * @return
     */
    private int countProductInShops(Product product) {
        int count = 0;

        for (Shop shop: shops) {
            count += shop.getProducts().contains(product) ? 1 : 0;
        }

        return count;
    }

    static public class Product implements Comparable<Product> {
        private String code;

        public Product(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        @Override
        public int compareTo(Product o) {
            return code.compareTo(o.getCode());
        }

        @Override
        public String toString() {
            return code;
        }

    }

    static public class Shop {
        private List<Product> products;

        public Shop(List<Product> products) {
            this.products = products;
        }

        public List<Product> getProducts() {
            return products;
        }
    }

    public static void main(String[] args) {
//        Product pr1 = new Product("PR1");
//        Product pr2 = new Product("PR2");
//        Product pr3 = new Product("PR3");
//        Product pr4 = new Product("PR4");
//        Product pr5 = new Product("PR5");
//        Product pr6 = new Product("PR6");
//        Product pr7 = new Product("PR7");
//        Product pr8 = new Product("PR8");
//        Product pr9 = new Product("PR9");
//        Product pr0 = new Product("PR0");
//
//        List<Product> products = new ArrayList<>();
//
//        products.add(pr0);
//        products.add(pr1);
//        products.add(pr2);
//        products.add(pr3);
//        products.add(pr4);
//        products.add(pr5);
//        products.add(pr6);
//        products.add(pr7);
//        products.add(pr8);
//        products.add(pr9);
//
//        List<Product> sh_pr0 = new ArrayList<>();
//        List<Product> sh_pr1 = new ArrayList<>();
//        List<Product> sh_pr2 = new ArrayList<>();
//
//        sh_pr0.add(pr1);
//        sh_pr0.add(pr3);
//        sh_pr0.add(pr6);
//        sh_pr0.add(pr8);
//
//        sh_pr1.add(pr2);
//        sh_pr1.add(pr3);
//        sh_pr1.add(pr8);
//
//        sh_pr2.add(pr6);
//        sh_pr2.add(pr7);
//        sh_pr2.add(pr9);
//        sh_pr2.add(pr3);
//        sh_pr2.add(pr4);
//        sh_pr2.add(pr8);
//
//        Shop sh0 = new Shop(sh_pr0);
//        Shop sh1 = new Shop(sh_pr1);
//        Shop sh2 = new Shop(sh_pr2);
//
//        List<Shop> shops = new ArrayList<>();
//
//        shops.add(sh0);
//        shops.add(sh1);
//        shops.add(sh2);
//
//        ProductAnalytics productAnalytics = new ProductAnalytics(products, shops);
//
//        System.out.println(productAnalytics.existInAll());
//        System.out.println(productAnalytics.existAtListInOne());
//        System.out.println(productAnalytics.notExistInShops());
//        System.out.println(productAnalytics.existOnlyInOne());
    }
}
