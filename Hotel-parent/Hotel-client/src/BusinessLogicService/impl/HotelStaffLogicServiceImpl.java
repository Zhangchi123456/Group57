package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.po.CirclePO;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.RoomPO;

import BusinessLogicService.Service.HotelInfo;
import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.Service.MemberLogicService;
import BusinessLogicService.Service.UserLogicService;
import vo.CircleVO;
import vo.CreditRecordVO;
import vo.HotelStaffVO;
import vo.HotelVO;
import vo.RoomVO;

public class HotelStaffLogicServiceImpl implements HotelStaffLogicService , HotelInfo{

	HotelDataService hds = (HotelDataService) RMIHelper.find("HotelDataService");
	UserLogicService uds = new UserLogicServiceImpl();
	MemberLogicService mds = new MemberLogicServiceImpl();
	
	HotelVO hotelvo = new HotelVO();
	
	
	
	//根据工作人员显示所在酒店
	public HotelVO findHotel(String name) {
		
		HotelStaffVO vo = uds.findHotelStaffByName(name);
		String hotelname = vo.getHotelname();
		HotelPO hotelpo = new HotelPO();
		try {
			hotelpo = hds.Findhotelbyname(hotelname);
			hotelvo.setbuHotelPO(hotelpo);
			return hotelvo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hotelvo;
	
		
	}
	
	//根据酒店名查找酒店
	public HotelVO findbyname(String name) {
		  
		 HotelVO vo=new HotelVO();
		 try {
			vo.setbuHotelPO(hds.Findhotelbyname(name));
			 return vo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
		
		
		 
	 }

	
	//显示所有客房
	public ArrayList<RoomVO> roomShowAll(String hotelid) {

		ArrayList<RoomVO> roomlist = new ArrayList<RoomVO>();
		ArrayList<RoomPO> list = new ArrayList<RoomPO>();
		try {
			list = hds.roomShowAll(hotelid);
			for(int i=0;i<list.size();i++){
				RoomVO roomvo = new RoomVO();
				
				roomvo.setRoomPO(list.get(i));
				roomlist.add(i, roomvo);
				}
				return roomlist;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roomlist;
		
		
	}
	
	//房间信息更新
	public boolean changeRoomInfo(RoomVO roomvo) {
	
		boolean info = false;
		
		try {
			info = hds.insertRoom(roomvo.toRoomPO(roomvo));
			return info;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return info;
	}
	
	
	//酒店基本信息更新
	public boolean changeHotelInfo(HotelVO vo) {
		
		boolean info = false;
		
		try {
			info = hds.update(vo.Tohotelpo(vo));
			return info;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
		
		
	}
	
	//入住信息更新
	public boolean changeCheckInInfo(String hotelname, int roomid, int orderid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String starttime, String leavetime) {
		
		boolean info = false;
		
		int new_singleRoom = hotelvo.getLeftSingleRoom()-singleRoom;
		int new_standardRoom = hotelvo.getLeftStandardRoom()-standardRoom;
		int new_familyRoom = hotelvo.getLeftFamilyRoom()-familyRoom;
		int new_suiteRoom = hotelvo.getLeftSuiteRoom()-suiteRoom;
		
		RoomVO roomvo = new RoomVO();
		roomvo = FindRoomByID(hotelname,roomid);
		
		hotelvo.setLeftSingleRoom(new_singleRoom);
		hotelvo.setLeftStandardRoom(new_standardRoom);
		hotelvo.setLeftFamilyRoom(new_familyRoom);
		hotelvo.setLeftSuiteRoom(new_suiteRoom);		
		roomvo.setStarttime(starttime);
		roomvo.setLeavetime(leavetime);
		roomvo.setOrderid(orderid);
		roomvo.setRoomstate("不可用");
		
		try {
			info = hds.update(hotelvo.Tohotelpo(hotelvo))&&hds.updateRoom(roomvo.toRoomPO(roomvo));
			return info;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
		
		
	}
	
	//退房信息更新
	public boolean changeCheckOutInfo(String hotelname, int roomid, int singleRoom, int standardRoom, int familyRoom, int suiteRoom, String roomstate, String leavetime) {
		
		boolean info = false;
		
		int new_singleRoom = hotelvo.getLeftSingleRoom()+singleRoom;
		int new_standardRoom = hotelvo.getLeftStandardRoom()+standardRoom;
		int new_familyRoom = hotelvo.getLeftFamilyRoom()+familyRoom;
		int new_suiteRoom = hotelvo.getLeftSuiteRoom()+suiteRoom;
		
		RoomVO roomvo = new RoomVO();
		roomvo = FindRoomByID(hotelname,roomid);
		
		hotelvo.setLeftSingleRoom(new_singleRoom);
		hotelvo.setLeftStandardRoom(new_standardRoom);
		hotelvo.setLeftFamilyRoom(new_familyRoom);
		hotelvo.setLeftSuiteRoom(new_suiteRoom);		
		roomvo.setRoomstate(roomstate);
		roomvo.setLeavetime(leavetime);
		
		try {
			info = hds.update(hotelvo.Tohotelpo(hotelvo))&&hds.updateRoom(roomvo.toRoomPO(roomvo));
			return info;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return info;
		
	}
	
	public RoomVO FindRoomByID(String hotelname, int roomid) {
		
		try {
			RoomPO po = new RoomPO();
			RoomVO vo = new RoomVO();
			po = hds.FindroombyID(hotelname, roomid);
			
			vo.setRoomPO(po);
			
			return vo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public CreditRecordVO CreditFindByorder(int orderid) {
		
		CreditRecordVO Vo = new CreditRecordVO();
		Vo = mds.findCreditRecord(orderid);
		
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

	//根据商圈返回酒店
	public ArrayList<HotelVO> findbycircle(String circle){
		 ArrayList<HotelPO> hotellist = new ArrayList<HotelPO>();
		try {
			hotellist = hds.FindhotelByCircle(circle);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ArrayList<HotelVO> list=new ArrayList<HotelVO>();
		 for(int i=0;i<hotellist.size();i++){
			 HotelVO vo = new HotelVO();
					vo.setbuHotelPO(hotellist.get(i));
					list.add(vo);
		 }
		 return list;
	 }

	
}
