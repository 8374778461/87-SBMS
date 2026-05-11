package in.ashokit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="welcome")
public interface WelcomeApiClient {
	
	@GetMapping("/welcome-msg")
	public String invokeWelcomeApi();

}
