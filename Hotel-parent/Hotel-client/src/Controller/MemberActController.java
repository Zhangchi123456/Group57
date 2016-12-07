package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.CreditRecordVO;
import vo.HotelVO;
import vo.MemberVO;
import vo.OrderVO;

public class MemberActController {
	private final static Map<String,Object> memberactmap = new HashMap<>();
	private final static String memberVokey="memberVo";
	private final static String creditrecordkey="creditrecord";
	private final static String hotelListkey="HotelList";
	private final static String currentorderkey="ordervo";
	
	private MemberActController(){
		
	}
	 public static void setMembervo(MemberVO memberVo){
  	   memberactmap.put(memberVokey,memberVo );
     }
     public static  MemberVO getmemberVo(){
  	   return (MemberVO)memberactmap.get(memberVokey);
     }
     public static void setCreditrecordvoList(ArrayList<CreditRecordVO> creditrecord){
    	   memberactmap.put(creditrecordkey,creditrecord );
       }
       
     
	@SuppressWarnings("unchecked")
	public static  ArrayList<CreditRecordVO> getCreditRecordVOList(){
    	   return (ArrayList<CreditRecordVO>)memberactmap.get(creditrecordkey);
       }
	
	
	  public static void setHotelvoList(ArrayList<HotelVO> HotelList){
   	   memberactmap.put(hotelListkey,HotelList );
      }
      
    
	@SuppressWarnings("unchecked")
	public static  ArrayList<HotelVO> getHotelVOList(){
   	   return (ArrayList<HotelVO>)memberactmap.get(hotelListkey);
      }
	
	 public static void setcurrentOrdervo(OrderVO ordervo){
	  	   memberactmap.put(currentorderkey,ordervo );
	     }
	     public static  OrderVO getOrdervo(){
	  	   return (OrderVO)memberactmap.get(currentorderkey);
	     }
}
