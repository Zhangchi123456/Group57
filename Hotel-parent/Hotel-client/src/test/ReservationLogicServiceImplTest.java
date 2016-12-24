package test;

import java.rmi.RemoteException;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import BusinessLogicService.impl.ReservationLogicServiceImpl;
import Controller.ReservationController;
import junit.framework.TestCase;
import vo.HotelVO;
import vo.WebPromotionVO;

public class ReservationLogicServiceImplTest extends TestCase {
     ReservationLogicServiceImpl reservation=new ReservationLogicServiceImpl();
     @Before
     public void setup(){
    	 String city1="南京";
    	 String city2="北京";
    	 
     }
    
     
     @Test
     public void testfindbyname() throws RemoteException{
    	 HotelVO vo=reservation.findbyname("南行酒店");
    	 assertEquals("南行酒店",vo.getName());
    	 assertEquals(5, vo.getStar());
     }
     
     @Test
     public void testshowall(){
    	 ArrayList<WebPromotionVO> weblist=reservation.showall();
    	 boolean result=false;
    	 if(weblist.size()>0){
    		 result=true;
    	 }
    	 assertTrue(result);
     }
     
     @Test
     public void testfindbycircle() throws RemoteException{
    	 ArrayList<HotelVO> hotellist=reservation.findbycircle("西单商圈");
    	 boolean result=true;
    	 if(hotellist.size()>1){
    		 result=true;
    	 }
    	assertTrue(result);
    	
     }
     
     @Test
     public void testIfreservationed() throws RemoteException{
    	 HotelVO vo=reservation.findbyname("南行酒店");
    	 assertEquals("是",reservation.Ifreservationed("高晓晓", vo));
     }
     
     @Test
     public void testfiltbysearch() throws RemoteException{
    	 ArrayList<HotelVO> list1=reservation.findbycircle("珠江路商圈");
    	 ArrayList<HotelVO> hotellist=reservation.filtbysearch(list1, "单人房","1间","任意星级","","300元及以下","null");
    	 boolean result=false;
    	 if(hotellist.size()>0){
    		 result=true;
    	 }
    	 assertTrue(result);
     }
     
     
     
}
