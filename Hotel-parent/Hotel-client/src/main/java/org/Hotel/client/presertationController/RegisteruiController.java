package org.Hotel.client.presertationController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisteruiController implements Initializable {
     @FXML
     private TextField NameText,PhonenumberText;
     
     @FXML
     private PasswordField PasswordText,PasswordconfirmText;
     
     @FXML
     private CheckBox MemberCheckbox,CompanyCheckbox;
     
     @FXML
     private Button CommitButton,ReturnButton;
     
     @FXML
     private DatePicker CheckinDatepicker,CheckoutDatePicker;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
