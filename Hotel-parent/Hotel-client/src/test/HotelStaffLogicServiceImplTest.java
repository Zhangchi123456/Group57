package test;


import org.junit.Test;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import junit.framework.TestCase;

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
			assertTrue("南行酒店".equals(hls.FindRoomByID("南行酒店",1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test4(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID("南行酒店",1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test5(){
		try {
			assertTrue("南行酒店".equals(hls.FindRoomByID("南行酒店",1).getHotelid()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
