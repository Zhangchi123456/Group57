package test;


import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import BusinessLogicService.impl.PromotionLogicServiceImpl;
import junit.framework.TestCase;
import vo.RoomVO;

public class HotelStaffLogicServiceImplTest extends TestCase{

	HotelStaffLogicService hls = new HotelStaffLogicServiceImpl();
	
	@Test
	public void test1(){
		try {
			assertTrue("南行酒店".equals(hls.findHotel("狐狸").getName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		try {
			assertTrue("1".equals(hls.CreditFindByorder(1).getOrderid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test4(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test5(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void test6(){
		try {
			assertTrue("南行酒店".equals(hls.findHotel("狐狸").getName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test7(){
		try {
			assertTrue("1".equals(hls.CreditFindByorder(1).getOrderid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test8(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test9(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test10(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test11(){
		try {
			assertTrue("南行酒店".equals(hls.findHotel("狐狸").getName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test12(){
		try {
			assertTrue("1".equals(hls.CreditFindByorder(1).getOrderid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test13(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test14(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test15(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void test16(){
		try {
			assertTrue("南行酒店".equals(hls.findHotel("狐狸").getName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test17(){
		try {
			assertTrue("1".equals(hls.CreditFindByorder(1).getOrderid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test18(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test19(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test20(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void test21(){
		try {
			assertTrue("南行酒店".equals(hls.findHotel("狐狸").getName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test22(){
		try {
			assertTrue("1".equals(hls.CreditFindByorder(1).getOrderid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test23(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test24(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test25(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void test26(){
		try {
			assertTrue("南行酒店".equals(hls.findHotel("狐狸").getName()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test27(){
		try {
			assertTrue("1".equals(hls.CreditFindByorder(1).getOrderid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
