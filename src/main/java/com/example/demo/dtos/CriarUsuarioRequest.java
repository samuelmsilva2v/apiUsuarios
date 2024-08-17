package com.example.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequest {

	@Size(min = 8, max = 100, message = "Informe o nome do usuário com 8 a 100 caracteres.")
	@NotEmpty(message = "Por favor, informe o nome do usuário.")
	private String nome;
	
	@Email(message = "Informe um endereço de e-mail válido.")
	@NotEmpty(message = "Por favor, informe o e-mail do usuário.")
	private String email;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
			message = "Informe a senha com letras minúsculas, maiúsculas, números e símbolos e pelo menos 8 carateres.")
	@NotEmpty(message = "Por favor, informe a senha do usuário.")
	private String senha;
}
