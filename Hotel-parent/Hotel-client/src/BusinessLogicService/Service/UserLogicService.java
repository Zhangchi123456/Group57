package BusinessLogicService.Service;

import java.util.ArrayList;

import org.Hotel.common.po.HotelStaffPO;
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
	//member
	public ArrayList<MemberVO> findMember();
	public void saveMember(MemberVO vo);
	//hotel related
	public ArrayList<String> showCity();
	public ArrayList<String> showCircle(String city);			
	public HotelStaffVO findByHotelStaff(String name);
	void addHotelStaff(HotelStaffVO vo); 
	
		

		
	
		
	

}
