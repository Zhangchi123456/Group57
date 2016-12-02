package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class UserWebAddHotelController implements Initializable{
    
	@FXML
	private TextField HotelnameText;
	
	@FXML
	private void AddHotelStuffButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_AddHotelStuffui();
	}
	@FXML
	private void AddRoomClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddRoomui();
	}
	@FXML
	private void AddIntroductionClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddDescriptionui();
	}
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Loginui();;
	}
	@FXML
	private void MemberMangementClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementui();
	}
	
	@FXML
	private void Webmanange(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagermentWebui();
	}
	@FXML
	private void AddHotelMangement(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebManagementHotelui();
	}
	@FXML
	private void AddRoom(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddRoomui();
	}
	@FXML
	private void AddDescription(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebAddDescriptionui();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
