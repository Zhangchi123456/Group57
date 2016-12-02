package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
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
     private DatePicker CheckinDatepicker,CheckoutDatePicker;
     
     @FXML
     private void CommitbuttonClicked(ActionEvent event){
    	 
     }
     @FXML
     private void ReturnbuttonClicked(ActionEvent event){
    	 UiswitchHelper.getApplication().goto_Loginui();
     }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
