package BusinessLogicService.Service;

import java.util.ArrayList;

import org.Hotel.common.po.WebStaffPO;

import vo.*;

public interface UserLogicService {
	//web staff
	public ArrayList<WebStaffVO> findWebStaff();
	public void saveWebStaff(WebStaffVO vo);
	public boolean findWebStaffBYName(String name);
	public boolean addWebStaff(WebStaffVO vo);
	//hotel staff
	public ArrayList<HotelStaffVO> findHotelStaff();
	public void saveHotelStaff(HotelStaffVO vo);
	
		

		
	
		
	

}
