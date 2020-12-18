package com.pratechtest.pratechtestbackend.response;

import org.springframework.http.HttpHeaders;

public class ResponseHeader {
	public static HttpHeaders RESPONSE_HEADERS;

	public static HttpHeaders getRESPONSE_HEADERS() {
		return RESPONSE_HEADERS;
	}
	
	public ResponseHeader() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void setRESPONSE_HEADERS(HttpHeaders rESPONSE_HEADERS) {
		RESPONSE_HEADERS = rESPONSE_HEADERS;
	}
	
	
}