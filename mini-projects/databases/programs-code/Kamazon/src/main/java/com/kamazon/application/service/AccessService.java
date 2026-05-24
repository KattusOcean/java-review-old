package main.java.com.kamazon.application.service;

import main.java.com.kamazon.application.mapper.UserMapper;
import main.java.com.kamazon.application.port.UserDto;
import main.java.com.kamazon.domain.entities.User;
import main.java.com.kamazon.domain.exceptions.AccessNotValidException;
import main.java.com.kamazon.domain.exceptions.InvalidCredentialsException;
import main.java.com.kamazon.domain.validations.ValidateAccess;
import main.java.com.kamazon.infrastructure.queriesRepository.AccessDao;

public class AccessService {
    private final ValidateAccess validateAccess;
    private final AccessDao accessDao;
    private final UserMapper userMapper;

    public AccessService(ValidateAccess validateAccess, AccessDao accessDao, UserMapper userMapper) {
        this.validateAccess = validateAccess;
        this.accessDao = accessDao;
        this.userMapper = userMapper;
    }

    public UserDto logIn(String email, String password) {
        try {
            if(!validateAccess.isLogInValid(email, password)) {
                throw new InvalidCredentialsException("[X] Email or password invalid");
            }

            User user = accessDao.logIn(email, password);

            if (user == null) {
                throw new InvalidCredentialsException("[X] Email or password incorrect");
            }

            return userMapper.toDto(user);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void register(String name, String email, String password) {
        if (!validateAccess.isRegistrationValid(name, email, password)) {
            throw new InvalidCredentialsException("[X] Name, email or password invalid");
        }

        accessDao.register(name, email, password);
    }
}
