package com.pratechtest.pratechtestbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratechtest.pratechtestbackend.iservice.IFormService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/forms")
public class FormController {
	
	@Autowired private IFormService formService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> login() {
		return formService.getAll();
	}
}
