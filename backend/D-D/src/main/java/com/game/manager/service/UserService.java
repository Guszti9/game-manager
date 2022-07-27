package com.game.manager.service;

import com.game.manager.model.UserMember;
import com.game.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserMember getUserById(Long id) {
        return userRepository.getById(id);
    }

    public List<UserMember> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(UserMember user) {
        userRepository.save(user);
    }

    public void editUser(Long id, UserMember updateData) {
        UserMember user = userRepository.getById(id);
        user.editUser(updateData);
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
