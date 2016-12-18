package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.HotelVO;
import vo.RoomVO;

public interface HotelInfo {
	public ArrayList<String> showCitys();
	
	public ArrayList<String> showCircle(String city);
	
	public void addHotel(HotelVO vo);
	
	public boolean isHotel(String name);
	
	public void addRoom(RoomVO vo);
}
