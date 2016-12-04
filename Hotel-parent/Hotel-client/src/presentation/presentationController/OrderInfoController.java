package presentation.presentationController;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import vo.OrderVO;

public class OrderInfoController implements Initializable {
	@FXML
	private Label OrderId,HotelName,UserNum,Child,Telephone,RoomType,TimeBegin,TimeEnd,RoomnumLabel,RTotalpriceLabel,UserName;
    
	@FXML
	private void ConfirmClicked(ActionEvent event){
	
	
		UiswitchHelper.getApplication().goto_Usermainui();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
