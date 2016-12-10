package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import Controller.HotelmanageController;
import Helper.LoginHelper;
import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import vo.HotelVO;
import vo.LogVO;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class HotelmainuiController implements Initializable{
	@FXML
	private Button RoomInfo,Update,Order,HotelInfo,HotelPromotion,Return;
	
	@FXML
	private Label title,welcome;
     
	@FXML
	private void RoomInfoButtonClicked(ActionEvent event) {
	    UiswitchHelper.getApplication().goto_roomInfoui();
		
	}
	@FXML
	private void OrderButtonClicked(ActionEvent event) {
	    UiswitchHelper.getApplication().goto_orderui();
	}
	@FXML
	private void UpdateButtonClicked(ActionEvent event) {
	    UiswitchHelper.getApplication().goto_updateui();
	}
	@FXML
	private void HotelInfoButtonClicked(ActionEvent event) {
		UiswitchHelper.getApplication().goto_hotelInfoui();
	}
	@FXML
	private void HotelPromotionClicked(ActionEvent event) {
		UiswitchHelper.getApplication().goto_birthdayui();
	}
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();
	}
	
	
	@Override
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
