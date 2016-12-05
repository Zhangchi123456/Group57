package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.HotelPO;

import BusinessLogicService.impl.RMIHelper;
import vo.HotelVO;
import BusinessLogicService.Service.ReservationLogicService;

import org.Hotel.common.dataService.HotelDataService;

public class ReservationLogicServiceImpl implements ReservationLogicService{
    HotelDataService hotelservice;
    public ArrayList<String> getallcity(){
    	return null;
    }
	public boolean Isdatereasonable(){
		return false;
		
	}
	

	public void getSearchInfo(){
		
	}
	
	
	public void getOrderInfo(){
		
	}
	public double Computeprice(){
		return 0;
		
	}
	
	 public ArrayList<HotelVO> findbycircle(String circle){
		 ArrayList<HotelPO> hotellist = null;//该行仍要改
		 ArrayList<HotelVO> list=new ArrayList<HotelVO>();
		 for(int i=0;i<hotellist.size();i++){
			 HotelVO vo = new HotelVO();
					vo.setbuHotelPO(hotellist.get(i));
					list.add(vo);
		 }
		 return list;
	 }
	 
	 public ArrayList<HotelVO> filtbysearch(ArrayList<HotelVO> hotellist,String roomtype,String roomnum,String hotelstar,String hotelgrade,String hotelprice){
		 int star=-1;
		 double grade=-1;
		 double lowprice=-1; 
		 double highprice=20000;
		 switch(roomtype){
		 
		 }
		switch(roomnum){
			
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
			if(vo.getGrade()>=grade&&vo.getSingleRoomPrice()>=lowprice&&vo.getSingleRoomPrice()<=highprice&&vo.getStar()>=star){
				filtedlist.add(vo);
			}
		 }
		 return filtedlist;
	 }
	 
	 public HotelVO findbyname(String name) throws RemoteException {
		  hotelservice=(HotelDataService) RMIHelper.find("HotelDataService");
		 HotelVO vo=new HotelVO();
	
		
			vo.setbuHotelPO(hotelservice.Findhotelbyname(name));
		
		 return vo;
		 
	 }
}
