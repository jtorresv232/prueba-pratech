package com.pratechtest.pratechtestbackend.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service("finalResponse")
public class FinalResponse {
	public Response getResponse(Object data, HttpHeaders responseHeaders, HttpStatus status){
		return new Response.SimpleResponseBuilder()
		        .result(data)
		        .responseHeaders(responseHeaders)
		        .status(status)
		        .build();
	}
}