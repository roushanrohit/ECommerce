package com.ecommerce.entity;

public class Item {

	public String name;
	public double weight;
	
	// pincode at which this item is available
	public int pinCode;
	
	public Item() {}

	public Item(String name, double weight, int pinCode) {
		super();
		this.name = name;
		this.weight = weight;
		this.pinCode = pinCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
}
