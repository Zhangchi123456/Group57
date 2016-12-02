package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class UserWebPromotionMainController implements Initializable{
    @FXML
    private Button CreditChargeButton,AbnormalOrderDealButton,ReturnButton;
    
    @FXML
    private void CreditChargeClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_Creditchargeui();
    }
    
    @FXML
    private void AbnormalOrderDealClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_abnormalorderui();
    }
    @FXML
    private void WebPromotionClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_webdiscoutdatenui();
    }
    @FXML
    private void ReturnClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_Loginui();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
