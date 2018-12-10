package com.prueba.app.service;

import com.prueba.app.model.entity.User;
import java.util.List;

public interface IUserService {

    List<User> findAll();
    User fingById(String id);
    User addUser(User user);
    User updateUser(User user);
}
