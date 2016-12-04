package org.Hotel.server.datahelp;

import java.util.Date;
import java.util.Map;

import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.WebPromotionPO;

public interface PromotionDataHelper {
	/**
	 * @return	从数据文件读入酒店促销策略
	 */
	public Map<String, HotelPromotionPO> getHotelPromotionData();
	/**
	 * 从数据文件中写入酒店促销策略
	 * @param map	
	 */
	public void updateHotelPromotionData(HotelPromotionPO po);
	public void deleteHotelPromotionData(HotelPromotionPO po);
	public void insertHotelPromotionData(HotelPromotionPO po);
	
	/**
	 * @return	从数据文件读入网站促销策略
	 */
	public Map<Date, WebPromotionPO> getWebPromotionData();
	/**
	 * 从数据文件中写入网站促销策略
	 * @param map	
	 */
	public void updateWebPromotionData(WebPromotionPO po);
	public void deleteWebPromotionData(WebPromotionPO po);
	public void insertWebPromotionData(WebPromotionPO po);
}