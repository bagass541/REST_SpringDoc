package com.bagas.REST_SpringDoc;

public class OrderNotFoundException extends RuntimeException{

	public OrderNotFoundException(Long id)
	{
		super("Could not find employee " + id);
	}
}

