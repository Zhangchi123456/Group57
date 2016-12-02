package presentationController;
import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
    
	@FXML
	private TextField UserId;
	@FXML
	private TextField PassWord;
	@FXML
	private void RegisterClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Registerui();;
	}
	@FXML
	private void SureClicked(ActionEvent event){
		if(UserId.getText().trim().substring(0, 1).equals("1"))
		UiswitchHelper.getApplication().goto_Usermainui();
		if(UserId.getText().trim().substring(0, 1).equals("2"))
			UiswitchHelper.getApplication().goto_HotelMainui();
		if(UserId.getText().trim().substring(0, 1).equals("3"))
			UiswitchHelper.getApplication().goto_UserWebManagementui();
		if(UserId.getText().trim().substring(0, 1).equals("4"))
			UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
