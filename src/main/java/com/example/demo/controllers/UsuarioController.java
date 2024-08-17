package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CriarUsuarioRequest;
import com.example.demo.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("criar")
	public CriarUsuarioRequest criar(@RequestBody @Valid CriarUsuarioRequest request) throws Exception {
		
		return usuarioService.
	}
}
