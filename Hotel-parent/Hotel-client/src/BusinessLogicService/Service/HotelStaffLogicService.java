package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public interface HotelStaffLogicService {
	
	//根据工作人员显示所在酒店
	public HotelVO findHotel(String name)throws RemoteException;
	
	//显示所有客房
	public ArrayList<RoomVO> roomShowAll(String hotelid)throws RemoteException;
	
	//房间信息更新
	public boolean changeRoomInfo(String hotelid, String roomid, String type) throws RemoteException;
	
	//酒店基本信息生成
	public boolean formHotelInfo(HotelVO vo)throws RemoteException;
	
	//酒店基本信息更新
	public boolean changeHotelInfo(HotelVO vo)throws RemoteException;
	
	//入住信息更新
	public boolean changeCheckInInfo(int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom)throws RemoteException;
	
	//退房信息更新
	public boolean changeCheckOutInfo(int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom)throws RemoteException;
	
	//根据房间号查找订单
	public OrderVO findOrderByRoom(int roomid)throws RemoteException;
}
