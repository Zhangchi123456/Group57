package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CreatorderController implements Initializable{
	 private String username,usernum,telephone,roomnum,roomtype,havechild,timebegin,timeend;
	
	
	 @FXML
	 private TextField UserName,UserNum,TelePhone,RoomnumText;//用户名，人数，电话
	 @FXML
	 private ChoiceBox RoomType,Child;//房间类型，有无孩子
	 @FXML
	 private DatePicker TimeBegin,TimeEnd;//开始时间，结束时间
    @FXML
    private void ReturnButtonClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_HotelListui();
    }
    
    @FXML
    private void ConfirmButtonClicked(ActionEvent event){
    	username=UserName.getText();
    	usernum=UserNum.getText();
    	telephone=TelePhone.getText();
    	roomnum=RoomnumText.getText();
    	roomtype=RoomType.getValue().toString();
    	havechild=Child.getValue().toString();
    	timebegin=TimeBegin.getValue().toString();
    	timeend=TimeEnd.getValue().toString();
         UiswitchHelper.getApplication().goto_confirmUi();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
