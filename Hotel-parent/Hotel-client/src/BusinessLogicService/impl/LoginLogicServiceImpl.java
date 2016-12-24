package BusinessLogicService.impl;

import java.rmi.RemoteException;

import org.Hotel.common.po.MemberPO;

import BusinessLogicService.Service.LoginLogicService;
import BusinessLogicService.Service.MemberInfo;
import BusinessLogicService.Service.UserInfo;
import util.UserType;
import vo.HotelStaffVO;
import vo.MemberVO;
import vo.WebManagerVO;
import vo.WebStaffVO;

public class LoginLogicServiceImpl implements LoginLogicService {

	UserInfo userservice=new UserLogicServiceImpl();
	MemberInfo memberservice=new MemberLogicServiceImpl();
	
	@Override
	public UserType findUser(String name, String password) {
		try{
			HotelStaffVO hotelstaffvo=userservice.findHotelStaffByName(name);
			WebStaffVO webstaffvo=userservice.findWebStaffByName(name);
			WebManagerVO webmanagervo=userservice.findWebManagerByName(name);
			MemberVO membervo=memberservice.findMemberByName(name);				
			
			if(hotelstaffvo!=null){
				if(hotelstaffvo.getPassword().equals(password))
					
					return UserType.hotelStaff;
			}
			if(webstaffvo!=null){
				if(webstaffvo.getPassword().equals(password))
				return UserType.webStaff;
			}
			if(webmanagervo!=null){
				if(webmanagervo.getPassword().equals(password))
				return UserType.webManager;
			}
			if(membervo!=null){
				if(membervo.getPassword().equals(password))
				return UserType.Member;
			}
			
			
			hotelstaffvo=null;
			webstaffvo =null;
			webmanagervo=null;
			membervo=null;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * current user operation
	 */
	@Override
	public void addCurrentUser(String name) {
		userservice.addCurrentUser(name);
		}
	@Override
	public boolean isCurrentUser(String name) {
		return userservice.isCurrentUser(name);		
	}
	
	public void removeCurrentUser(String name) {
		
	}
	
}
