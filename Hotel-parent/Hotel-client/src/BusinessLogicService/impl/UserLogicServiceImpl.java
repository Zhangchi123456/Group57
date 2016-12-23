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

import BusinessLogicService.Service.HotelInfo;
import BusinessLogicService.Service.LogoutLogicService;
import BusinessLogicService.Service.MemberInfo;
import BusinessLogicService.Service.PromotionInfo;
import BusinessLogicService.Service.UserInfo;
import BusinessLogicService.Service.UserLogicService;
import vo.WebManagerVO;
import vo.HotelPromotionVO;
import vo.HotelStaffVO;
import vo.HotelVO;
import vo.MemberVO;
import vo.RoomVO;
import vo.WebStaffVO;

public class UserLogicServiceImpl implements UserLogicService,UserInfo,LogoutLogicService{
	UserDataService userdata=(UserDataService) RMIHelper.find("UserDataService");
	MemberInfo memberInfo=null;
	HotelInfo hotelInfo=null;
	PromotionInfo promotionInfo=null;
	
	//find if there is a user of 4 exist
	@Override
	public boolean findUserBYName(String name) {
		memberInfo=new MemberLogicServiceImpl();
		
		WebStaffPO po1=null;
		HotelStaffPO po2=null;
		WebManagerPO po3=null;
		MemberPO po4=null;
		try {
			po1=userdata.findByWebStaff(name);
			po2=userdata.findByHotelStaff(name);
			po3=userdata.findByWebManager(name);
			po4=memberInfo.findMemberByName(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po1==null&&po2==null&&po3==null&&po4==null){
			return false;
		}else 
			return true;
	}//end find user by name

	//Web staff operation
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
		return new ArrayList<WebStaffVO>();
	}

	@Override
	public void saveWebStaff(WebStaffVO vo) {
		WebStaffPO po=vo.settopo(vo);
		try {
			userdata.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean addWebStaff(WebStaffVO vo) {
		WebStaffPO po=vo.settopo(vo);
		try {
			return userdata.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	//hotel staff operation
	@Override
	public ArrayList<HotelStaffVO> findHotelStaff() {
		try {
			ArrayList<HotelStaffPO> list=userdata.showAllHotelStaff();
			ArrayList<HotelStaffVO> listvo=new ArrayList<>();
			for(HotelStaffPO po:list){
				if(po!=null){
					HotelStaffVO vo=new HotelStaffVO();
					vo.setbypo(po);
					listvo.add(vo);
				}
			}
			return listvo;
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		return new ArrayList<HotelStaffVO>();
	}//end find hotels

	//add hotel staff 
	@Override
	public void addHotelStaff(HotelStaffVO vo) {
		HotelStaffPO po=new HotelStaffPO();
		po=vo.settopo(vo);
		try {
			userdata.insert(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}//end hotel staff
	//update hotel staff
	@Override
	public void saveHotelStaff(HotelStaffVO vo) {
		HotelStaffPO po=new HotelStaffPO();
		vo.settopo(vo);
		try {
			userdata.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}//end update hotel staff
	//return member vo array list
	@Override
	public ArrayList<MemberVO> findMember() {
		ArrayList<MemberVO> listvo=new ArrayList<>();
		memberInfo=new MemberLogicServiceImpl();
		try {
			listvo=memberInfo.showall();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return listvo;
	}//end show members
	//save member vo
	@Override
	public void saveMember(MemberVO vo){
		memberInfo=new MemberLogicServiceImpl();
		memberInfo.saveMember(vo);
	}//update member info
	
	//hotel operation
	@Override
	public ArrayList<String> showCity() {
		hotelInfo=new HotelStaffLogicServiceImpl();
		return hotelInfo.showCitys();
	}

	@Override
	public ArrayList<String> showCircle(String city) {
		hotelInfo=new HotelStaffLogicServiceImpl();
		return hotelInfo.showCircle(city);
	}

	@Override
	public boolean findHotel(String name) {
		hotelInfo=new HotelStaffLogicServiceImpl();
		return hotelInfo.isHotel(name);
	}//if a hotel is exist by name

	@Override
	public void addHotel(HotelVO vo) {
		hotelInfo=new HotelStaffLogicServiceImpl();
		hotelInfo.addHotel(vo);
	}//end add hotel 

	//add hotel promotion strategy
	@Override
	public void addHotelStrategy(HotelPromotionVO vo) {
		promotionInfo=new PromotionLogicServiceImpl();
		promotionInfo.addHotelPromotion(vo);
	}//end add hotel promotion strategy

	@Override
	public boolean findWebStaffBYName(String name) {
		try{
			WebStaffPO po =  userdata.findByWebStaff(name);
			if(po != null){
				return true;
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public HotelStaffVO findHotelStaffByName(String name) {
		try {
			HotelStaffPO po =  userdata.findByHotelStaff(name);
			HotelStaffVO vo = new HotelStaffVO(name, name, name);
			if(po!=null){
				vo.setbypo(po);
				return vo;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public WebStaffVO findWebStaffByName(String name) {
		 try {
			WebStaffPO po =  userdata.findByWebStaff(name);
			if(po != null){
				WebStaffVO vo=new WebStaffVO();
				vo.setbypo(po);
				return vo;
			}
		}catch (RemoteException e) {
				e.printStackTrace();
		}
		return null;
	}

	@Override
	public WebManagerVO findWebManagerByName(String name) {
		try {
			WebManagerPO po =  userdata.findByWebManager(name);
			if(po != null){
				WebManagerVO vo=new WebManagerVO();
				vo.setbypo(po);
				return vo;
			}
		}catch (RemoteException e) {
				e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isCurrentUser(String name) {
		try {
			return userdata.isCurrentUser(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void addCurrentUser(String name) {
		try {
			userdata.addCurrentUser(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void removeCurrentUser(String name){
		try{
			userdata.removeCurrentUser(name);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
