package BusinessLogicService.Service;

import org.Hotel.common.po.WebManagerPO;

public class WebManagerVO {
	public String name;
	
	public String password;

	public String getName() {
		return name;
	}
	
	public WebManagerVO(String name,String password){
		this.name=name;
		this.password=password;
	}
	
	public WebManagerVO(WebManagerPO po){
		this(po.getName(), po.getPassword());
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
