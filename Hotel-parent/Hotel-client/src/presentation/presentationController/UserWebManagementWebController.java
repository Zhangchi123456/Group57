package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class UserWebManagementWebController implements Initializable{
	String webpromotionName,webpromotionPassword,webpromotionPhonenumber;
    @FXML
    private TextField NameText,PhonenumberText,PasswordText;
    
    @FXML
    private void SaveButtonClicked(ActionEvent event){
    	
    }
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();;
	}
	@FXML
	private void AddHotelMangement(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementHotelui();
	}
	
	@FXML
	private void MemberMangementClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementui();
	}
	@FXML
	private void AddHotelClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddHotelui();
	}
	@FXML
	private void AddButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_AddWebStuffui();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
