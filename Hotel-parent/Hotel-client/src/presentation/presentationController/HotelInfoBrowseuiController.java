package presentation.presentationController;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.ReservationLogicService;
import BusinessLogicService.impl.ReservationLogicServiceImpl;
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
import vo.WebPromotionVO;

public class HotelInfoBrowseuiController implements Initializable{
	private HotelVO hotelvo;
	private HotelPromotionVO hotelpromotion;
	private ReservationLogicService reservationService=new ReservationLogicServiceImpl();
	@FXML
	private Button formOrder,Back,myOrder,Checkbenefit;	//跳转的按钮
	@FXML
	private Label hotelName,Star,introduction,address,SingleLabel,StandardLabel,FamilyLabel,SuiteLabel;
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
	ArrayList<WebPromotionVO> weblist=reservationService.showall();
	ReservationController.setWebpromotionvolist(weblist);
	try {
		ArrayList<HotelPromotionVO> prolist=reservationService.findhotelpro(hotelvo.getName());
		ReservationController.setHotelproList(prolist);
		
		hotelName.setText(hotelvo.getName());
		Star.setText(String.valueOf(hotelvo.getStar()));
		address.setText(hotelvo.getAddress());
		SingleLabel.setText(String.valueOf(hotelvo.getSingleRoomPrice()));
		StandardLabel.setText(String.valueOf(hotelvo.getStandardRoomPrice()));
	    FamilyLabel.setText(String.valueOf(hotelvo.getFamilyRoomPrice()));
	    SuiteLabel.setText(String.valueOf(hotelvo.getSuiteRoomPrice()));
	    
	
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

}
}