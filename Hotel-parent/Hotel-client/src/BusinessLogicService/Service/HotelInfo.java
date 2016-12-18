package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.CircleVO;
import vo.HotelVO;
import vo.RoomVO;

public interface HotelInfo {
	public ArrayList<String> showCitys();
	
	public ArrayList<String> showCircle(String city);
	
	public void addHotel(HotelVO vo);
	
	public boolean isHotel(String name);
	
	public void addRoom(RoomVO vo);

	ArrayList<CircleVO> getCircle(String city_name);

	CircleVO getCircle(String city_name, String circle);

	void updateCircle(CircleVO vo);
	
	public HotelVO findbyname(String name) throws RemoteException;
}
