package org.Hotel.common.po;

public class MemberLevelPO {

	private String name;
	
	private int level;
	
	private int credit;
	
	private double discount;
	
	private String type;
	
	public MemberLevelPO() {
		
	}
	
	public MemberLevelPO(String name, int level, int credit, double discount, String type) {
		super();
		
		this.level = level;
		this.credit = credit;
		this.discount = discount;
		this.name = name;
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
