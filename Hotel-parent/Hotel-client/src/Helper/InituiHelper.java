package Helper;



import java.util.Date;

import vo.MemberVO;

public class InituiHelper {
	private static MemberVO membervo;
       private InituiHelper(){}
        public static void setMemberVO(MemberVO Membervo){
        	membervo=Membervo;
        }
        public  static int getMemberID(){
        	return membervo.getid();
        }
        public static int getMemberCreditvalue(){
        	return membervo.getcredit();
        }
        public static String getMemberlevel(){
        	return membervo.getlevel();
        }
        public static Date getMemberBirthday(){
        	return  membervo.getbirthday();
        }
        public static String getMemberproperty(){
        	return membervo.getproperty();
        }
        public static String getMemberphonenumber(){
        	return membervo.getphonenumber();
        }
        public static String getMembername(){
        	return membervo.getname();
        }
}
