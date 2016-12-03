package Controller;

import java.util.HashMap;
import java.util.Map;

import vo.HotelVO;

public class HotelmanageController {
	private final static Map<String,Object> Hotelmanagemap = new HashMap<>();
	private final static String Hotelkey="hotelvo";
	
	
	public static void setHotelvo(HotelVO hotelvo){
		Hotelmanagemap.put(Hotelkey, hotelvo);
	}
	public static HotelVO getHotelVO(){
		return (HotelVO)Hotelmanagemap.get(Hotelkey);
	}
	
	
}
