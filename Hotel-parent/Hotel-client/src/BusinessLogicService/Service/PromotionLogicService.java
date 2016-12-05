package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.MemberLevelVO;
import vo.CircleVO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public interface PromotionLogicService {

	HotelPromotionVO getHotelPromotion(String hotel_name, String name);

	void updateHotelPromotion(HotelPromotionVO vo);

	void addHotelPromotion(HotelPromotionVO vo);

	ArrayList<HotelPromotionVO> getHotelPromotionList(String name, String hotel_name);

	void addWebPromotion(WebPromotionVO vo);

	ArrayList<WebPromotionVO> getWebPromotionList();

	MemberLevelVO getMemberLevel(int lv);

	void updateMemberLevel(MemberLevelVO vo);

	ArrayList<CircleVO> getCircle(String city_name);

	CircleVO getCircle(String city_name, String circle);

	void updateCircle(CircleVO vo);

	void deleteWebPromotion(WebPromotionVO vo);

	void deleteHotelPromotion(HotelPromotionVO vo);

}
