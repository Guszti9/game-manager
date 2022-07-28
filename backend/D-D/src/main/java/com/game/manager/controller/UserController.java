package com.game.manager.controller;

import com.game.manager.appuser.AppUser;
import com.game.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/user/{id}")
    public Optional<AppUser> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("api/all-user")
    public List<AppUser> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("api/user")
    public void addUser(@RequestBody AppUser user) {
        userService.addUser(user);
    }

    @PutMapping("api/user/{id}")
    public void editUser(@PathVariable Long id, @RequestBody AppUser user) {
        userService.editUser(id, user);
    }

    @DeleteMapping("api/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
