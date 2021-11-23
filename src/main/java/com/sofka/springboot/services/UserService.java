package com.sofka.springboot.services;

import java.util.ArrayList;
import java.util.Optional;

import com.sofka.springboot.models.UserModel;
import com.sofka.springboot.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUsers(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getUsersById(Long id) {
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> getUsersByPriority(Integer priority) {
        return userRepository.findByPrioridad(priority);
    }

    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
