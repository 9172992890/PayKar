package com.PayKar.transaction.service;

import com.PayKar.transaction.Entity.User;
import com.PayKar.transaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getUserByUsername(String username){
        return StreamSupport
                .stream(userRepository.findAll().spliterator(),false)
                .filter(x->x.getUsername().equals(username))
                .findFirst();
    }
    public void createUser(User user){
        userRepository.save(user);
    }
    public Optional<User> getAllUser(){
        return null;
    }
}
