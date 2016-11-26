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

public class HotelInfoBrowseuiController implements Initializable{
	@FXML
	private Button formOrder,Back,myOrder;
	
	@FXML
	private ChoiceBox Startx;
	
	@FXML
	private TextField hotelNametx,Provincetx,detailAddresstx,introductiontx,Blocktx,Citytx;
	
	@FXML
	private Label hotelInfo,hotelName,Address,Province,City,Block,Star,introduction,welcome;
     
	@FXML
	private void backButtonClicked(ActionEvent event){
		
	}
	@FXML
	private void myOrderButtonClicked(ActionEvent event){
		
	}
	@FXML
	private void formOrderButtonClicked(ActionEvent event){
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
