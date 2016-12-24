package Controller;

import java.util.HashMap;

import java.util.Map;

import vo.HotelVO;
import vo.RoomVO;

/*酒店工作人员流程控制器
 * 持有当前酒店，酒店当前房间
 * 
 */
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
