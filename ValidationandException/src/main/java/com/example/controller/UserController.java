package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.advice.UserDetails;
import com.example.entity.User;
import com.example.service.UserNotFoundException;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
   @Autowired
   private UserService users;
   
   @PostMapping("/post")
   public ResponseEntity<String> addDetails(@RequestBody @Valid UserDetails userDetails){
	   
		   return new ResponseEntity<String>(users.addUser(userDetails),HttpStatus.CREATED);
	   
	
   }
   @GetMapping("/get")
   public ResponseEntity<List<User>> get(){
	   return new ResponseEntity<List<User>>(users.getall(),HttpStatus.OK);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<User> getid(@PathVariable int id) throws UserNotFoundException{
	   return new ResponseEntity<User>(users.getById(id),HttpStatus.OK);
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<String> delete(@PathVariable int id) throws UserNotFoundException{
	   return new ResponseEntity<String>(users.deleteid(id),HttpStatus.OK);
   }
   
   @PutMapping("/put")
   @PostMapping("/post")
   public ResponseEntity<String> updateDetails(@RequestBody @Valid UserDetails userDetails){
	   
		   return new ResponseEntity<String>(users.addUser(userDetails),HttpStatus.CREATED);
	   
	
   }
}
