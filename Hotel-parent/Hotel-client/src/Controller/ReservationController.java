package Controller;


import java.util.HashMap;
import java.util.Map;

import vo.MemberVO;
import vo.WebPromotionVO;

public class ReservationController {
	private final static Map<String,Object> reservationmap = new HashMap<>();
	private final static String membervokey = "vo";	
    private final static String webpromotionkey="webpromotion";
       private ReservationController(){
    	   
       }
       public static void setWebpromotionvo(WebPromotionVO webpromotion){
    	   reservationmap.put(webpromotionkey, webpromotion);
       }
       public static WebPromotionVO getWebPromotionvo(){
    	   return (WebPromotionVO)reservationmap.get(webpromotionkey);
       }
       public static void setMembervo(MemberVO vo){
    	   reservationmap.put(membervokey, vo);
       }
       public static  MemberVO getMembervo(){
    	   return (MemberVO)reservationmap.get(membervokey);
       }
}
