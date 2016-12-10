package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.presentationController.HotelorderuiController.SimpleHotelOrder;
import presentation.presentationController.OrderlistuiController.SimpleOrder;
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
	private TableColumn<SimpleRoom, String> roomNum,RoomInfo,State,Last;
	
	@FXML
	private Label roomList;
	
	public ObservableList<SimpleRoom> temp;
		
	String Name = HotelmanageController.getRoomVO().getHotelid();
	HotelStaffLogicService hser = new HotelStaffLogicServiceImpl();
	OrderLogicService oser = new OrderLogicServiceImpl();
	ArrayList<RoomVO> roomlist = new ArrayList<RoomVO>();
     
	@FXML
	private void ReturnButtonClicked(ActionEvent event) throws IOException{
		UiswitchHelper.getApplication().goto_HotelMainui();
		
	}
	@FXML
	private void okButtonClicked(ActionEvent event){
		int selectnumber=table.getSelectionModel().getSelectedIndex();
		
		String room_id = temp.get(selectnumber).getRoomnum();
		int roomid = Integer.parseInt(room_id);
		RoomVO vo;
		OrderVO ordervo;
		try {
			vo = hser.FindRoomByID(roomid);
			vo.setRoomstate("可用");
			int orderid = vo.getOrderid();
			ordervo = oser.orderShowAll(orderid);
			if(vo.getRoomtype().equals("单人房"))
			    hser.changeCheckOutInfo(roomid, Integer.parseInt(ordervo.getSingleRoom()), 0,0,0, "可用", vo.getLeavetime());
			if(vo.getRoomtype().equals("标准间"))
				hser.changeCheckOutInfo(roomid, 0, Integer.parseInt(ordervo.getStandardRoom()), 0, 0, "可用", vo.getLeavetime());
			if(vo.getRoomtype().equals("家庭房"))
				hser.changeCheckOutInfo(roomid, 0,0, Integer.parseInt(ordervo.getFamilyRoom()), 0, "可用", vo.getLeavetime());
			if(vo.getRoomtype().equals("套间"))
				hser.changeCheckOutInfo(roomid, 0,0,0, Integer.parseInt(ordervo.getSuiteRoom()), "可用", vo.getLeavetime());
			temp.get(selectnumber).setState(vo.getRoomstate());
			temp.get(selectnumber).setLast(vo.getLeavetime());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
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
	
	
	
	public void  Roomlist(ArrayList<RoomVO> roomlist){
    	ObservableList<SimpleRoom> temp =FXCollections.observableArrayList();
    	for(int i=0;i<roomlist.size();i++){
    	temp.add(new SimpleRoom(String.valueOf(roomlist.get(i).getId()), 
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
