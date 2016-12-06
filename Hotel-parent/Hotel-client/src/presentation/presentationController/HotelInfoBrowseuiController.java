package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicService.Service.ReservationLogicService;
import Controller.ReservationController;
import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import vo.HotelPromotionVO;
import vo.HotelVO;

public class HotelInfoBrowseuiController implements Initializable{
	private HotelVO hotelvo;
	private HotelPromotionVO hotelpromotion;
	private ReservationLogicService reservationService;
	@FXML
	private Button formOrder,Back,myOrder;	//跳转的按钮
	@FXML
	private Label hotelName,Star,introduction,address,SingleLabel,StandardLabel,FamilyLabel,SuiteLabel,benefit;
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
	 //初始化方法
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	/*  hotelvo=ReservationController.getCurrentHotelvo();
		hotelpromotion=ReservationController.getHotelPromotionvo();
		hotelName.setText(hotelvo.getName());
		Star.setText(String.valueOf(hotelvo.getStar()));
		address.setText(hotelvo.getAddress());
		SingleLabel.setText(String.valueOf(hotelvo.getSingleRoomPrice()));
		StandardLabel.setText(String.valueOf(hotelvo.getStandardRoomPrice()));
	    FamilyLabel.setText(String.valueOf(hotelvo.getFamilyRoomPrice()));
	    SuiteLabel.setText(String.valueOf(hotelvo.getSuiteRoomPrice()));
	    benefit.setText("日期优惠："+String.valueOf(hotelpromotion.getStartDate())+"-"+String.valueOf(hotelpromotion.getEndDate())+" 折扣值："+String.valueOf(hotelpromotion.getDateDiscount())
	    		+"3间以上优惠： "+String.valueOf(hotelpromotion.getMultiorderDiscount()));
		*/
	}

}
