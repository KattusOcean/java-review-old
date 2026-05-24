package main.java.com.kamazon.infrastructure.queriesRepository;

import main.java.com.kamazon.infrastructure.databaseConnector.DBConnector;

import java.sql.*;
import java.util.*;
import oracle.sql.*;

public class OrdersJdbc implements OrdersDao {

    @Override
    public void showProductsByCategory(String category) {
        String sql = "SELECT * FROM products WHERE UPPER(category) = UPPER(?)";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category.toUpperCase());

            try (ResultSet rs = ps.executeQuery()) {
                int i = 1;

                while (rs.next()) {
                    int pId = rs.getInt("id");
                    String pName = rs.getString("name");
                    double pPrice = rs.getDouble("price");
                    String pCategory = rs.getString("category");
                    int pStock = rs.getInt("stock");
                    double pRating = rs.getDouble("rating");
                    System.out.printf("""
                            Product %d {
                                Id: %d
                                Name: %s
                                Price: %.2f
                                Category: %s
                                Stock: %d
                                Rating: %.2f
                            }
                            |||||||||||||||||||||||||||||||||||||||||
                            """, i, pId, pName, pPrice, pCategory, pStock, pRating);
                    i++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void listCurrentProductsInCart(Set<Integer> productsIds) {
        if (productsIds.isEmpty()) {
            System.out.println("Cart is empty!");
            System.out.println("------------------------------------------");
            return;
        }

        String ids = String.join(",", Collections.nCopies(productsIds.size(), "?"));
        String sql = "SELECT id, name, price, rating FROM products WHERE id IN (" + ids + ")";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            int i = 1;
            for (Integer id : productsIds) {
                ps.setInt(i++, id);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int pId = rs.getInt("id");
                    String pName = rs.getString("name");
                    double pPrice = rs.getDouble("price");
                    double pRating = rs.getDouble("rating");
                    System.out.println("ID: " + pId + " | Name: " + pName + " | Price: " + pPrice + " | Rating: " + pRating);
                    // SHOW CURRENT QUANTITY
                }
            }
            System.out.println("------------------------------------------");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void listOperationsHistory(String email) {
        String sql = """
                    SELECT r.id, u.email, r.type, r.date_op, ri.product_id, ri.quantity, ri.subtotal, r.total
                    FROM receipts r
                    JOIN users u ON r.user_id = u.id
                    JOIN receipt_item ri ON r.id = ri.receipt_id
                    WHERE LOWER(u.email) = LOWER(?)
                    """;
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email.toLowerCase());

            try (ResultSet rs = ps.executeQuery()) {
                String rEmail, rType, rDate;
                int rId, rTotal,rProductId, rQuantity, rSubtotal;
                while (rs.next()) {
                    rId = rs.getInt("id");
                    rEmail = rs.getString("email");
                    rType = rs.getString("type");
                    rDate =  rs.getString("date_op");
                    rProductId = rs.getInt("product_id");
                    rQuantity = rs.getInt("quantity");
                    rSubtotal = rs.getInt("subtotal");
                    rTotal = rs.getInt("total");
                    System.out.printf("""
                            %s {
                                ID: %d
                                EMAIL: %s
                                DATE: %s
                                PRODUCT ID: %d
                                QUANTITY: %d
                                SUBTOTAL: %d
                                TOTAL: %d
                            }
                            |||||||||||||||||||||||||||||||||||||||||
                            """, rType, rId, rEmail, rDate, rProductId, rQuantity, rSubtotal, rTotal);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean makePurchase(Integer userId, Map<Integer, Integer> productMap) {
        if (productMap.isEmpty()) return false;
        try (Connection conn = DBConnector.getConnection()) {

            // USING DEPRECATED OBJECT CANNOT BE THE ONLY SOLUTION
            // WHY IS `createArrayOf` NOT SUPPORTED?
            // ORA-17023: Unsupported feature: createArrayOf
            // https://docs.oracle.com/error-help/db/ora-17023/

            // Map to Integer Arrays
            Integer[] productIdsArrayJava = productMap.keySet().toArray(new Integer[0]);
            Integer[] quantitiesArrayJava = productMap.values().toArray(new Integer[0]);

            // Oracle descriptor
            ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("T_NUMBER_TABLE", conn);

            // Oracle arrays
            ARRAY productIdsArray = new ARRAY(descriptor, conn, productIdsArrayJava);
            ARRAY quantitiesArray = new ARRAY(descriptor, conn, quantitiesArrayJava);

            // Procedure call
            String sql = "{ CALL make_purchase(?, ?, ?) }";
            try (CallableStatement cs = conn.prepareCall(sql)) {
                cs.setInt(1, userId);
                cs.setArray(2, productIdsArray);
                cs.setArray(3, quantitiesArray);
                cs.executeUpdate();
            }
            return true;

        } catch (SQLException e) {
            System.out.println("Error when purchasing: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean returnPurchase(Integer userId, Map<Integer, Integer> productMap, Integer receiptId) {
        if (productMap.isEmpty()) return false;
        try (Connection conn = DBConnector.getConnection()) {

            // USING DEPRECATED OBJECT CANNOT BE THE ONLY SOLUTION
            // WHY IS `createArrayOf` NOT SUPPORTED?
            // ORA-17023: Unsupported feature: createArrayOf
            // https://docs.oracle.com/error-help/db/ora-17023/

            // Map to Integer Arrays
            Integer[] productIdsArrayJava = productMap.keySet().toArray(new Integer[0]);
            Integer[] quantitiesArrayJava = productMap.values().toArray(new Integer[0]);

            // Oracle descriptor
            ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("T_NUMBER_TABLE", conn);

            // Oracle arrays
            ARRAY productIdsArray = new ARRAY(descriptor, conn, productIdsArrayJava);
            ARRAY quantitiesArray = new ARRAY(descriptor, conn, quantitiesArrayJava);

            // Procedure call
            String sql = "{ CALL return_purchase(?, ?, ?, ?) }";
            try (CallableStatement cs = conn.prepareCall(sql)) {
                cs.setInt(1, userId);
                cs.setArray(2, productIdsArray);
                cs.setArray(3, quantitiesArray);
                cs.setInt(4, receiptId);
                cs.executeUpdate();
            }
            return true;

        } catch (SQLException e) {
            System.out.println("Error when returning purchase: " + e.getMessage());
            return false;
        }
    }

    // PRE-ACTUAL, NOT SUPPORTED(?) WAY OF USING NESTED TABLES TO CALL A PROCEDURE
//    @Override
//    public void makePurchase(Integer userId, Map<Integer, Integer> productMap, List<Integer> productIds, List<Integer> quantities) {
//
//        for (Map.Entry<Integer, Integer> map : productMap.entrySet()) {
//            productIds.add(map.getKey());
//            quantities.add(map.getValue());
//        }
//
//        String sql = "{ CALL make_purchase(?, ?, ?) }";
//        try (Connection conn = DBConnector.getConnection();
//             CallableStatement cs = conn.prepareCall(sql)) {
//
//            Array productIdsArray = conn.createArrayOf("T_NUMBER_TABLE", productIds.toArray());
//            Array quantitiesArray = conn.createArrayOf("T_NUMBER_TABLE", quantities.toArray());
//
//            cs.setInt(1, userId);
//            cs.setArray(2, productIdsArray);
//            cs.setArray(3, quantitiesArray);
//            cs.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    @Override
//    public void returnPurchase(Integer userId, Map<Integer, Integer> productMap, Integer receipt_id, List<Integer> productIds, List<Integer> quantities) {
//
//        for (Map.Entry<Integer, Integer> map : productMap.entrySet()) {
//            productIds.add(map.getKey());
//            quantities.add(map.getValue());
//        }
//
//        String sql = "{ CALL make_purchase(?, ?, ?, ?) }";
//        try (Connection conn = DBConnector.getConnection();
//             CallableStatement cs = conn.prepareCall(sql)) {
//
//            Array productIdsArray = conn.createArrayOf("T_NUMBER_TABLE", productIds.toArray());
//            Array quantitiesArray = conn.createArrayOf("T_NUMBER_TABLE", quantities.toArray());
//
//            cs.setInt(1, userId);
//            cs.setArray(2, productIdsArray);
//            cs.setArray(3, quantitiesArray);
//            cs.setInt(4, receipt_id);
//            cs.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}