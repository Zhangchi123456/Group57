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
import presentation.userui.AlertBox;

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
    	if(!Allisfilled()){
    		AlertBox alt = new AlertBox();
			alt.display("信息填写不全");
    	}else if(!Isdateright()){
    		AlertBox alt2 = new AlertBox();
			alt2.display("日期选择错误");
    	}else{
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
    }
    
    private boolean Allisfilled(){
    	if(UserName.getText().isEmpty()||UserNum.getText().isEmpty()||TelePhone.getText().isEmpty()||
    			RoomnumText.getText().isEmpty()||RoomType.getValue().toString().equals(null)||Child.getValue().toString().equals(null)||
    			TimeBegin.getValue().toString().equals(null)||TimeEnd.getValue().toString().equals(null)){
    		return false;
    	}
    	return true;
    }
    
    private boolean Isdateright(){
    	if(TimeEnd.getValue().isBefore(TimeBegin.getValue())){
    		return false;
    	}
    	return true;
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
