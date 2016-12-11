package BusinessLogicService.impl.userbl;

import org.Hotel.common.dataService.HotelDataService;

import BusinessLogicService.Service.user.UserLogicService;
import BusinessLogicService.impl.RMIHelper;
import main.java.org.Hotel.client.util.UserType;

import java.rmi.RemoteException;

import org.Hotel.common.dataService.*;
import org.Hotel.common.po.*;

public class UserLogicServiceImp implements UserLogicService{
	UserDataService userservice=(UserDataService) RMIHelper.find("UserDataService");
	MemberDataService memberservice=(MemberDataService) RMIHelper.find("MemberDataService");
	
	@Override
	public boolean hasLogin(String name) {
		
		
		return false;
	}

	@Override
	public boolean isFound(String name, String password) {
		return true;
//		try{
//			HotelStaffPO hotelstaffpo=userservice.findByHotelStaff(name);
//			WebStaffPO webstaffpo=userservice.findByWebStaff(name);
//			WebManagerPO webmanagerpo=userservice.findByWebManager(name);
//			MemberPO memberpo=memberservice.find(name);
//			
//			if(hotelstaffpo!=null){
//				if(hotelstaffpo.getPassword().equals(password))
//					return true;
//			}
//			if(webstaffpo!=null){
//				if(webstaffpo.getPassword().equals(password))
//				return true;
//			}
//			if(webmanagerpo!=null){
//				if(webmanagerpo.getPassword().equals(password))
//				return true;
//			}
//			if(memberpo!=null){
//				if(memberpo.getPassword().equals(password))
//				return true;
//			}
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		return false;
	}

	@Override
	public UserType findUser(String name, String password) {
		try{
			HotelStaffPO hotelstaffpo=userservice.findByHotelStaff(name);
			WebStaffPO webstaffpo=userservice.findByWebStaff(name);
			WebManagerPO webmanagerpo=userservice.findByWebManager(name);
			MemberPO memberpo=memberservice.find(name);
			System.out.println(hotelstaffpo.getName()+1);
			System.out.println(memberpo.getName()+2);
			if(hotelstaffpo!=null){
				if(hotelstaffpo.getPassword().equals(password))
					
					return UserType.hotelStaff;
			}
			if(webstaffpo!=null){
				if(webstaffpo.getPassword().equals(password))
				return UserType.webStaff;
			}
			if(webmanagerpo!=null){
				if(webmanagerpo.getPassword().equals(password))
				return UserType.webManager;
			}
			if(memberpo!=null){
				if(memberpo.getPassword().equals(password))
				return UserType.Member;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addCurrentUser(String name) {
		// TODO Auto-generated method stub
		
	}
	
}
