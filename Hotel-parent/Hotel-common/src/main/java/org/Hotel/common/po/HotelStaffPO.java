package org.Hotel.common.po;

import java.io.Serializable;

public class HotelStaffPO implements Serializable{

	private int id;
	
	private String password;
	private String name;
	private String hotelname;
	
	public HotelStaffPO() {
		super();
	}
	//Jerry
	public HotelStaffPO(String name,String hotelname,String password){
		this.password = password;
		this.name = name;
		this.hotelname = hotelname;
		id = -1;
	}
	public HotelStaffPO(int id, String password) {
		super();
		
		this.id = id;
		this.password = password;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(int id){
		
		this.id = id;
	}
	
	public String getPassword() {
			
		return password;
		
	}

	public void setPassword(String password) {
			
		this.password = password;
		
	}
	

	public void setName(String name) {
			
		this.name = name;
		
	}
	public String getName() {
		
		return name;
		
	}
	public String getHotelName() {
		
		return hotelname;
		
	}
	public void setHotelName(String hotelname) {
			
		this.hotelname =hotelname;
		
	}
}
