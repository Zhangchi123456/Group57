package presentation.presentationController;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import Controller.HotelmanageController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelVO;
import vo.RoomVO;

public class HotelRoomEntryuiController implements Initializable {

	@FXML
	private TextField singleroomnum,singleroomprice,standardroomnum,standardroomprice,familyroomnum,familyroomprice,suiteroomnum,suiteroomprice;
	
	@FXML
	private Button save,back;
	
	HotelStaffLogicService hser = new HotelStaffLogicServiceImpl();
	HotelVO vo = HotelmanageController.getHotelVO();
    String hotelname = vo.getName();
    ArrayList<RoomVO> roomlist = new ArrayList<RoomVO>();
	AlertBox alt;
	
	int snum; double spri;
	int stnum; double stpri;
	int fnum; double fpri;
	int sunum; double supri;
	@FXML
	private void ReturnButtonClicked(ActionEvent event){
		
		UiswitchHelper.getApplication().goto_HotelMainui();
	}
	
	@FXML//保存按钮
	private void SaveButtonClicked(ActionEvent event){
		if(singleroomnum.getText().equals("")||singleroomprice.getText().equals("")
				||standardroomnum.getText().equals("")||standardroomprice.getText().equals("")
				||familyroomnum.getText().equals("")||familyroomprice.getText().equals("")
				||suiteroomnum.getText().equals("")||suiteroomprice.getText().equals("")){
			alt = new AlertBox();
			alt.display("请填写完整！");
		}else{
			snum = Integer.parseInt(singleroomnum.getText());
			spri = Double.parseDouble(singleroomprice.getText());
			stnum = Integer.parseInt(standardroomnum.getText());
			stpri = Double.parseDouble(standardroomprice.getText());
			fnum = Integer.parseInt(familyroomnum.getText());
			fpri = Double.parseDouble(familyroomprice.getText());
			sunum = Integer.parseInt(suiteroomnum.getText());
			supri = Double.parseDouble(suiteroomprice.getText());
			
			vo.setSingleRoom(vo.getSingleRoom()+snum);
			vo.setLeftSingleRoom(vo.getLeftSingleRoom()+snum);
			vo.setSingleRoomPrice(spri);
			vo.setStandardRoom(vo.getStandardRoom()+stnum);
			vo.setLeftStandardRoom(vo.getLeftStandardRoom()+stnum);
			vo.setStandardRoomPrice(stpri);
			vo.setFamilyRoom(vo.getFamilyRoom()+fnum);
			vo.setLeftFamilyRoom(vo.getLeftFamilyRoom()+fnum);
			vo.setFamilyRoomPrice(fpri);
			vo.setSuiteRoom(vo.getSuiteRoom()+sunum);
			vo.setLeftSuiteRoom(vo.getLeftSuiteRoom()+sunum);
			vo.setSuiteRoomPrice(supri);
			
			try {
				roomlist = hser.roomShowAll(hotelname);
				int i=(roomlist.size()+1);
				boolean info = false;
				while(i<=snum){
					RoomVO roomvo = new RoomVO();
					roomvo.setHotelid(hotelname);
					roomvo.setRoomid(i);
					roomvo.setRoomstate("可用");
					roomvo.setRoomtype("单人房");
					info = hser.changeRoomInfo(roomvo);
					if(info == false){
						alt = new AlertBox();
						alt.display("保存失败！");
					}else{
					i=i+1;
					}
				}
				while(i<=snum+stnum){
					RoomVO roomvo = new RoomVO();
					roomvo.setHotelid(hotelname);
					roomvo.setRoomid(i);
					roomvo.setRoomstate("可用");
					roomvo.setRoomtype("标准间");
					info = hser.changeRoomInfo(roomvo);
					if(info == false){
						alt = new AlertBox();
						alt.display("保存失败！");
					}else{
					i=i+1;
					}
				}
				while(i<=snum+stnum+fnum){
					RoomVO roomvo = new RoomVO();
					roomvo.setHotelid(hotelname);
					roomvo.setRoomid(i);
					roomvo.setRoomstate("可用");
					roomvo.setRoomtype("家庭房");
					info = hser.changeRoomInfo(roomvo);
					if(info == false){
						alt = new AlertBox();
						alt.display("保存失败！");
					}else{
					i=i+1;
					}
				}
				while(i<=snum+stnum+fnum+sunum){
					RoomVO roomvo = new RoomVO();
					roomvo.setHotelid(hotelname);
					roomvo.setRoomid(i);
					roomvo.setRoomstate("可用");
					roomvo.setRoomtype("套房");
					info = hser.changeRoomInfo(roomvo);
					if(info==false){
						alt = new AlertBox();
						alt.display("保存失败！");
					}else{
					i=i+1;
					}
				}
				
				if(hser.changeHotelInfo(vo)&&info){
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
	
	@Override//界面初始化方法
	public void initialize(URL location, ResourceBundle resources) {
		singleroomnum.setText("");
        singleroomprice.setText("");
        standardroomnum.setText("");
        standardroomprice.setText("");
        familyroomnum.setText("");
        familyroomprice.setText("");
        suiteroomnum.setText("");
        suiteroomprice.setText("");
		
	}

}
