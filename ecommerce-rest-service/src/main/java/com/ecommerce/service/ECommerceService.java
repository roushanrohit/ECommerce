package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.Item;

public interface ECommerceService {

	public Item add(Item item);
	
	public List<Item> list();
	
	public int totalValue();
	
	public String removeAll();
}
