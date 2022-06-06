package com.example.user_service.service;

import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //fake user list

    List<User> list = List.of(
            new User(1311L, "Durgesh Tiwari", "23525625"),
            new User(1312L, "Ankit Tiwari", "99999"),
            new User(1314L, "Ravi Tiwari", "888")
    );

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User setUser() {
        return userRepository.save(list.get(0));
    }
}
