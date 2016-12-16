package BusinessLogicService.impl;

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
	public boolean hasLogin(String name) {
		
			
		return false;
	}


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

	@Override
	public void addCurrentUser(String name) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean currentUser(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
