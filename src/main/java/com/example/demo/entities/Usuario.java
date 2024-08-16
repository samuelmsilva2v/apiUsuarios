package com.example.demo.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class Usuario {

	private UUID id;
	private String nome;
	private String email;
	private String senha;
}
