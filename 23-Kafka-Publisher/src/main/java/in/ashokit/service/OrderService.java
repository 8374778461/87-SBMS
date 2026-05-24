package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.ashokit.constants.AppConstants;
import in.ashokit.models.Order;

@Service
public class OrderService {

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;

	public String createOrder(Order order) {

		// TODO : Logic to save order in DB

		// publish msg to topic
		kafkaTemplate.send(AppConstants.TOPIC_NAME, order);

		return "Msg published to kafka topic";

	}

}
