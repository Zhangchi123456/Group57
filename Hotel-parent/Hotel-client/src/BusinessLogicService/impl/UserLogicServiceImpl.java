package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.dataService.PromotionDataService;
import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.CirclePO;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.MemberPO;
import org.Hotel.common.po.RoomPO;
import org.Hotel.common.po.WebManagerPO;
import org.Hotel.common.po.WebStaffPO;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.Service.MemberLogicService;
import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.Service.UserLogicService;
import vo.HotelPromotionVO;
import vo.HotelStaffVO;
import vo.HotelVO;
import vo.MemberVO;
import vo.RoomVO;
import vo.WebStaffVO;

public class UserLogicServiceImpl implements UserLogicService{
	UserDataService userdata=(UserDataService) RMIHelper.find("UserDataService");
	HotelStaffLogicService hoteldata=new HotelStaffLogicServiceImpl();
	MemberLogicService memberdata=new MemberLogicServiceImpl();
	PromotionLogicService promotiondata=new PromotionLogicServiceImpl();
	
	
	@Override
	public ArrayList<WebStaffVO> findWebStaff() {
		try {
			ArrayList<WebStaffPO> list=userdata.showAllWebStaff();
			ArrayList<WebStaffVO> listvo=new ArrayList<>();
			for(WebStaffPO po:list){
				if(po!=null){
					WebStaffVO vo=new WebStaffVO(po.getName(),po.getPassword());
					listvo.add(vo);
				}
			}
			return listvo;
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void saveWebStaff(WebStaffVO vo) {
		WebStaffPO po=new WebStaffPO(vo.getName(),vo.getPassword());
		try {
			userdata.update(po);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public boolean findWebStaffBYName(String name) {
		WebStaffPO po1=null;
		HotelStaffPO po2=null;
		WebManagerPO po3=null;
		MemberVO vo4=null;
		try {
			po1=userdata.findByWebStaff(name);
			po2=userdata.findByHotelStaff(name);
			po3=userdata.findByWebManager(name);
			vo4=memberdata.Findmemberbyname(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po1==null&&po2==null&&po3==null&&vo4==null){
			return false;
		}else 
			return true;
		
	}


	@Override
	public boolean addWebStaff(WebStaffVO vo) {
		WebStaffPO po=new WebStaffPO(vo.getName(),vo.getPassword());
		try {
			return userdata.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}


	@Override
	public ArrayList<HotelStaffVO> findHotelStaff() {
		try {
			ArrayList<HotelStaffPO> list=userdata.showAllHotelStaff();
			ArrayList<HotelStaffVO> listvo=new ArrayList<>();
			for(HotelStaffPO po:list){
				if(po!=null){
					HotelStaffVO vo=new HotelStaffVO(po.getName(),po.getPassword(),po.getHotelName());
					listvo.add(vo);
				}
			}
			return listvo;
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void saveHotelStaff(HotelStaffVO vo) {
		HotelStaffPO po=new HotelStaffPO(vo.getName(),vo.getPassword(),vo.getHotelname());
		try {
			userdata.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public ArrayList<MemberVO> findMember() {
		try {
			ArrayList<MemberVO> list=memberdata.showall();
			
			return list;
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public void saveMember(MemberVO vo){
//		MemberPO po;
//		try {
//			po = vo.topo();
//			memberdata.u
//			
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//	}

	
	@Override
//	public ArrayList<String> showCity() {
//		try {
//			return hoteldata.
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}


//	@Override
//	public ArrayList<String> showCircle(String city) {
//		ArrayList<CirclePO> list;
//		ArrayList<String> circleList=new ArrayList<>();
//		try{
//			list = hoteldata.circleShowAll(city);
//			for(CirclePO po:list){
//				circleList.add(po.getName());
//			}
//			return circleList;
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return null;
//	}


//	@Override
//	public boolean findHotel(String name) {
//		HotelPO po=null;
//		try {
//			po=hoteldata.Findhotelbyname(name);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(po==null){
//			return false;
//		}
//		return true;
//	}//if a hotel is exist by name


//	@Override
//	public void addHotel(HotelVO vo) {
//		HotelPO po=vo.Tohotelpo(vo);
//		try {
//			hoteldata.insert(po);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//	}//end add hotel 


//	@Override
//	public void addRoom(RoomVO vo) {
//		RoomPO po=vo.toRoomPO(vo);
//		try {
//			hoteldata.insertRoom(po);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		
//	}//end add room

	//add hotel staff 
//	@Override
	public void addHotelStaff(HotelStaffVO vo) {
		HotelStaffPO po=new HotelStaffPO(vo.getName(),vo.getHotelname(),vo.getPassword());
		try {
			userdata.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}//end hotel staff

	//add hotel promotion strategy
//	@Override
//	public void addHotelStrategy(HotelPromotionVO vo) {
//		HotelPromotionPO po=vo.toPO();
//		try{
//			promotiondata.insert(po);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}//end add hotel promotion strategy


	@Override
	public HotelStaffVO findByHotelStaff(String name) {
		// TODO Auto-generated method stub
		HotelStaffPO po;
		try {
			po = userdata.findByHotelStaff(name);
			HotelStaffVO vo =new HotelStaffVO(name, name, name);
			vo.setbypo(po);
			return vo;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	

}
