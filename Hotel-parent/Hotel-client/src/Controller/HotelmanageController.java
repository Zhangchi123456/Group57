package Controller;

import java.util.HashMap;
import java.util.Map;

import vo.HotelVO;
import vo.RoomVO;

public class HotelmanageController {
	private final static Map<String,Object> Hotelmanagemap = new HashMap<>();
	private final static String Hotelkey="hotelvo";
	
	
	public static void setHotelvo(HotelVO hotelvo){
		Hotelmanagemap.put(Hotelkey, hotelvo);
	}
	public static HotelVO getHotelVO(){
		return (HotelVO)Hotelmanagemap.get(Hotelkey);
	}
	
	private final static Map<String,Object> Roommanagemap = new HashMap<>();
	private final static String Roomkey="hotelvo";
	
	
	public static void setRoomvo(RoomVO roomvo){
		Roommanagemap.put(Hotelkey, roomvo);
	}
	public static RoomVO getRoomVO(){
		return (RoomVO)Roommanagemap.get(Roomkey);
	}
	
}
