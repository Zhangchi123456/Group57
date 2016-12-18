package BusinessLogicService.Service;

import vo.*;

public interface UserInfo {
	public WebStaffVO findWebStaffByName(String name);
	public HotelStaffVO findHotelStaffByName(String name);
	public WebManagerVO findWebManagerByName(String name);
	
	public boolean isCurrentUser(String name);
	public void addCurrentUser(String name);
	

}
