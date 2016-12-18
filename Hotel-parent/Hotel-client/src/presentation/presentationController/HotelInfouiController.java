package presentation.presentationController;


import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import Controller.HotelmanageController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import presentation.userui.AlertBox;
import vo.HotelVO;

public class HotelInfouiController implements Initializable{
	String hotelstar;
	@FXML
	private Button ReturnButton;//返回按钮
	@FXML
	private Label HotelnameLabel,ShowStar;//酒店名称
	@FXML
	private TextArea HotelDescription;//酒店介绍
	@FXML
	private TextArea HotelAddress;//酒店地址
	@FXML
	private ChoiceBox<String> HotelStar;//酒店星级
	//界面跳转
	
	HotelStaffLogicService hser = new HotelStaffLogicServiceImpl();
	HotelVO vo = HotelmanageController.getHotelVO();

	AlertBox alt;
	@FXML
	private void ReturnButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelMainui();
	}
	@FXML
	private void SaveClicked(ActionEvent event){
		if(!Allisfilled()){
			alt = new AlertBox();
			alt.display("信息填写不全!");
		}else{
			
			int instar=0;
			hotelstar=HotelStar.getValue().toString();
			
			if(hotelstar.equals("一星")){
				instar=1;
			}
			if(hotelstar.equals("二星")){
				instar=2;
			}
			if(hotelstar.equals("三星")){
				instar=3;
			}
			if(hotelstar.equals("四星")){
				instar=4;
			}
			if(hotelstar.equals("五星")){
				instar=5;
			}		
			try {
				if(hser.changeHotelInfo(HotelnameLabel.getText(), instar, HotelDescription.getText(), HotelAddress.getText())){
					alt = new AlertBox();
					alt.display("保存成功！");
				}else{
					alt = new AlertBox();
					alt.display("保存失败！");
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private boolean Allisfilled(){
		if(HotelDescription.getText().equals("")||HotelAddress.getText().equals("")||HotelStar.getSelectionModel().getSelectedIndex()==-1){
			return false;
		}else
		return true;
	}
	//初始化界面
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String star = "";
		
		
		HotelnameLabel.setText(vo.getName());
		HotelDescription.setText(vo.getIntroduction());
		HotelAddress.setText(vo.getAddress());
		
		if(vo.getStar()==1){
			star="★";
		}
		if(vo.getStar()==2){
			star="★★";
		}
		if(vo.getStar()==3){
			star="★★★";
		}
		if(vo.getStar()==4){
			star="★★★★";
		}
		if(vo.getStar()==5){
			star="★★★★★";
		}
		ShowStar.setText(star);
	}

}
