package com.pratechtest.pratechtestbackend.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface IResponse {
	public ResponseEntity<String> toResponseEntity();
	public String toJson();
	public HttpStatus getHttpStatus();
}
