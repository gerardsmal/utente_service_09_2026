package com.betacom.ut.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.betacom.ut.dto.output.ResponseDTO;
import com.betacom.ut.services.interfaces.IMessageServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionManager {
	private final IMessageServices msgS;
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ResponseDTO> handleBadCredentials(
	        BadCredentialsException ex) {

	    return ResponseEntity
	        .status(HttpStatus.UNAUTHORIZED)
	        .body(new ResponseDTO(msgS.get("login_invalid")));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> handleException(Exception e){
		return ResponseEntity.badRequest()
				.body(ResponseDTO.builder()
						.msg(msgS.get(e.getMessage()))
						.build()
						);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleValidationException(MethodArgumentNotValidException e) {
		  String msg = e.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .findFirst()
	                .map(FieldError::getDefaultMessage)
	                .orElse("Errore di validazione");

		  return ResponseEntity.badRequest()
					.body(ResponseDTO.builder()
							.msg(msgS.get(msg))
							.build()
							);
		  
	}
	
}

