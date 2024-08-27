package com.example.demo.components;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.collections.LogMensageria;
import com.example.demo.dtos.MensagemUsuarioResponse;
import com.example.demo.repositories.LogMensageriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RabbitMQProducerComponent {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue queue;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private LogMensageriaRepository logMensageriaRepository;

	public void send(MensagemUsuarioResponse mensagem) throws Exception {

		LogMensageria logMensageria = new LogMensageria();
		logMensageria.setId(UUID.randomUUID());
		logMensageria.setDataHora(new Date());
		logMensageria.setOperacao("ENVIO DE MENSAGEM PARA A FILA");

		try {
			
			String json = objectMapper.writeValueAsString(mensagem);

			rabbitTemplate.convertAndSend(queue.getName(), json);
			
			logMensageria.setStatus("SUCESSO");
			logMensageria.setDescricao(json);
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
