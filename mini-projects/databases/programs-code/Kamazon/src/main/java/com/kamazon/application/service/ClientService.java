package main.java.com.kamazon.application.service;

import main.java.com.kamazon.infrastructure.queriesRepository.EntitiesDao;
import main.java.com.kamazon.infrastructure.queriesRepository.OrdersDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClientService {
    OrdersDao ordersDao;
    EntitiesDao entitiesDao;

    public ClientService(OrdersDao ordersDao, EntitiesDao entitiesDao) {
        this.ordersDao = ordersDao;
        this.entitiesDao = entitiesDao;
    }

    // ENTITIES RELATED
    public Integer getUserId(String email) {
        return entitiesDao.getUserId(email);
    }

    // PRODUCTS RELATED
    public void showProductsByCategory(String category) {
        ordersDao.showProductsByCategory(category);
    }

    // CART RELATED
    public void listCurrentProductsInCart(Set<Integer> productsIds) {
        ordersDao.listCurrentProductsInCart(productsIds);
    }

    // INFORMATION SEARCH
    public void listOperationsHistory(String email) {
        ordersDao.listOperationsHistory(email);
    }

    // FINAL METHODS
    public boolean makePurchase(Integer userId, Map<Integer, Integer> productMap) {
        return ordersDao.makePurchase(userId, productMap);
    }

    public boolean returnPurchase(Integer userId, Map<Integer, Integer> productMap, Integer receipt_id) {
        return ordersDao.returnPurchase(userId, productMap, receipt_id);
    }
}
