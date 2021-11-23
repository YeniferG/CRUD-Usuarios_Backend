package com.sofka.springboot.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.sofka.springboot.models.UserModel;
import com.sofka.springboot.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping()
    public UserModel saveUsers(@RequestBody UserModel user) {
        return this.userService.saveUsers(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUsersById(@PathVariable("id") Long id) {
        return this.userService.getUsersById(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getUsersByPriority(@RequestParam("priority") Integer priority) {
        return this.userService.getUsersByPriority(priority);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "Se elimino el usuario con id " + id;
        } else {
            return "No fue posible eliminar el usuario con id " + id;
        }
    }

}
