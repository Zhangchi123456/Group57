package org.Hotel.client.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import org.Hotel.client.Helper.UiswitchHelper;
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

public class MyHotelOrderuiController implements Initializable{
	@FXML
	private Button ReturnButton;
	@FXML
	private TextField HotelName;
	@FXML
	private TextField HotelDescription;
	@FXML
	private TextField HotelAddress;
	@FXML
	private ChoiceBox HotelStar;
	
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Usermainui();
	}
	@FXML
	private void RefrashClicked(ActionEvent event){
	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}