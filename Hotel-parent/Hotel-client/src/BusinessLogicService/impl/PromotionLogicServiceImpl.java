package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.dataService.PromotionDataService;
import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.WebPromotionPO;

import BusinessLogicService.Service.HotelInfo;
import BusinessLogicService.Service.MemberInfo;
import BusinessLogicService.Service.PromotionInfo;
import BusinessLogicService.Service.PromotionLogicService;
import vo.CircleVO;
import vo.HotelPromotionVO;
import vo.MemberLevelVO;
import vo.WebPromotionVO;

public class PromotionLogicServiceImpl implements PromotionLogicService,PromotionInfo{
	
	PromotionDataService promotiondataservice = null;
	HotelInfo hotelinfo = null;
	MemberInfo memberinfo = null;
	
	public PromotionLogicServiceImpl(){
		this.promotiondataservice = (PromotionDataService)RMIHelper.find("PromotionDataService");
		this.hotelinfo = new HotelStaffLogicServiceImpl();
		this.memberinfo = new MemberLogicServiceImpl();
	}

	@Override
	public void updateHotelPromotion(HotelPromotionVO vo) {
	//更新酒店促销策略
		try{
			promotiondataservice.update(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<HotelPromotionVO> findhotelpro(String name){
		//根据酒店名返回促销策略列表
		ArrayList<HotelPromotionVO> hotelprolist2 = new ArrayList<HotelPromotionVO>();
		try{
			ArrayList<HotelPromotionPO> hotelprolist=promotiondataservice.findByHotelProID(name);
			for(int i=0;i<hotelprolist.size();i++){
				HotelPromotionVO vo=new HotelPromotionVO();
				vo.setByPO(hotelprolist.get(i));
				hotelprolist2.add(vo);
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return hotelprolist2;
	 }


	@Override
	public HotelPromotionVO getHotelPromotion(String hotel_name, String name) {
	//根据酒店名与策略名获取已有促销策略	
		HotelPromotionVO vo = new HotelPromotionVO();
		try{
			vo.setByPO(promotiondataservice.findByHotelProType(name, hotel_name));
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void addHotelPromotion(HotelPromotionVO vo) {
	//新增酒店促销策略	
		try{
			promotiondataservice.insert(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<HotelPromotionVO> getHotelPromotionList(String name, String hotel_name) {
	//根据酒店名与策略名获取已有促销策略
		ArrayList<HotelPromotionVO> voList = new ArrayList<HotelPromotionVO>();
		try{
			ArrayList<HotelPromotionPO> poList = promotiondataservice.findByHotelProID(hotel_name);
			for(int i=0;i<poList.size();i++){
				if(poList.get(i).getType().equals(name)){
					HotelPromotionVO vo = new HotelPromotionVO();
					vo.setByPO(poList.get(i));
					voList.add(vo);
				}
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return voList;
	}

	@Override
	public void addWebPromotion(WebPromotionVO vo) {
	//新增网站促销策略
		try{
			promotiondataservice.insert(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<WebPromotionVO> getWebPromotionList() {
	//获取已有网站促销策略	
		ArrayList<WebPromotionVO> voList =new ArrayList<WebPromotionVO>();
		
		try{
			ArrayList<WebPromotionPO> poList = promotiondataservice.showAllWebPro(); 
			for(int i=0;i<poList.size();i++){
				WebPromotionVO vo = new WebPromotionVO();
				vo.setByPO(poList.get(i));
				voList.add(vo);
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return voList;
		
	}

	@Override
	public MemberLevelVO getMemberLevel(int lv) {
	//获取会员级别对应信息
		return memberinfo.getMemberLevel(lv);
	}

	@Override
	public boolean updateMemberLevel(MemberLevelVO vo) {
	//更新会员级别信息	
		return memberinfo.updateMemberLevel(vo);
	}

	@Override
	public ArrayList<CircleVO> getCircle(String city_name) {
	//根据城市名获取商圈列表	
		return hotelinfo.getCircle(city_name);
	}

	@Override
	public CircleVO getCircle(String city_name, String circle) {
	//获取商圈的折扣信息
		return hotelinfo.getCircle(city_name, circle);
	}

	@Override
	public void updateCircle(CircleVO vo) {
	//更新商圈折扣信息
		hotelinfo.updateCircle(vo);
	}

	@Override
	public void deleteWebPromotion(WebPromotionVO vo) {
	//删除网站营销策略
		try{
			promotiondataservice.delete(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteHotelPromotion(HotelPromotionVO vo) {
	//删除酒店营销策略
		try{
			promotiondataservice.delete(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		
	}

	//add hotel promotion strategy
	@Override
	public void addHotelStrategy(HotelPromotionVO vo) {
		HotelPromotionPO po=vo.toPO();
		try{
			promotiondataservice.insert(po);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
