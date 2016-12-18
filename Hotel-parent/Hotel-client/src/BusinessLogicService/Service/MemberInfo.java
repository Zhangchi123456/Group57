package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.MemberPO;

import vo.MemberLevelVO;
import vo.MemberVO;

public interface MemberInfo {
	public MemberPO findMemberByName(String name);
	public ArrayList<MemberVO> showall()throws RemoteException ;
	public void saveMember(MemberVO vo);
	public boolean updateMemberLevel(MemberLevelVO vo);
	public MemberLevelVO getMemberLevel(int lv);
}
