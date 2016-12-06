package BusinessLogicService.impl;

import java.util.ArrayList;

import org.Hotel.common.dataService.PromotionDataService;

import BusinessLogicService.Service.PromotionLogicService;
import vo.CircleVO;
import vo.HotelPromotionVO;
import vo.MemberLevelVO;
import vo.WebPromotionVO;

public class PromotionLogicServiceImpl implements PromotionLogicService{
	
	PromotionDataService promtiondata = null;
	
	public PromotionLogicServiceImpl(){
		this.promtiondata = (PromotionDataService)RMIHelper.find("PromotionDataService");
	}

	@Override
	public void updateHotelPromotion(HotelPromotionVO vo) {
		
		
	}

	@Override
	public HotelPromotionVO getHotelPromotion(String hotel_name, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<HotelPromotionVO> getHotelPromotionList(String name, String hotel_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addWebPromotion(WebPromotionVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<WebPromotionVO> getWebPromotionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberLevelVO getMemberLevel(int lv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateMemberLevel(MemberLevelVO vo) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<CircleVO> getCircle(String city_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CircleVO getCircle(String city_name, String circle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCircle(CircleVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWebPromotion(WebPromotionVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		
	}

}
