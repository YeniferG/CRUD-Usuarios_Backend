package com.sofka.springboot.repositories;

import java.util.ArrayList;

import com.sofka.springboot.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//En esta clase se realiza la conexion con la BBDD
@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByPriority(Integer priority);

    public abstract ArrayList<UserModel> findByEmail(String email);
}
