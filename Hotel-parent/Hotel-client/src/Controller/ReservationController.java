package Controller;


import vo.MemberVO;

public class ReservationController {
       private MemberVO membervo;
       
       public ReservationController(){
    	   
       }
       public void setMmembervo(MemberVO vo){
    	   this.membervo=vo;
       }
       public MemberVO getMembervo(){
    	   return membervo;
       }
}
