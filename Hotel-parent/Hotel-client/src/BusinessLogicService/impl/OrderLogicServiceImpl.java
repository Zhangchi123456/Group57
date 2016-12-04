package BusinessLogicService.impl;

import java.util.ArrayList;

import BusinessLogicService.Service.OrderLogicService;
import vo.OrderVO;

public class OrderLogicServiceImpl implements OrderLogicService {

	@Override
	public boolean evaluate(int OrderId, String score, String EvaluateInfo) {		
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean input(OrderVO VO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderVO findUserOrderinfo(String UserName, int OrderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean revokeUserOrder(String UserName, int OrderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeOrderStation(int OrderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderVO UserOrderList(String UserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO  HotelOrderList(String UserName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> findUserOrderListAll(String UserName) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> a = new ArrayList<OrderVO>();
		a.add(new OrderVO(0,0.0,"a","b","aweqwqwe","bqweqqwess","c","d","f","g","q"	,"aweqwqwe") );
		return a;
	}

	@Override
	public ArrayList<OrderVO> findUserOrderListStation(String UserName, String OrderStation) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> a = new ArrayList<OrderVO>();
		a.add(new OrderVO(0,0.0,"a","b","aweqwqwe","bqweqqwess","c","d","f","g","q"	,"aweqwqwe"));
		a.add(new OrderVO(0,0.0,"a","b","aweqwqwe","bqweqqwess","c","d","f","g","q"	,"aweqwqwe"));
		return a;
	}

}
