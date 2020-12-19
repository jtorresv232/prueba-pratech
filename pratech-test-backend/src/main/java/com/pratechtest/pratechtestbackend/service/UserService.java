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

	@Override
	public ResponseEntity<String> signup(User user) {
		try {
			System.out.println(user.getEmail() + user.getPassword());
			userRepository.save(user);
		} catch(Exception e) {
			return finalResponse.getResponse("No se pudo crear el usuario, puede que el correo se encuentre en uso", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR).toResponseEntity();
		}
		
		return finalResponse.getResponse("El usuario ha sido creado exitosamente", responseHeaders, HttpStatus.OK).toResponseEntity();
	}
	
}
