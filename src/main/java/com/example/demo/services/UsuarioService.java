package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.components.SHA256Component;
import com.example.demo.dtos.CriarUsuarioRequest;
import com.example.demo.repositories.PerfilRepository;
import com.example.demo.repositories.UsuarioRepository;

public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private SHA256Component sha256Component;
	
	public CriarUsuarioRespons
}
