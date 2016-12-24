package test;

import org.junit.Test;

import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.impl.PromotionLogicServiceImpl;
import junit.framework.TestCase;

public class PromotionLogicServiceImplTest extends TestCase {
	
	PromotionLogicService promotion = new PromotionLogicServiceImpl();
	
	@Test
	public void test1(){
		assertTrue("南行酒店".equals(promotion.getHotelPromotion("南行酒店", "生日折扣").getHotelName()));
	}
	
	@Test
	public void test2(){
		assertEquals(1000,promotion.getMemberLevel(2).getCredit());
	}
	
	@Test
	public void test3(){
		assertEquals("王府井商圈",promotion.getCircle("北京","王府井商圈").getName());
	}
	
	@Test
	public void test4(){
		assertEquals("南行酒店",promotion.getHotelPromotionList("日期折扣","南行酒店").get(0).getHotelName());
	}
	
	@Test
	public void test5(){
		assertEquals("北京",promotion.getCircle("北京").get(0).getCity());
	}

}
