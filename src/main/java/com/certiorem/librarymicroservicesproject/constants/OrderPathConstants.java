package com.certiorem.librarymicroservicesproject.constants;

public class OrderPathConstants {

	// URL path
	public static final String ORDER_SERVICE_SAVE = "/order/save";
	public static final String ORDER_SERVICE_READ = "/order/read";
	public static final String ORDER_SERVICE_DELETE = "/order/delete";
	public static final String ORDER_SERVICE_GET_ALL = "/order/all";
	public static final String ORDER_SERVICE_GET_BY_CLIENT = "/order/by-client";
	
	// URL Params names
	public static final String ORDER_SERVICE_ID_PARAM_NAME = "id";
	public static final String ORDER_SERVICE_CLIENT_ID_PARAM_NAME = "clientId";
	
	// URL Params path
	public static final String ORDER_SERVICE_ID_PARAM = "?id={" + ORDER_SERVICE_ID_PARAM_NAME + "}";
	public static final String ORDER_SERVICE_CLIENT_ID_PARAM = "?clientId={" + ORDER_SERVICE_CLIENT_ID_PARAM_NAME + "}";
	
}
