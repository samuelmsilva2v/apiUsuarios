package com.example.demo.dtos;

import lombok.Data;

@Data
public class MensagemUsuarioResponse {

	private String emailDestinatario;
	private String assunto;
	private String texto;
}
