package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.Hotel.common.po.HotelPO;

import BusinessLogicService.impl.RMIHelper;
import vo.HotelPromotionVO;
import vo.HotelVO;
import vo.MemberLevelVO;
import vo.MemberVO;
import vo.OrderVO;
import vo.WebPromotionVO;
import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.Service.ReservationLogicService;

import org.Hotel.common.dataService.HotelDataService;

public class ReservationLogicServiceImpl implements ReservationLogicService{
    HotelDataService hotelservice=(HotelDataService) RMIHelper.find("HotelDataService");
    PromotionLogicService promotionService=new PromotionLogicServiceImpl();
    
    public ArrayList<String> getallcity() throws RemoteException{
    	return hotelservice.cityShowAll();
    }
	


	
	
	public double Computeprice(MemberVO member,WebPromotionVO webpro,HotelPromotionVO hotelpro,int num,int price,LocalDate checkindate,LocalDate checkoutdate) throws ParseException{
             double finalprice=0.0;
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
            String strin=checkindate.toString();
            String strout=checkoutdate.toString();
            Date Datein=sdf.parse(strin);
            Date Dateout=sdf.parse(strout);
             MemberLevelVO level=promotionService.getMemberLevel(Integer.parseInt(member.getlevel()));
             finalprice=num*price*level.getDiscount();
             if(member.getbirthday().isBefore(checkoutdate)||member.getbirthday().isEqual(checkindate)){
            	 finalprice=finalprice*hotelpro.getBirthdayDiscount();
             }
             if(Datein.after(hotelpro.getStartDate())||Dateout.before(hotelpro.getEndDate())){
            	 finalprice=finalprice*hotelpro.getDateDiscount();
             }
             if(num>=3){
            	 finalprice=finalprice*hotelpro.getMultiorderDiscount();
             }
             if(Datein.after((Date) webpro.getStartDate())||Dateout.before((Date) webpro.getEndDate())){
            	 finalprice=finalprice*webpro.getDateDiscount();
             }
             if(member.getproperty().equals("企业会员")){
            	 finalprice=finalprice* hotelpro.getEnterpriceDiscount()*level.getDiscount();
             }else{
            	 finalprice=finalprice*level.getDiscount();
             }
             
             
            		 
			return finalprice;
             
		
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
		case"5分":
			grade=5;
			break;
		case"4分及以上":
			grade=4;
			break;
		case"3分及以上":
			grade=3;
		
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
			 Date startdate=vo.getStarttime();
			 Date enddate=vo.getLeavetime();
			if(startdate.before(Datein)||startdate.equals(Datein)||enddate.after(Dateout)||enddate.equals(Dateout)){
				
				
				leftsingle=leftsingle-vo.getSingleRoom();
				leftstandard=leftstandard-vo.getStandardRoom();
				leftfamily=leftfamily-vo.getFamilyRoom();
				leftsuite=leftsuite-vo.getSuiteRoom();
				
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
	
}
