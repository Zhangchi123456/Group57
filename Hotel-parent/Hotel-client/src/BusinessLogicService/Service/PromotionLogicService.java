package BusinessLogicService.Service;

import vo.HotelPromotionVO;

public interface PromotionLogicService {

	HotelPromotionVO getHotelPromotion(String hotel_name, String name);

	void updateHotelPromotion(HotelPromotionVO vo);

}
