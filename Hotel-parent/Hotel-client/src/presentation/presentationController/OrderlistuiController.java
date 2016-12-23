package presentation.presentationController;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import BusinessLogicService.Service.MemberLogicService;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.MemberLogicServiceImpl;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import Controller.MemberActController;
import vo.MemberVO;
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
import presentation.userui.AlertBox;


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
   //类需要的引用和对象
   public ObservableList<SimpleOrder> temp;
   public  static String Orderid;
   public static String Hotelname; 
   LoginController login = new LoginController();
   String UserName =login.UserName;
   OrderLogicService order = new OrderLogicServiceImpl();
   ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
   AlertBox alt = new AlertBox();	
   MemberLogicService memberservice=new MemberLogicServiceImpl();
   
   //监听
   @FXML
   private void ReturnButtonClicked(ActionEvent event){
	   UiswitchHelper.getApplication().goto_Usermainui();
   }
   //评价按钮的监听
   @FXML 
   private void EvaluateClicked(ActionEvent event){	   
	   int selectnumber=OrderList.getSelectionModel().getSelectedIndex();
	   if(temp.get(selectnumber).getOrderstation().equals("已执行")){
		   Orderid=  temp.get(selectnumber).getOrder();
		   Hotelname  = temp.get(selectnumber).getHotel();
		   UiswitchHelper.getApplication().goto_OrderEvaluateui();}
	   else{
		   alt.display("未完成订单不能评价");
	   }
	   
   }
   //撤销按钮的监听
   @FXML 
   private void  DeleteOrderClicked(ActionEvent event) throws ParseException{        
	   int selectnumber=OrderList.getSelectionModel().getSelectedIndex();
	   if(!temp.get(selectnumber).getOrderstation().equals("未执行")){
		   alt.display("不能撤销该订单");
	   }
	   else{
		   Orderid=  temp.get(selectnumber).getOrder();
		   boolean bool= order.changeOrderStation(Orderid, "已撤销");
		   double price=Double.parseDouble(temp.get(selectnumber).getPrice());
		   String starttime = null;
		   int cutcredit=0;
		   for(int i=0;i<orderlist.size();i++){
			   
			   if(Orderid==orderlist.get(i).getId()){
				   starttime=orderlist.get(i).getStarttime();
				   cutcredit=Integer.parseInt(orderlist.get(i).getPrice());
			   }
		   }
		   starttime=starttime+" 18:00:00";
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		   SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		   Date startdate=sdf.parse(starttime);
		   String nowdate=sdf2.format(System.currentTimeMillis());
		   Date today=sdf2.parse(nowdate);
		   if((startdate.getTime()-today.getTime())/1000<21600){
			   MemberVO member=MemberActController.getmemberVo();
			   member.setMembercreditvalue(member.getcredit()-cutcredit);
			   memberservice.updateMemberinfo(member);
			   MemberActController.setMembervo(member);
			   
		   }
		   if(bool){ 
			   alt.display("订单已撤销");
			   String tem = (String) OrderStationChoiceBox.getValue();
			   if(tem.equals("未执行订单")){
				   orderlist = order.findUserOrderListStation(UserName, "未执行");
			   }
			   else{
			   orderlist =order.findUserOrderListAll(UserName);
			   }
			   if(orderlist!=null);
			   Orderlist(orderlist);
		   }
	   }
   }
   //订单查询的监听
   @FXML 
   private void ChoiceBoxClicked(ActionEvent event){
	  if(OrderStationChoiceBox.getValue().equals("已执行订单")){
		  orderlist = order.findUserOrderListStation(UserName, "已执行");
		  if(orderlist!=null);
		  Orderlist(orderlist);
	  }
	  if(OrderStationChoiceBox.getValue().equals("未执行订单")){
		  orderlist = order.findUserOrderListStation(UserName, "未执行");
		  if(orderlist!=null);
		  Orderlist(orderlist);
	  }
	  if(OrderStationChoiceBox.getValue().equals("异常订单")){
		  orderlist = order.findUserOrderListStation(UserName, "异常");
		  if(orderlist!=null);
		  Orderlist(orderlist);
	  }
	  if(OrderStationChoiceBox.getValue().equals("所有订单")){
		  orderlist = order.findUserOrderListAll(UserName);
		  if(orderlist!=null);
		  Orderlist(orderlist);}
	  
	  if(OrderStationChoiceBox.getValue().equals("已撤销订单")){
			  orderlist = order.findUserOrderListStation(UserName,"已撤销");
			  if(orderlist!=null);
			  Orderlist(orderlist);	  
	  }
   }
   //界面初始化
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		 OrderStationChoiceBox.setValue("所有订单");
    	 orderlist =order.findUserOrderListAll(UserName);
    	 if(orderlist!=null);
    	 Orderlist(orderlist);
	}
	
	
	
	
//orderlist在表中显示的方法	
	 public void  Orderlist(ArrayList<OrderVO > orderlist){
        temp =FXCollections.observableArrayList();
    	for(int i=0;i<orderlist.size();i++){
    	temp.add(new SimpleOrder(orderlist.get(i).getHotelid(),orderlist.get(i).getId(),orderlist.get(i).getStarttime()+"——"
   		+orderlist.get(i).getLeavetime(),orderlist.get(i).getPrice(),
   		String.valueOf(Integer.parseInt(orderlist.get(i).getSingleRoom())+Integer.parseInt(orderlist.get(i).getFamilyRoom())+Integer.parseInt(orderlist.get(i).getStandardRoom())+Integer.parseInt(orderlist.get(i).getSuiteRoom())),
   		orderlist.get(i).getComment(),orderlist.get(i).getState()));
    	}
	
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
	
		   OrderList.setItems(temp);//将list加入列表中


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

