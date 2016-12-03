package org.Hotel.server.datahelp;

import java.util.Map;

import org.Hotel.common.po.OrderPO;

public interface OrderDataHelper {
	/**
	 * @return	从数据文件读入订单信息
	 */
    public Map<Integer,OrderPO> getOrderData();
    /**
	 * 从数据文件中写入订单信息
	 * @param map	
	 */
    public void updateOrderData(OrderPO orderpo);
	
	public void insertOrderData(OrderPO orderpo);
	
	public void deleteOrderData(OrderPO orderpo);
}
