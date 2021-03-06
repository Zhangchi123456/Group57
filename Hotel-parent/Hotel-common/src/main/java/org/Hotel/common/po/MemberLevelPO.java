package org.Hotel.common.po;

import java.io.Serializable;

public class MemberLevelPO implements Serializable{
	
	private int level;
	
	private int credit;
	
	private double discount;
	
	public MemberLevelPO() {
		
	}
	
	public MemberLevelPO(int level, int credit, double discount) {
		super();
		
		this.level = level;
		this.credit = credit;
		this.discount = discount;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
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
}
