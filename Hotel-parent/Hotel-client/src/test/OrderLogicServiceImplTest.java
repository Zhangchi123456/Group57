package test;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import BusinessLogicService.impl.ReservationLogicServiceImpl;
import Controller.ReservationController;
import junit.framework.TestCase;
import vo.HotelVO;
import vo.OrderVO;
import vo.WebPromotionVO;

public class OrderLogicServiceImplTest extends TestCase {
       OrderLogicService order=new OrderLogicServiceImpl();
     
     @Test
     public void testFindOrderByusername() throws RemoteException{
    	 ArrayList<OrderVO> order1=order.findUserOrderListAll("高晓晓");	
    	
    	 assertEquals("高晓晓",order1.get(0).getName());
     }

     
     @Test
     public void testfingbyhotel() throws RemoteException{
    	 ArrayList<OrderVO> order1=order.findUserOrderListHotel("南行酒店");
    	 assertEquals("南行酒店",order1.get(0).getHotelid());
     }
     
     @Test
     public void testfindbyhotelandname(){
    	 ArrayList<OrderVO> order1=order.findUserOrderListHotelandName("高晓晓", "南行酒店");
    	 assertEquals("南行酒店",order1.get(0).getHotelid());
    	 assertEquals("高晓晓",order1.get(0).getName());

     }
     
     @Test
     public void testfindOrderStation() throws RemoteException{
    	 ArrayList<OrderVO> order1=order.findUserOrderListStation("高晓晓", "已执行");
    	 assertEquals("高晓晓",order1.get(0).getName());
    	
     } 
     @Test
     public void testfindorderbystation() throws RemoteException{
    	 ArrayList<OrderVO> order1=order.orderShowAllByStation( "已执行");
    	 assertEquals("已执行",order1.get(0).getState());
     }
     
     @Test
     public void testfindall() throws RemoteException{
    	 ArrayList<OrderVO> order1=order.showALl();
    	 assertEquals("1",order1.get(0).getId());
     }
    
     
}
