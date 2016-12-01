package org.Hotel.server.dataService;

import org.Hotel.server.po.PromotionPO;

public interface PromotionDataService {
	public boolean insert(PromotionPO po){
		return true;
	}
	
	public boolean delete(PromotionPO po){
		return true;
	}
	
	public boolean update(PromotionPO po){
		return true;
	}
	
	public PromotionPO findByID(String id){
		PromotionPO po = new PromotionPO();
		return po;
	}
	
	public PromotionPO findByType(String type){
		PromotionPO po = new PromotionPO();
		return po;
	}
	
	public PromotionPO showAll(){
		PromotionPO po = new PromotionPO();
		return po;
	}
}
