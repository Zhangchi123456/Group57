package presentation.presentationController;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.plaf.synth.SynthSpinnerUI;

import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.Service.ReservationLogicService;
import BusinessLogicService.impl.OrderLogicServiceImpl;
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
	//类需要的对象和引用
	 private String roomnum,roomtype;
	 private ReservationLogicService reservationService=new ReservationLogicServiceImpl();
	 private OrderLogicService orderService=new OrderLogicServiceImpl();
	 private AlertBox alt2 = new AlertBox();
	 //界面项目
	 @FXML
	 private TextField UserNum,RoomnumText;//人数，电话
	 @FXML 
	 private Label UserName;
	 @FXML
	 private ChoiceBox RoomType,Child;//房间类型，有无孩子
	 @FXML
	 private DatePicker TimeBegin,TimeEnd;//开始时间，结束时间
	 
	 
	//监听事件
	 //返回按钮的监听
    @FXML
    private void ReturnButtonClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_HotelListui();
    }
    //确认按钮的监听
    @FXML
    private void ConfirmButtonClicked(ActionEvent event) throws NumberFormatException, ParseException{    	
    	if(!Allisfilled()){    		
			alt2.display("信息填写不全");
			
    	}else if(!Isdateright()){
			alt2.display("日期选择错误");
    	}else if(TimeBegin.getValue().getDayOfYear()==TimeEnd.getValue().getDayOfYear()){
			alt2.display("无法当天入住当天离开");
    	}else if(ReservationController.getMembervo().getcredit()<0){
			alt2.display("信用值为负无法预订，请先充值");
    	}else if(!reservationService.roomleft(ReservationController.getCurrentHotelvo(), 
    orderService.findUserOrderListHotel(ReservationController.getCurrentHotelvo().getName()),TimeBegin.getValue(),TimeEnd.getValue(),Integer.parseInt(RoomnumText.getText().toString()), RoomType.getValue().toString())){
			alt2.display("抱歉，剩余房间数量不足");
    	}else if(TimeBegin.getValue().isBefore(LocalDate.now())){
			alt2.display("抱歉，无法预订今天之前的房间");
    	}
    	else{
    	
    	OrderVO vo = new OrderVO();   	
    	vo.setName(UserName.getText());
    	vo.setPeoplenum(UserNum.getText());    	
    	vo.setHotelid(ReservationController.getCurrentHotelvo().getName());
    	
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
  //判断信息是否填写完整  
    private boolean Allisfilled(){
        	if(UserNum.getText().isEmpty()||RoomnumText.getText().isEmpty()||RoomType.getValue().toString().equals(null)||Child.getValue().toString().equals(null)||
    			TimeBegin.getValue().toString().equals(null)||TimeEnd.getValue().toString().equals(null)){
    		return false;
    	}
    	return true;
    }
   //判断日期是否合法 
    private boolean Isdateright(){
    	if(TimeEnd.getValue().isBefore(TimeBegin.getValue())){
    		return false;
    	}
    	return true;
    }
    //初始化界面
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		LoginController con = new LoginController();
		UserName.setText(con.UserName);
	}

}
