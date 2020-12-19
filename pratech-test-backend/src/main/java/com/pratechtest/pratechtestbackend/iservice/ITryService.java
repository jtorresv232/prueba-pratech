package com.pratechtest.pratechtestbackend.iservice;

import org.springframework.http.ResponseEntity;

public interface ITryService {
	ResponseEntity<String> getAllTriesByUser(int userid);
	ResponseEntity<String> deleteTry(int tryid);
}
