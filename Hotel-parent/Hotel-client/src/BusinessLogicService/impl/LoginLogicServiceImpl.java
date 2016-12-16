package BusinessLogicService.impl;

import java.rmi.RemoteException;

import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.MemberPO;
import org.Hotel.common.po.WebManagerPO;
import org.Hotel.common.po.WebStaffPO;

import BusinessLogicService.Service.LoginLogicService;
import util.UserType;

public class LoginLogicServiceImpl implements LoginLogicService {

	UserDataService userservice=(UserDataService) RMIHelper.find("UserDataService");
	MemberDataService memberservice=(MemberDataService) RMIHelper.find("MemberDataService");
	
	@Override
	public UserType findUser(String name, String password) {
		try{
			HotelStaffPO hotelstaffpo=userservice.findByHotelStaff(name);
			WebStaffPO webstaffpo=userservice.findByWebStaff(name);
			WebManagerPO webmanagerpo=userservice.findByWebManager(name);
			MemberPO memberpo=memberservice.find(name);
			
			if(hotelstaffpo!=null){
				if(hotelstaffpo.getPassword().equals(password))
					
					return UserType.hotelStaff;
			}
			if(webstaffpo!=null){
				if(webstaffpo.getPassword().equals(password))
				return UserType.webStaff;
			}
			if(memberpo!=null){
				if(memberpo.getPassword().equals(password))
				return UserType.Member;
			}
			if(webmanagerpo!=null){
				if(webmanagerpo.getPassword().equals(password))
				return UserType.webManager;
			}
			
			hotelstaffpo=null;
			webstaffpo =null;
			webmanagerpo=null;
			memberpo=null;
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
		try {
			userservice.addCurrentUser(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean isCurrentUser(String name) {
		try {
			return userservice.isCurrentUser(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void removeCurrentUser(String name) {
		try {
			userservice.removeCurrentUser(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
