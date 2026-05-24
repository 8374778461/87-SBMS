package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import in.ashokit.constants.AppConstants;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = "group_ashokit_orders")
	public void getKafkaMsgs(String orderJson) {

		System.out.println("** Msg Recieved From Kafka : Consumer - 1***");

		System.out.println(orderJson);

	}
	
	@KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = "group_ashokit_orders")
	public void getKafkaMsgsnew(String orderJson) {

		System.out.println("** Msg Recieved From Kafka : Consumer - 2***");

		System.out.println(orderJson);

	}
	
	

}
