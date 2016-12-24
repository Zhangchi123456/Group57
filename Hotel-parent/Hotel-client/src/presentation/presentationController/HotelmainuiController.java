package presentation.presentationController;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import Controller.HotelmanageController;
import Helper.LoginHelper;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import vo.HotelVO;
import vo.LogVO;
import javafx.scene.control.Button;

public class HotelmainuiController implements Initializable{
	@FXML
	private Button RoomInfo,Update,Order,HotelInfo,HotelPromotion,Return,RoomEntry;//跳转按钮
	
	@FXML
	private Label title,welcome;
     
	@FXML
	private void RoomInfoButtonClicked(ActionEvent event) {
	    UiswitchHelper.getApplication().goto_roomInfoui();
		
	}//房间列表界面
	@FXML
	private void OrderButtonClicked(ActionEvent event) {
	    UiswitchHelper.getApplication().goto_orderui();
	}//订单界面
	@FXML
	private void UpdateButtonClicked(ActionEvent event) {
	    UiswitchHelper.getApplication().goto_updateui();
	}//更新入住界面
	@FXML
	private void HotelInfoButtonClicked(ActionEvent event) {
		UiswitchHelper.getApplication().goto_hotelInfoui();
	}//酒店信息界面
	@FXML
	private void HotelPromotionClicked(ActionEvent event) {
		UiswitchHelper.getApplication().goto_birthdayui();
	}//促销策略界面
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();
	}//返回
	@FXML
	private void RoomEntryButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelRoomEntryui();
	}//输入可用客房
	
	
	@Override//初始化方法
	public void initialize(URL location, ResourceBundle resources) {
		
		HotelStaffLogicService ser = new HotelStaffLogicServiceImpl();
		
		LogVO logvo = LoginHelper.getLogVO();
		String name = logvo.getUsername();

		HotelVO hotelvo;
		
		try {
			hotelvo = ser.findHotel(name);
			HotelmanageController.setHotelvo(hotelvo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
