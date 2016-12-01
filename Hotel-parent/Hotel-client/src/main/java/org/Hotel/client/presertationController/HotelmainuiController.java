package org.Hotel.client.presertationController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
	private Button RoomInfo,Update,Order,HotelInfo;
	
	@FXML
	private Label title,welcome;
     
	@FXML
	private void RoomInfoButtonClicked(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("roomInfoui.fxml"));
		
	}
	
	private void OrderButtonClicked(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("orderui.fxml"));
	}
	
	private void UpdateButtonClicked(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("updateui.fxml"));
	}
	
	private void HotelInfoButtonClicked(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("hotelInfo.fxml"));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
