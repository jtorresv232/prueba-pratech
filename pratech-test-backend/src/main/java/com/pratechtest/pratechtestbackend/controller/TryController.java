package com.pratechtest.pratechtestbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratechtest.pratechtestbackend.iservice.ITryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tries")
public class TryController {
	
	@Autowired ITryService tryService;

	@RequestMapping("/{userid}")
	public ResponseEntity<String> getAllByUser(@PathVariable("userid") int id) {
		return tryService.getAllTriesByUser(id);
	}
	
	@RequestMapping(value="/{tryid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteByid(@PathVariable("tryid") int tryid) {
		return tryService.deleteTry(tryid);
	}
}
