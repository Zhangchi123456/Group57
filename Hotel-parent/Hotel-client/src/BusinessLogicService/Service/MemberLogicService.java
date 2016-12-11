package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import vo.CreditRecordVO;
import vo.MemberVO;

public interface MemberLogicService {
        public boolean updateMemberinfo(MemberVO vo) throws ParseException, RemoteException;
        
        public MemberVO Findmemberbyname(String name) throws RemoteException;
        public ArrayList<MemberVO> showall()throws RemoteException;
        public ArrayList<CreditRecordVO> FindCreditbyname(String name) throws RemoteException, ParseException;
}
