package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.models.Order;
import in.ashokit.service.OrderService;

@RestController
public class OrderRestController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/order")
	public String createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}

}
