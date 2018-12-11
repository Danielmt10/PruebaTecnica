package com.prueba.app.service;

import com.prueba.app.model.dao.IUserTypeRepository;
import com.prueba.app.model.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserTypeService implements IUserTypeService {

    @Autowired
    private IUserTypeRepository repository;

    @Override
    public List<UserType> findAll() {
        List<UserType> auth = new ArrayList<UserType>();
        repository.findAll()
                .forEach(roles -> auth.add(roles));
        return auth;
    }
}
