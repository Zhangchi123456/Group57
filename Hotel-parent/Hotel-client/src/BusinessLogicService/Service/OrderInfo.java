package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.OrderVO;


//用于逻辑层之间各模块调用的接口
public interface OrderInfo {
	  public ArrayList<OrderVO> findUserOrderListAll(String UserName);//通过用户名查找所有该用户的订单
}
