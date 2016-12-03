
package presentation.presentationController;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import vo.MemberVO ;
import vo.OrderVO;
import Helper.UiswitchHelper;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import Controller.ReservationController;

import javafx.scene.control.TableColumn.CellEditEvent;
public class OrderlistuiController implements Initializable{
   @FXML
   private Button ReturnButton;
   @FXML
   private TableView<SimpleOrder> OrderList;
   @FXML
   private TableColumn<SimpleOrder,String> HotelName,OrderId,Time,Price,Room,Evaluate,OrderStation;
   @FXML
   private ChoiceBox OrderStationChoiceBox;
   
   @FXML
   private void ReturnButtonClicked(ActionEvent event){
	   UiswitchHelper.getApplication().goto_Usermainui();
   }
   
   @FXML 
   private void EvaluateClicked(ActionEvent event){
	   UiswitchHelper.getApplication().goto_OrderEvaluateui();
   }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		OrderLogicService am = new OrderLogicServiceImpl();
		String UserName = "";
    	ArrayList<OrderVO> orderlist =am.findUserOrderListAll(UserName);
    	ArrayList<SimpleOrder> temp = new ArrayList<SimpleOrder>();
    	for(int i=0;i<orderlist.size();i++){
    		temp.add(new SimpleOrder(orderlist.get(i).hotelname,String.valueOf(orderlist.get(i).orderid),String.valueOf(orderlist.get(i).BeginDate)+"-"
    		+String.valueOf(orderlist.get(i).EndDate),String.valueOf(orderlist.get(i).orderprice),orderlist.get(i).roomname,orderlist.get(i).orderEvaluation,orderlist.get(i).orderstate));
    	}
    	
	    	OrderStationChoiceBox.setValue("所有订单");
		  ObservableList<SimpleOrder> data =FXCollections.observableArrayList(temp);
	//		  new SimpleOrder("a","b","c","d","f","","")
		     
		  HotelName.setCellValueFactory(
		            new PropertyValueFactory<>("hotelname"));
		 
		  HotelName.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  HotelName.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setHotelName(t.getNewValue());
		        });
		 OrderId.setCellValueFactory(
		            new PropertyValueFactory<>("orderid"));
		 
		  OrderId.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  OrderId.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setOrderId(t.getNewValue());
		        });
		  Time.setCellValueFactory(
		            new PropertyValueFactory<>("time"));
		 
		  Time.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  Time.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setTime(t.getNewValue());
		        });
		 Price.setCellValueFactory(
		            new PropertyValueFactory<>("price"));
		 
		  Price.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  Price.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setPrice(t.getNewValue());
		        });
		  Room.setCellValueFactory(
		            new PropertyValueFactory<>("room"));
		 
		  Room.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  Room.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setRoom(t.getNewValue());
		        });
		  Evaluate.setCellValueFactory(
		            new PropertyValueFactory<>("evaluate"));
		 
		  Evaluate.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  Evaluate.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setEvaluate(t.getNewValue());
		        });
		  OrderStation.setCellValueFactory(
		            new PropertyValueFactory<>("orderstation"));
		 
		  OrderStation.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  OrderStation.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setOrderStation(t.getNewValue());
		        });
		       OrderList.setItems(data);


	}
		public static class SimpleOrder {
		 
	        private final SimpleStringProperty hotelname;
	        private final SimpleStringProperty orderid;
	        private final SimpleStringProperty time;
	        private final SimpleStringProperty price;
	        private final SimpleStringProperty room;
	        private final SimpleStringProperty evaluate;
	        private final SimpleStringProperty orderstation;
	 
	        private SimpleOrder(String hotelname,String orderid,String time,String price,String roomname,String evaluate,String orderstate){
	        	  this.hotelname = new SimpleStringProperty(hotelname);
	        	  this.orderid = new SimpleStringProperty(String.valueOf(orderid));
	        	  this.time = new SimpleStringProperty(time);    	  
	        	  this.price = new SimpleStringProperty(String.valueOf(price));
	        	  this.room = new SimpleStringProperty(roomname);
	        	  this.evaluate = new SimpleStringProperty(evaluate);
	        	  this.orderstation = new SimpleStringProperty(orderstate);
	        }  
	 
	        public void setHotelName(String hotelname) {
				// TODO Auto-generated method stub
	        	this.hotelname.set(hotelname);
			}

			public void setOrderStation(String hotelname) {
				// TODO Auto-generated method stub
				orderstation.set(hotelname);
			}

			public void setEvaluate(String hotelname) {
				// TODO Auto-generated method stub
				evaluate.set(hotelname);
			}

			public void setRoom(String hotelname) {
				// TODO Auto-generated method stub
				room.set(hotelname);
			}

			public void setPrice(String hotelname) {
				// TODO Auto-generated method stub
				price.set(hotelname);
			}

			public void setTime(String hotelname) {
				// TODO Auto-generated method stub
				time.set(hotelname);
			}

			public void setOrderId(String hotelname) {
				// TODO Auto-generated method stub
				orderid.set(hotelname);
			}

	

			public String getHotelName() {
	            return hotelname.get();
	        }
	 
	     

			public String getOrderId() {
				return orderid.get();
			}

			public String getTime() {
				return time.get();
			}

			public String getPrice() {
				return price.get();
			}

			public String getRoom() {
				return room.get();
			}

			public String getEvaluate() {
				return evaluate.get();
			}

			public String getOrderstation() {
				return orderstation.get();
			}

		
	 
	    
	  }
}