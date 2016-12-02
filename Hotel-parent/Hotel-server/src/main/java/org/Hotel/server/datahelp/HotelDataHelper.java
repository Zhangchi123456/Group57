package org.Hotel.server.datahelp;

import java.util.Map;

import org.Hotel.common.po.HotelPO;

public interface HotelDataHelper {
	/**
	 * @return	从数据文件读入酒店信息
	 */
	public Map<Integer,HotelPO> getHotelData();
	/**
	 * 从数据文件中写入酒店信息
	 * @param map	
	 */
	public void updateHotelData(Map<Integer,HotelPO> map);

}
