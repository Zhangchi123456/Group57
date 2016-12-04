package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.OrderVO;

public interface OrderLogicService {
	public boolean evaluate(int OrderId,String score ,String EvaluateInfo); //评价订单信息的保存。
    public boolean input(OrderVO VO);//订单信息的保存
    public OrderVO findUserOrderinfo(String UserName,int OrderId);//通过订单号查找订单；返回订单信息
    public ArrayList<OrderVO> findUserOrderListAll(String UserName);//通过用户名查找所有该用户的订单
    public ArrayList<OrderVO> findUserOrderListStation(String UserName,String OrderStation);//通过用户名和订单状态查找订单   
    public boolean revokeUserOrder(String UserName,int OrderId);//撤销订单并扣除信用值
    public boolean changeOrderStation(int OrderId);//更改订单状态
    public OrderVO UserOrderList(String UserName);//查找用户所有的订单信息
    public OrderVO HotelOrderList(String UserName);//查找酒店所有的订单信息
   
    
}