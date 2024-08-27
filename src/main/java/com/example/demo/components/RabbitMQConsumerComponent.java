package com.example.demo.components;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.demo.collections.LogMensageria;
import com.example.demo.dtos.MensagemUsuarioResponse;
import com.example.demo.repositories.LogMensageriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RabbitMQConsumerComponent {

	@Autowired
	private EmailComponent emailComponent;

	@Autowired
	private LogMensageriaRepository logMensageriaRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@RabbitListener(queues = { "mensagens-usuarios" })
	public void process(@Payload String message) throws Exception {

		LogMensageria logMensageria = new LogMensageria();
		logMensageria.setId(UUID.randomUUID());
		logMensageria.setDataHora(new Date());
		logMensageria.setOperacao("PROCESSAMENTO DE MENSAGEM DA FILA");

		try {

			MensagemUsuarioResponse mensagem = objectMapper.readValue(message, MensagemUsuarioResponse.class);
			emailComponent.sendMail(mensagem.getEmailDestinatario(), mensagem.getAssunto(), mensagem.getTexto());

			logMensageria.setStatus("SUCESSO");
			logMensageria.setDescricao(message);
		} 
		catch (Exception e) {

			logMensageria.setStatus("ERRO");
			logMensageria.setDescricao(e.getMessage());
		} 
		finally {

			logMensageriaRepository.save(logMensageria);
		}
	}
}
