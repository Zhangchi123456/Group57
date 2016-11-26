package org.Hotel.client.presertationController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class UsermainuiController implements Initializable{
	@FXML
	private Label memebernamelabel;
	
	@FXML
	private ChoiceBox ProvinceChoicebox,CityChoicebox,RoomtypeChoicebox,RoomnumChoicebox,HotelstarChoicebox,HotelgradeChoicebox,HotelpriceChoicebox;
	   
	@FXML
	private DatePicker CheckinDatepicker,CheckoutDatepicker;
     
	@FXML
	private void ProvinceChoiceClicked(ActionEvent event){
		
	}
	@FXML
	private void RoomtypeChoiceClicked(ActionEvent event){
		ObservableList T=FXCollections.observableArrayList("大床房","标准间","家庭房","套房");
		RoomtypeChoicebox.setItems(T);
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
