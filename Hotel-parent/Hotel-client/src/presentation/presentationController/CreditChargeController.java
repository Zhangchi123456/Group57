package presentation.presentationController;
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
import presentation.userui.AlertBox;

public class CreditChargeController implements Initializable{
	private String Username,Chargenum;
	
    @FXML
    private TextField UsernameText,ChargenumText;
    
    
    @FXML
    private void ConfirmClicked(ActionEvent event){
    	if(!AllIsfilled()){
    		AlertBox alt = new AlertBox();
			alt.display("请将用户名和金额填写完整");
    	}else if(!Ischargereasonable()){
    		AlertBox alt2 = new AlertBox();
			alt2.display("充值金额必须大于0元");
    	}else{
    		Username=UsernameText.getText().toString();
    		Chargenum=ChargenumText.getText().toString();
    	}
    	
    }
    
    private boolean AllIsfilled(){
    	if(UsernameText.getText().toString().equals(null)||ChargenumText.getText().isEmpty()){
    		return false;
    	}
    	return true;
    }
    
    private boolean Ischargereasonable(){
    	if(Integer.parseInt(ChargenumText.getText().toString())<=0){
    		return false;
    	}
    	return true;
    }
	@FXML
	private void ReturnButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}