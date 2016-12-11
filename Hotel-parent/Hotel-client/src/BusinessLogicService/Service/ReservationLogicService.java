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
	
	
	
	//计算订单总价,需要考虑会员等级折扣，网站营销策略折扣，酒店营销折扣，合作企业折扣
	public double Computeprice(MemberVO member,ArrayList<WebPromotionVO> webprolist,ArrayList<HotelPromotionVO> hotelprolist,int num,double price,LocalDate checkindate,LocalDate checkoutdate) throws ParseException;
	
	//通过商圈从数据库找到酒店列表
	 public ArrayList<HotelVO> findbycircle(String circle) throws RemoteException;
	 
	 //根据界面搜索条件过滤酒店列表
	 public ArrayList<HotelVO> filtbysearch(ArrayList<HotelVO> hotellist,String roomtype,String roomnum,String hotelstar,String hotelgrade,String hotelprice,String Hotelname);
	 
	//通过酒店名找到酒店
	 public HotelVO findbyname(String name) throws RemoteException ;
	 
	//判断酒店是否预订过
	 public String Ifreservationed(String name,HotelVO vo);
	//获得酒店的营销策略
	 public ArrayList<HotelPromotionVO> findhotelpro(String name) throws RemoteException;
	 
	//获得网站的营销策略
	 public ArrayList<WebPromotionVO> showall();



}
