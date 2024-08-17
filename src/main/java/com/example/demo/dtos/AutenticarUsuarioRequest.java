package com.example.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AutenticarUsuarioRequest {

	@Email(message = "Por favor, informe um endereço de e-mail válido.")
	@NotEmpty(message = "Por favor, informe o e-mail do usuário.")
	private String email;
	
	@Size(min = 8, message = "Por favor, informe a senha com 8 caracteres.")
	@NotEmpty(message = "Por favor, informe a senha do usuário.")
	private String senha;
}
