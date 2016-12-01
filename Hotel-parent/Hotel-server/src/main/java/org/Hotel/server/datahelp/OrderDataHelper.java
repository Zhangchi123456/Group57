package org.Hotel.server.datahelp;

import java.util.Map;

import org.Hotel.common.po.OrderPO;

public interface OrderDataHelper {

    public Map<Integer,OrderPO> getOrderData();
	
	public void updateOrderData(Map<Integer,OrderPO> map);
}
