package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.CreditRecordVO;
import vo.HotelVO;
import vo.RoomVO;

public interface HotelStaffLogicService {
	
	//根据工作人员显示所在酒店
	public HotelVO findHotel(String name)throws RemoteException;
	
	//显示所有客房
	public ArrayList<RoomVO> roomShowAll(String hotelid)throws RemoteException;
	
	//房间信息更新
	public boolean changeRoomInfo(RoomVO roomvo) throws RemoteException;
	
	//酒店基本信息更新
	public boolean changeHotelInfo(HotelVO vo)throws RemoteException;
	
	//入住信息更新
	public boolean changeCheckInInfo(String hotelname, int roomid, int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String starttime, String leavetime)throws RemoteException;
	
	//退房信息更新
	public boolean changeCheckOutInfo(String hotelname, int roomid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String roomstate, String leavetime)throws RemoteException;
	
	//根据房间号查找房间
	public RoomVO FindRoomByID(String hotelname, int roomid)throws RemoteException;
	
	//根据订单号查找信用记录
	public CreditRecordVO CreditFindByorder(int orderid)throws RemoteException;
}
