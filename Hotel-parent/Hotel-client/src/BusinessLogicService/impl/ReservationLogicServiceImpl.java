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
import BusinessLogicService.Service.HotelInfo;
import BusinessLogicService.Service.OrderInfo;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.Service.PromotionInfo;
import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.Service.ReservationLogicService;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.dataService.PromotionDataService;

public class ReservationLogicServiceImpl implements ReservationLogicService{
	//持有hotelservice。promotionservice。orderservice接口
    HotelInfo hotelservice=new HotelStaffLogicServiceImpl();
    PromotionInfo promotionService=new PromotionLogicServiceImpl();
    OrderInfo orderService=new OrderLogicServiceImpl();
    
	
	
	//计算订单价格方法的实现
	public double Computeprice(MemberVO member,ArrayList<WebPromotionVO> webprolist,ArrayList<HotelPromotionVO> hotelprolist,int num,double price,LocalDate checkindate,LocalDate checkoutdate){
            try{
		    double finalprice=0.0;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strin=checkindate.toString();
            String strout=checkoutdate.toString();
            long m;
			
				m = sdf.parse(strout).getTime()-sdf.parse(strin).getTime();
		
            int day=(int)(m/(1000 * 60 * 60 * 24)); 
            Date Datein=sdf.parse(strin);
            Date Dateout=sdf.parse(strout);
            MemberLevelVO level=promotionService.getMemberLevel(Integer.parseInt(member.getlevel()));
          //根据会员等级和商圈折扣计算价格
            finalprice=day*num*price*level.getDiscount();
           
          //根据网站营销策略优惠计算价格
            for(int i=0;i<webprolist.size();i++){
            	 WebPromotionVO webpro=webprolist.get(i);
            	 Date start=sdf.parse(webpro.getStartDate());
            	 Date end=sdf.parse(webpro.getEndDate());
            	 if((Datein.after(start)||Datein.equals(start))&&(Dateout.before(end)||Dateout.equals(end))){
            		 if(webpro.getDateDiscount()!=0){
            		 finalprice=finalprice*webpro.getDateDiscount();
            		 }
            	 }
            	
             }
           //根据酒店促销策略计算优惠
             for(int j=0;j<hotelprolist.size();j++){
            	 HotelPromotionVO hotelpro=hotelprolist.get(j);
            	 switch(hotelpro.getName()){
            	 case"多间折扣":
            		 if(num>=3||hotelpro.getMultiorderDiscount()!=0){
            			 finalprice=finalprice*hotelpro.getMultiorderDiscount();
            		 }
            		 break;
            	 case "企业折扣":
            		 if(member.getproperty().equals("企业会员")||hotelpro.getEnterpriceDiscount()!=0){
            			 finalprice=finalprice*hotelpro.getEnterpriceDiscount();
            		 }
            		 break;
            	 case"生日折扣":
            		 if(member.getBirthday()!=null){
            		 if(member.getbirthday().isAfter(checkindate)||member.getbirthday().isBefore(checkoutdate)||member.getbirthday().isEqual(checkindate)||member.getbirthday().isEqual(checkoutdate)){
            			 if(hotelpro.getBirthdayDiscount()!=0){
            			 finalprice=finalprice-price*(1-hotelpro.getBirthdayDiscount());
            			 }
            		 }
            		 }
            		 break;
            	 case"日期折扣":
            		 Date start=sdf.parse(hotelpro.getStartDate());
                	 Date end=sdf.parse(hotelpro.getEndDate());
                	 if((Datein.after(start)||Datein.equals(start))&&(Dateout.before(end)||Dateout.equals(end))){
                		 if(hotelpro.getDateDiscount()!=0){
                		 finalprice=finalprice*hotelpro.getDateDiscount();
                		 }
                	 }
            		 break;
            	 }
             }		 
            
			return Math.floor(finalprice);
            }
            catch(ParseException e){
            	e.printStackTrace();
            }
            return Math.floor(price*num);
	}
	
	//判断是否曾预定过这个酒店方法的实现
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
	 //通过商圈名字找酒店的方法实现
	 public ArrayList<HotelVO> findbycircle(String circle) {
		ArrayList<HotelVO> list=new ArrayList<HotelVO>();
		try {
			list = hotelservice.findbycircle(circle);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
	 }
	 //根据搜索条件过滤酒店的方法实现
	 public ArrayList<HotelVO> filtbysearch(ArrayList<HotelVO> hotellist,String roomtype,String roomnum,String hotelstar,String hotelgrade,String hotelprice,String Hotelname){
		 int star=-1;
		 double grade=-1;
		 double lowprice=-1; 
		 double highprice=20000;
		 String rotype;
		 int Roomnum=0;
		 if(Hotelname=="null"){
			 Hotelname="";
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
		//通过各种条件过滤酒店列表；
		 ArrayList<HotelVO> filtedlist=new ArrayList<HotelVO>();
		 for(int i=0;i<hotellist.size();i++){
			HotelVO vo=hotellist.get(i);
			if(vo.getName().contains(Hotelname)&&vo.getGrade()>=grade&&vo.getSingleRoomPrice()>=lowprice&&vo.getSingleRoomPrice()<=highprice&&vo.getStar()>=star){
				switch(roomtype){
				 case"单人房":
					 if(vo.getSingleRoom()>=Roomnum){
						 filtedlist.add(vo);
					 }
					 break;
				 case"标准间":
					 if(vo.getStandardRoom()>=Roomnum){
						 filtedlist.add(vo);
					 }
					 break;
				 case"套间":
					 if(vo.getSuiteRoom()>=Roomnum){
						 filtedlist.add(vo);
					 }
					 break;
				 case"家庭房":
					 if(vo.getSuiteRoom()>=Roomnum){
						 filtedlist.add(vo);
					 }
					 break;
				 default:
					 filtedlist.add(vo);
				 }
				
			}
		 }
		 return filtedlist;
	 }
	 
	 
	 //检查是否有房间剩余的方法实现
	 public boolean roomleft(HotelVO hotel,ArrayList<OrderVO> orderlist,LocalDate checkindate,LocalDate checkoutdate,int num,String roomtype){
		try{
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
        switch(roomtype){
			case"单人房":
				if(num>hotel.getSingleRoom()){
					return false;
				}
				break;
			case"标准间":
				if(num>hotel.getStandardRoom()){
					return false;
				}
				break;
			case"家庭房":
				if(num>hotel.getFamilyRoom()){
					return false;
				}
				break;
			case"套间":
				if(num>hotel.getSuiteRoom()){
					return false;
				}
				
				break;
			}
         //调用该酒店历史订单判断房间是否剩余
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
			//判断预订房间数量是否超过酒店持有最大房间数。
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
		}catch(ParseException e){
			e.printStackTrace();
		}
		return true;
	 }
	 //通过酒店名找到酒店的实现
	 public HotelVO findbyname(String name) { 
		HotelVO vo=new HotelVO();
		try {
			vo = hotelservice.findbyname(name);
			 return vo;
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
        return vo;
	 }
	 //通过名字找到酒店营销策略方法的实现
	 public ArrayList<HotelPromotionVO> findhotelpro(String name){
		 ArrayList<HotelPromotionVO> hotelprolist=promotionService.findhotelpro(name);
		 return hotelprolist;
	 }
	 //通过名字找到网站营销策略的实现
	 public ArrayList<WebPromotionVO> showall(){
		 ArrayList<WebPromotionVO> LIST=promotionService.getWebPromotionList();
		 return LIST;
	 }

	
}
