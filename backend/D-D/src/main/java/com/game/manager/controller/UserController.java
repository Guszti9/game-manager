package com.game.manager.controller;

import com.game.manager.model.UserMember;
import com.game.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/user/{id}")
    public UserMember getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("api/user")
    public void addUser(@RequestBody UserMember user) {
        userService.addUser(user);
    }

    @PutMapping("api/user/{id}")
    public void editUser(@PathVariable Long id, @RequestBody UserMember user) {
        userService.editUser(id, user);
    }

    @DeleteMapping("api/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
