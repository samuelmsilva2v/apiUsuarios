package com.example.demo.exceptions;

public class EmailJaCadastradoException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "O e-mail informado já está cadastrado. Tente outro.";
	}
	
}
