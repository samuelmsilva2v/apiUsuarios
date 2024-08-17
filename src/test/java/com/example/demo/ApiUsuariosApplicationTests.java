package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.dtos.CriarUsuarioRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiUsuariosApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private static String nomeUsuario;
	private static String emailUsuario;

	@Test
	@Order(1)
	public void criarUsuarioComSucessoTest() throws Exception {

		CriarUsuarioRequest request = new CriarUsuarioRequest();
		Faker faker = new Faker();

		request.setNome(faker.name().fullName());
		request.setEmail(faker.internet().emailAddress());
		request.setSenha("@Teste123");

		mockMvc.perform(post("/api/usuario/criar").contentType("application/json")
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk());

		nomeUsuario = request.getNome();
		emailUsuario = request.getEmail();
	}

	@Test
	@Order(2)
	public void emailJaCadastradoTest() throws Exception {

		CriarUsuarioRequest request = new CriarUsuarioRequest();
		Faker faker = new Faker();

		request.setNome(faker.name().fullName());
		request.setEmail(emailUsuario);
		request.setSenha("@Teste123");

		MvcResult result = mockMvc
				.perform(post("/api/usuario/criar").contentType("application/json")
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isUnprocessableEntity()).andReturn();

		String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		assertTrue(content.contains("O e-mail informado já está cadastrado. Tente outro."));

	}

	@Test
	@Order(3)
	public void validacaoCamposObrigatóriosTest() throws Exception {

		CriarUsuarioRequest request = new CriarUsuarioRequest();

		request.setNome(null);
		request.setEmail(null);
		request.setSenha(null);

		MvcResult result = mockMvc
				.perform(post("/api/usuario/criar").contentType("application/json")
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest()).andReturn();

		String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		assertTrue(content.contains("Por favor, informe o nome do usuário."));
		assertTrue(content.contains("Por favor, informe o e-mail do usuário."));
		assertTrue(content.contains("Por favor, informe a senha do usuário."));
	}

	@Test
	@Order(4)
	public void validacaoDeSenhaForteTest() throws Exception {

		CriarUsuarioRequest request = new CriarUsuarioRequest();
		Faker faker = new Faker();

		request.setNome(faker.name().fullName());
		request.setEmail(faker.internet().emailAddress());
		request.setSenha("teste");

		MvcResult result = mockMvc
				.perform(post("/api/usuario/criar").contentType("application/json")
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest()).andReturn();

		String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);

		assertTrue(content.contains("Informe a senha com letras minúsculas, maiúsculas, números e símbolos e pelo menos 8 carateres."));
	}

}
