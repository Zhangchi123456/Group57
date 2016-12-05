package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.HotelVO;

public interface ReservationLogicService {
    
	
	//在搜索酒店页面的方法 
	public ArrayList<String> getallcity();
	
	//获取搜索条件
	public void getSearchInfo();
	
	//获取订单信息
	public void getOrderInfo();
	
	//计算订单总价,需要考虑会员等级折扣，网站营销策略折扣，酒店营销折扣，合作企业折扣
	public double Computeprice();
	
	//通过搜索界面的条件从数据库找到酒店列表
	 public ArrayList<HotelVO> findbysearch(String searchmust,String searchother);
	 
	//通过酒店名找到酒店
	 public HotelVO findbyname(String name);
	
}
