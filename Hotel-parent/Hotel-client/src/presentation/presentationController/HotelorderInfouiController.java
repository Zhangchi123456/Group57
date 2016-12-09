package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.impl.OrderLogicServiceImpl;
import Controller.MemberActController;
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
import vo.OrderVO;

public class HotelorderInfouiController implements Initializable{

	private ObservableList<String> Statelist;
	@FXML
	private TextField INtimetx,OutTimetx;//入住时间，离开时间
	
	@FXML
	private Label OrderUser;//订单持有者
	
	@FXML
	private ChoiceBox Statetx;//更改订单状态
     
	OrderLogicServiceImpl ser = new OrderLogicServiceImpl();

	String order_id = HotelorderuiController.Orderid;
	int orderid = Integer.parseInt(order_id);
	OrderVO ordervo = ser.orderShowAll(orderid);
	
	@SuppressWarnings("unchecked")
	@FXML
	private void ReturnClicked(ActionEvent event) throws IOException{
		
		String state = Statetx.getValue().toString();
			
		UiswitchHelper.getApplication().goto_orderui();
		
	}
	@FXML
	private void RefreshClicked(ActionEvent event){
		
		MemberActController.setcurrentOrdervo(ordervo);
		
		INtimetx.setText(ordervo.getStarttime());
		OutTimetx.setText(ordervo.getLeavetime());
	}
	@FXML
    private void CheckClicked(ActionEvent event){
		
		UiswitchHelper.getApplication().goto_ordeinfoui();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		MemberActController.setcurrentOrdervo(ordervo);
		
		INtimetx.setText(ordervo.getStarttime());
		OutTimetx.setText(ordervo.getLeavetime());
		
		ArrayList<String> statelist = new ArrayList<String>();
		statelist.add("未执行");
		statelist.add("已执行");
		statelist.add("异常");
		statelist.add("已撤销");
		Statelist=FXCollections.observableArrayList(statelist);
		Statetx.setItems(Statelist);
		
		Statetx.getSelectionModel()
	     .selectedItemProperty()
	     .addListener((ov,oldv,newv)->{
	    	 if(newv=="未执行"){
	    	 OrderUser.setText("未执行");
	    	 }
	    	 else if(newv=="已执行"){
	    	 OrderUser.setText("未执行");
	    	 }
	    	 else if(newv=="异常"){
	         OrderUser.setText("异常");
	    	 }
	    	 else{
	    	 OrderUser.setText("已撤销");
	    	 }
	    	 
	     });
	
				
	}

}
