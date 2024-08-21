package com.example.demo.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class ObterDadosResponse {

	private UUID id;
	private String nome;
	private String email;
	private String nomePerfil;
}
