package BusinessLogicService.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.Hotel.common.dataService.HotelDataService;
import org.Hotel.common.dataService.MemberDataService;
import org.Hotel.common.dataService.PromotionDataService;
import org.Hotel.common.po.CirclePO;
import org.Hotel.common.po.HotelPromotionPO;
import org.Hotel.common.po.WebPromotionPO;

import BusinessLogicService.Service.PromotionLogicService;
import vo.CircleVO;
import vo.HotelPromotionVO;
import vo.MemberLevelVO;
import vo.WebPromotionVO;

public class PromotionLogicServiceImpl implements PromotionLogicService{
	
	PromotionDataService promotiondataservice = null;
	HotelDataService hoteldataservice = null;
	MemberDataService memberdataservice = null;
	
	public PromotionLogicServiceImpl(){
		this.promotiondataservice = (PromotionDataService)RMIHelper.find("PromotionDataService");
		this.hoteldataservice = (HotelDataService)RMIHelper.find("HotelDataService");
		this.memberdataservice = (MemberDataService)RMIHelper.find("MemberDataService");
	}

	@Override
	public void updateHotelPromotion(HotelPromotionVO vo) {
		try{
			promotiondataservice.update(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}

	@Override
	public HotelPromotionVO getHotelPromotion(String hotel_name, String name) {
		
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
		
		try{
			promotiondataservice.insert(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<HotelPromotionVO> getHotelPromotionList(String name, String hotel_name) {
		ArrayList<HotelPromotionVO> voList = new ArrayList<HotelPromotionVO>();
		HotelPromotionVO vo = new HotelPromotionVO();
		try{
			ArrayList<HotelPromotionPO> poList = promotiondataservice.findByHotelProID(hotel_name);
			for(int i=0;i<poList.size();i++){
				if(poList.get(i).getType() == "日期折扣"){
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
		try{
			promotiondataservice.insert(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<WebPromotionVO> getWebPromotionList() {
		
		ArrayList<WebPromotionVO> voList =new ArrayList<WebPromotionVO>();
		WebPromotionVO vo = new WebPromotionVO();

		try{
			ArrayList<WebPromotionPO> poList = promotiondataservice.showAllWebPro(); 
			for(int i=0;i<poList.size();i++){
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
		MemberLevelVO vo = new MemberLevelVO();
		try {
			vo.setByPO(memberdataservice.findLV(lv));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean updateMemberLevel(MemberLevelVO vo) {
		
		try{
			int lv = vo.getLevel();
			if(lv==1){
				if(vo.getCredit()<memberdataservice.findLV(2).getCredit()){
					memberdataservice.update(vo.toPO());
					return true;
				}
			}else if(lv==6){
				if(vo.getCredit()>memberdataservice.findLV(5).getCredit()){
					memberdataservice.update(vo.toPO());
					return true;
				}
			}else{
				if(vo.getCredit()>memberdataservice.findLV(lv-1).getCredit()
						&&vo.getCredit()<memberdataservice.findLV(lv+1).getCredit()){
					memberdataservice.update(vo.toPO());
					return true;
				}
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<CircleVO> getCircle(String city_name) {
		
		ArrayList<CircleVO> voList = new ArrayList<CircleVO>();
		
		try{
			ArrayList<CirclePO> poList = hoteldataservice.circleShowAll(city_name);
			for(int i=0;i<poList.size();i++){
				CircleVO vo = new CircleVO();
				vo.setByPO(poList.get(i));
				voList.add(vo);
			}
			return voList;
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CircleVO getCircle(String city_name, String circle) {
		CircleVO vo = new CircleVO();
		try {
			vo.setByPO(hoteldataservice.circleFind(city_name, circle));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void updateCircle(CircleVO vo) {
		try{
			hoteldataservice.update(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteWebPromotion(WebPromotionVO vo) {
		try{
			promotiondataservice.delete(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteHotelPromotion(HotelPromotionVO vo) {
		try{
			promotiondataservice.delete(vo.toPO());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		
	}

}
