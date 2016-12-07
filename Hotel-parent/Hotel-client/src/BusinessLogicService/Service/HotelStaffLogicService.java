package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.HotelVO;
import vo.RoomVO;

public interface HotelStaffLogicService {

	//显示所有客房
	public ArrayList<RoomVO> roomShowAll(String hotelid, int room_id, String room_type)throws RemoteException;
	
	//房间信息更新
	public boolean changeRoomInfo(String roomid, String type) throws RemoteException;
	
	//酒店基本信息生成
	public boolean formHotelInfo(HotelVO vo)throws RemoteException;
	
	//酒店基本信息更新
	public boolean changeHotelInfo(HotelVO vo)throws RemoteException;
	
	//入住信息更新
	public boolean changeCheckInInfo(int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom)throws RemoteException;
	
	//退房信息更新
	public boolean changeCheckOutInfo(int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom)throws RemoteException;
}
