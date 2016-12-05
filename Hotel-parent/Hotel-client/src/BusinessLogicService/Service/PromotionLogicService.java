package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public interface PromotionLogicService {

	HotelPromotionVO getHotelPromotion(String hotel_name, String name);

	void updateHotelPromotion(HotelPromotionVO vo);

	void addHotelPromotion(HotelPromotionVO vo);

	ArrayList<HotelPromotionVO> getHotelPromotionList(String name, String hotel_name);

	void addWebPromotion(WebPromotionVO vo);

	ArrayList<WebPromotionVO> getWebPromotionList();

}
