 package org.Hotel.common.po;
 
 public class WebManagerPO {
 
 	private int id;
 	
 	private String password;
 	
 	private String name;
 	
 	public WebManagerPO() {
  		super();
  	}
  	//Jerry 
 	public WebManagerPO(String name, String password){
 		this.password = password;
		this.name = name;
 		id=-1;
 	}
 	public WebManagerPO(int id ,String name,String password){
 		
  	}
  	

 	public WebManagerPO(int id, String password) {
  		super();
  		
  		this.id = id;
  		this.password = password;
 		this.name = name;
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
