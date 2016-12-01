package org.Hotel.server.datahelp;

import java.util.Map;

import org.Hotel.common.po.*;

public interface UserDataHelper {

	public Map<Integer,WebStaffPO> getWebStaffData();
	
	public void updateWebStaffData(Map<Integer,WebStaffPO> map);
	
    
	public Map<Integer,WebManagerPO> getWebManagerData();
	
	public void updateWebManagerData(Map<Integer,WebManagerPO> map);
	
    
	public Map<Integer,HotelStaffPO> getHotelStaffData();
	
	public void updateHotelStaffData(Map<Integer,HotelStaffPO> map);
}
