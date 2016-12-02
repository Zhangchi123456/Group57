package org.Hotel.server.datahelp;

import java.util.Map;

import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.WebPromotionPO;

public interface PromotionDataHelper {
	/**
	 * @return	从数据文件读入酒店促销策略
	 */
	public Map<Integer,HotelPromotionPO> getHotelPromotionData();
	/**
	 * 从数据文件中写入酒店促销策略
	 * @param map	
	 */
	public void updateHotelPromotionData(Map<Integer,HotelPromotionPO> map);
	
	/**
	 * @return	从数据文件读入网站促销策略
	 */
	public Map<Integer,WebPromotionPO> getWebPromotionData();
	/**
	 * 从数据文件中写入网站促销策略
	 * @param map	
	 */
	public void updateWebPromotionData(Map<Integer,WebPromotionPO> map);
}