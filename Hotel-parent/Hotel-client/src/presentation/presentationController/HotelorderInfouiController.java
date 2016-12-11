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
	private Button refresh,back;
	@FXML
	private TextField INtimetx,OutTimetx,OrderUser;//入住时间，离开时间
	
	@FXML
	private Label Person,CurrentState,OrderId,orderInfo,INtime,OutTime,State,SingleRoom,StandardRoom,FamilyRoom,SuiteRoom,singlenumber,standardnumber,familynumber,suitenumber;//订单持有者
	
	@FXML
	private ChoiceBox Statetx;//更改订单状态
     
	OrderLogicServiceImpl ser = new OrderLogicServiceImpl();

	String order_id = HotelorderuiController.Orderid;
	int orderid = Integer.parseInt(order_id);
	OrderVO ordervo = ser.orderShowAll(orderid);
	
	@SuppressWarnings("unchecked")
	@FXML
	private void ReturnClicked(ActionEvent event) throws IOException{
			
		UiswitchHelper.getApplication().goto_orderui();
		
	}
	@FXML
	private void RefrashClicked(ActionEvent event){
		
		String state = Statetx.getValue().toString();
		ordervo.setState(state);
		
		MemberActController.setcurrentOrdervo(ordervo);
		
		INtimetx.setText(ordervo.getStarttime());
		OutTimetx.setText(ordervo.getLeavetime());
		Person.setText(ordervo.getId());
		CurrentState.setText(ordervo.getState());
		singlenumber.setText(ordervo.getSingleRoom());
		standardnumber.setText(ordervo.getStandardRoom());
		familynumber.setText(ordervo.getFamilyRoom());
		suitenumber.setText(ordervo.getSuiteRoom());
	}
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		MemberActController.setcurrentOrdervo(ordervo);
		
		INtimetx.setText(ordervo.getStarttime());
		OutTimetx.setText(ordervo.getLeavetime());
		Person.setText(ordervo.getId());
		CurrentState.setText(ordervo.getState());
		singlenumber.setText(ordervo.getSingleRoom());
		standardnumber.setText(ordervo.getStandardRoom());
		familynumber.setText(ordervo.getFamilyRoom());
		suitenumber.setText(ordervo.getSuiteRoom());
		
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
	    		 CurrentState.setText("未执行");
	    		 ordervo.setState("未执行");
	    	 }
	    	 else if(newv=="已执行"){
	    		 CurrentState.setText("已执行");
	    		 ordervo.setState("已执行");
	    	 }
	    	 else if(newv=="异常"){
	    		 CurrentState.setText("异常");
	    		 ordervo.setState("异常");
	    	 }
	    	 else{
	    		 CurrentState.setText("已撤销");
	    		 ordervo.setState("已撤销");
	    	 }
	    	 
	     });
	
				
	}

}
