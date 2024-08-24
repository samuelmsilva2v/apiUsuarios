package com.example.demo.components;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.MensagemUsuarioResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RabbitMQProducerComponent {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue queue;

	@Autowired
	private ObjectMapper objectMapper;

	public void send(MensagemUsuarioResponse mensagem) throws Exception {

		String json = objectMapper.writeValueAsString(mensagem);

		rabbitTemplate.convertAndSend(queue.getName(), json);
	}

}
