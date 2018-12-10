package com.prueba.app.controller;

import com.prueba.app.model.entity.User;
import com.prueba.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("user/{id}")
    public ResponseEntity<User> findById(@PathVariable String id){
        User user = service.fingById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = service.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("log/{dni}/{pass}")
    public ResponseEntity<Boolean> loggin(@PathVariable("dni") String dni,@PathVariable("pass") String pass){
        boolean isLogged = service.findUserByDniAndPassword(dni, pass);
        return new ResponseEntity<Boolean>(isLogged, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = service.addUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

}
