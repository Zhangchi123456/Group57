package org.Hotel.client.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import org.Hotel.client.Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CreatorderController implements Initializable{
    @FXML
    private void ReturnButtonClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_HotelListui();
    }
    
    @FXML
    private void ConfirmButtonClicked(ActionEvent event){
         UiswitchHelper.getApplication().goto_confirmUi();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
