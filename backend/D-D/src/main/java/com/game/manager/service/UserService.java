package com.game.manager.service;

import com.game.manager.appuser.AppUser;
import com.game.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<AppUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(AppUser user) {
        userRepository.save(user);
    }

    public void editUser(Long id, AppUser updateData) {
        AppUser user = userRepository.getById(id);
        user.editUser(updateData);
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
