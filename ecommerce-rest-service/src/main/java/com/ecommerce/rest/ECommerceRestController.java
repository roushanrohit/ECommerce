package com.ecommerce.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Item;
import com.ecommerce.service.ECommerceService;

@RestController
@RequestMapping("/ecommerce")
public class ECommerceRestController {

	// autowire the ECommerce service
	@Autowired
	private ECommerceService ecommerceService;
	
	// add item to the cart
	@PostMapping("/add")
	public Item addItem(@RequestBody Item item) {
		
		return ecommerceService.add(item);
	}
	
	// get list of items in the cart
	@GetMapping("/list")
	public List<Item> getItems(){
		
		return ecommerceService.list();
	}
	
	// get total value of items
	@GetMapping("/cartValue")
	public int totalValue(){
		
		return ecommerceService.totalValue();
	}
	
	// remove all items from the cart
	@GetMapping("/emptyCart")
	public String removeAll(){
		
		return ecommerceService.removeAll();
	}
}
