package com.ashok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.entity.User;
import com.ashok.services.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/add")
	ResponseEntity<User> addUser(@RequestBody User user)
	{
		User user1=userService.addUser(user);
		return new ResponseEntity<>(user1,HttpStatus.ACCEPTED);
	}
	@GetMapping("/get")
	ResponseEntity<List<User>> AllUser()
	{
		List<User> user=userService.getAllUser();
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
	}

	
	 @GetMapping("/user") ResponseEntity<User> getUserById(@PathVariable Long userId) { 
		 userService.getUserById(userId); return new
	  ResponseEntity<>(HttpStatus.ACCEPTED); }
	
	@DeleteMapping("/delete")
	ResponseEntity<?> deleteUser(@PathVariable Long userId)
	{
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
