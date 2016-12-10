package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.Hotel.common.po.HotelPO;
import org.Hotel.common.po.HotelPromotionPO;

import BusinessLogicService.impl.RMIHelper;
import vo.HotelPromotionVO;
import vo.HotelVO;
import vo.MemberLevelVO;
import vo.MemberVO;
import vo.OrderVO;
import vo.WebPromotionVO;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.Service.ReservationLogicService;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.dataService.PromotionDataService;

public class ReservationLogicServiceImpl implements ReservationLogicService{
    HotelDataService hotelservice=(HotelDataService) RMIHelper.find("HotelDataService");
    PromotionLogicService promotionService;
    OrderLogicService orderService=new OrderLogicServiceImpl();
    public ArrayList<String> getallcity() throws RemoteException{
    	return hotelservice.cityShowAll();
    }
	


	
	
	public double Computeprice(MemberVO member,ArrayList<WebPromotionVO> webprolist,ArrayList<HotelPromotionVO> hotelprolist,int num,int price,LocalDate checkindate,LocalDate checkoutdate) throws ParseException{
             double finalprice=0.0;
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
            String strin=checkindate.toString();
            String strout=checkoutdate.toString();
            Date Datein=sdf.parse(strin);
            Date Dateout=sdf.parse(strout);
             MemberLevelVO level=promotionService.getMemberLevel(Integer.parseInt(member.getlevel()));
             finalprice=num*price*level.getDiscount();
             for(int i=0;i<webprolist.size();i++){
            	 WebPromotionVO webpro=webprolist.get(i);
            	
             }
             for(int j=0;j<hotelprolist.size();j++){
            	 HotelPromotionVO hotelpro=hotelprolist.get(j);
            	 switch(hotelpro.getName()){
            	 case"多间折扣":
            		 if(num>=3){
            			 finalprice=finalprice*hotelpro.getMultiorderDiscount();
            		 }
            		 break;
            	 case "企业折扣":
            		 if(member.getproperty().equals("企业会员")){
            			 finalprice=finalprice*hotelpro.getEnterpriceDiscount();
            		 }
            		 break;
            	 case"生日折扣":
            		 if(member.getbirthday().isAfter(checkindate)||member.getbirthday().isBefore(checkoutdate)||member.getbirthday().isEqual(checkindate)||member.getbirthday().isEqual(checkoutdate)){
            			 finalprice=finalprice-price*(1-hotelpro.getBirthdayDiscount());
            		 }
            		 break;
            	 case"日期折扣":
            		
            		 break;
            	 }
             }
             
            		 
			return finalprice;
             
		
	}
	
	 public String Ifreservationed(String name,HotelVO vo){
		 ArrayList<OrderVO> orderlist=orderService.findUserOrderListAll(name);
		 String hotelname=vo.getName();
		 for(int i=0;i<orderlist.size();i++){
			 if(orderlist.get(i).getHotelid().equals(hotelname)){
				 return "是";
			 }
			 
		 }
		 return "否";
	 }
	 public ArrayList<HotelVO> findbycircle(String circle) throws RemoteException{
		 ArrayList<HotelPO> hotellist = hotelservice.FindhotelByCircle(circle);
		 ArrayList<HotelVO> list=new ArrayList<HotelVO>();
		 for(int i=0;i<hotellist.size();i++){
			 HotelVO vo = new HotelVO();
					vo.setbuHotelPO(hotellist.get(i));
					list.add(vo);
		 }
		 return list;
	 }
	 
