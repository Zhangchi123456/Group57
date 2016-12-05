package org.Hotel.server.datahelp;

import java.util.Map;
import org.Hotel.common.po.*;

public interface UserDataHelper {
	/**
	 * @return	从数据文件读入网站营销人员
	 */
	public Map<String, WebStaffPO> getWebStaffData();
	/**
	 * 从数据文件中写入网站营销人员
	 * @param map	
	 */
	public void updateWebStaffData(WebStaffPO webstaffpo);
	
	public void insertWebStaffData(WebStaffPO webstaffpo);
		
	public void deleteWebStaffData(WebStaffPO webstaffpo);
	
	/**
	 * @return	从数据文件读入网站管理人员
	 */
	public Map<String, WebManagerPO> getWebManagerData();
	/**
	 * 从数据文件中写入网站管理人员
	 * @param map	
	 */
	public void updateWebManagerData(WebManagerPO webmanagerpo);
	
	public void insertWebManagerData(WebManagerPO webmanagerpo);
		
	public void deleteWebManagerData(WebManagerPO webmanagerpo);
	
	/**
	 * @return	从数据文件读入酒店工作人员
	 */
	public Map<String, HotelStaffPO> getHotelStaffData();
	/**
	 * 从数据文件中写入酒店工作人员
	 * @param map	
	 */
	public void updateHotelStaffData(HotelStaffPO hotelstaffpo);
	
	public void insertHotelStaffData(HotelStaffPO hotelstaffpo);
		
	public void deleteHotelStaffData(HotelStaffPO hotelstaffpo);
}
