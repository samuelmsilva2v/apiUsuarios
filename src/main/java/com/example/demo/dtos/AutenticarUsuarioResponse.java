package com.example.demo.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class AutenticarUsuarioResponse {

	private UUID id;
	private String nome;
	private String email;
	private Date dataHoraAcesso;
	private String tokenAcesso;
	private Date dataHoraExpiracao;
	private String nomePerfil;
}
