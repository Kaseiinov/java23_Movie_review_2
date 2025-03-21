package kg.attractor.movie.controller;

import kg.attractor.movie.dto.UserDto;
import kg.attractor.movie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public UserDto getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public HttpStatus createUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return HttpStatus.OK;
    }

    @PostMapping("withId")
    public int createaUserAndReturnId(@RequestBody UserDto userDto) {
         return userService.createUserAndReturnId(userDto);

    }
}
