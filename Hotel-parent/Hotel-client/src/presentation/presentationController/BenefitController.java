package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class BenefitController implements Initializable{
     @FXML
     private Label hotel1,hotel2,hotel3,hotel4,hotel5,web1,web2,web3;
     
     @FXML
     private void ReturnClicked(ActionEvent event){
    	 UiswitchHelper.getApplication().goto_hotelInfoBrowseui();
     }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
