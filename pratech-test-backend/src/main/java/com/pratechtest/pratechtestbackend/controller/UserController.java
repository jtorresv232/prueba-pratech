package com.pratechtest.pratechtestbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratechtest.pratechtestbackend.entity.User;
import com.pratechtest.pratechtestbackend.iservice.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired private IUserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody User user) {
		return userService.login(user.getEmail(), user.getPassword());
	}
}
