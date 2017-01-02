package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.HotelPromotionVO;
import vo.MemberLevelVO;
import vo.WebPromotionVO;

public interface PromotionInfo {
	
	public void addHotelPromotion(HotelPromotionVO vo);//添加酒店营销策略

	ArrayList<HotelPromotionVO> findhotelpro(String name);//根据姓名查找酒店营销策略
	
	ArrayList<WebPromotionVO> getWebPromotionList();//得到营销策略列表
	
	MemberLevelVO getMemberLevel(int lv);//根据级别得到会员等级数
}
