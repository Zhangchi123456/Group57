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
     public void testgetallcity() throws RemoteException{
    	 ArrayList<String> city=reservation.getallcity();
    	 boolean result=(city.contains("南京")&&city.contains("北京"));
    	 assertTrue(result);
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
    	 assertEquals(1, weblist.size());
     }
     
     @Test
     public void testfindbycircle() throws RemoteException{
    	 ArrayList<HotelVO> hotellist=reservation.findbycircle("西单商圈");
    	 assertEquals(1, hotellist.size());
    	 assertEquals("北平酒店",hotellist.get(0).getName());
    	
     }
     
     @Test
     public void testIfreservationed() throws RemoteException{
    	 HotelVO vo=reservation.findbyname("南行酒店");
    	 assertEquals("是",reservation.Ifreservationed("高晓晓", vo));
     }
     
     @Test
     public void testfiltbysearch() throws RemoteException{
    	 ArrayList<HotelVO> list1=reservation.findbycircle("珠江路商圈");
    	 ArrayList<HotelVO> hotellist=reservation.filtbysearch(list1, "单人房","1间","任意星级","8分及以上","300元以下","null");
    	 assertEquals(1,hotellist.size());
     }
     
     
     
}
