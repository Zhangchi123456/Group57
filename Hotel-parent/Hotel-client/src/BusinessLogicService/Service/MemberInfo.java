package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.po.MemberPO;

import vo.MemberLevelVO;
import vo.MemberVO;

public interface MemberInfo {
	
    //通过会员名得到会员信息
	public MemberPO findMemberByName(String name);
	//展示所有会员
	public ArrayList<MemberVO> showall()throws RemoteException ;
	//保存会员信息
	public void saveMember(MemberVO vo);
	//更新会员等级
	public boolean updateMemberLevel(MemberLevelVO vo);
	//得到会员等级
	public MemberLevelVO getMemberLevel(int lv);
	
}
