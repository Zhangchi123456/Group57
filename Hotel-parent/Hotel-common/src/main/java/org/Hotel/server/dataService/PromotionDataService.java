package org.Hotel.server.dataService;

import org.Hotel.server.po.PromotionPO;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PromotionDataService {
	public boolean insert(PromotionPO po);
	
	public boolean delete(PromotionPO po);
	
	public boolean update(PromotionPO po);
	
	public PromotionPO findByID(String id);
	
	public PromotionPO findByType(String type);
	
	public PromotionPO showAll();
}
