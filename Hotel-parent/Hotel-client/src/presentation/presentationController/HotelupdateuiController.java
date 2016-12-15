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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.CreditRecordVO;
import vo.OrderVO;

public class HotelupdateuiController implements Initializable{
	@FXML
	private Button ok,back;
	
	@FXML
	private TextField roomNumtx,INtimetx,orderNumtx,OutTimetx;
	
	@FXML
	private Label Update,roomNum,INtime,OutTime,orderNum;
     
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
		INtimetx.setText(ordervo.getStarttime());
		OutTimetx.setText(ordervo.getLeavetime());
		try {
			
			if(hser.changeCheckInInfo(Integer.parseInt(roomNumtx.getText()), orderid, Integer.parseInt(ordervo.getSingleRoom()), Integer.parseInt(ordervo.getStandardRoom()), Integer.parseInt(ordervo.getFamilyRoom()), Integer.parseInt(ordervo.getSuiteRoom()), ordervo.getStarttime(), ordervo.getLeavetime())==true){
				AlertBox alt = new AlertBox();
				alt.display("更新成功！");
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
		AlertBox alt = new AlertBox();
		alt.display("请先填写订单号和房间号！");
	}

}
