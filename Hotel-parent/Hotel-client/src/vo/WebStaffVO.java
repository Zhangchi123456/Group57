package vo;


import org.Hotel.common.po.WebStaffPO;

import security.DES;

public class WebStaffVO {
	private String name;
	private String password;
	
	public WebStaffVO(){
		this(null,null);
	}
	
	public WebStaffVO(String name,String password){
		this.name=name;
		this.password=password;
	}
	
	  public void setbypo(WebStaffPO po){
	    	 this.name = po.getName();
	    	 try {
				this.password=DES.decrypt(po.getPassword());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	     }
	  
	  
	 public WebStaffPO  settopo(WebStaffVO vo){
	    	WebStaffPO po = new WebStaffPO();
	    	po.setName(vo.getName());
	    	try {
				po.setPassword(DES.encrypt(vo.getPassword()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return po;
	    }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
