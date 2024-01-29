package com.example.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepositary extends JpaRepository<User, Integer>{

}
