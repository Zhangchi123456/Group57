package presentation.presentationController;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import javax.swing.plaf.synth.SynthSpinnerUI;

import BusinessLogicService.Service.ReservationLogicService;
import BusinessLogicService.impl.ReservationLogicServiceImpl;
import Controller.ReservationController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelVO;
import vo.OrderVO;

public class CreatorderController implements Initializable{
	 private String username,usernum,telephone,roomnum,roomtype,havechild,timebegin,timeend;
	 private ReservationLogicService reservationService=new ReservationLogicServiceImpl();
	 @FXML
	 private TextField UserNum,RoomnumText;//人数，电话
	 @FXML 
	 private Label UserName;
	 @FXML
	 private ChoiceBox RoomType,Child;//房间类型，有无孩子
	 @FXML
	 private DatePicker TimeBegin,TimeEnd;//开始时间，结束时间
    @FXML
    private void ReturnButtonClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_HotelListui();
    }
    
    @FXML
    private void ConfirmButtonClicked(ActionEvent event) throws NumberFormatException, ParseException{
    	if(!Allisfilled()){
    		AlertBox alt = new AlertBox();
			alt.display("信息填写不全");
    	}else if(!Isdateright()){
    		AlertBox alt2 = new AlertBox();
			alt2.display("日期选择错误");
    	}else{
    	OrderVO vo = new OrderVO();
    	
    	vo.setName(UserName.getText());
    	vo.setPeoplenum(UserNum.getText());
    	
    	
    	
    	roomtype=RoomType.getValue().toString();
    	roomnum=RoomnumText.getText();
    	double Aprice=0.0;
    	HotelVO hotel=ReservationController.getCurrentHotelvo();
    	if("单人房".equals(roomtype)){  
    		Aprice=hotel.getSingleRoomPrice();
   		    vo.setSingleRoom(roomnum);
    		vo.setFamilyRoom("0");
    		vo.setStandardRoom("0");
    		vo.setSuiteRoom("0");
    	}
    	if("标准间".equals(roomtype)){
    		Aprice=hotel.getStandardRoomPrice();
    		vo.setSingleRoom("0");
    		vo.setFamilyRoom("0");
    		vo.setStandardRoom(roomnum);
    		vo.setSuiteRoom("0");
    	}
    	if("家庭房".equals(roomtype)){
    		Aprice=hotel.getFamilyRoomPrice();
    		vo.setSingleRoom("0");
    		vo.setFamilyRoom(roomnum);
    		vo.setStandardRoom("0");
    		vo.setSuiteRoom("0");
    	}
    	if("套间".equals(roomtype)){
    		Aprice=hotel.getSuiteRoomPrice();
    		vo.setSingleRoom("0");
    		vo.setFamilyRoom("0");
    		vo.setStandardRoom("0");
    		vo.setSuiteRoom(roomnum);
    	}
    	
    	
    	
    	double price=reservationService.Computeprice(ReservationController.getMembervo(), ReservationController.getWebPromotionvolist(),ReservationController.getHotelprolist(),Integer.parseInt(roomnum), Aprice,TimeBegin.getValue(), TimeEnd.getValue());
    	vo.setPrice(String.valueOf(price));
    	vo.setId(String.valueOf(Math.round(Math.random()*100000)));
    	vo.setHavekids(Child.getValue().toString());
    	vo.setStarttime(TimeBegin.getValue().toString());
    	vo.setLeavetime(TimeEnd.getValue().toString());
    	ReservationController.setOrdervo(vo);
         UiswitchHelper.getApplication().goto_confirmUi();
    	}
    }
    
    private boolean Allisfilled(){
    	if(UserNum.getText().isEmpty()||RoomnumText.getText().isEmpty()||RoomType.getValue().toString().equals(null)||Child.getValue().toString().equals(null)||
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
		LoginController con = new LoginController();
		UserName.setText(con.UserName);
	}

}
