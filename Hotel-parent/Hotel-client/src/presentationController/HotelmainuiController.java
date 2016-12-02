package presentationController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class HotelmainuiController implements Initializable{
	@FXML
	private Button RoomInfo,Update,Order,HotelInfo,HotelPromotion;
	
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
		// TODO Auto-generated method stub
		
	}

}
