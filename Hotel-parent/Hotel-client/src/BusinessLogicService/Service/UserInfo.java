package BusinessLogicService.Service;

import vo.*;

public interface UserInfo {
	public WebStaffVO findWebStaffByName(String name);//查找网站营销人员
	public HotelStaffVO findHotelStaffByName(String name);//查找酒店工作人员
	public WebManagerVO findWebManagerByName(String name);// 查找网站管理人员
	public boolean isCurrentUser(String name);//判断是否为当前使用者
	public void addCurrentUser(String name);//添加当前使用者
	

}
