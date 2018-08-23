package com.tdd.parking.controller;

import com.tdd.parking.entity.User;
import com.tdd.parking.exception.BadRequestException;
import com.tdd.parking.service.UserService;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user){
        String pwd = userService.addUser(user);
        if(pwd != null){
         return ResponseEntity.status(HttpStatus.CREATED).body(pwd);
        }
        throw new BadRequestException();
    }

}
