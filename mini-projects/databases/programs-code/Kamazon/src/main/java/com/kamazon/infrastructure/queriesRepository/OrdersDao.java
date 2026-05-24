package main.java.com.kamazon.infrastructure.queriesRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface OrdersDao {
    // PRODUCTS RELATED
    void showProductsByCategory(String category);

    // CART RELATED
    void listCurrentProductsInCart(Set<Integer> productsIds);

    // INFORMATION SEARCH
    void listOperationsHistory(String email);

    // FINAL METHODS
    boolean makePurchase(Integer userId, Map<Integer, Integer> productMap);
    boolean returnPurchase(Integer userId, Map<Integer, Integer> productMap, Integer receiptId);
}
