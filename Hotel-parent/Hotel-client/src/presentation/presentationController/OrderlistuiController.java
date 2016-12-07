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
import Controller.MemberActController;
import Controller.ReservationController;

import javafx.scene.control.TableColumn.CellEditEvent;
public class OrderlistuiController implements Initializable{
	//界面项目
   @FXML
   private Button ReturnButton;
   @FXML
   private TableView<SimpleOrder> OrderList;
   @FXML
   private TableColumn<SimpleOrder,String> HotelName,OrderId,Time,Price,Room,Evaluate,OrderStation;
   @FXML
   private ChoiceBox OrderStationChoiceBox;
   
   public ObservableList<SimpleOrder> temp;
   public  static String Orderid;
   public static String Hotelname;
  
   String UserName ="";// MemberActController.getmemberVo().getname();
   OrderLogicService am = new OrderLogicServiceImpl();
   ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
   
   
   //监听
   @FXML
   private void ReturnButtonClicked(ActionEvent event){
	   UiswitchHelper.getApplication().goto_Usermainui();
   }
   
   @FXML 
   private void EvaluateClicked(ActionEvent event){
	   
	   int selectnumber=OrderList.getSelectionModel().getSelectedIndex();
	  
	    Orderid=  temp.get(selectnumber).getOrder();
	    Hotelname  = temp.get(selectnumber).getHotel();
	    
	
	   UiswitchHelper.getApplication().goto_OrderEvaluateui();
   }
   @FXML 
   private void ChoiceBoxClicked(ActionEvent event){
	  if(OrderStationChoiceBox.getValue().equals("已执行订单")){
		  orderlist = am.findUserOrderListStation(UserName, "已执行订单");
		  if(orderlist!=null);
		  Orderlist(orderlist);
	  }
	  if(OrderStationChoiceBox.getValue().equals("未执行订单")){
		  orderlist = am.findUserOrderListStation(UserName, "未执行订单");
		  if(orderlist!=null);
		  Orderlist(orderlist);
	  }
	  if(OrderStationChoiceBox.getValue().equals("异常订单")){
		  orderlist = am.findUserOrderListStation(UserName, "异常订单");
		  if(orderlist!=null);
		  Orderlist(orderlist);
	  }
	  if(OrderStationChoiceBox.getValue().equals("所有订单")){
		  orderlist = am.findUserOrderListAll(UserName);
		  if(orderlist!=null);
		  Orderlist(orderlist);
	  }
   }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		OrderStationChoiceBox.setValue("所有订单");
    	 orderlist =am.findUserOrderListAll(UserName);
    	 if(orderlist!=null);
    	 Orderlist(orderlist);
	}
	
	
	
	
//orderlist在表中显示的方法	
	 public void  Orderlist(ArrayList<OrderVO > orderlist){
    	 temp =FXCollections.observableArrayList();
    	for(int i=0;i<orderlist.size();i++){
    	temp.add(new SimpleOrder(orderlist.get(i).getHotelid(),orderlist.get(i).getId(),orderlist.get(i).getStarttime().toString()+"——"
   		+orderlist.get(i).getLeavetime().toString(),orderlist.get(i).getPrice(),
   		String.valueOf(orderlist.get(i).getSingleRoom()+orderlist.get(i).getFamilyRoom()+orderlist.get(i).getStandardRoom()+orderlist.get(i).getSuiteRoom()),
   		orderlist.get(i).getComment(),orderlist.get(i).getState()));
    	}
	//	  ObservableList<SimpleOrder> data =FXCollections.observableArrayList(
	//			  new SimpleOrder("123456","zhangchi","无","如家酒店","2016/6/16","2016/6/18","未执行"，"12.0","2016/6/16","2016/6/18",2,false,0,1,1,0),
		//		  new SimpleOrder("a","b","c","d","f","g","q"),
			//	  new SimpleOrder("a","b","c","d","f","g","q")
		//		  );
	//		  new SimpleOrder("a","b","c","d","f","","")
		     

		  HotelName.setCellValueFactory(
		            new PropertyValueFactory<>("hotel"));		 
		  HotelName.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  HotelName.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setHotel(t.getNewValue());
		        });
		  OrderId.setCellValueFactory(
		            new PropertyValueFactory<>("order"));
		 
		  OrderId.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  OrderId.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setOrder(t.getNewValue());
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
	
		       OrderList.setItems(temp);


	}
//Order 的简化
		public static class SimpleOrder {		 		         
	         SimpleStringProperty time;
	         SimpleStringProperty price;
	         SimpleStringProperty room;
	         SimpleStringProperty evaluate;
	         SimpleStringProperty orderstation;
	         SimpleStringProperty hotel;
	         SimpleStringProperty order;
	        private SimpleOrder(String hotelName,String orderid,String time,String price,String roomname,String evaluate,String orderstate){
	        	  this.hotel = new SimpleStringProperty(hotelName);
	        	  this.order = new SimpleStringProperty(orderid);
	        	  this.time = new SimpleStringProperty(time);    	  
	        	  this.price = new SimpleStringProperty(price);
	        	  this.room = new SimpleStringProperty(roomname);
	        	  this.evaluate = new SimpleStringProperty(evaluate);
	        	  this.orderstation = new SimpleStringProperty(orderstate);
	        }  
	       public void setHotel(String hotelName){
	    	   hotel.set(hotelName);
	       }
	       public String getHotel(){
	    	   return hotel.get();
	       }
	       public void setOrder(String hotelName){
	    	   order.set(hotelName);
	    	   
	       }
	       public String getOrder(){
	    	   return order.get();
	       }
	        public void setRoom(String hotelName) {
				// TODO Auto-generated method stub
	        	room.set(hotelName);
			}

			public void setOrderStation(String hotelName) {
				// TODO Auto-generated method stub
				orderstation.set(hotelName);
			}

			public void setEvaluate(String hotelName) {
				// TODO Auto-generated method stub
				evaluate.set(hotelName);
			}

			public void setPrice(String hotelName) {
				// TODO Auto-generated method stub
				price.set(hotelName);
			}

			public void setTime(String hotelName) {
				// TODO Auto-generated method stub
				time.set(hotelName);
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

