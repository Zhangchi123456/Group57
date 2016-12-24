package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import Controller.HotelmanageController;
import Helper.UiswitchHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.userui.AlertBox;
import vo.OrderVO;
import vo.RoomVO;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class HotelroomInfouiController implements Initializable{
	@FXML
	private Button ok,back;
	
	@FXML
	private TableView<SimpleRoom> table;
	
	@FXML
	private TableColumn<SimpleRoom, String> roomNum,RoomInfo,State,Last;//房间号，房间类型，状态，最后一次退房时间
	
	@FXML
	private Label roomList;
	
	public ObservableList<SimpleRoom> temp;
		
	static String Name = HotelmanageController.getHotelVO().getName();
	HotelStaffLogicService hser = new HotelStaffLogicServiceImpl();
	OrderLogicService oser = new OrderLogicServiceImpl();
	ArrayList<RoomVO> roomlist = new ArrayList<RoomVO>();
     
	AlertBox alt;
	SimpleDateFormat nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	@FXML//返回按钮
	private void ReturnButtonClicked(ActionEvent event) throws IOException{
		UiswitchHelper.getApplication().goto_HotelMainui();
		
	}
	@FXML
	private void okButtonClicked(ActionEvent event){
		if(!table.getSelectionModel().isEmpty()){
		int selectnumber=table.getSelectionModel().getSelectedIndex();
		temp=table.getItems();
		String room_id = temp.get(selectnumber).getRoomnum();
		int roomid = Integer.parseInt(room_id);
		RoomVO vo;
		OrderVO ordervo;
		String realleavetime;
		try {
			vo = hser.FindRoomByID(Name, roomid);
			vo.setRoomstate("可用");
			int orderid = vo.getOrderid();
			if(orderid==0){
				alt = new AlertBox();
				alt.display("无效房间！");
			}
			ordervo = oser.orderShowAll(orderid);
			realleavetime = nowtime.format(new Date());
			vo.setLeavetime(realleavetime);
			ordervo.setLeavetime(realleavetime);
			if(vo.getRoomtype().equals("单人房"))
			    if(hser.changeCheckOutInfo(Name, roomid, 1, 0,0,0, "可用", vo.getLeavetime())){
			    	UiswitchHelper.getApplication().goto_roomInfoui();
			    	AlertBox alt1 = new AlertBox();
					alt1.display("退房成功！");
			    }
			if(vo.getRoomtype().equals("标准间"))
				if(hser.changeCheckOutInfo(Name, roomid, 0, 1, 0, 0, "可用", vo.getLeavetime())){
					UiswitchHelper.getApplication().goto_roomInfoui();
					AlertBox alt2 = new AlertBox();
					alt2.display("退房成功！");
				}
			if(vo.getRoomtype().equals("家庭房"))
				if(hser.changeCheckOutInfo(Name, roomid, 0,0, 1, 0, "可用", vo.getLeavetime())){
					UiswitchHelper.getApplication().goto_roomInfoui();
					AlertBox alt3 = new AlertBox();
					alt3.display("退房成功！");
				}
			if(vo.getRoomtype().equals("套间"))
				if(hser.changeCheckOutInfo(Name, roomid, 0,0,0, 1, "可用", vo.getLeavetime())){
					UiswitchHelper.getApplication().goto_roomInfoui();
					AlertBox alt4 = new AlertBox();
					alt4.display("退房成功！");
				}
			temp.get(selectnumber).setState(vo.getRoomstate());
			temp.get(selectnumber).setLast(realleavetime);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			alt = new AlertBox();
			alt.display("请先选择！");
		}
	}
	@Override//界面初始化方法
	public void initialize(URL location, ResourceBundle resources) {
		try {
			roomlist = hser.roomShowAll(Name);
			if(roomlist!=null)
		   	Roomlist(roomlist);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//表中项
	public void  Roomlist(ArrayList<RoomVO> roomlist){
    	ObservableList<SimpleRoom> temp =FXCollections.observableArrayList();
    	for(int i=0;i<roomlist.size();i++){
    	temp.add(new SimpleRoom(String.valueOf(roomlist.get(i).getRoomid()), 
    			roomlist.get(i).getRoomtype(), 
    			roomlist.get(i).getRoomstate(), 
    			roomlist.get(i).getLeavetime()));
    	}
    	  roomNum.setCellValueFactory(
		            new PropertyValueFactory<>("roomnum"));		 
		  roomNum.setCellFactory(TextFieldTableCell.<SimpleRoom>forTableColumn());
		  roomNum.setOnEditCommit(
		            (CellEditEvent<SimpleRoom, String> t) -> {
		                ((SimpleRoom) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setRoomnum(t.getNewValue());
		        });
		  RoomInfo.setCellValueFactory(
		            new PropertyValueFactory<>("roominfo"));
		 
		  RoomInfo.setCellFactory(TextFieldTableCell.<SimpleRoom>forTableColumn());
		  RoomInfo.setOnEditCommit(
		            (CellEditEvent<SimpleRoom, String> t) -> {
		                ((SimpleRoom) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setRoominfo(t.getNewValue());
		        });
		  State.setCellValueFactory(
		            new PropertyValueFactory<>("state"));
		 
		  State.setCellFactory(TextFieldTableCell.<SimpleRoom>forTableColumn());
		  State.setOnEditCommit(
		            (CellEditEvent<SimpleRoom, String> t) -> {
		                ((SimpleRoom) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setState(t.getNewValue());
		        });
		  Last.setCellValueFactory(
		            new PropertyValueFactory<>("last"));
		 
		  Last.setCellFactory(TextFieldTableCell.<SimpleRoom>forTableColumn());
		  Last.setOnEditCommit(
		            (CellEditEvent<SimpleRoom, String> t) -> {
		                ((SimpleRoom) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setLast(t.getNewValue());
		        });
		  table.setItems(temp);
	
    	}
    	
	public static class SimpleRoom {		 		         
        SimpleStringProperty roomnum;
        SimpleStringProperty roominfo;
        SimpleStringProperty state;
        SimpleStringProperty last;
 
       private SimpleRoom(String roomnum, String roominfo, String state, String last) {
       	  this.roomnum = new SimpleStringProperty(roomnum);
       	  this.roominfo = new SimpleStringProperty(roominfo);
       	  this.state = new SimpleStringProperty(state);    	  
       	  this.last = new SimpleStringProperty(last);
       	
       }

	/**
	 * @return the roomnum
	 */
	public String getRoomnum() {
		return roomnum.get();
	}

	/**
	 * @param string the roomnum to set
	 */
	public void setRoomnum(String string) {
		roomnum.set(string);;
	}

	/**
	 * @return the roominfo
	 */
	public String getRoominfo() {
		return roominfo.get();
	}

	/**
	 * @param string the roominfo to set
	 */
	public void setRoominfo(String string) {
		roominfo.set(string);;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state.get();
	}

	/**
	 * @param string the state to set
	 */
	public void setState(String string) {
		state.set(string);
	}

	/**
	 * @return the last
	 */
	public String getLast() {
		return last.get();
	}

	/**
	 * @param string the last to set
	 */
	public void setLast(String string) {
		last.set(string);;
	}  
     
	}
}