	 public ArrayList<HotelVO> filtbysearch(ArrayList<HotelVO> hotellist,String roomtype,String roomnum,String hotelstar,String hotelgrade,String hotelprice,String Hotelname){
		 int star=-1;
		 double grade=-1;
		 double lowprice=-1; 
		 double highprice=20000;
		 int Roomnum=0;
		 
		 
		 if(Hotelname=="null"){
			 Hotelname="";
		 }
		 switch(roomtype){
		 case"单人房":
			 break;
		 
		 }
		switch(roomnum){
		case"1间":
			Roomnum=1;
			break;
		case"2间":
			Roomnum=2;
			break;
		case"3间及以上":
			Roomnum=3;
			break;
		}
		switch(hotelstar){
		case"5星":
			star=5;
			break;
		case"4星及以上":
			star=4;
			break;
		case "3星及以上":
			star=3;
		}
		switch(hotelgrade){
		case"10分":
			grade=10;
			break;
		case"8分及以上":
			grade=8;
			break;
		case"5分及以上":
			grade=5;
		
		}
		
		switch(hotelprice){
		case"300元以下":
			highprice=300;
			break;
		case"300元到600元":
			lowprice=300;
			highprice=600;
		case"600元以上":
		     lowprice=600;
		}
		 ArrayList<HotelVO> filtedlist=new ArrayList<HotelVO>();
		 for(int i=0;i<hotellist.size();i++){
			HotelVO vo=hotellist.get(i);
			
			if(vo.getName().contains(Hotelname)&&vo.getGrade()>=grade&&vo.getSingleRoomPrice()>=lowprice&&vo.getSingleRoomPrice()<=highprice&&vo.getStar()>=star){
				filtedlist.add(vo);
			}
		 }
		 return filtedlist;
	 }
	 
	 public boolean roomleft(HotelVO hotel,ArrayList<OrderVO> orderlist,LocalDate checkindate,LocalDate checkoutdate,int num,String roomtype) throws ParseException{
		int leftsingle=hotel.getSingleRoom();
		int leftstandard=hotel.getStandardRoom();
		int leftfamily=hotel.getFamilyRoom();
		int leftsuite=hotel.getSuiteRoom();
		 ArrayList<HotelVO> hotellist=new ArrayList<HotelVO>();
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
         String strin=checkindate.toString();
         String strout=checkoutdate.toString();
         Date Datein=sdf.parse(strin);
         Date Dateout=sdf.parse(strout);
		 for(int i=0;i<orderlist.size();i++){
			 OrderVO vo=orderlist.get(i);
			Date startdate=sdf.parse(vo.getStarttime());
			 Date enddate=sdf.parse(vo.getLeavetime());
			if(startdate.before(Datein)||startdate.equals(Datein)||enddate.after(Dateout)||enddate.equals(Dateout)){
				
				
				leftsingle=leftsingle-Integer.parseInt(vo.getSingleRoom());
				leftstandard=leftstandard-Integer.parseInt(vo.getStandardRoom());
				leftfamily=leftfamily-Integer.parseInt(vo.getFamilyRoom());
				leftsuite=leftsuite-Integer.parseInt(vo.getSuiteRoom());
				
			}
			switch(roomtype){
			case"单人房":
				if(num>leftsingle){
					return false;
				}
				break;
			case"标准间":
				if(num>leftstandard){
					return false;
				}
				break;
			case"家庭房":
				if(num>leftfamily){
					return false;
				}
				break;
			case"套间":
				if(num>leftsuite){
					return false;
				}
				
				break;
			}
		 }
		 
		 return true;
	 }
	 
	 public HotelVO findbyname(String name) throws RemoteException {
		  
		 HotelVO vo=new HotelVO();
	
		
			vo.setbuHotelPO(hotelservice.Findhotelbyname(name));
		
		 return vo;
		 
	 }
	 
	 public ArrayList<HotelPromotionVO> findhotelpro(String name) throws RemoteException{
		 PromotionDataService promotionservice=(PromotionDataService)RMIHelper.find("PromotionDataService");
		 ArrayList<HotelPromotionPO> hotelprolist=promotionservice.findByHotelProID(name);
		 ArrayList<HotelPromotionVO> hotelprolist2 = new ArrayList<HotelPromotionVO>();
		 for(int i=0;i<hotelprolist.size();i++){
			 HotelPromotionVO vo=new HotelPromotionVO();
			 vo.setByPO(hotelprolist.get(i));
			 hotelprolist2.add(vo);
		 }
		 return hotelprolist2;
	 }
	 
	 public ArrayList<WebPromotionVO> showall(){
		 ArrayList<WebPromotionVO> LIST=promotionService.getWebPromotionList();
		 return LIST;
	 }





	
}
