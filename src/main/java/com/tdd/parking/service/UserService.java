package com.tdd.parking.service;

import com.tdd.parking.entity.User;
import com.tdd.parking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public boolean addUser(User user) {
        User user1 = userRepository.findById(user.getId()).orElse(null);
        if(user1 == null){
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
