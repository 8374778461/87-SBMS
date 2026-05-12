package in.ashokit;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class RequestValidationFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		System.out.println("filter() method called..");

		ServerHttpRequest request = exchange.getRequest();

		HttpHeaders headers = request.getHeaders();

		List<String> list = headers.get("SecretToken");

		if (list!=null && !list.isEmpty() && list.get(0).equals("ashokit@123")) {

			return chain.filter(exchange); // process request
		}

		throw new RuntimeException("Invalid Request");
	}

}
