package com.example.eventmanagment.Controller;

import com.example.eventmanagment.Dto.AuthenticationRequestDto;
import com.example.eventmanagment.Dto.AuthenticationResponseDTO;
import com.example.eventmanagment.Model.User;
import com.example.eventmanagment.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getallUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/authenticate")
    public AuthenticationResponseDTO authenticate(@RequestBody AuthenticationRequestDto authenticationRequest) {
        return userService.authenticateUser(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    }

}
