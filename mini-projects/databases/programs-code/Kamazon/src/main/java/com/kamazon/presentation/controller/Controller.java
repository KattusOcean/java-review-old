package main.java.com.kamazon.presentation.controller;

import main.java.com.kamazon.application.port.ProductDto;
import main.java.com.kamazon.application.port.UserDto;
import main.java.com.kamazon.application.service.AccessService;
import main.java.com.kamazon.application.service.AdminService;
import main.java.com.kamazon.application.service.ClientService;
import main.java.com.kamazon.domain.enums.UserRole;
import main.java.com.kamazon.domain.exceptions.AccessNotValidException;
import main.java.com.kamazon.domain.exceptions.InvalidCredentialsException;
import main.java.com.kamazon.presentation.view.AccessView;
import main.java.com.kamazon.presentation.view.AdminView;
import main.java.com.kamazon.presentation.view.ClientView;

import java.util.*;

public class Controller {

    private final AccessView accessView;
    private final AdminView adminView;
    private final ClientView clientView;
    private final AdminService adminService;
    private final ClientService clientService;
    private final AccessService accessService;

    public Controller(AccessView accessView, AdminView adminView, ClientView clientView, AdminService adminService, ClientService clientService, AccessService accessService) {
        this.accessView = accessView;
        this.adminView = adminView;
        this.clientView = clientView;
        this.adminService = adminService;
        this.clientService = clientService;
        this.accessService = accessService;
    }

    public void controllerStart() {
        switch (accessView.accessStart()) {
            case 1 -> logIn();
            case 2 -> register();
        }
    }

    private void logIn() {
        accessView.startLogIn();
        String email = accessView.askEmail();
        String password = accessView.askPassword();

        try {
            UserDto userDto = accessService.logIn(email, password);
            String name = userDto.getName();
            accessView.successfulLogIn(name);


            Map<Integer, Integer> productMap = new HashMap<>();

            if (userDto.getRole() == UserRole.ADMIN) {
                startAdmin(name, email, productMap);
            } else if (userDto.getRole() == UserRole.CLIENT) {
                startClient(name, email, productMap);
            }

        } catch (InvalidCredentialsException e) {
            System.out.println(e.getMessage());
        }
    }

    private void register() {
        accessView.startRegistration();
        String name = accessView.askName();
        String email = accessView.askEmail();
        String password = accessView.askPassword();

        try {
            accessService.register(name, email, password);
            accessService.logIn(email, password);
        } catch (AccessNotValidException e) {
            System.out.println(e.getMessage());
        }

        logIn();

        accessView.successfulRegister(name);
    }

    private void startAdmin(String name, String email, Map<Integer, Integer> productMap) {
        int option;
        boolean exit;

        do {
            option = adminView.startAdminMenu(name);
            switch (option) {
                case 1 -> {
                    UserDto newUserDto = adminView.askForUser();
                    adminService.addUser(newUserDto);
                }

                case 2 -> {
                    ProductDto newProductDto = adminView.askForProduct();
                    adminService.addProduct(newProductDto);
                }

                case 3 -> exit = startPurchase(email, productMap);
                case 4 -> exit = startReturn(email, productMap);
                case 0 ->clientView.bye(name);
            }
        } while (option != 0);
    }

    private void startClient(String name, String email, Map<Integer, Integer> productMap) {
        int option;
        do {
            option = clientView.startClientMenu(name);
            switch(option) {
                case 1 -> startPurchase(email, productMap);
                case 2 -> startReturn(email, productMap);
                case 0 -> clientView.bye(name);
                default -> System.out.println("Invalid option, try again.");
            }
        } while(option != 0);
    }


    private boolean startPurchase(String email, Map<Integer, Integer> productMap) {
        int option;
        do {
            option = clientView.makePurchaseMenu();
            switch (option) {
                case 1 -> {
                    clientView.showNotes();
                    String category = clientView.showProductsByCategoryMenu();
                    clientService.showProductsByCategory(category);
                    addProductsToCart(productMap);
                }

                case 2 -> deleteSelectedProductsOffCart(productMap);
                case 3 -> clientService.listCurrentProductsInCart(productMap.keySet());

                case 4 -> {
                    if (productMap.isEmpty()) {
                        System.out.println("Cannot finish purchase: cart is empty!");
                    } else {
                        Integer userId = clientService.getUserId(email);
                        if (clientService.makePurchase(userId, productMap)) {
                            System.out.println("Purchased completed successfully!");
                            System.out.println("------------------------------------------");
                        }
                        productMap.clear(); // clears cart post purchase
                        return true; // exits to main menu
                    }
                }

                case 0 -> {
                    productMap.clear();
                    clientView.cancelOperation();
                    return true; // exits to main menu
                }

                default -> System.out.println("Invalid option, try again.");
            }
        } while(true);
    }


    private boolean startReturn(String email, Map<Integer, Integer> productMap) {
        int option;
        clientService.listOperationsHistory(email);

        do {
            option = clientView.returnPurchaseMenu();
            switch(option) {
                case 1 -> {
                    addProductsToCart(productMap);

                    Integer userId = clientService.getUserId(email);
                    Integer receiptId;

                    receiptId = clientView.askForReceiptId();
                    if(clientService.returnPurchase(userId, productMap, receiptId)) {
                        System.out.println("Return completed successfully!");
                        System.out.println("------------------------------------------");
                    }
                }

                case 0 -> {
                    productMap.clear();
                    clientView.cancelOperation();
                    return true; // exits to main menu
                }

                default -> System.out.println("Invalid option, try again.");
            }
        } while(true);
    }

    private void addProductsToCart(Map<Integer, Integer> productMap) {
        while(true) {
            int productId = clientView.askProductId();
            if(productId == 0) break;
            int quantity = clientView.askProductQuantity();
            if(quantity <= 0) break;

            productMap.put(productId, quantity);
        }
        System.out.println("------------------------------------------");
    }

    private void deleteSelectedProductsOffCart(Map<Integer, Integer> productMap) {
        if(productMap.isEmpty()) {
            System.out.println("Cart is empty!");
            System.out.println("------------------------------------------");
            return;
        }

        while(true) {
            int productId = clientView.askProductId();
            if(productId == 0) break;

            if(!productMap.containsKey(productId)) {
                System.out.println("Product not in cart!");
                continue;
            }

            int quantity = clientView.askProductQuantity();
            int currentQuantity = productMap.get(productId);

            if(quantity >= currentQuantity) productMap.remove(productId);
            else productMap.put(productId, currentQuantity - quantity);
        }
        System.out.println("------------------------------------------");
    }
}
