package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import presentation.presentationController.HotelroomInfouiController.SimpleRoom;
import vo.OrderVO;
import vo.RoomVO;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class HotelorderuiController implements Initializable{
	@FXML
	private Button ok,back;
	
	@FXML
	private TableView table;
	
	@FXML
	private TableColumn OrderNum,OrderInfo,State;
	
	@FXML
	private Label OrderList;
     
	@FXML
	private void backButtonClicked(ActionEvent event) throws IOException{
		UiswitchHelper.getApplication().goto_HotelMainui();
		
	}
	@FXML
	private void okButtonClicked(ActionEvent event) throws IOException{
		UiswitchHelper.getApplication().goto_ordeinfoui();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public static class SimpleHotelOrder {		 		         
        SimpleStringProperty ordernum;
        SimpleStringProperty orderinfo;
        SimpleStringProperty state;
 
       private SimpleHotelOrder(String ordernum, String orderinfo, String state) {
       	  this.ordernum = new SimpleStringProperty(ordernum);
       	  this.orderinfo = new SimpleStringProperty(orderinfo);
       	  this.state = new SimpleStringProperty(state);    	  
       	
       }


	/**
	 * @return the ordernum
	 */
	public String getOrdernum() {
		return ordernum.get();
	}

	/**
	 * @param string the ordernum to set
	 */
	public void setOrdernum(String string) {
		ordernum.set(string);;
	}

	/**
	 * @return the orderinfo
	 */
	public String getOrderinfo() {
		return orderinfo.get();
	}

	/**
	 * @param string the orderinfo to set
	 */
	public void setOrderinfo(String string) {
		orderinfo.set(string);;
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
	}
	
	public void  HotelOrderlist(ArrayList<OrderVO> orderlist){
    	ObservableList<SimpleRoom> temp =FXCollections.observableArrayList();
    	for(int i=0;i<orderlist.size();i++){
    	temp.add(new SimpleRoom(String.valueOf(orderlist.get(i).getId()), 
    			orderlist.get(i).getType(), 
    			orderlist.get(i).getState(), orderlist.get(i).
    			getLasttime()));
    	}
    	  OrderNum.setCellValueFactory(
		            new PropertyValueFactory<>("ordernum"));		 
		  OrderNum.setCellFactory(TextFieldTableCell.<SimpleRoom>forTableColumn());
		  OrderNum.setOnEditCommit(
		            (CellEditEvent<SimpleRoom, String> t) -> {
		                ((SimpleRoom) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setRoomnum(t.getNewValue());
		        });
		  OrderInfo.setCellValueFactory(
		            new PropertyValueFactory<>("orderinfo"));
		 
		  OrderInfo.setCellFactory(TextFieldTableCell.<SimpleRoom>forTableColumn());
		  orderInfo.setOnEditCommit(
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
	
}
