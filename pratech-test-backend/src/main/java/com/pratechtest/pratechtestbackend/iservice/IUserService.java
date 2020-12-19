package com.pratechtest.pratechtestbackend.iservice;

import org.springframework.http.ResponseEntity;

import com.pratechtest.pratechtestbackend.entity.User;


public interface IUserService {
	public ResponseEntity<String> login(String email, String password);
	public ResponseEntity<String> signup(User user);
}
