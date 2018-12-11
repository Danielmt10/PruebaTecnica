package com.prueba.app.service;

import com.prueba.app.model.dao.IUserRepository;
import com.prueba.app.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> findAll() {
        List<User> Users = new ArrayList<User>();
        repository
                .findAll()
                .forEach(user -> Users.add(user));
        return Users;
    }

    @Override
    public User fingById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        return !repository.existsById(user.getDni()) ? repository.save(user) : null;
    }

    @Override
    public User updateUser(User user) {
        return repository.existsById(user.getDni()) ? repository.save(user) : null;
    }

    @Override
    public boolean findUserByDniAndPassword(String dni, String password) {
        if(repository.existsById(dni)) {
            User user = repository.findUserByDniAndPassword(dni, password);
            if(user != null)
                return true;
            else
                return false;
        }
        return false;
    }

}
