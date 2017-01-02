package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Test;

import BusinessLogicService.impl.MemberLogicServiceImpl;
import vo.CreditRecordVO;
import vo.MemberVO;

public class MemberLogicServiceImplTest {
        MemberLogicServiceImpl member=new MemberLogicServiceImpl();
        //对根据姓名找会员方法的测试
	@Test
	public void testfindmemberbyname() throws RemoteException {
		MemberVO vo=member.Findmemberbyname("高晓晓");
		assertEquals("1",vo.getlevel());
		assertEquals("1997-12-13",vo.Birthday);
	}
	//返回所有会员的单元测试
	@Test
	public void testMembershowall() throws RemoteException{
		ArrayList<MemberVO> memberlist=member.showall();
		boolean result = false;
		if(memberlist.size()==9){
			result=true;
		}
		
		assertTrue(result);
	}
	//查找信用记录的方法测试
	@Test
	public void testFindcreditbyname() throws RemoteException, ParseException{
		ArrayList<CreditRecordVO> creditlist=member.FindCreditbyname("高晓晓");
		assertEquals(2, creditlist.size());
	}

}
