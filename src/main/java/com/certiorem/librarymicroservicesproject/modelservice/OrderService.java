package com.certiorem.librarymicroservicesproject.modelservice;

import java.util.List;

public interface OrderService {

	public Object createUpdateOrder(Object order);
	
	public Object getOrder(Integer id);
	
	public void deleteOrder(Integer id);
	
	public List<Object> getAllOrders();
	
	public List<Object> getOrdersByClientId(Integer clientId);
	
}
