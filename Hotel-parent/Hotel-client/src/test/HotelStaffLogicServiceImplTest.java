package test;


import static org.junit.Assert.*;

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
		assertTrue("南行酒店".equals(hls.findHotel("狐狸").getName()));
	}
	
	@Test
	public void test2(){
		assertTrue("1".equals(hls.CreditFindByorder(1).getOrderid()));
	}
	
	@Test
	public void test3(){
		assertTrue("南行酒店".equals(hls.FindRoomByID(1).getHotelid()));
	}

}
