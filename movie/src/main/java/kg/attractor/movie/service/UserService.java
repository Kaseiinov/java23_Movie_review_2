package kg.attractor.movie.service;

import kg.attractor.movie.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();

    UserDto getUserById(int id);

    void addUser(UserDto userDto);

    int createUserAndReturnId(UserDto userDto);
}
