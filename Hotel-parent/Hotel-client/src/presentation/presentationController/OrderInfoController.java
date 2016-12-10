package presentation.presentationController;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.Service.ReservationLogicService;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import BusinessLogicService.impl.ReservationLogicServiceImpl;
import Controller.MemberActController;
import Controller.ReservationController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import vo.OrderVO;

public class OrderInfoController implements Initializable {
	@FXML
	private Label HotelName,UserNum,Child,RoomType,TimeBegin,TimeEnd,RoomnumLabel,TotalpriceLabel;
    
	@FXML
	private void ConfirmClicked(ActionEvent event){
	
		UiswitchHelper.getApplication().goto_Usermainui();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	ReservationLogicService res = new ReservationLogicServiceImpl();
	OrderVO vo =	ReservationController.getOrdervo();
  
	HotelName.setText(ReservationController.getCurrentHotelvo().getName());
	UserNum.setText(String.valueOf(vo.getPeoplenum()));
	Child.setText(vo.isHavekids());
	if(Integer.parseInt(vo.getFamilyRoom())!=0){
		RoomType.setText("家庭房");		
	}
	if(Integer.parseInt(vo.getSingleRoom())!=0){
		RoomType.setText("单人房");		
	}
	if(Integer.parseInt(vo.getStandardRoom())!=0){
		RoomType.setText("标准间");		
	}
	if(Integer.parseInt(vo.getSuiteRoom())!=0){
		RoomType.setText("套间");		
	}
	TimeBegin.setText(vo.getStarttime());
	TimeEnd.setText(vo.getLeavetime());
	TotalpriceLabel.setText("100");
	vo.setPrice(TotalpriceLabel.getText());
	}
}
