package presentation.presentationController;

import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.javafx.scene.control.skin.CheckBoxSkin;

import BusinessLogicService.Service.MemberLogicService;
import BusinessLogicService.Service.ReservationLogicService;
import BusinessLogicService.impl.MemberLogicServiceImpl;
import BusinessLogicService.impl.ReservationLogicServiceImpl;
import Controller.MemberActController;
import Controller.ReservationController;
import Helper.InituiHelper;
import Helper.LoginHelper;
import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelVO;
import vo.MemberVO;

public class UsermainuiController implements Initializable{
	private ObservableList<String> citylist;
	private ObservableList<String> circlelist;
	private ReservationLogicService reservationService=new ReservationLogicServiceImpl();
	private MemberLogicService memberservice=new MemberLogicServiceImpl();
	private AlertBox alt2 = new AlertBox();
	@FXML
	private Label membernamelabel;
	//显示会员名的label
	@FXML
	private ChoiceBox CityChoicebox,RoomTypeChoicebox,RoomnumChoicebox,HotelstarChoicebox,HotelgradeChoicebox,HotelpriceChoicebox,BusinessChoicebox;
	  //对应：             城市选择，     房间类型选择          房间数量选择          酒店星级选择           酒店评分选择       酒店价格选择          商圈选择， 
	@FXML
	private DatePicker CheckindateDatepicker,CheckoutdateDatepicker;
    //                 入住日期                离开日期
	@FXML
	private TextField HotelnameText;
	//                酒店名文本框
	
	
	@FXML
	private void MemberinformationButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Userinformationui();
	}
	
	@FXML
	private void CreditrecordButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Usercreditrecordui();
	}
	
	@FXML
	private void MyorderButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_OrderListUi();
	}
	@FXML
	private void RhotelClicked(ActionEvent event) {
	  UiswitchHelper.getApplication().goto_reservationedhotelUi();
	}
	
	
	@FXML
	private void SearchButtonClicked(ActionEvent event) throws RemoteException{
		if(CityChoicebox.getSelectionModel().getSelectedIndex()==-1||BusinessChoicebox.getSelectionModel().getSelectedIndex()==-1){
			alt2.display("请务必输入城市和商圈");
		}else{
		String roomtype;
    	String roomnum;
    	String hotelstar;
    	String hotelgrade;
    	String hotelprice;
    	String allresult;
    	String hotelname;
    	String cityname;
		String Businessname=BusinessChoicebox.getValue().toString();
		
    	if(RoomTypeChoicebox.getValue()!=null){
    		roomtype=RoomTypeChoicebox.getValue().toString();
    	}else{
    		roomtype="null";
    	}
    	if(RoomnumChoicebox.getValue()!=null){
    		roomnum=RoomnumChoicebox.getValue().toString();
    	}else{
    		roomnum="null";
    	}
    	if(HotelstarChoicebox.getValue()!=null){
    		hotelstar=HotelstarChoicebox.getValue().toString();
    	}else{
    		hotelstar="null";
    	}
    	if(HotelgradeChoicebox.getValue()!=null){
    		hotelgrade=HotelgradeChoicebox.getValue().toString();
    	}else{
    		hotelgrade="null";
    	}
    	if(HotelpriceChoicebox.getValue()!=null){
    		hotelprice=HotelpriceChoicebox.getValue().toString();
    	}else{
    		hotelprice="null";
    	}
    	if(HotelnameText.getText()!=null){
    		hotelname=HotelnameText.getText().toString();
    	}else{
    		hotelname="null";
    	}
		ArrayList<HotelVO> hotellist=reservationService.findbycircle(Businessname);
		hotellist=reservationService.filtbysearch(hotellist, roomtype, roomnum, hotelstar, hotelgrade, hotelprice, hotelname);
		
		if(hotellist.size()==0){
			alt2.display("没有符合条件的酒店");
		}else {
		ReservationController.setHotelvoList(hotellist);
		UiswitchHelper.getApplication().goto_HotelListui();
		}
		}
	}

	@FXML
	private void ReturnButtonClicked(ActionEvent event){
		ReservationController.setMembervo(null);
		UiswitchHelper.getApplication().goto_Loginui();
	}
	
	private String getMustSearchText(){
		String cityname=CityChoicebox.getValue().toString();
		String Businessname=BusinessChoicebox.getValue().toString();
		return cityname+" "+Businessname;
	}
	
    private boolean Isdate(){
    	LocalDate checkindate=CheckindateDatepicker.getValue();
    	LocalDate checkoutdate=CheckoutdateDatepicker.getValue();
    	if(checkindate.isAfter(checkoutdate)){
    		return false;
    	}
    	return true;
    }
    
    
    
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MemberVO member=new MemberVO();
		if(ReservationController.getMembervo()==null){
	     member=memberservice.Findmemberbyname(LoginController.UserName);
		}else{
			member=ReservationController.getMembervo();
		}
	    memberservice.updatelevel(member);
	    ReservationController.setMembervo(member);
		MemberActController.setMembervo(member);
		
		ArrayList<String> Citylist=new ArrayList<String>();
		ArrayList<String> PekingList=new ArrayList<String>();
		ArrayList<String> NanjingList=new ArrayList<String>();
		PekingList.add("西单商圈");
		PekingList.add("王府井商圈");
		PekingList.add("崇文门商圈");
		PekingList.add("中关村商圈");
		PekingList.add("三里屯商圈");
		NanjingList.add("新街口商圈");
		NanjingList.add("山西路商圈");
		NanjingList.add("夫子庙商圈");
		NanjingList.add("珠江路商圈");
		Citylist.add("南京");
		Citylist.add("北京");
		citylist=FXCollections.observableArrayList(Citylist);
			
		CityChoicebox.setItems(citylist);
		CityChoicebox.getSelectionModel()
		     .selectedItemProperty()
		     .addListener((ov,oldv,newv)->{
		    	 if(newv=="南京"){
		    	 BusinessChoicebox.setItems(FXCollections.observableArrayList(NanjingList));
		    	 }else{
		    		 BusinessChoicebox.setItems(FXCollections.observableArrayList(PekingList));
		    	 }
		     });
		
		
		
	    		
		membernamelabel.setText(member.getMembername());
		
	}

}