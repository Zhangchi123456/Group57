package org.Hotel.server.datahelp;

import java.util.Map;
import org.Hotel.common.po.*;

public interface UserDataHelper {
	/**
	 * @return	从数据文件读入网站营销人员
	 */
	public Map<Integer,WebStaffPO> getWebStaffData();
	/**
	 * 从数据文件中写入网站营销人员
	 * @param map	
	 */
	public void updateWebStaffData(Map<Integer,WebStaffPO> map);
	
	/**
	 * @return	从数据文件读入网站管理人员
	 */
	public Map<Integer,WebManagerPO> getWebManagerData();
	/**
	 * 从数据文件中写入网站管理人员
	 * @param map	
	 */
	public void updateWebManagerData(Map<Integer,WebManagerPO> map);
	
	/**
	 * @return	从数据文件读入酒店工作人员
	 */
	public Map<Integer,HotelStaffPO> getHotelStaffData();
	/**
	 * 从数据文件中写入酒店工作人员
	 * @param map	
	 */
	public void updateHotelStaffData(Map<Integer,HotelStaffPO> map);
}
