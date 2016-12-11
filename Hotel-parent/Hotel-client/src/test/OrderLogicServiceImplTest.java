package test;


import static org.junit.Assert.*;

import org.junit.Test;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import junit.framework.TestCase;
import vo.HotelPromotionVO;
import vo.OrderVO;

public class OrderLogicServiceImplTest {
	
	OrderLogicServiceImpl Order = new OrderLogicServiceImpl();
	
	@Test
	public void test1(){
		OrderVO vo = new OrderVO();
	
		assertTrue(Order.input(vo));
		
	}
	@Test
	public void test2(){
		OrderVO vo = new OrderVO();
	
		assertTrue(Order.evaluate(vo.getId(), vo.getGrade(), vo.getComment()));
		
	}

}
