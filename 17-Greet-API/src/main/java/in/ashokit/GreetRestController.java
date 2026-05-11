package in.ashokit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetRestController {

	@Value("${msg}")
	private String greetMsg;

	@Autowired
	private WelcomeApiClient welcomeApiClient;

	@GetMapping("/greet")
	public String getWelcomeMsg() {

		String welcomeApiMsg = welcomeApiClient.invokeWelcomeApi();

		return greetMsg + ", " + welcomeApiMsg;
	}
}
