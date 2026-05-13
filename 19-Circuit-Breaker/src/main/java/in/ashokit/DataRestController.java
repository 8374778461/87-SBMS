package in.ashokit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DataRestController {

	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod = "getDataFromDB", name = "ashokit")
	public String getDataFromRedis() {

		System.out.println("*** redis() method executed... ***");

		int i = 10 / 0;

		return "redis call success";

	}

	public String getDataFromDB(Throwable t) {

		System.out.println("*** db() method executed... ***");

		return "db call success";
	}

}
