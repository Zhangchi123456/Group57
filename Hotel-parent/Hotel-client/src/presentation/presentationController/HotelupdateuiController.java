package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import Controller.HotelmanageController;
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
	private TextField roomNumtx,orderNumtx;//房间号，订单号
	
	@FXML
	private Label Update,roomNum,INtime,OutTime,orderNum,INtimetx,OutTimetx;
     
	HotelStaffLogicService hser = new HotelStaffLogicServiceImpl();
	OrderLogicService oser = new OrderLogicServiceImpl();
	String Name = HotelmanageController.getHotelVO().getName();

	AlertBox alt;
	SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@FXML//返回按钮
	private void ReturnClicked(ActionEvent event) throws IOException{
		UiswitchHelper.getApplication().goto_HotelMainui();
		
	}
	
	@FXML//确认按钮
	private void SureClicked(ActionEvent event){
		if(roomNum.getText()==null||orderNumtx.getText()==null){
			alt = new AlertBox();
			alt.display("请填写订单号和房间号！");
		}
		int orderid = Integer.parseInt(orderNumtx.getText());
		OrderVO ordervo = oser.orderShowAll(orderid);
		String room_id = roomNumtx.getText().toString();
		RoomVO roomvo;
		String realstarttime;
		try {
		if(ordervo==null||ordervo.getState()=="已撤销"){
			alt = new AlertBox();
			alt.display("请填写正确订单号！");
		}
		else if(!isRight(room_id)){
			alt = new AlertBox();
			alt.display("请填写可用房间号！");
		}else{
		realstarttime = nowtime.format(new Date());
		ordervo.setStarttime(realstarttime);
		INtimetx.setText(realstarttime);
		OutTimetx.setText(ordervo.getLeavetime());
		roomvo = hser.FindRoomByID(Name, Integer.parseInt(room_id));
		roomvo.setRoomstate("不可用");
		roomvo.setStarttime(realstarttime);
		
		int singleroom = 0;
		int standardroom = 0;
		int familyroom = 0;
		int suiteroom = 0;
		switch(roomvo.getRoomtype()){
		
		case "单人间":
			singleroom = 1;
			break;
		case "标准间":
			standardroom = 1;
			break;
		case "家庭房":
			familyroom = 1;
			break;
		case "套间":
			suiteroom = 1;
			break;
		    }
		if(hser.changeCheckInInfo(Name, Integer.parseInt(room_id), orderid, singleroom, standardroom, familyroom, suiteroom, realstarttime, ordervo.getLeavetime())){
			
			alt = new AlertBox();			
			alt.display("更新成功！");
	    }else{
	    	alt = new AlertBox();
	    	alt.display("更新失败！");
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
	@Override//界面初始化方法
	public void initialize(URL location, ResourceBundle resources) {
		INtimetx.setText(null);
		OutTimetx.setText(null);
		orderNumtx.setText(null);
		roomNumtx.setText(null);
	}
	
	public boolean isRight(String inroomid) throws NumberFormatException, RemoteException{
			if(hser.FindRoomByID(Name, Integer.parseInt(inroomid)).getRoomstate().equals("可用")){
			    return true;
			}else{
				return false;
			}
	}

}
