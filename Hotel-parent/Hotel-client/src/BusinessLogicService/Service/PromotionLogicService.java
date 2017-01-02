package BusinessLogicService.Service;

import java.util.ArrayList;

import vo.MemberLevelVO;
import vo.CircleVO;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public interface PromotionLogicService {

	HotelPromotionVO getHotelPromotion(String hotel_name, String name);//根据会员名和策略名来找到酒店营销策略
	
	void updateHotelPromotion(HotelPromotionVO vo);//更新酒店营销策略
	
	void addHotelPromotion(HotelPromotionVO vo);//添加酒店营销策略
	
	ArrayList<HotelPromotionVO> getHotelPromotionList(String name, String hotel_name);//根据酒店名和策略名来找到酒店营销列表

	void addWebPromotion(WebPromotionVO vo);//添加网站营销策略

	ArrayList<WebPromotionVO> getWebPromotionList();//得到网站营销策略列表

	MemberLevelVO getMemberLevel(int lv);//根据等级数得到会员等级对象

	boolean updateMemberLevel(MemberLevelVO vo);//更新会员等级

	ArrayList<CircleVO> getCircle(String city_name);//得到商圈列表

	CircleVO getCircle(String city_name, String circle);//通过城市名和商圈名得到商圈vo

	void updateCircle(CircleVO vo);//更新商圈

	void deleteWebPromotion(WebPromotionVO vo);//删除网站营销策略

	void deleteHotelPromotion(HotelPromotionVO vo);//删除酒店营销策略

}
