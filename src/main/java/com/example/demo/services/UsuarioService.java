package com.example.demo.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.components.JwtTokenComponent;
import com.example.demo.components.SHA256Component;
import com.example.demo.dtos.AutenticarUsuarioRequest;
import com.example.demo.dtos.AutenticarUsuarioResponse;
import com.example.demo.dtos.CriarUsuarioRequest;
import com.example.demo.dtos.CriarUsuarioResponse;
import com.example.demo.dtos.ObterDadosResponse;
import com.example.demo.entities.Usuario;
import com.example.demo.exceptions.AcessoNegadoException;
import com.example.demo.exceptions.EmailJaCadastradoException;
import com.example.demo.repositories.PerfilRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private SHA256Component sha256Component;
	
	@Autowired 
	private JwtTokenComponent jwtTokenComponent;

	public CriarUsuarioResponse criar(CriarUsuarioRequest request) throws Exception {
		
		if(usuarioRepository.findByEmail(request.getEmail()) != null)
			throw new EmailJaCadastradoException();
		
		Usuario usuario = new Usuario();
		
		usuario.setId(UUID.randomUUID());
		usuario.setNome(request.getNome());
		usuario.setEmail(request.getEmail());
		usuario.setSenha(sha256Component.hash(request.getSenha()));
		usuario.setPerfil(perfilRepository.findByNome("DEFAULT"));
		
		usuarioRepository.save(usuario);
		
		CriarUsuarioResponse response = new CriarUsuarioResponse();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setDataHoraCadastro(new Date());
		
		return response;
	}
	
	public AutenticarUsuarioResponse autenticar(AutenticarUsuarioRequest request) throws Exception {
		
		Usuario usuario = usuarioRepository.findByEmailAndSenha(request.getEmail(), sha256Component.hash(request.getSenha()));
		
		if(usuario == null)
			throw new AcessoNegadoException();
		
		AutenticarUsuarioResponse response = new AutenticarUsuarioResponse();
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setDataHoraAcesso(new Date());
		response.setTokenAcesso(jwtTokenComponent.generateToken(usuario));
		response.setDataHoraExpiracao(jwtTokenComponent.getExpirationDate());
		response.setNomePerfil(usuario.getPerfil().getNome());
		
		return response;
	}
	
	public ObterDadosResponse obterDados(String token) throws Exception {
		
		String email = jwtTokenComponent.getEmailFromToken(token);
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if(usuario == null)
			throw new AcessoNegadoException();
		
		ObterDadosResponse response = new ObterDadosResponse();
		
		response.setId(usuario.getId());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setNomePerfil(usuario.getPerfil().getNome());		
		
		return response;
	}
}
