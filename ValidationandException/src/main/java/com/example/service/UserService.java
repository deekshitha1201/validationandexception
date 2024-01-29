package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.advice.UserDetails;
import com.example.entity.User;

public interface UserService {
    String addUser(UserDetails userDetails);
    List<User> getall();
    User getById(int id) throws UserNotFoundException;
    String deleteid(int id) throws UserNotFoundException;
}
