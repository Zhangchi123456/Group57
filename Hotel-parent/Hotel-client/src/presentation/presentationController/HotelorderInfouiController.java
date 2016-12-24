package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
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
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import vo.CreditRecordVO;
import vo.MemberVO;
import vo.OrderVO;

public class HotelorderInfouiController implements Initializable{

	private ObservableList<String> Statelist;
	
	@FXML
	private Button refresh,back;
	@FXML
	private Label INtimetx,OutTimetx;//入住时间，离开时间，订单持有者
	
	@FXML
	private Label Person,CurrentState,OrderId,orderInfo,INtime,OutTime,State,SingleRoom,StandardRoom,FamilyRoom,SuiteRoom,singlenumber,standardnumber,familynumber,suitenumber;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox Statetx;//更改订单状态
     
	OrderLogicService ser = new OrderLogicServiceImpl();
	HotelStaffLogicService hser = new HotelStaffLogicServiceImpl();
	MemberLogicService mser = new MemberLogicServiceImpl();

	String order_id = HotelorderuiController.Orderid;
	int orderid = Integer.parseInt(order_id);
	OrderVO ordervo = ser.orderShowAll(orderid);

	
	@FXML
	private void ReturnClicked(ActionEvent event) throws IOException{
			
		UiswitchHelper.getApplication().goto_orderui();
		
	}//返回至订单列表界面
	@FXML
	private void RefrashClicked(ActionEvent event){
		//刷新
		SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式
		String lasttime = ordervo.getLasttime();
	
		int judge;//日期判断辅助变量
		CreditRecordVO creditvo = null;
		MemberVO membervo = null;
		membervo = mser.Findmemberbyname(ordervo.getName());;
		ArrayList<CreditRecordVO> creditlist = new ArrayList<CreditRecordVO>();
		creditlist = mser.FindCreditbyname(ordervo.getName());
		int tempcredit = 0;
		try {//处理异常订单
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
                tempcredit = (int)Double.parseDouble(ordervo.getPrice());
				creditvo.setCreditchange("-"+ordervo.getPrice());
				creditvo.setAction("异常");
				creditvo.setCreditlast(String.valueOf(membervo.getcredit() - (int)Double.parseDouble(ordervo.getPrice())));
				creditvo.setTime(lasttime);
				membervo.setMembercreditvalue(Integer.parseInt(creditvo.getCreditlast()));
				mser.updateMemberinfo(membervo);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		MemberActController.setcurrentOrdervo(ordervo);
		
		INtimetx.setText(ordervo.getStarttime());
		OutTimetx.setText(ordervo.getLeavetime());
		OrderId.setText(ordervo.getId());
		CurrentState.setText(ordervo.getState());
		singlenumber.setText(ordervo.getSingleRoom());
		standardnumber.setText(ordervo.getStandardRoom());
		familynumber.setText(ordervo.getFamilyRoom());
		suitenumber.setText(ordervo.getSuiteRoom());
		
		if(CurrentState.getText().toString().equals("已执行")){
			//处理已执行订单
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
			creditvo.setCreditlast(String.valueOf(tempcredit + membervo.getMembercreditvalue() + (int)Double.parseDouble(ordervo.getPrice())));
			creditvo.setTime(nowtime.format(new Date()).toString());
			membervo.setMembercreditvalue(Integer.parseInt(creditvo.getCreditlast()));
			mser.updateMemberinfo(membervo);
		}
		
		if(CurrentState.getText().toString().equals("已撤销")){
			//处理已撤销订单
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
			mser.updateMemberinfo(membervo);
		}
	}
	@SuppressWarnings("unchecked")
	@Override//界面初始化方法
	public void initialize(URL location, ResourceBundle resources) {
		
		SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lasttime = ordervo.getLasttime();
		int judge;
		CreditRecordVO creditvo = null;
		MemberVO membervo = null;
		membervo = mser.Findmemberbyname(ordervo.getName());;
		ArrayList<CreditRecordVO> creditlist = new ArrayList<CreditRecordVO>();
		creditlist = mser.FindCreditbyname(ordervo.getName());
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
				tempcredit =(int) Double.parseDouble(ordervo.getPrice());
				creditvo.setCreditchange("-"+ordervo.getPrice());
				creditvo.setAction("异常");
				creditvo.setCreditlast(String.valueOf(tempcredit - (int)Double.parseDouble(ordervo.getPrice())));
				creditvo.setTime(lasttime);
				membervo.setMembercreditvalue(Integer.parseInt(creditvo.getCreditlast()));
				mser.updateMemberinfo(membervo);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		MemberActController.setcurrentOrdervo(ordervo);
		
		INtimetx.setText(ordervo.getStarttime());
		OutTimetx.setText(ordervo.getLeavetime());
		OrderId.setText(ordervo.getId());
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
			creditvo.setCreditlast(String.valueOf(tempcredit + membervo.getMembercreditvalue() + (int)Double.parseDouble(ordervo.getPrice())));
			creditvo.setTime(nowtime.format(new Date()).toString());
			membervo.setMembercreditvalue(Integer.parseInt(creditvo.getCreditlast()));
			mser.updateMemberinfo(membervo);
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
			mser.updateMemberinfo(membervo);
		}
		
		ArrayList<String> statelist = new ArrayList<String>();//选择框
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
