package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.dataService.OrderDataService;
import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.RoomPO;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.Service.ReservationLogicService;
import Controller.HotelmanageController;
import Controller.MemberActController;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class HotelStaffLogicServiceImpl implements HotelStaffLogicService {

	HotelDataService hds;
	OrderDataService ods;
	UserDataService uds;
	
	//根据工作人员显示所在酒店
	public HotelVO findHotel(String name)throws RemoteException {
		
		uds = (UserDataService) RMIHelper.find("UserDataService");
		HotelVO hotelvo = new HotelVO();
		
		HotelStaffPO po = uds.findByHotelStaff(name);
		String hotelname = po.getHotelName();
		
		hotelvo.setName(hotelname);
		
		return hotelvo;
	}
	
	//显示所有客房
	public ArrayList<RoomVO> roomShowAll(String hotelid, int room_id, String room_type)throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		ArrayList<RoomVO> roomlist = new ArrayList<RoomVO>();
		ArrayList<RoomPO> list = hds.roomShowAll(hotelid, room_id, room_type);
		for(int i=0;i<list.size();i++){
		RoomVO roomvo = new RoomVO();
		
		roomvo.setRoomPO(list.get(i));
		roomlist.add(i, roomvo);
		}
		return roomlist;
		
	}
	
	//房间信息更新
	public boolean changeRoomInfo(String hotelid, String roomid, String type) throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		boolean info = false;
		
		HotelmanageController.getRoomVO().setRoomtype(type);
		
		info = hds.updateRoom(HotelmanageController.getRoomVO().toRoomPO( HotelmanageController.getRoomVO()));
		
		return info;
	}
	
	//酒店基本信息生成
	public boolean formHotelInfo(HotelVO vo)throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		boolean info = false;
		
		info = hds.insert(HotelmanageController.getHotelVO().Tohotelpo( HotelmanageController.getHotelVO()));
		
		return info;
	}
	
	
	//酒店基本信息更新
	public boolean changeHotelInfo(HotelVO vo)throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		boolean info = false;
		
		info = hds.update(HotelmanageController.getHotelVO().Tohotelpo( HotelmanageController.getHotelVO()));
		
		return info;
	}
	
	//入住信息更新
	public boolean changeCheckInInfo(int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom)throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		boolean info = false;
		
		int new_singleRoom = HotelmanageController.getHotelVO().getLeftSingleRoom()-singleRoom;
		int new_standardRoom = HotelmanageController.getHotelVO().getLeftStandardRoom()-standardRoom;
		int new_familyRoom = HotelmanageController.getHotelVO().getLeftFamilyRoom()-familyRoom;
		int new_suiteRoom = HotelmanageController.getHotelVO().getLeftSuiteRoom()-suiteRoom;
		
		HotelmanageController.getHotelVO().setLeftSingleRoom(new_singleRoom);
		HotelmanageController.getHotelVO().setLeftStandardRoom(new_standardRoom);
		HotelmanageController.getHotelVO().setLeftFamilyRoom(new_familyRoom);
		HotelmanageController.getHotelVO().setLeftSuiteRoom(new_suiteRoom);		
		
		info = hds.update(HotelmanageController.getHotelVO().Tohotelpo( HotelmanageController.getHotelVO()));
		
		return info;
	}
	
	//退房信息更新
	public boolean changeCheckOutInfo(int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom)throws RemoteException {
		
		hds=(HotelDataService) RMIHelper.find("HotelDataService");
		
		boolean info = false;
		
		int new_singleRoom = HotelmanageController.getHotelVO().getLeftSingleRoom()+singleRoom;
		int new_standardRoom = HotelmanageController.getHotelVO().getLeftStandardRoom()+standardRoom;
		int new_familyRoom = HotelmanageController.getHotelVO().getLeftFamilyRoom()+familyRoom;
		int new_suiteRoom = HotelmanageController.getHotelVO().getLeftSuiteRoom()+suiteRoom;
		
		HotelmanageController.getHotelVO().setLeftSingleRoom(new_singleRoom);
		HotelmanageController.getHotelVO().setLeftStandardRoom(new_standardRoom);
		HotelmanageController.getHotelVO().setLeftFamilyRoom(new_familyRoom);
		HotelmanageController.getHotelVO().setLeftSuiteRoom(new_suiteRoom);		
		
		info = hds.update(HotelmanageController.getHotelVO().Tohotelpo( HotelmanageController.getHotelVO()));
		
		return info;
		
	}
	
}
