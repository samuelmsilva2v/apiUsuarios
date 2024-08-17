package com.example.demo.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exceptions.EmailJaCadastradoException;

public class UsuarioExceptionHandler {

	@ExceptionHandler(EmailJaCadastradoException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ResponseBody
	public List<String> errorHandler(EmailJaCadastradoException e) {

		List<String> errors = new ArrayList<String>();
		errors.add(e.getMessage());

		return errors;
	}

}
