package main.java.com.kamazon.application.service;

import main.java.com.kamazon.application.mapper.ProductMapper;
import main.java.com.kamazon.application.mapper.UserMapper;
import main.java.com.kamazon.application.port.ProductDto;
import main.java.com.kamazon.application.port.UserDto;
import main.java.com.kamazon.domain.entities.Product;
import main.java.com.kamazon.domain.entities.User;
import main.java.com.kamazon.domain.validations.ValidateInput;
import main.java.com.kamazon.infrastructure.queriesRepository.*;

public class AdminService {
    private final ValidateInput validateInput;
    private final EntitiesDao entitiesDao;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;

    public AdminService(ValidateInput validateInput, EntitiesDao entitiesDao, UserMapper userMapper, ProductMapper productMapper) {
        this.validateInput = validateInput;
        this.entitiesDao = entitiesDao;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
    }

    public void addUser(UserDto userDto) {
        validateInput.isUserInputValid(userDto);
        User user = userMapper.toEntity(userDto);
        entitiesDao.addUser(user);
    }

    public void addProduct(ProductDto productDto) {
        validateInput.isProductInputValid(productDto);
        Product product = productMapper.toEntity(productDto);
        entitiesDao.addProduct(product);
    }
}
