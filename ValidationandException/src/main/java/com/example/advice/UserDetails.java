package com.example.advice;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserDetails {
	  @NotNull(message = "enter a valid name")
	  private String name;
	  @Email(message = "Invalid email address")
	   private String email;
	  @Pattern(regexp = "[A-Z]{1}[a-z]{2}",message = "Invalid password")
	   private String password;
	  @Pattern(regexp = "[6-9]{1}[0-9]{9}",message = "Invalid mobile number")
	   private String mobileno;
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(@NotNull(message = "enter a valid name") String name,
			@Email(message = "Invalid email address") String email,
			@Pattern(regexp = "(A-Z){1}(a-z){2}", message = "Invalid password") String password,
			@Pattern(regexp = "(6-9){1}(0-9){9}", message = "Invalid mobile number") String mobileno) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileno = mobileno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	  
}
