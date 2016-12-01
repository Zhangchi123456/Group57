package org.Hotel.client.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import org.Hotel.client.Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class orderuiController implements Initializable{
    @FXML
    private Button ReturnButton;
    @FXML
    private TableColumn OrderId,OrderInfo,OrderStation;
    @FXML
    private void ReturnClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_HotelMainui();
    }
    @FXML
    
    private void CheckClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_ordeinfoui();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
