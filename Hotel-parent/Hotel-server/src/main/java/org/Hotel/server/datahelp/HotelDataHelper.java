package org.Hotel.server.datahelp;

import java.util.Map;

import org.Hotel.common.po.CirclePO;
import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.RoomPO;

public interface HotelDataHelper {
	/**
	 * @return	从数据文件读入酒店信息
	 */
	public Map<String,HotelPO> getHotelData();
	/**
	 * 从数据文件中写入酒店信息
	 * @param map	
	 */
	public void updateHotelData(HotelPO hotelpo);
	
	public void insertHotelData(HotelPO hotelpo);
	
	public void deleteHotelData(HotelPO hotelpo);

	/**
	 * @return	从数据文件读入客房信息
	 */
	public Map<Integer,RoomPO> getRoomData();
	/**
	 * 从数据文件中写入客房信息
	 * @param map	
	 */
	public void updateRoomData(RoomPO roompo);
	
	public void insertRoomData(RoomPO roompo);
	
	public void deleteRoomData(RoomPO roompo);
		
	/**
	 * @return	从数据文件读入酒店信息
	 */
	public Map<String,CirclePO> getCircleData();
	/**
	 * 从数据文件中写入酒店信息
	 * @param map	
	 */
	public void updateCircleData(CirclePO circlepo);
	
	public void insertCircleData(CirclePO circlepo);
	
	public void deleteCircleData(CirclePO circlepo);
	
}
