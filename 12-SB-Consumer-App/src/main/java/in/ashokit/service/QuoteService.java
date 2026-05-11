package in.ashokit.service;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.dto.Quote;
import reactor.core.publisher.Mono;

@Service
public class QuoteService {

	String apiUrl = "https://dummyjson.com/quotes/random";

	public void getRandomQuote1() {

		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> forEntity = rt.getForEntity(apiUrl, String.class);

		String body = forEntity.getBody();

		System.out.println(body);

	}

	public void getRandomQuote2() {

		RestTemplate rt = new RestTemplate();

		ResponseEntity<Quote> forEntity = rt.getForEntity(apiUrl, Quote.class); // json to java conversion

		Quote body = forEntity.getBody();

		System.out.println(body);

	}
	
	
	public void getRandomQuote3() {
		
		WebClient webClient = WebClient.create();
		
		Mono<Quote> bodyToMono = webClient.get()
										 .uri(apiUrl)
										 .retrieve()
										 .bodyToMono(Quote.class);
		
		Quote q = bodyToMono.block(); // making sync call
		
		System.out.println(q);
		
	}
	
	public void getRandomQuoteAsync() {
		
		WebClient webClient = WebClient.create();
		
		webClient.get()
				 .uri(apiUrl)
				 .retrieve()
				 .bodyToMono(Quote.class)
				 .subscribe(response -> {  // making async call with handler
					 handleResponse(response);
				 });

		System.out.println("Request sending completed");
	}

	private void handleResponse(Quote response) {
		System.out.println(response);
	}
}

