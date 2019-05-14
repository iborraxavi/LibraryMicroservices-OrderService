package com.certiorem.librarymicroservicesproject.modelservice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.certiorem.librarymicroservicesproject.constants.DatabasePathConstants;
import com.certiorem.librarymicroservicesproject.constants.OrderPathConstants;
import com.certiorem.librarymicroservicesproject.modelservice.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Object createUpdateOrder(Object order) {
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(
				DatabasePathConstants.DATABASE_SERVICE_HOST + OrderPathConstants.ORDER_SERVICE_SAVE, order, Object.class);
		return responseEntity.getBody();
	}

	@Override
	public void deleteOrder(Integer orderId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(OrderPathConstants.ORDER_SERVICE_ID_PARAM_NAME, orderId);

		restTemplate.delete(DatabasePathConstants.DATABASE_SERVICE_HOST + OrderPathConstants.ORDER_SERVICE_DELETE
				+ OrderPathConstants.ORDER_SERVICE_ID_PARAM, uriVariables);
	}

	@Override
	public List<Object> getAllOrders() {
		ResponseEntity<List<Object>> response = restTemplate.exchange(
				DatabasePathConstants.DATABASE_SERVICE_HOST + OrderPathConstants.ORDER_SERVICE_GET_ALL, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Object>>() {
				});
		return response.getBody();
	}

	@Override
	public Object getOrder(Integer orderId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(OrderPathConstants.ORDER_SERVICE_ID_PARAM_NAME, orderId);

		ResponseEntity<Object> responseEntity = restTemplate
				.getForEntity(DatabasePathConstants.DATABASE_SERVICE_HOST + OrderPathConstants.ORDER_SERVICE_READ
						+ OrderPathConstants.ORDER_SERVICE_ID_PARAM, Object.class, uriVariables);
		return responseEntity.getBody();
	}

	@Override
	public List<Object> getOrdersByClientId(Integer clientId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(OrderPathConstants.ORDER_SERVICE_CLIENT_ID_PARAM_NAME, clientId);
		ResponseEntity<List<Object>> response = restTemplate.exchange(
				DatabasePathConstants.DATABASE_SERVICE_HOST + OrderPathConstants.ORDER_SERVICE_GET_BY_CLIENT
						+ OrderPathConstants.ORDER_SERVICE_CLIENT_ID_PARAM,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Object>>() {
				}, uriVariables);
		return response.getBody();
	}

}
