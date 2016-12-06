package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import vo.HotelPromotionVO;
import vo.HotelVO;
import vo.MemberVO;
import vo.WebPromotionVO;

public interface ReservationLogicService {
    
	
	//在搜索酒店页面的方法 
	public ArrayList<String> getallcity() throws RemoteException ;
	
	//获取搜索条件
	public void getSearchInfo();
	
	
	
	
	//计算订单总价,需要考虑会员等级折扣，网站营销策略折扣，酒店营销折扣，合作企业折扣
	public double Computeprice(MemberVO member,WebPromotionVO webpro,HotelPromotionVO hotelpro,int num,int price,LocalDate checkindate,LocalDate checkoutdate) throws ParseException;
	
	//通过商圈从数据库找到酒店列表
	 public ArrayList<HotelVO> findbycircle(String circle);
	 
	 //根据界面搜索条件过滤酒店列表
	 public ArrayList<HotelVO> filtbysearch(ArrayList<HotelVO> hotellist,String roomtype,String roomnum,String hotelstar,String hotelgrade,String hotelprice,String Hotelname);
	 
	//通过酒店名找到酒店
	 public HotelVO findbyname(String name) throws RemoteException ;
	 
	
	
}
