package org.Hotel.server.datahelp;

import java.util.List;
import java.util.Map;
import org.Hotel.common.po.*;

public interface HotelDataHelper {
	
	public Map<Integer,HotelPO> getHotelData();
	
	public void updateHotelData(Map<Integer,HotelPO> map);
	
	

}
