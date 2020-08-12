package com.cg.drinkDelight.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.drinkDelight.dto.DrinkDelightErrorMsg;
import com.cg.drinkDelight.exception.NoVendorException;

@RestControllerAdvice
public class DrinkDelightExceptionAdvice {
   Logger logger = LoggerFactory.getLogger(DrinkDelightExceptionAdvice.class);
   
	@ExceptionHandler({NoVendorException.class})
	@ResponseStatus(code=HttpStatus.NOT_FOUND,reason = "vendor details are wrong")
	public DrinkDelightErrorMsg handleExcveption(Exception ex) {
		logger.error(ex.getMessage());
		return new DrinkDelightErrorMsg(ex.getMessage());
	}
}
