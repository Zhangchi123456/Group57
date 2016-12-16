package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.dataService.OrderDataService;
import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.CreditPO;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.RoomPO;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.Service.ReservationLogicService;
import Controller.HotelmanageController;
import Controller.MemberActController;
import vo.CreditRecordVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class HotelStaffLogicServiceImpl implements HotelStaffLogicService {

	HotelDataService hds;
	OrderDataService ods;
	UserDataService uds;
	MemberDataService mds;
	
	HotelVO hotelvo = new HotelVO();
	
	//根据工作人员显示所在酒店
	public HotelVO findHotel(String name)throws RemoteException {
		
		uds = (UserDataService) RMIHelper.find("UserDataService");
		hds = (HotelDataService) RMIHelper.find("HotelDataService");
		
		HotelStaffPO po = uds.findByHotelStaff(name);
		String hotelname = po.getHotelName();
		HotelPO hotelpo = new HotelPO();
		hotelpo = hds.Findhotelbyname(hotelname);
		hotelvo.setbuHotelPO(hotelpo);
		return hotelvo;
		
	}
	
	//显示所有客房
	public ArrayList<RoomVO> roomShowAll(String hotelid)throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		ArrayList<RoomVO> roomlist = new ArrayList<RoomVO>();
		ArrayList<RoomPO> list = hds.roomShowAll(hotelid);
		for(int i=0;i<list.size();i++){
		RoomVO roomvo = new RoomVO();
		
		roomvo.setRoomPO(list.get(i));
		roomlist.add(i, roomvo);
		}
		return roomlist;
		
	}
	
	//房间信息更新
	public boolean changeRoomInfo(String roomid, String type) throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		boolean info = false;
		
		RoomVO roomvo = new RoomVO();
		RoomPO roompo = hds.FindroombyID(Integer.parseInt(roomid));
		
		roomvo.setRoomPO(roompo);
		roomvo.setRoomtype(type);
		
		info = hds.updateRoom(roomvo.toRoomPO(roomvo));
		
		return info;
	}
	
	//酒店基本信息生成
	public boolean formHotelInfo(HotelVO vo)throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		boolean info = false;
		
		info = hds.insert(vo.Tohotelpo(vo));
		
		return info;
	}
	
	
	//酒店基本信息更新
	public boolean changeHotelInfo(HotelVO vo)throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		boolean info = false;
		
		info = hds.update(vo.Tohotelpo(vo));
		
		return info;
	}
	
	//入住信息更新
	public boolean changeCheckInInfo(int roomid, int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String starttime, String leavetime)throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		boolean info = false;
		
		int new_singleRoom = hotelvo.getLeftSingleRoom()-singleRoom;
		int new_standardRoom = hotelvo.getLeftStandardRoom()-standardRoom;
		int new_familyRoom = hotelvo.getLeftFamilyRoom()-familyRoom;
		int new_suiteRoom = hotelvo.getLeftSuiteRoom()-suiteRoom;
		
		RoomVO roomvo = FindRoomByID(roomid);
		
		hotelvo.setLeftSingleRoom(new_singleRoom);
		hotelvo.setLeftStandardRoom(new_standardRoom);
		hotelvo.setLeftFamilyRoom(new_familyRoom);
		hotelvo.setLeftSuiteRoom(new_suiteRoom);		
		roomvo.setStarttime(starttime);
		roomvo.setLeavetime(leavetime);
		roomvo.setOrderid(orderid);
		roomvo.setRoomstate("不可用");
		
		info = hds.update(hotelvo.Tohotelpo(hotelvo))&&hds.updateRoom(roomvo.toRoomPO(roomvo));
		
		return info;
	}
	
	//退房信息更新
	public boolean changeCheckOutInfo(int roomid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String roomstate, String leavetime)throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		boolean info = false;
		
		int new_singleRoom = hotelvo.getLeftSingleRoom()+singleRoom;
		int new_standardRoom = hotelvo.getLeftStandardRoom()+standardRoom;
		int new_familyRoom = hotelvo.getLeftFamilyRoom()+familyRoom;
		int new_suiteRoom = hotelvo.getLeftSuiteRoom()+suiteRoom;
		
		RoomVO roomvo = FindRoomByID(roomid);
		
		hotelvo.setLeftSingleRoom(new_singleRoom);
		hotelvo.setLeftStandardRoom(new_standardRoom);
		hotelvo.setLeftFamilyRoom(new_familyRoom);
		hotelvo.setLeftSuiteRoom(new_suiteRoom);		
		roomvo.setRoomstate(roomstate);
		roomvo.setLeavetime(leavetime);
		roomvo.setRoomstate("可用");
		
		info = hds.update(hotelvo.Tohotelpo(hotelvo))&&hds.updateRoom(roomvo.toRoomPO(roomvo));
		
		return info;
		
	}
	
	public RoomVO FindRoomByID(int roomid)throws RemoteException {
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		RoomPO po = hds.FindroombyID(roomid);
		
		RoomVO vo = new RoomVO();
		
		vo.setRoomPO(po);
		
		return vo;
	}
	
	public CreditRecordVO CreditFindByorder(int orderid)throws RemoteException {
		
		mds = (MemberDataService) RMIHelper.find("MemberDataService");
		
		CreditPO po = mds.findCreditRecord(orderid);
		
		CreditRecordVO vo = new CreditRecordVO();
		
		vo.setbyCreditPO(po);
		
		return vo;
	}

	
}
