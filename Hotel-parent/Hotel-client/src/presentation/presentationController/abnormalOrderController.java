package presentation.presentationController;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.MemberLogicService;
import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.MemberLogicServiceImpl;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import Helper.UiswitchHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.userui.AlertBox;
import vo.CreditRecordVO;
import vo.MemberVO;
import vo.OrderVO;

public class abnormalOrderController implements Initializable{
	
	//类需要的对象和引用
	  public ObservableList<SimpleOrder> temp;
	  OrderLogicService am = new OrderLogicServiceImpl();
	  AlertBox alt = new AlertBox();
	  MemberLogicService memberlogic = new MemberLogicServiceImpl();
	  ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
	  MemberVO membervo = new MemberVO(0, 0, null, null, null);
	  
	//界面项
    @FXML
    private TableView<SimpleOrder> Table;//异常订单表
    @FXML
    private TableColumn<SimpleOrder,String> OrderId,User,HotelName,OrderPrice;//表中项
    @FXML
    private RadioButton  halfcredit,allcredit;
 
    //界面跳转
    //返回按钮的监听
	@FXML
	private void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
	}
	//撤销按钮的监听
	@FXML
	private void DeleteClicked(ActionEvent event){
	
		int selectnumber=Table.getSelectionModel().getSelectedIndex();
		
		if(halfcredit.isSelected()&&allcredit.isSelected()){
			alt.display("选择错误");
		}
		else if(!halfcredit.isSelected()&&!allcredit.isSelected()){
			alt.display("未选择处理方法");
		}
		else if(halfcredit.isSelected()){
			membervo=memberlogic.Findmemberbyname(orderlist.get(selectnumber).getName());
			int credit = (int) Double.parseDouble(orderlist.get(selectnumber).getPrice())/2+membervo.getMembercreditvalue();
			membervo.setMembercreditvalue(credit);
			CreditRecordVO creditvo=new CreditRecordVO();
			creditvo.action="异常订单撤销";
			creditvo.creditchange=String.valueOf(credit);
			creditvo.time=LocalDate.now().toString();
			creditvo.membername=membervo.getname();
			creditvo.creditlast=String.valueOf(membervo.getcredit());
			creditvo.orderid=orderlist.get(selectnumber).getId();
			memberlogic.addCreditRecord(creditvo);					
			memberlogic.updateMemberinfo(membervo);
			alt.display("更改成功");
			orderlist=am.orderShowAllByStation("异常订单");
			 if(orderlist!=null);
			 Orderlist(orderlist);
		}
		else if(allcredit.isSelected()){
			membervo=memberlogic.Findmemberbyname(orderlist.get(selectnumber).getName());
			int credit =(int) Double.parseDouble(orderlist.get(selectnumber).getPrice())*1+membervo.getMembercreditvalue();
			membervo.setMembercreditvalue(credit);
			CreditRecordVO creditvo=new CreditRecordVO();
			creditvo.action="异常订单撤销";
			creditvo.creditchange=String.valueOf(credit);
			creditvo.time=LocalDate.now().toString();
			creditvo.membername=membervo.getname();
			creditvo.creditlast=String.valueOf(membervo.getcredit());
			creditvo.orderid=orderlist.get(selectnumber).getId();
			memberlogic.addCreditRecord(creditvo);
			memberlogic.updateMemberinfo(membervo);
			boolean a =am.changeOrderStation(orderlist.get(selectnumber).getId(),"已撤销订单");
			if(a)
			alt.display("更改成功");
			orderlist=am.orderShowAllByStation("异常订单");
			 if(orderlist!=null);
			 Orderlist(orderlist);
		}
		
	}

	//界面初始化
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		orderlist=am.orderShowAllByStation("异常订单");
		 if(orderlist!=null);
    	 Orderlist(orderlist);
    	 
	}
	 public void  Orderlist(ArrayList<OrderVO > orderlist){
    	 temp =FXCollections.observableArrayList();
    	 for(int i=0;i<orderlist.size();i++){
    		 temp.add(new SimpleOrder(orderlist.get(i).getHotelid(),orderlist.get(i).getId(),
    				 orderlist.get(i).getName(),orderlist.get(i).getPrice()));   		 
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
		  User.setCellValueFactory(
		            new PropertyValueFactory<>("time"));
		 
		  User.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  User.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setTime(t.getNewValue());
		        });
		  OrderPrice.setCellValueFactory(
		            new PropertyValueFactory<>("price"));
		 
		  OrderPrice.setCellFactory(TextFieldTableCell.<SimpleOrder>forTableColumn());
		  OrderPrice.setOnEditCommit(
		            (CellEditEvent<SimpleOrder, String> t) -> {
		                ((SimpleOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setPrice(t.getNewValue());
		        });
		    Table.setItems(temp);
	 }
	//Order 的简化
			public static class SimpleOrder {		 		         
		         SimpleStringProperty time;
		         SimpleStringProperty price;		         
		         SimpleStringProperty hotel;
		         SimpleStringProperty order;
		        private SimpleOrder(String hotelName,String orderid,String time,String price){
		        	  this.hotel = new SimpleStringProperty(hotelName);
		        	  this.order = new SimpleStringProperty(orderid);
		        	  this.time = new SimpleStringProperty(time);    	  
		        	  this.price = new SimpleStringProperty(price);
		   
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
		  }
	}

