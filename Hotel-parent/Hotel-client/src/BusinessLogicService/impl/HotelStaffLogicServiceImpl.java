package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.dataService.OrderDataService;
import org.Hotel.common.dataService.PromotionDataService;
import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.CirclePO;
import org.Hotel.common.po.CreditPO;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.RoomPO;

import BusinessLogicService.Service.HotelInfo;
import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.Service.MemberLogicService;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.Service.ReservationLogicService;
import BusinessLogicService.Service.UserLogicService;
import Controller.HotelmanageController;
import Controller.MemberActController;
import vo.CircleVO;
import vo.CreditRecordVO;
import vo.HotelPromotionVO;
import vo.HotelStaffVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class HotelStaffLogicServiceImpl implements HotelStaffLogicService , HotelInfo{

	HotelDataService hds = (HotelDataService) RMIHelper.find("HotelDataService");
	UserLogicService uds = new UserLogicServiceImpl();
	MemberLogicService mds = new MemberLogicServiceImpl();
	
	HotelVO hotelvo = new HotelVO();
	
	
	
	//根据工作人员显示所在酒店
	public HotelVO findHotel(String name)throws RemoteException {
		
		HotelStaffVO vo = uds.findByHotelStaff(name);
		String hotelname = vo.getHotelname();
		HotelPO hotelpo = new HotelPO();
		hotelpo = hds.Findhotelbyname(hotelname);
		hotelvo.setbuHotelPO(hotelpo);
		return hotelvo;
		
	}
	
	//根据酒店名查找酒店
	public HotelVO findbyname(String name) throws RemoteException {
		  
		 HotelVO vo=new HotelVO();
		 vo.setbuHotelPO(hds.Findhotelbyname(name));
		
		 return vo;
		 
	 }

	
	//显示所有客房
	public ArrayList<RoomVO> roomShowAll(String hotelid)throws RemoteException {

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
	
		boolean info = false;
		
		RoomVO roomvo = new RoomVO();
		RoomPO roompo = hds.FindroombyID(Integer.parseInt(roomid));
		
		roomvo.setRoomPO(roompo);
		roomvo.setRoomtype(type);
		
		info = hds.updateRoom(roomvo.toRoomPO(roomvo));
		
		return info;
	}
	
	
	//酒店基本信息更新
	public boolean changeHotelInfo(int star, String introduction, String address)throws RemoteException {
		
		boolean info = false;
		
		hotelvo.setStar(star);
		hotelvo.setIntroduction(introduction);
		hotelvo.setAdsress(address);
		
		info = hds.update(hotelvo.Tohotelpo(hotelvo));
		
		return info;
	}
	
	//入住信息更新
	public boolean changeCheckInInfo(int roomid, int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String starttime, String leavetime)throws RemoteException {
		
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
		
		RoomPO po = hds.FindroombyID(roomid);
		
		RoomVO vo = new RoomVO();
		
		vo.setRoomPO(po);
		
		return vo;
	}
	
	public CreditRecordVO CreditFindByorder(int orderid)throws RemoteException {
		
		CreditRecordVO Vo = mds.findCreditRecord(orderid);
		
		return Vo;
	}

	//hotel info method
	@Override
	public ArrayList<String> showCitys() {
		try {
			return hds.cityShowAll();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}

	@Override
	public ArrayList<String> showCircle(String city) {
		ArrayList<CirclePO> list;
		ArrayList<String> circleList=new ArrayList<>();
		try{
			list = hds.circleShowAll(city);
			for(CirclePO po:list){
				circleList.add(po.getName());
			}
			return circleList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}

	@Override
	public void addHotel(HotelVO vo) {
		HotelPO po=vo.Tohotelpo(vo);
		try {
			hds.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean isHotel(String name) {
		HotelPO po=null;
		try {
			po=hds.Findhotelbyname(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po==null){
			return false;
		}
		return true;
	}//if a hotel is exist by name


	@Override
	public void addRoom(RoomVO vo) {
		RoomPO po=vo.toRoomPO(vo);
		try {
			hds.insertRoom(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<CircleVO> getCircle(String city_name) {
	//根据城市名获取商圈列表	
		ArrayList<CircleVO> voList = new ArrayList<CircleVO>();
		
		try{
			ArrayList<CirclePO> poList = hds.circleShowAll(city_name);
			for(int i=0;i<poList.size();i++){
				CircleVO vo = new CircleVO();
				vo.setByPO(poList.get(i));
				voList.add(vo);
			}
			return voList;
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CircleVO getCircle(String city_name, String circle) {
	//获取商圈的折扣信息
		CircleVO vo = new CircleVO();
		try {
			vo.setByPO(hds.circleFind(city_name, circle));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void updateCircle(CircleVO vo) {
	//更新商圈折扣信息
		try{
			hds.update(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}

	public ArrayList<HotelVO> findbycircle(String circle) throws RemoteException{
		 ArrayList<HotelPO> hotellist = hds.FindhotelByCircle(circle);
		 ArrayList<HotelVO> list=new ArrayList<HotelVO>();
		 for(int i=0;i<hotellist.size();i++){
			 HotelVO vo = new HotelVO();
					vo.setbuHotelPO(hotellist.get(i));
					list.add(vo);
		 }
		 return list;
	 }

	
}
