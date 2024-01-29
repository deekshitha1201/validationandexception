package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advice.UserDetails;
import com.example.entity.User;
import com.example.repositary.UserRepositary;
@Service
public class UserServiceImpl implements UserService{
@Autowired
  private UserRepositary userep;
	@Override
	public String addUser(UserDetails userDetails) {
		User user=new User();
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setMobileno(userDetails.getMobileno());
		List<User> use=getall().stream().filter(res->(res.getEmail().equalsIgnoreCase(userDetails.getEmail())))
				.collect(Collectors.toList());
		if(use.isEmpty()) {
			userep.save(user);
			return "Successfully registered";
		}
		
		 return "email is already exist";
	}
	@Override
	public List<User> getall() {
		
		return userep.findAll();
	}
	@Override
	public User getById(int id)  throws UserNotFoundException{
		Optional<User> u=userep.findById(id);
		if(u.isPresent()) {
			return u.get();
		}
		else {
			throw new  UserNotFoundException("id not found");
		}
	}
	@Override
	public String deleteid(int id) throws UserNotFoundException {
		if(userep.existsById(id)) {
			userep.deleteById(id);
			return "successfully deleted";
		}
		else {
			throw new UserNotFoundException("id not found");
		}
	}
   
}
