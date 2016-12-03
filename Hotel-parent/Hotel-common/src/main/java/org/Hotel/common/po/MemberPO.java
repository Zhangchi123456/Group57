package org.Hotel.common.po;

public class MemberPO {

	private int id;
	
	private String password;
	
	public MemberPO() {
		super();
	}
	
	public  MemberPO(int id, String password) {
		
		super();
		
		this.id = id;
		this.password = password;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(int id) {

		this.id = id;
	}
	
	public String getPassword() {
			
		return password;
		
	}

	public void setPassword(String password) {
			
		this.password = password;
		
	}
}
