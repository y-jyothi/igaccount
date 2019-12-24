package com.example.kalingaAcoounts.controller.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.kalingaAcoounts.exceptions.serviceexceptions.ServiceException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<Map<String, Object>> serviceExceptionHandler(Exception e, Throwable cause) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("Header", "Error message");
		response.put("Error", true);
		response.put("Body", e.getMessage());
		response.put("HTTP Status", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

	}


}
