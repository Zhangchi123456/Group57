package org.Hotel.client.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import org.Hotel.client.Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserinformationuiController implements Initializable{
     @FXML
     private Label MembercharacterLabel,MemberlevelLabel,MembercreditvalueLabel;
     
     @FXML
     private TextField MembernameText,PhonenumberText;
     
     @FXML
     private DatePicker BirthdayDatepicker;
     
     @FXML
     private Button ReturnButton,SaveButton;
     
     @FXML
     private void SaveButtonClicked(ActionEvent event){
    	 
     }
     
     @FXML
     private void ReturnButtonClicked(ActionEvent event){
    	 UiswitchHelper.getApplication().goto_Usermainui();
     }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
