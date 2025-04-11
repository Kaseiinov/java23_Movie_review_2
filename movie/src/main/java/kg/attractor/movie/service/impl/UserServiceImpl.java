package kg.attractor.movie.service.impl;

import kg.attractor.movie.dao.UserDao;
import kg.attractor.movie.dto.UserDto;
import kg.attractor.movie.exceptions.UserNotFoundException;
import kg.attractor.movie.model.User;
import kg.attractor.movie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public List<UserDto> getUsers() {
        List<User> list = userDao.getUsers();
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .email(e.getEmail())
                        .name(e.getName())
                        .password(e.getPassword())
                        .build())
                .toList();
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userDao.getUserById(id)
                .orElseThrow(UserNotFoundException::new);
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .build();
    }

    @Override
    public void addUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userDao.createUser(user);
    }

    @Override
    public int createUserAndReturnId(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return userDao.createUserAndReturnId(user);
    }
}
