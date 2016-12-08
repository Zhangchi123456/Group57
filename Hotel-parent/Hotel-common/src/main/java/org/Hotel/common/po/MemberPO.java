package org.Hotel.common.po;

import java.io.Serializable;
import java.util.Date;

public class MemberPO implements Serializable{

	private int id;
	
	private String name;
	
	private String password;
	
	private String connection;
	
	private Date birthday;
	
	private int credit;
	
	private boolean enterprise;
	
	private int level;
	
	public MemberPO() {
		super();
	}
	
	public MemberPO(int id, String password, String connection, 
			Date birthday, String name, int credit, boolean enterprise, int level) {
		
		super();
		
		this.id = id;
		this.password = password;
		this.connection = connection;
		this.birthday = birthday;
		this.name = name;
		this.enterprise = enterprise;
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
	 * @return the enterprise
	 */
	public boolean isEnterprise() {
		return enterprise;
	}

	/**
	 * @param enterprice the enterprise to set
	 */
	public void setEnterprise(boolean enterprise) {
		this.enterprise = enterprise;
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
