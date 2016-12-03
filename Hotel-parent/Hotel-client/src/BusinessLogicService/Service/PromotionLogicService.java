package BusinessLogicService.Service;

import vo.HotelPromotionVO;

public interface PromotionLogicService {

	HotelPromotionVO getHotelPromotion(int id, String name);

	void updateHotelPromotion(HotelPromotionVO vo);

}
