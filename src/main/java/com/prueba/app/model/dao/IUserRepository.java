package com.prueba.app.model.dao;

import com.prueba.app.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, String> {

    @Query("select u from User u where u.dni = ?1 and u.password = ?2")
    User findUserByDniAndPassword(String dni, String password);
}
