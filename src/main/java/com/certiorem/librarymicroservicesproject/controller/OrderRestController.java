package com.certiorem.librarymicroservicesproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.certiorem.librarymicroservicesproject.constants.OrderPathConstants;
import com.certiorem.librarymicroservicesproject.modelservice.OrderService;

@RestController
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping(OrderPathConstants.ORDER_SERVICE_SAVE)
	@ResponseBody
	public Object saveOrder(@RequestParam Object order) {
		return orderService.createUpdateOrder(order);
	}
	
	@GetMapping(OrderPathConstants.ORDER_SERVICE_READ)
	@ResponseBody
	public Object getOrderById(@RequestParam String id) {
		return orderService.getOrder(Integer.parseInt(id));
	}
	
	@GetMapping(OrderPathConstants.ORDER_SERVICE_DELETE)
	@ResponseBody
	public void deleteOrders(@RequestParam String id) {
		orderService.deleteOrder(Integer.parseInt(id));
	}
	
	@GetMapping(OrderPathConstants.ORDER_SERVICE_GET_ALL)
	@ResponseBody
	public List<Object> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	@GetMapping(OrderPathConstants.ORDER_SERVICE_GET_BY_CLIENT)
	@ResponseBody
	public List<Object> getOrdersByClient(@RequestParam String clientId) {
		return orderService.getOrdersByClientId(Integer.parseInt(clientId));
	}
	
}
