package Controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.HotelPromotionVO;
import vo.HotelVO;
import vo.MemberVO;
import vo.OrderVO;
import vo.WebPromotionVO;

public class ReservationController {
	private final static Map<String,Object> reservationmap = new HashMap<>();
	private final static String membervokey = "vo";	
    private final static String webpromotionkey="webpromotion";
    private final static String currenthotelkey="Hotelvo";
    private final static String currenthotelprokey="Hotelpro";
    private final static String hotellistkey="Hotellist";
    private final static String ordervokey="ordervo";
       private ReservationController(){
    	   
       }
       public static void setWebpromotionvo(WebPromotionVO webpromotion){
    	   reservationmap.put(webpromotionkey, webpromotion);
       }
       public static WebPromotionVO getWebPromotionvo(){
    	   return (WebPromotionVO)reservationmap.get(webpromotionkey);
       }
       public static void setOrdervo(OrderVO ordervo){
    	   reservationmap.put(ordervokey, ordervo);
       }
       public static OrderVO getOrdervo(){
    	   return (OrderVO)reservationmap.get(ordervokey);
       }
       public static void setMembervo(MemberVO vo){
    	   reservationmap.put(membervokey, vo);
       }
       public static  MemberVO getMembervo(){
    	   return (MemberVO)reservationmap.get(membervokey);
       }

      public static void setHotelvo(HotelVO Hotelvo){
	   reservationmap.put(currenthotelkey, Hotelvo);
}
         public static HotelVO getCurrentHotelvo(){
	   return (HotelVO)reservationmap.get(currenthotelkey);
}
         
         public static void setHotelpromotionvo(HotelPromotionVO Hotelpro){
      	   reservationmap.put(currenthotelprokey, Hotelpro);
         }
         public static HotelPromotionVO getHotelPromotionvo(){
      	   return (HotelPromotionVO)reservationmap.get(currenthotelprokey);
         }
         public static void setHotelvoList(ArrayList<HotelVO> hotellist){
      	   reservationmap.put(hotellistkey, hotellist);
         }
         public static ArrayList<HotelVO> getHotelvolist(){
      	   return (ArrayList<HotelVO>)reservationmap.get(hotellistkey);
         }
}
