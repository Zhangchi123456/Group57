package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import presentation.presentationController.OrderlistuiController.SimpleOrder;
import vo.OrderVO;
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
     
	@FXML
	private void backButtonClicked(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("mainui.fxml"));
		
	}
	@FXML
	private void okButtonClicked(ActionEvent event){
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
	public SimpleStringProperty getRoomnum() {
		return roomnum;
	}

	/**
	 * @param roomnum the roomnum to set
	 */
	public void setRoomnum(SimpleStringProperty roomnum) {
		this.roomnum = roomnum;
	}

	/**
	 * @return the roominfo
	 */
	public SimpleStringProperty getRoominfo() {
		return roominfo;
	}

	/**
	 * @param roominfo the roominfo to set
	 */
	public void setRoominfo(SimpleStringProperty roominfo) {
		this.roominfo = roominfo;
	}

	/**
	 * @return the state
	 */
	public SimpleStringProperty getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(SimpleStringProperty state) {
		this.state = state;
	}

	/**
	 * @return the last
	 */
	public SimpleStringProperty getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(SimpleStringProperty last) {
		this.last = last;
	}  
     
	}
	
	public void  Roomlist(ArrayList<RoomVO> orderlist){
    	ObservableList<SimpleRoom> temp =FXCollections.observableArrayList();
    	for(int i=0;i<orderlist.size();i++){
    	temp.add(new SimpleRoom(orderlist.get(i).getHotelid(),orderlist.get(i).getId(),orderlist.get(i).getIntime()+"——"
   		+orderlist.get(i).getOuttime(),orderlist.get(i).getPrice(),
   		String.valueOf(orderlist.get(i).getSingleRoom()+orderlist.get(i).getFamilyRoom()+orderlist.get(i).getStandardRoom()+orderlist.get(i).getSuiteRoom()),
   		orderlist.get(i).getComment(),orderlist.get(i).getState()));
    	}

}
