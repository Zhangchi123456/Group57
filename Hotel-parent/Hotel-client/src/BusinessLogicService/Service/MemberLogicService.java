package BusinessLogicService.Service;

import java.rmi.RemoteException;
import java.text.ParseException;

import vo.MemberVO;

public interface MemberLogicService {
        public boolean updateMemberinfo(MemberVO vo) throws ParseException, RemoteException;
}
