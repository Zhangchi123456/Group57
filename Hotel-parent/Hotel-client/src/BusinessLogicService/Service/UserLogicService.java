package BusinessLogicService.Service;

import java.util.ArrayList;

import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.WebStaffPO;

import vo.*;

public interface UserLogicService {
	//web staff info
	public ArrayList<WebStaffVO> findWebStaff();
	public void saveWebStaff(WebStaffVO vo);
	public boolean findWebStaffBYName(String name);
	public boolean addWebStaff(WebStaffVO vo);
	//hotel staff info
	public ArrayList<HotelStaffVO> findHotelStaff();
	public void saveHotelStaff(HotelStaffVO vo);
	public void addHotelStaff(HotelStaffVO vo);
	public HotelStaffVO findHotelStaffByName(String name);
	//member info
	public ArrayList<MemberVO> findMember();
	public void saveMember(MemberVO vo);
	//hotel attributes:city and circle
	public ArrayList<String> showCity();
	public ArrayList<String> showCircle(String city);	
	//hotel info
	public boolean findHotel(String name);
	public void addHotel(HotelVO vo);
	public void addHotelStrategy(HotelPromotionVO vo);
	//whether is a user 
	public boolean findUserBYName(String name); 
	
		

		
	
		
	

}
