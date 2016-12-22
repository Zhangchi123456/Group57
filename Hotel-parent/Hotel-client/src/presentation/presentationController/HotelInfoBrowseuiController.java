package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.ReservationLogicService;
import BusinessLogicService.impl.ReservationLogicServiceImpl;
import Controller.ReservationController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import vo.HotelPromotionVO;
import vo.HotelVO;

public class HotelInfoBrowseuiController implements Initializable{
	private HotelVO hotelvo;
	@SuppressWarnings("unused")
	private HotelPromotionVO hotelpromotion;
	private ReservationLogicService reservationService=new ReservationLogicServiceImpl();
	@FXML
	private Button formOrder,Back,myOrder,Checkbenefit;	//跳转的按钮
	@FXML
	private Label hotelName,Star,introduction,address,SingleLabel,StandardLabel,FamilyLabel,SuiteLabel;
	// 持有的各个label用以显示信息。
	@FXML
	private void ReturnButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelListui();
	}
	@FXML
	private void MyorderButtoncClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_OrderListUi();
	}
	@FXML
	private void CreatorderButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_OrderinputUi();
	}
	@FXML
	private void CheckbenefitClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_benefitui();
	}
	 //初始化方法
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	hotelvo=ReservationController.getCurrentHotelvo();
	
	ArrayList<HotelPromotionVO> prolist=reservationService.findhotelpro(hotelvo.getName());
	ReservationController.setHotelproList(prolist);
	
	hotelName.setText(hotelvo.getName());
	Star.setText(String.valueOf(hotelvo.getStar()));
	address.setText(hotelvo.getAddress());
	SingleLabel.setText(String.valueOf(hotelvo.getSingleRoomPrice()));
	
	
	StandardLabel.setText(String.valueOf(hotelvo.getStandardRoomPrice()));
	FamilyLabel.setText(String.valueOf(hotelvo.getFamilyRoomPrice()));
	SuiteLabel.setText(String.valueOf(hotelvo.getSuiteRoomPrice()));
		

}
}