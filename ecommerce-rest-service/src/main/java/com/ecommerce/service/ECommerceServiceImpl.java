package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Item;

/*
 * Not using a DB layer for simplicity
 * All Calculations are done in the service layer
 */
@Service
public class ECommerceServiceImpl implements ECommerceService {

	@Autowired
	ShippingService shippingService;
	
	List<Item> items = new ArrayList<>();
	int[][] matrix;
	/*
	 * Table for calculating total cost
	 *                                Distance
	 *    Weight        < 5 km    5 - 20 km  20 - 50 km  50 - 500 km  500 - 800 km  > 800 km
	 * < 2 kg              12        15          20          50           100         220
	 * 2.01 - 5 kg         14        18          24          55           110         250
	 * 5.01 - 20 kg        16        25          30          80           130         270
	 * > 20.01 kg          21        35          50          90           150         300
	 */
	
	public ECommerceServiceImpl() {
		
		items = new ArrayList<>();
		matrix = new int[4][6];
		
		matrix[0][0] = 12;
		matrix[0][1] = 15;
		matrix[0][2] = 20;
		matrix[0][3] = 50;
		matrix[0][4] = 100;
		matrix[0][5] = 220;
		
		matrix[1][0] = 14;
		matrix[1][1] = 18;
		matrix[1][2] = 24;
		matrix[1][3] = 55;
		matrix[1][4] = 110;
		matrix[1][5] = 250;
		
		matrix[2][0] = 16;
		matrix[2][1] = 25;
		matrix[2][2] = 30;
		matrix[2][3] = 80;
		matrix[2][4] = 130;
		matrix[2][5] = 270;
		
		matrix[3][0] = 21;
		matrix[3][1] = 35;
		matrix[3][2] = 50;
		matrix[3][3] = 90;
		matrix[3][4] = 150;
		matrix[3][5] = 300;
	}
	
	@Override
	public Item add(Item item) {
		
		items.add(item);
		return item;
	}

	@Override
	public List<Item> list() {
		return items;
	}
	
	@Override
	public int totalValue() {
		
		int total = 0;
		for(Item i : items) {
			
			double w = i.weight;
			if(w < 2.0) total += findCost(i, 0);
			else if(w < 5.0) total += findCost(i, 1);
			else if(w < 20.0) total += findCost(i, 2);
			else total += findCost(i, 3);
		}
		return total;
	}
	
	public int findCost(Item item, int rowNo) {
		
		int cost = 0;
		int distance = shippingService.distance(item);
		if(distance < 5) cost = matrix[rowNo][0];
		else if(distance < 20) cost = matrix[rowNo][1];
		else if(distance < 50) cost = matrix[rowNo][2];
		else if(distance < 500) cost = matrix[rowNo][3];
		else if(distance < 800) cost = matrix[rowNo][4];
		else cost = matrix[rowNo][5];
		
		return cost;
	}

	@Override
	public String removeAll() {
		
		if(items.size() > 0) {
			items.clear();
			return "All items removed from the cart";
		}
		return "No items found in the cart";
	}

}
