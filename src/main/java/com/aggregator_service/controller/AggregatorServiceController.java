package com.aggregator_service.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aggregator_service.model.Order;
import com.aggregator_service.model.OrderDetail;
import com.aggregator_service.model.User;

@RestController
@RequestMapping(value = "/orderdetail")
public class AggregatorServiceController {

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping(value = "/{email_id}")
	public OrderDetail getOrderDetail(@PathVariable(name = "email_id") String email_id) {
		ResponseEntity<List<Order>> orderList = restTemplate.exchange("http://order:8091/order/"+email_id, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Order>>() {
                }); 
		ResponseEntity<User> user = restTemplate.exchange("http://user:8090/user/"+email_id, HttpMethod.GET,
                null, new ParameterizedTypeReference<User>() {
                }); 
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderList(orderList.getBody());
		orderDetail.setUser(user.getBody());
		return orderDetail;
		

	}
}
