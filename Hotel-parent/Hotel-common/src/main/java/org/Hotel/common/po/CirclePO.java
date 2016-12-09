package org.Hotel.common.po;

import java.io.Serializable;

public class CirclePO implements Serializable{

	private double discount;
	
	private String city;
	
	private String name;
	
	public CirclePO() {
		super();
	}
	
	public CirclePO(double discount, String city, String name) {
		super();
		
		this.discount = discount;
		this.city = city;
		this.name = name;
	}

	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
