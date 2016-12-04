package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import Controller.MemberActController;
import Helper.UiswitchHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.presentationController.OrderlistuiController.SimpleOrder;
import vo.MemberVO;
import vo.OrderVO;

public class MyHotelOrderuiController implements Initializable{
	@FXML
	private Button ReturnButton;
	@FXML
	private TableView<SimpleOrder> HotelTable;//酒店列表
	@FXML
	private TableColumn<SimpleOrder,String> HotelName,OrderTime,OrderStation;//表中项目
	
	String UserName = MemberActController.getmemberVo().getname();
	   OrderLogicService am = new OrderLogicServiceImpl();
	   ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
	   
	//监听方法
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Usermainui();
	}
	@FXML
	private void RefrashClicked(ActionEvent event){
		 orderlist =am.findUserOrderListAll(UserName);
    	 if(orderlist!=null);
    	 Orderlist(orderlist);
	}
	
	
	//初始化方法
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 orderlist =am.findUserOrderListAll(UserName);
    	 if(orderlist!=null);
    	 Orderlist(orderlist);
	}
	
	 public void  Orderlist(ArrayList<OrderVO > orderlist){
	    	ObservableList<SimpleOrder> temp =FXCollections.observableArrayList();
	    	for(int i=0;i<orderlist.size();i++){
	    		temp.add(new SimpleOrder(orderlist.get(i).getHotelid(),orderlist.get(i).getStarttime()+"——"
	   		+orderlist.get(i).getLeavetime(),orderlist.get(i).getState()));
	    	}
		//	  ObservableList<SimpleOrder> data =FXCollections.observableArrayList(
		//			  new SimpleOrder("aweqwqwe","bqweqqwess","c","d","f","g","q"),
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
			 
			  OrderTime.setCellValueFactory(
			            new PropertyValueFactory<>("time"));
			 
			  OrderTime.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
			  OrderTime.setOnEditCommit(
			            (CellEditEvent<SimpleOrder, String> t) -> {
			                ((SimpleOrder) t.getTableView().getItems().get(
			                        t.getTablePosition().getRow())
			                        ).setTime(t.getNewValue());
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
		
			      HotelTable.setItems(temp);


		}
	//Order 的简化
			public static class SimpleOrder {		 		         
		         SimpleStringProperty time;		      		      		         
		         SimpleStringProperty orderstation;
		         SimpleStringProperty hotel;
		        
		        private SimpleOrder(String hotelName,String time,String orderstate){
		        	 this.hotel = new SimpleStringProperty(hotelName);		        	 
		        	  this.time = new SimpleStringProperty(time);    	         		        		        
		        	  this.orderstation = new SimpleStringProperty(orderstate);
		        }  
		       public void setHotel(String hotelName){
		    	   hotel.set(hotelName);
		       }
		       public String getHotel(){
		    	   return hotel.get();
		       }
		   
				public void setOrderStation(String hotelName) {
					// TODO Auto-generated method stub
					orderstation.set(hotelName);
				}			
				public void setTime(String hotelName) {
					// TODO Auto-generated method stub
					time.set(hotelName);
				}								     
					public String getTime() {
					return time.get();
				}				
				public String getOrderstation() {
					return orderstation.get();
				}

			
		 
		    
		  
	}
}