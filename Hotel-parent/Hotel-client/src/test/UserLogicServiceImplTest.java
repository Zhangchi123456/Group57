package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.dataService.UserDataService;
import org.Hotel.common.po.HotelStaffPO;
import org.Hotel.common.po.WebManagerPO;
import org.Hotel.common.po.WebStaffPO;
import org.junit.Test;

import BusinessLogicService.impl.PromotionLogicServiceImpl;
import BusinessLogicService.impl.RMIHelper;
import BusinessLogicService.impl.UserLogicServiceImpl;
import junit.framework.TestCase;
import vo.*;

public class UserLogicServiceImplTest {
	UserLogicServiceImpl userbl=new UserLogicServiceImpl();
	
	
	@Test
	public void testFindWebStaff1() {
		ArrayList<WebStaffVO> list=userbl.findWebStaff();
		
		WebStaffVO vo=userbl.findWebStaff().get(0);
		
		WebStaffVO vo1=new WebStaffVO("ninini","123456");
		
		assertNotEquals(vo1.getName(),vo.getName());
	}
	@Test
	public void testFindWebStaffByName2() {
		
		boolean bool=userbl.findWebStaffBYName("老王");
		assertEquals(true,bool);
	}
	@Test
	public void testFindWebStaffByName3() {
		boolean bool=userbl.findWebStaffBYName("老");
		assertEquals(false,bool);
	}
	@Test
	public void testFindWebStaffByName4() {
		boolean bool=userbl.findWebStaffBYName("ninini");
		assertEquals(false,bool);
	}
	@Test
	public void testFindWebStaffByName5() {
		boolean bool=userbl.findWebStaffBYName("大冰");
		assertEquals(true,bool);
	}
	@Test
	public void addWebStaff1() {
		WebStaffVO vo=new WebStaffVO("刑天","123456789");
		boolean bool=userbl.addWebStaff(vo);
		assertEquals(false,bool);
	}
	@Test
	public void addWebStaff2() {
		WebStaffVO vo=new WebStaffVO("老王","123456789");
		boolean bool=userbl.addWebStaff(vo);
		assertEquals(false,bool);
	}
	@Test
	public void testFindHotelStaff1() {
		ArrayList<HotelStaffVO> list=userbl.findHotelStaff();
		
		HotelStaffVO vo=userbl.findHotelStaff().get(3);
		
		HotelStaffVO vo1=new HotelStaffVO("狐狸","123456","南行酒店");
		
		assertNotEquals(vo1.getName(),vo.getName());
	}
	@Test
	public void testFindHotelStaff2() {
		ArrayList<HotelStaffVO> list=userbl.findHotelStaff();
		
		HotelStaffVO vo=userbl.findHotelStaff().get(3);
		
		HotelStaffVO vo1=new HotelStaffVO("meiren","dagougou","南行酒店");
		
		assertNotEquals(vo1.getName(),vo.getName());
	}
	@Test
	public void testFindMember1() {
		ArrayList<MemberVO> list=userbl.findMember();
		
		boolean bool=false;
		for(MemberVO vo:list){
			if(vo.getname().contains("高晓晓"))
			{
				bool=true;
			}
		}
		
		assertEquals(true,bool);
	}
	@Test
	public void testFindMember2() {
		ArrayList<MemberVO> list=userbl.findMember();
		
		boolean bool=false;
		for(MemberVO vo:list){
			if(vo.getname().contains("庄状"))
			{
				bool=true;
			}
		}
		
		assertEquals(false,bool);
	}
	@Test
	public void testFindMember3() {
		ArrayList<MemberVO> list=userbl.findMember();
		
		boolean bool=false;
		for(MemberVO vo:list){
			if(vo.getname().contains("wuren"))
			{
				bool=true;
			}
		}
		
		assertEquals(false,bool);
	}

}
