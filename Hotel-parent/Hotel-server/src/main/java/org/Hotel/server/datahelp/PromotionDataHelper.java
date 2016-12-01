package org.Hotel.server.datahelp;

import java.util.Map;

import org.Hotel.common.po.PromotionPO;

public interface PromotionDataHelper {

	public Map<Integer,PromotionPO> getPromotionData();
	
	public void updatePromotionData(Map<Integer,PromotionPO> map);
}
