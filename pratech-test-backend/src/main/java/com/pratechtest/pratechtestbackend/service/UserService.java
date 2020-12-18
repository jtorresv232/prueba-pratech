package com.pratechtest.pratechtestbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pratechtest.pratechtestbackend.entity.User;
import com.pratechtest.pratechtestbackend.irepository.IUserRepository;
import com.pratechtest.pratechtestbackend.iservice.IUserService;
import com.pratechtest.pratechtestbackend.response.FinalResponse;

@Service
public class UserService implements IUserService{
	
	@Autowired private IUserRepository userRepository;
	@Autowired private FinalResponse finalResponse;
	private HttpHeaders responseHeaders = new HttpHeaders();
	
	@Override
	public ResponseEntity<String> login(String email, String password) {
		Optional<User> userFound =  userRepository.findByEmailPassword(email, password);
		if(!userFound.isPresent()) {
			return finalResponse.getResponse("User not found", responseHeaders, HttpStatus.NOT_FOUND).toResponseEntity();
		}
		
		return finalResponse.getResponse(userFound.get(), responseHeaders, HttpStatus.OK).toResponseEntity();
	}

}
