package com.pratechtest.pratechtestbackend.iservice;

import org.springframework.http.ResponseEntity;


public interface IUserService {
	public ResponseEntity<String> login(String email, String password);
}
