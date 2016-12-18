package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.HotelPromotionVO;
import vo.MemberLevelVO;
import vo.WebPromotionVO;

public interface PromotionInfo {
	
	public void addHotelPromotion(HotelPromotionVO vo);

	ArrayList<HotelPromotionVO> findhotelpro(String name);
	
	ArrayList<WebPromotionVO> getWebPromotionList();
	
	MemberLevelVO getMemberLevel(int lv);
}
