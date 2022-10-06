package com.monkey.generator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.monkey.generator.controller.exception.CAuthenticationEntryPointException;
import com.monkey.generator.model.ResponseModel;

@ControllerAdvice
public class MonkeyControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {ConstraintViolationException.class})
	protected ResponseEntity<ResponseModel> handleConstraintViolation(ConstraintViolationException e, WebRequest request) {
		return  getErrorMessage(e.getMessage());
	}
	
	@ExceptionHandler(CAuthenticationEntryPointException.class)
	public ResponseEntity<ResponseModel> authenticationEntryPointException(WebRequest request, CAuthenticationEntryPointException e) {
	    return getAuthErrorMessage();
	}

	
	private ResponseEntity<ResponseModel> getErrorMessage(String e) {
		String message = "올바른 값을 입력해주세요.";
		List<String> error = new ArrayList<String>();
		for(String token : e.split(",")) {
			error.add(token.trim());
		}
		ResponseModel rm = new ResponseModel(400, false, message, error);
		return new ResponseEntity<>(rm, HttpStatus.BAD_REQUEST);
	}
	
	private ResponseEntity<ResponseModel> getAuthErrorMessage() {
		String message = "권한이 없습니다.";
		ResponseModel rm = new ResponseModel(403, false, message);
		return new ResponseEntity<>(rm, HttpStatus.FORBIDDEN);
	}

}
