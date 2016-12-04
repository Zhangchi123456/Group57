package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.HotelVO;

public interface ReservationLogicService {
    
	
	//在搜索酒店页面的方法 
	
    //判断选择的日期是否合理
	public boolean Isdatereasonable();
	
	//获取搜索条件
	public void getSearchInfo();
	
	//获取订单信息
	public void getOrderInfo();
	
	//计算订单总价
	public double Computeprice();
	
	//通过搜索界面的条件从数据库找到酒店列表
	 public ArrayList<HotelVO> findbysearch(String searchmust,String searchother);
	
}
