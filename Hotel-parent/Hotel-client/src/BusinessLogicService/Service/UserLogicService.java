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
	//member
	public ArrayList<MemberVO> findMember();
	public void saveMember(MemberVO vo);
	//hotel related
	public ArrayList<String> showCity();
	public ArrayList<String> showCircle(String city);
	public boolean findHotel(String name);
	public void addHotel(HotelVO vo);
	//hotel add new hotel room
	public void addRoom(RoomVO vo);
	//add hotel staff
	public void addHotelStaff(HotelStaffVO vo);
	//add hotel strategy
	public void addHotelStrategy(HotelPromotionVO vo);
	
	
		

		
	
		
	

}
