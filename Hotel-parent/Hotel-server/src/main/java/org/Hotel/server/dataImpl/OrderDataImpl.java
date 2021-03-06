
package org.Hotel.server.dataImpl;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.Hotel.common.dataService.OrderDataService;
import org.Hotel.common.po.OrderPO;
import org.Hotel.server.datahelp.DataFactory;
import org.Hotel.server.datahelp.OrderDataHelper;
import org.Hotel.server.datahelp.impl.DataFactoryImpl;

@SuppressWarnings("serial")
public class OrderDataImpl extends UnicastRemoteObject implements 

OrderDataService,Serializable{


	private Map<Integer, OrderPO> map;
	
	private OrderDataHelper orderDataHelper;
	
	private DataFactory dataFactory;
	
	private static OrderDataImpl orderDataImpl;
	
	public static OrderDataImpl getInstance() throws RemoteException{
		if(orderDataImpl == null){
			orderDataImpl = new OrderDataImpl();
		}
		return orderDataImpl;
	}
	
	public OrderDataImpl()throws RemoteException{
		if(map == null){
			dataFactory = new DataFactoryImpl();
			orderDataHelper = dataFactory.getOrderDataHelper();
			map = orderDataHelper.getOrderData();
		}
	}

	/*DickChou
	 * 增删改查
	 * 
	 */
		public boolean insert(OrderPO orderpo)throws RemoteException{
			int order_id = orderpo.getId();
			if(map.get(order_id) == null){
				map.put(order_id, orderpo);
				orderDataHelper.insertOrderData(orderpo);
				return true;
			}else
			return false;
	    	
	    }
		
		public boolean delete(OrderPO orderpo)throws RemoteException{
			int order_id = orderpo.getId();
			if(map.get(order_id) != null){
				map.remove(order_id, orderpo);
				orderDataHelper.deleteOrderData(orderpo);
				return true;
			}else
			return false;
			
		}
		
		public boolean update(OrderPO orderpo)throws RemoteException{
			int order_id = orderpo.getId();
			if(map.get(order_id) != null){
				map.put(order_id, orderpo);
				orderDataHelper.updateOrderData(orderpo);
				return true;
			}else
			return false;
			
		}
		//找所有订单
	    public ArrayList<OrderPO> showAll()throws RemoteException{
	    	ArrayList<OrderPO> orderlist = new ArrayList<OrderPO>();
			Iterator<Map.Entry<Integer,OrderPO>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, OrderPO> entry = iterator.next();
				OrderPO orderpo = entry.getValue();
				orderlist.add(orderpo);
			}
			return orderlist;
	    	
	    }
		//根据订单号找订单
		public OrderPO orderShowAll(int order_id)throws RemoteException{
			OrderPO orderpo = new OrderPO();
			Iterator<Map.Entry<Integer,OrderPO>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, OrderPO> entry = iterator.next();
				orderpo = entry.getValue();
				if(order_id == orderpo.getId())
					return orderpo;

			}
			return null;
			
		}
		//根据用户名找订单
		public ArrayList<OrderPO> orderShowAllByName(String name)throws RemoteException{
			ArrayList<OrderPO> orderlist = new ArrayList<OrderPO>();
			Iterator<Map.Entry<Integer,OrderPO>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, OrderPO> entry = iterator.next();
				OrderPO orderpo = entry.getValue();
				if(name .equals(orderpo.getName()))
					orderlist.add(orderpo);
			}
	     	return orderlist;
			
		}
		//根据状态找订单
		public ArrayList<OrderPO> orderShowAllByStation(String station)throws RemoteException{
			ArrayList<OrderPO> orderlist = new ArrayList<OrderPO>();
			Iterator<Map.Entry<Integer,OrderPO>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, OrderPO> entry = iterator.next();
				OrderPO orderpo = entry.getValue();
				if(station.equals(orderpo.getState())){
					orderlist.add(orderpo);
				}
				
			}
		
	     	return orderlist;
			
		}
		//根据酒店找订单
		public ArrayList<OrderPO> orderShowAllByHotel(String hotel_id)throws RemoteException{
			ArrayList<OrderPO> orderlist = new ArrayList<OrderPO>();
			Iterator<Map.Entry<Integer,OrderPO>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, OrderPO> entry = iterator.next();
				OrderPO orderpo = entry.getValue();
				if(hotel_id.equals( orderpo.getHotelid()))
					orderlist.add(orderpo);
			}
			return orderlist;
			
		}
		//根据用户和状态找订单
		public ArrayList<OrderPO> orderShowAllByName(String name, String state)throws RemoteException{
			ArrayList<OrderPO> orderlist = new ArrayList<OrderPO>();
			Iterator<Map.Entry<Integer,OrderPO>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, OrderPO> entry = iterator.next();
				OrderPO orderpo = entry.getValue();
				if(name.equals(orderpo.getName())&&state.equals(orderpo.getState()))
					orderlist.add(orderpo);
			}
			return orderlist;
			
		}
		//根据酒店和用户找订单
		public ArrayList<OrderPO> orderShowAllByHotel(String hotel_id, String name)throws RemoteException{
			ArrayList<OrderPO> orderlist = new ArrayList<OrderPO>();
			Iterator<Map.Entry<Integer,OrderPO>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<Integer, OrderPO> entry = iterator.next();
				OrderPO orderpo = entry.getValue();
				if(hotel_id.equals(orderpo.getHotelid())&&name.equals( orderpo.getName()) )
					orderlist.add(orderpo);
			}
			return orderlist;
			
		}
}