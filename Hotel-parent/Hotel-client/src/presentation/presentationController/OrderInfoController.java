package presentation.presentationController;


import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

import BusinessLogicService.Service.MemberLogicService;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.Service.ReservationLogicService;
import BusinessLogicService.impl.MemberLogicServiceImpl;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import BusinessLogicService.impl.ReservationLogicServiceImpl;
import Controller.MemberActController;
import Controller.ReservationController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.CreditRecordVO;
import vo.OrderVO;

public class OrderInfoController implements Initializable {
	@FXML
	private Label HotelName,UserNum,Child,RoomType,TimeBegin,TimeEnd,RoomnumLabel,TotalpriceLabel,OrderId;
	
    OrderVO vo =	ReservationController.getOrdervo();
    OrderLogicService orderlogic = new OrderLogicServiceImpl();
    
	@FXML
	private void ConfirmClicked(ActionEvent event){
		vo.setLasttime(vo.getLeavetime()+" 18:00:00");
		vo.setState("未执行订单");
	    orderlogic.input(vo);
	    MemberLogicService memberservice=new MemberLogicServiceImpl();
	    CreditRecordVO credit=new CreditRecordVO();
		credit.setOrderid(vo.getId());
		credit.membername=ReservationController.getMembervo().getMembername();
		try {
			if(memberservice.addCreditRecord(credit)){
//				System.out.println("succeed");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UiswitchHelper.getApplication().goto_Usermainui();
		AlertBox alt = new AlertBox();
	    alt.display("订单生成成功");
	}
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_OrderinputUi();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ReservationLogicService res = new ReservationLogicServiceImpl();
	
		vo.setHotelid(ReservationController.getCurrentHotelvo().getName());
		HotelName.setText(vo.getHotelid());
		UserNum.setText(String.valueOf(vo.getPeoplenum()));
		Child.setText(vo.isHavekids());
		if(Integer.parseInt(vo.getFamilyRoom())!=0){
			RoomType.setText("家庭房");	
			RoomnumLabel.setText(vo.getFamilyRoom());
		}
		if(Integer.parseInt(vo.getSingleRoom())!=0){
			RoomType.setText("单人房");	
			RoomnumLabel.setText(vo.getSingleRoom());
		}
		if(Integer.parseInt(vo.getStandardRoom())!=0){
			RoomType.setText("标准间");		
			RoomnumLabel.setText(vo.getStandardRoom());
		}
		if(Integer.parseInt(vo.getSuiteRoom())!=0){
			RoomType.setText("套间");	
			RoomnumLabel.setText(vo.getSuiteRoom());
		}
		OrderId.setText(vo.getId());
		TimeBegin.setText(vo.getStarttime());
		TimeEnd.setText(vo.getLeavetime());
		TotalpriceLabel.setText(vo.getPrice());
	}
	
}
