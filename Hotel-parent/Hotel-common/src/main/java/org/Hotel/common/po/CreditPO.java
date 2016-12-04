package org.Hotel.common.po;

import java.util.Date;

public class CreditPO {

	private String name;
	
	private int id;
	
	private int orderid;
	
	private int creditchange;
	
	private int credit;
	
	private Date time;
	
	private String action;
	
	public CreditPO() {
		
	}
	
	public CreditPO(String name, int id, int orderid, int creditchange, int credit, Date time, String action) {
		
		super();
		
		this.name = name;
		this.id = id;
		this.creditchange = creditchange;
		this.credit = credit;
		this.time = time;
		this.action = action;
		this.orderid = orderid;
	}

	/**
	 * @return the orderid
	 */
	public int getOrderid() {
		return orderid;
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the creditchange
	 */
	public int getCreditchange() {
		return creditchange;
	}

	/**
	 * @param creditchange the creditchange to set
	 */
	public void setCreditchange(int creditchange) {
		this.creditchange = creditchange;
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
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
}
