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

//En esta clase se recibe la petición web
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    // Metodo que sirve para buscar todos los usuarios
    @GetMapping()
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    // Merodo que sirve para guardar usuarios
    @PostMapping()
    public String saveUsers(@RequestBody UserModel user) {
        return this.userService.saveUsers(user);
    }

    // Metodod que sirve para buscar los usuarios por su id
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    // Metodod que sirve para buscar los usuarios por la prioridad
    @GetMapping("/query")
    public ArrayList<UserModel> getUsersByPriority(@RequestParam("priority") Integer priority) {
        return this.userService.getUsersByPriority(priority);
    }

    // Metodod que sirve para buscar los usuarios por su email
    @GetMapping("/emails")
    public ArrayList<UserModel> getByEmail(@RequestParam("email") String email) {
        return this.userService.getByEmail(email);
    }

    // Metodo que sirve para eliminar los usuarios por su id
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
