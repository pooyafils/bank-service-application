package com.dev.BankService.config;

import com.dev.BankService.constants.Constants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessegingConfig {

	@Bean
	public Queue queue() {
		return new Queue(Constants.QUEUE_1);
	}
	@Bean
	public Queue queueTwo() {
		return new Queue(Constants.QUEUE_2);
	}
	@Bean
	public Queue queueThree() {
		return new Queue(Constants.QUEUE_3);
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(Constants.EXCHANGE_1);
	}
	@Bean
	public TopicExchange topicExchangeTwo() {
		return new TopicExchange(Constants.EXCHANGE_2);
	}
	@Bean
	public TopicExchange topicExchangeThree() {
		return new TopicExchange(Constants.EXCHANGE_3);
	}

	@Bean
	public Binding binding(Queue queue, @Qualifier("topicExchange") TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Constants.ROUTING_KEY_1);
	}
	@Bean
	public Binding bindingTransactions() {
		return BindingBuilder.bind(queueTwo()).to(topicExchangeTwo()).with(Constants.ROUTING_KEY_2);
	}
	@Bean
	public Binding bindingCurrency() {
		return BindingBuilder.bind(queueThree()).to(topicExchangeThree()).with(Constants.ROUTING_KEY_3);
	}
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
}
