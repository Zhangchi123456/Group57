package org.Hotel.client.presertationController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

public class HotelListuiController implements Initializable{
	@FXML
	private ChoiceBox SortChoicebox;
	
	@FXML
	private CheckBox ReservationCheckbox;
	
	@FXML
	private Button ReturnButton;
	
    @FXML
    private void SortChoiceboxClicked(ActionEvent event){
    	
    }
    
    @FXML
    private void ReturnButton(ActionEvent event){
    	
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
