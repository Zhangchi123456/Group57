package org.Hotel.common.po;

import java.io.Serializable;

public class WebStaffPO implements Serializable{

	private int id;
	
	private String name;
	
	private String password;
	
	public WebStaffPO() {
		super();
	}
	
	public WebStaffPO(int id, String password) {
		super();
		
		this.id = id;
		this.password = password;
	}
	public WebStaffPO(String name,String password){
		this.password = password;
		this.name = name;
		id = -1;
	}
	
	public WebStaffPO(int id,String name,String password){
		this.id=id;
		this.name=name;
		this.password=password;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	private void setId(int id){
		
		this.id = id;
	}
	
	public String getPassword() {
			
		return password;
		
	}

	public void setPassword(String password) {
			
		this.password = password;
		
	}
	
	public void setName(String name){
		
		this.name = name;
	}
	
	public String getName() {
			
		return name;
		
	}

}
