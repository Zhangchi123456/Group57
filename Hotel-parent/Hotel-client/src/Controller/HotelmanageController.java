package Controller;

import java.util.HashMap;

import java.util.Map;

import vo.HotelVO;
import vo.RoomVO;

/*酒店工作人员流程控制器，职责是保存需要在整个流程中使用的数据
 * 持有当前酒店，酒店当前房间
 * @author 周霁初
 * @version 1.1
 * 
 */
public class HotelmanageController {
	private final static Map<String,Object> Hotelmanagemap = new HashMap<>();//持有map来保存数据
	private final static String Hotelkey="hotelvo";//通过hotelkey来得到hotel 数据
	
	
	public static void setHotelvo(HotelVO hotelvo){
		Hotelmanagemap.put(Hotelkey, hotelvo);
	}
	public static HotelVO getHotelVO(){
		return (HotelVO)Hotelmanagemap.get(Hotelkey);
	}
	
	private final static Map<String,Object> Roommanagemap = new HashMap<>();
	private final static String Roomkey="hotelvo";//持有roomkey来得到房间信息
	
	
	public static void setRoomvo(RoomVO roomvo){
		Roommanagemap.put(Hotelkey, roomvo);
	}
	public static RoomVO getRoomVO(){
		return (RoomVO)Roommanagemap.get(Roomkey);
	}
	
}
