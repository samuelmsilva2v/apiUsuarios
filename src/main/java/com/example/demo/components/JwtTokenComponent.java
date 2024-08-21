package com.example.demo.components;

import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenComponent {

	@Value("${jwt.secretkey}")
	private String secretKey;

	@Value("${jwt.expiration}")
	private Integer expiration;

	public Date getExpirationDate() {
		Date dataAtual = new Date();
		return new Date(dataAtual.getTime() + expiration);
	}

	public String generateToken(Usuario usuario) {

		return Jwts.builder().setSubject(usuario.getEmail()) // identificação do usuário
				.setNotBefore(new Date()) // data de geração do token
				.setExpiration(getExpirationDate()) // data de expiração do token
				.signWith(SignatureAlgorithm.HS256, secretKey) // chave secreta (assinatura) do token
				.compact();
	}

	public String getEmailFromToken(String token) {
		return getSubject(token, Claims::getSubject);
	}

	private <T> T getSubject(String token, Function<Claims, T> claimsResolver) {
		
		final Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();

		return claimsResolver.apply(claims);
	}

}
