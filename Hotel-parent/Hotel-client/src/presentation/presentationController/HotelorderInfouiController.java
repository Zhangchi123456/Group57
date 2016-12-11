package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.Service.MemberLogicService;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import BusinessLogicService.impl.MemberLogicServiceImpl;
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
import vo.CreditRecordVO;
import vo.MemberVO;
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
     
	OrderLogicService ser = new OrderLogicServiceImpl();
	HotelStaffLogicService hser = new HotelStaffLogicServiceImpl();
	MemberLogicService mser = new MemberLogicServiceImpl();

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
		
		SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lasttime = ordervo.getLasttime();
	
		int judge;
		CreditRecordVO creditvo = null;
		MemberVO membervo = null;
		try {
			membervo = mser.Findmemberbyname(ordervo.getName());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		ArrayList<CreditRecordVO> creditlist = new ArrayList<CreditRecordVO>();
		try {
			creditlist = mser.FindCreditbyname(ordervo.getName());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int tempcredit = 0;
		try {
			judge = nowtime.parse(nowtime.format(new Date())).compareTo(nowtime.parse(lasttime));
			if(judge==1){
				CurrentState.setText("异常");
				ordervo.setState("异常");
				ser.changeOrderStation(String.valueOf(orderid), "异常");
				
				for(int i=0;i<creditlist.size();i++){
					if(Integer.parseInt(creditlist.get(i).getOrderid()) == orderid){
						creditvo = creditlist.get(i);
						break;
					}
				}
                tempcredit = Integer.parseInt(ordervo.getPrice());
				creditvo.setCreditchange("-"+ordervo.getPrice());
				creditvo.setAction("异常");
				creditvo.setCreditlast(String.valueOf(membervo.getcredit() - Integer.parseInt(ordervo.getPrice())));
				creditvo.setTime(lasttime);
				membervo.setMembercreditvalue(Integer.parseInt(creditvo.getCreditlast()));
				mser.updateMemberinfo(membervo);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		MemberActController.setcurrentOrdervo(ordervo);
		
		INtimetx.setText(ordervo.getStarttime());
		OutTimetx.setText(ordervo.getLeavetime());
		Person.setText(ordervo.getId());
		CurrentState.setText(ordervo.getState());
		singlenumber.setText(ordervo.getSingleRoom());
		standardnumber.setText(ordervo.getStandardRoom());
		familynumber.setText(ordervo.getFamilyRoom());
		suitenumber.setText(ordervo.getSuiteRoom());
		
		if(CurrentState.getText().toString().equals("已执行")){
			ordervo.setState("已执行");
			ser.changeOrderStation(String.valueOf(orderid), "已执行");
			
			for(int i=0;i<creditlist.size();i++){
				if(Integer.parseInt(creditlist.get(i).getOrderid()) == orderid){
					creditvo = creditlist.get(i);
					break;
				}
			}
			
			creditvo.setCreditchange(ordervo.getPrice()+tempcredit);
			creditvo.setAction("已执行");
			creditvo.setCreditlast(String.valueOf(tempcredit + membervo.getMembercreditvalue() + Integer.parseInt(ordervo.getPrice())));
			creditvo.setTime(nowtime.format(new Date()).toString());
			membervo.setMembercreditvalue(Integer.parseInt(creditvo.getCreditlast()));
			try {
				mser.updateMemberinfo(membervo);
			} catch (RemoteException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(CurrentState.getText().toString().equals("已撤销")){
			ordervo.setState("已撤销");
			ser.changeOrderStation(String.valueOf(orderid), "已撤销");
			
			for(int i=0;i<creditlist.size();i++){
				if(Integer.parseInt(creditlist.get(i).getOrderid()) == orderid){
					creditvo = creditlist.get(i);
					break;
				}
			}

			creditvo.setAction("已撤销");
			creditvo.setCreditlast(String.valueOf(membervo.getcredit()));
			creditvo.setTime(nowtime.format(new Date()).toString());
			membervo.setMembercreditvalue(Integer.parseInt(creditvo.getCreditlast()));
			try {
				mser.updateMemberinfo(membervo);
			} catch (RemoteException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lasttime = ordervo.getLasttime();
		int judge;
		CreditRecordVO creditvo = null;
		MemberVO membervo = null;
		try {
			membervo = mser.Findmemberbyname(ordervo.getName());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		ArrayList<CreditRecordVO> creditlist = new ArrayList<CreditRecordVO>();
		try {
			creditlist = mser.FindCreditbyname(ordervo.getName());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int tempcredit = 0;
		try {
			judge = nowtime.parse(nowtime.format(new Date())).compareTo(nowtime.parse(lasttime));
			if(judge==1){
				CurrentState.setText("异常");
				ordervo.setState("异常");
				ser.changeOrderStation(String.valueOf(orderid), "异常");
				for(int i=0;i<creditlist.size();i++){
					if(Integer.parseInt(creditlist.get(i).getOrderid()) == orderid){
						creditvo = creditlist.get(i);
						break;
					}
				}
				tempcredit = Integer.parseInt(ordervo.getPrice());
				creditvo.setCreditchange("-"+ordervo.getPrice());
				creditvo.setAction("异常");
				creditvo.setCreditlast(String.valueOf(tempcredit - Integer.parseInt(ordervo.getPrice())));
				creditvo.setTime(lasttime);
				membervo.setMembercreditvalue(Integer.parseInt(creditvo.getCreditlast()));
				mser.updateMemberinfo(membervo);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		MemberActController.setcurrentOrdervo(ordervo);
		
		INtimetx.setText(ordervo.getStarttime());
		OutTimetx.setText(ordervo.getLeavetime());
		Person.setText(ordervo.getId());
		CurrentState.setText(ordervo.getState());
		singlenumber.setText(ordervo.getSingleRoom());
		standardnumber.setText(ordervo.getStandardRoom());
		familynumber.setText(ordervo.getFamilyRoom());
		suitenumber.setText(ordervo.getSuiteRoom());
		
		if(CurrentState.getText().toString().equals("已执行")){
			ordervo.setState("已执行");
			ser.changeOrderStation(String.valueOf(orderid), "已执行");
			
			for(int i=0;i<creditlist.size();i++){
				if(Integer.parseInt(creditlist.get(i).getOrderid()) == orderid){
					creditvo = creditlist.get(i);
					break;
				}
			}
			
			creditvo.setCreditchange(ordervo.getPrice()+tempcredit);
			creditvo.setAction("已执行");
			creditvo.setCreditlast(String.valueOf(tempcredit + membervo.getMembercreditvalue() + Integer.parseInt(ordervo.getPrice())));
			creditvo.setTime(nowtime.format(new Date()).toString());
			membervo.setMembercreditvalue(Integer.parseInt(creditvo.getCreditlast()));
			try {
				mser.updateMemberinfo(membervo);
			} catch (RemoteException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(CurrentState.getText().toString().equals("已撤销")){
			ordervo.setState("已撤销");
			ser.changeOrderStation(String.valueOf(orderid), "已撤销");
			
			for(int i=0;i<creditlist.size();i++){
				if(Integer.parseInt(creditlist.get(i).getOrderid()) == orderid){
					creditvo = creditlist.get(i);
					break;
				}
			}

			creditvo.setAction("已撤销");
			creditvo.setCreditlast(String.valueOf(membervo.getcredit()));
			creditvo.setTime(nowtime.format(new Date()).toString());
			membervo.setMembercreditvalue(Integer.parseInt(creditvo.getCreditlast()));
			try {
				mser.updateMemberinfo(membervo);
			} catch (RemoteException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
	    		 ser.changeOrderStation(String.valueOf(orderid), "未执行");
	    	 }
	    	 else if(newv=="已执行"){
	    		 CurrentState.setText("已执行");
	    		 ordervo.setState("已执行");
	    		 ser.changeOrderStation(String.valueOf(orderid), "已执行");
	    	 }
	    	 else if(newv=="异常"){
	    		 CurrentState.setText("异常");
	    		 ordervo.setState("异常");
	    		 ser.changeOrderStation(String.valueOf(orderid), "异常");
	    	 }
	    	 else{
	    		 CurrentState.setText("已撤销");
	    		 ordervo.setState("已撤销");
	    		 ser.changeOrderStation(String.valueOf(orderid), "已撤销");
	    	 }
	    	 
	     });
	
				
	}

}
