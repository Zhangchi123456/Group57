package BusinessLogicService.Service;

import java.util.ArrayList;

import org.Hotel.common.po.WebStaffPO;

import vo.WebStaffVO;

public interface UserLogicService {
	
	
	public ArrayList<WebStaffVO> findWebStaff();
	
	public void saveWebStaff(WebStaffVO vo);
	
	public boolean findWebStaffBYName(String name);
	
	public boolean addWebStaff(WebStaffVO vo);

}
