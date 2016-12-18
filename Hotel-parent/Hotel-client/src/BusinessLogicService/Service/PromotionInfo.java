package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.HotelPromotionVO;

public interface PromotionInfo {
	public void addHotelStrategy(HotelPromotionVO vo);

	ArrayList<HotelPromotionVO> findhotelpro(String name);
}
