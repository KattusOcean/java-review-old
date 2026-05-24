package main.java.com.kamazon.application.mapper;

import main.java.com.kamazon.application.port.UserDto;
import main.java.com.kamazon.domain.entities.User;

public class UserMapper {
    public UserDto toDto (User user) {
        return new UserDto (
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            user.getRole(),
            user.getBalance()
        );
    }

    public User toEntity (UserDto userDto) {
        return new User (
            userDto.getName(),
            userDto.getEmail(),
            userDto.getPassword(),
            userDto.getRole(),
            userDto.getBalance()
        );
    }
}
