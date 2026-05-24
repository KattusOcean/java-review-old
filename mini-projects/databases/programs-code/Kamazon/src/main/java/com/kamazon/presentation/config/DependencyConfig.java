package main.java.com.kamazon.presentation.config;

import main.java.com.kamazon.application.mapper.ProductMapper;
import main.java.com.kamazon.application.mapper.UserMapper;
import main.java.com.kamazon.application.service.AccessService;
import main.java.com.kamazon.application.service.AdminService;
import main.java.com.kamazon.application.service.ClientService;
import main.java.com.kamazon.domain.validations.ValidateAccess;
import main.java.com.kamazon.domain.validations.ValidateInput;
import main.java.com.kamazon.infrastructure.queriesRepository.*;
import main.java.com.kamazon.presentation.controller.Controller;
import main.java.com.kamazon.presentation.view.AccessView;
import main.java.com.kamazon.presentation.view.AdminView;
import main.java.com.kamazon.presentation.view.ClientView;

public class DependencyConfig {
    AccessView accessView = new AccessView();
    AdminView adminView = new AdminView();
    ClientView clientView = new ClientView();

    OrdersDao ordersDao = new OrdersJdbc();
    EntitiesDao entitiesDao = new EntitiesJdbc();
    AccessDao accessDao = new AccessJdbc();
    ValidateInput validateInput = new ValidateInput();
    ValidateAccess validateAccess = new ValidateAccess();
    UserMapper userMapper = new UserMapper();
    ProductMapper productMapper = new ProductMapper();

    AccessService accessService = new AccessService(validateAccess, accessDao, userMapper);
    AdminService adminService = new AdminService(validateInput, entitiesDao, userMapper, productMapper);
    ClientService clientService = new ClientService(ordersDao, entitiesDao);

    public Controller createController() {
        return new Controller(accessView, adminView, clientView, adminService, clientService, accessService);
    }
}
