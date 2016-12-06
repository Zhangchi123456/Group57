package org.Hotel.common.po;

/**
 * @author Jerry
 *
 */
public class WebManagerPO {
	private String name;
	private String password;
	
	public WebManagerPO(String theName,String thePassword){
		name=theName;
		password=thePassword;
	}
	
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	public String Password(){
		return password;
	}
	
	public void setName(String name){
		
		this.name = name;
	}
	
	public String getName() {
			
		return name;
		
	}
	
}
