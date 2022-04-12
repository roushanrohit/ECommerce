package com.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ecommerce.entity.Item;

/*
 * We're generating a unique distance for every time this service is called.
 * Assuming each item will be delivered from different warehouses.
 */
@Service
public class ShippingServiceImpl implements ShippingService{
	
	@Override
	public int distance(Item item) {
		return (int) Math.random() * 1000 * item.pinCode;
	}

}
