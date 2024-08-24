package com.example.demo.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumerComponent {

	@RabbitListener(queues = { "mensagens-usuarios" })
	public void process(@Payload String message) throws Exception {

		// TODO integrar com o Outlook e enviar por e-mail
		System.out.println("\nMENSAGEM PROCESSADA COM SUCESSO:");
		System.out.println(message);
	}
}
