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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class HotelroomInfouiController implements Initializable{
	@FXML
	private Button ok,back;
	
	@FXML
	private TableView table;
	
	@FXML
	private TableColumn roomNum,RoomInfo,State,Last;
	
	@FXML
	private Label roomList;
     
	@FXML
	private void backButtonClicked(ActionEvent event){
		Parent root = FXMLLoader.load(getClass().getResource("mainui.fxml"));
		
	}
	@FXML
	private void okButtonClicked(ActionEvent event){
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
