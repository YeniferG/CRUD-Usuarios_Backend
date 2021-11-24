package com.sofka.springboot.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.sofka.springboot.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByPrioridad(Integer priority);

    public abstract Optional<UserModel> findByEmail(String email);
}
