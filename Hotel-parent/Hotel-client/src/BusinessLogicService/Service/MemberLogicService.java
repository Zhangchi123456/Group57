package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import org.Hotel.common.po.CreditPO;

import vo.CreditRecordVO;
import vo.MemberLevelVO;
import vo.MemberVO;

public interface MemberLogicService {
	//更新会员信息的方法
        public boolean updateMemberinfo(MemberVO vo);
    //通过会员名找到会员信息
        public MemberVO Findmemberbyname(String name) ;
    //展示所有会员
        public ArrayList<MemberVO> showall();
    //通过会员名字找到会员信用记录的方法
        public ArrayList<CreditRecordVO> FindCreditbyname(String name);
    //通过订单号找到信用记录
        public CreditRecordVO findCreditRecord(int orderid);
    //生成信用记录
        public boolean addCreditRecord(CreditRecordVO vo) ;
    //获得会员名字的列表  
        public ArrayList<String> getnamelist();
    //更新会员的等级
        public void updatelevel(MemberVO member);
}
