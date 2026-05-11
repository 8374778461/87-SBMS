package in.ashokit.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@GetMapping(value = "/welcome", produces = "text/plain")
	public String welcomeMsg() {

		return "Welcome to Ashok IT";
	}
	
	@GetMapping(value = "/greet", produces = "text/plain")
	public ResponseEntity<String> greetMsg() {

		String msg =  "Good Morning";
		
		//int i = 10/0;
		
		return ResponseEntity.status(200)
							 .header("Customer-Header", "Ashok IT")
							 .body(msg);
	}
}
