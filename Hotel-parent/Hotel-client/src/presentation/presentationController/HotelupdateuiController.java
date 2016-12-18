package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.OrderVO;
import vo.RoomVO;

public class HotelupdateuiController implements Initializable{
	@FXML
	private Button ok,back;
	
	@FXML
	private TextField roomNumtx,orderNumtx;
	
	@FXML
	private Label Update,roomNum,INtime,OutTime,orderNum,INtimetx,OutTimetx;
     
	HotelStaffLogicService hser = new HotelStaffLogicServiceImpl();
	OrderLogicService oser = new OrderLogicServiceImpl();

	@FXML
	private void ReturnClicked(ActionEvent event) throws IOException{
		UiswitchHelper.getApplication().goto_HotelMainui();
		
	}
	@FXML
	private void SureClicked(ActionEvent event){
		if(roomNum.getText()==null||orderNumtx.getText()==null){
			AlertBox alt2 = new AlertBox();
			alt2.display("请填写订单号和房间号！");
		}
		int orderid = Integer.parseInt(orderNumtx.getText());
		OrderVO ordervo = oser.orderShowAll(orderid);
		String room_id = roomNumtx.getText().toString();
		RoomVO roomvo;
		try {
		if(ordervo==null||ordervo.getState()=="已撤销"){
			AlertBox alt3 = new AlertBox();
			alt3.display("请填写正确订单号！");
		}
		else if(!isRight(room_id)){
			AlertBox alt4 = new AlertBox();
			alt4.display("请填写可用房间号！");
		}else{
		INtimetx.setText(ordervo.getStarttime());
		OutTimetx.setText(ordervo.getLeavetime());
		roomvo = hser.FindRoomByID(Integer.parseInt(room_id));
		
		switch(roomvo.getRoomtype()){
		
		case "单人间":
			if(hser.changeCheckInInfo(Integer.parseInt(room_id), orderid, 1, 0, 0, 0, ordervo.getStarttime(), ordervo.getLeavetime())==true){
			
				AlertBox alt = new AlertBox();			
				alt.display("更新成功！");
		    }
			break;
		case "标准间":
			if(hser.changeCheckInInfo(Integer.parseInt(room_id), orderid, 0, 1, 0, 0, ordervo.getStarttime(), ordervo.getLeavetime())==true){
				
				AlertBox alt = new AlertBox();			
				alt.display("更新成功！");
		    }
			break;
		case "家庭房":
			if(hser.changeCheckInInfo(Integer.parseInt(room_id), orderid, 0, 0, 1, 0, ordervo.getStarttime(), ordervo.getLeavetime())==true){
				
				AlertBox alt = new AlertBox();			
				alt.display("更新成功！");
		    }
			break;
		case "套间":
			if(hser.changeCheckInInfo(Integer.parseInt(room_id), orderid, 0, 0, 0, 1, ordervo.getStarttime(), ordervo.getLeavetime())==true){
				
				AlertBox alt = new AlertBox();			
				alt.display("更新成功！");
		    }
			break;
		    }
		}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		INtimetx.setText(null);
		OutTimetx.setText(null);
		orderNumtx.setText(null);
		roomNumtx.setText(null);
	}
	
	public boolean isRight(String inroomid) throws NumberFormatException, RemoteException{
			if(hser.FindRoomByID(Integer.parseInt(inroomid)).getRoomstate().equals("可用")){
			    return true;
			}else{
				return false;
			}
	}

}
