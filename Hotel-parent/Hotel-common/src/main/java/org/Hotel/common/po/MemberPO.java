package org.Hotel.common.po;

import java.util.Date;

public class MemberPO {

	private int id;
	
	private String name;
	
	private String password;
	
	private String connection;
	
	private Date birthday;
	
	private int credit;
	
	private boolean enterprice;
	
	public MemberPO() {
		super();
	}
	
	public MemberPO(int id, String password, String connection, Date birthday, String name, int credit, boolean enterprice) {
		
		super();
		
		this.id = id;
		this.password = password;
		this.connection = connection;
		this.birthday = birthday;
		this.name = name;
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
	 * @return the enterprice
	 */
	public boolean isEnterprice() {
		return enterprice;
	}

	/**
	 * @param enterprice the enterprice to set
	 */
	public void setEnterprice(boolean enterprice) {
		this.enterprice = enterprice;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	
	public int getId(){
		return id;
	}
	
	public String getPassword() {
			
		return password;
		
	}

	public void setPassword(String password) {
			
		this.password = password;
		
	}
	
	public String getConnection() {
		
		return connection;
	}
	
	public void setConnection(String connection) {
		
		this.connection = connection;
	}
	
	public Date getBirthday() {
		
		return birthday;
	}
	
	public void setBirthday(Date birthday){
		
		this.birthday = birthday;
	}
}
