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
        public boolean updateMemberinfo(MemberVO vo) throws ParseException, RemoteException;
    //通过会员名找到会员信息
        public MemberVO Findmemberbyname(String name) throws RemoteException;
    //展示所有会员
        public ArrayList<MemberVO> showall()throws RemoteException;
    //通过会员名字找到会员信用记录的方法
        public ArrayList<CreditRecordVO> FindCreditbyname(String name) throws RemoteException, ParseException;
    //通过订单号找到信用记录
        public CreditRecordVO findCreditRecord(int orderid) throws RemoteException;
    //生成信用记录
        public boolean addCreditRecord(CreditRecordVO vo) throws ParseException, RemoteException;
    //获得会员名字的列表  
        public ArrayList<String> getnamelist() throws RemoteException;
     
        public void updatelevel(MemberVO member);
}
