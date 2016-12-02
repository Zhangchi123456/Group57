package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddHotelStuffController implements Initializable{
	 @FXML
	    private TextField NameText,PhonenumberText;
	    
	    @FXML
	    private PasswordField PasswordText,ConfirmTextField;
	    
	    @FXML
	    private void ReturnButtonClicked(ActionEvent event){
	    	UiswitchHelper.getApplication().goto_UserWebManagementHotelui();
	    }
	    
	    @FXML
	    private void AddButtonClicked(ActionEvent event){
	    	
	    }
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
}
