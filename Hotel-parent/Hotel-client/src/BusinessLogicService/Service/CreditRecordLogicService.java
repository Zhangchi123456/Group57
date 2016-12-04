package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.CreditRecordVO;

public interface CreditRecordLogicService {
	    //通过用户名查找信用记录列表；
        public ArrayList<CreditRecordVO> findbyMembername(String membername);
}
