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

    public static void main(String[] args) {

    }
}
