package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.HotelPO;

import vo.CreditRecordVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public interface HotelStaffLogicService {
	
	//根据工作人员显示所在酒店
	public HotelVO findHotel(String name)throws RemoteException;
	
	//生成一个新的酒店
	public boolean insert(HotelVO hotelvo)throws RemoteException;
	
	//显示所有客房
	public ArrayList<RoomVO> roomShowAll(String hotelid)throws RemoteException;
	
	//房间信息更新
	public boolean changeRoomInfo(String roomid, String type) throws RemoteException;
	
	//酒店基本信息生成
	public boolean formHotelInfo(HotelVO vo)throws RemoteException;
	
	//酒店基本信息更新
	public boolean changeHotelInfo(HotelVO vo)throws RemoteException;
	
	//入住信息更新
	public boolean changeCheckInInfo(int roomid, int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String starttime, String leavetime)throws RemoteException;
	
	//退房信息更新
	public boolean changeCheckOutInfo(int roomid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String roomstate, String leavetime)throws RemoteException;
	
	//根据房间号查找房间
	public RoomVO FindRoomByID(int roomid)throws RemoteException;
	
	//根据订单号查找信用记录
	public CreditRecordVO CreditFindByorder(int orderid)throws RemoteException;
}
