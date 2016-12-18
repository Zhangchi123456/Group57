package vo;

import java.io.Serializable;

public class WebManagerVO implements Serializable{

	private int id;
	
	private String password;
	
	private String name;
	
	public WebManagerVO() {
		super();
	}
	//Jerry 
	public WebManagerVO(String name,String password){
		this.name = name;
		this.password = password;
		
	}
	
	public WebManagerVO(int id, String password) {
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
	
}