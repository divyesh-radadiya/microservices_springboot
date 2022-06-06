package com.example.user_service.controller;

import java.util.List;

import com.example.user_service.entity.User;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {

        User user = this.userService.getUser(userId);

        //http://localhost:9002/contact/user/1311

        List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);

        user.setContacts(contacts);

        return user;

    }
    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return userService.setUser();

    }

}
