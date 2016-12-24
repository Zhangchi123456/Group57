package presentation.presentationController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogicService.Service.OrderLogicService;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.userui.AlertBox;
import vo.OrderVO;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class HotelorderuiController implements Initializable{
	@FXML
	private Button ok,back;
	
	@FXML
	private TableView<SimpleHotelOrder> table;
	
	@FXML
	private TableColumn<SimpleHotelOrder, String> OrderNum,OrderInfo,State;//订单号，订单人数，状态
	
	@FXML
	private Label OrderList;
	
	@FXML
	private ChoiceBox<String> stateFind;//订单状态选择框
	
    public ObservableList<SimpleHotelOrder> temp;
	public static String Orderid;
	
	String Name = HotelmanageController.getHotelVO().getName();
	OrderLogicService am = new OrderLogicServiceImpl();
	ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();
     
	AlertBox alt;
	@FXML//返回按钮
	private void ReturnClicked(ActionEvent event) throws IOException{
		UiswitchHelper.getApplication().goto_HotelMainui();
		
	}
	@FXML//跳转至订单信息界面
	private void CheckClicked(ActionEvent event) throws IOException{
		if(!table.getSelectionModel().isEmpty()){
		int selectnumber=table.getSelectionModel().getSelectedIndex();
		temp=table.getItems();
	    Orderid = temp.get(selectnumber).getOrdernum();
	    
		UiswitchHelper.getApplication().goto_ordeinfoui();
		}
		else{
			alt = new AlertBox();
			alt.display("请先选择！");
		}
	}
	
	 @SuppressWarnings("unused")
	@FXML //选择框监听
	private void ChoiceBoxClicked(ActionEvent event){
		 orderlist = am.findUserOrderListHotel(Name);
		 ArrayList<OrderVO> templist = new ArrayList<OrderVO>();
		 
		 if(stateFind.getValue().equals("所有订单")){
			 if(orderlist!=null){
	    	 HotelOrderlist(orderlist); 
			 }
		 }
		 
		 if(stateFind.getValue().equals("未执行订单")){
			 for(int i=0;i<orderlist.size();i++){
				 if(orderlist.get(i).getState().equals("未执行")){
					 templist.add(orderlist.get(i));
				 }
			 }
			 if(templist!=null){
	    	 HotelOrderlist(templist); 
			 }else{
				 alt = new AlertBox();
				 alt.display("无订单！");
			 }
		 }
		 
		 if(stateFind.getValue().equals("已执行订单")){
			 for(int i=0;i<orderlist.size();i++){
				 if(orderlist.get(i).getState().equals("已执行")){
					 templist.add(orderlist.get(i));
				 }
			 }
			 if(templist!=null){
	    	 HotelOrderlist(templist); 
			 }else{
				 alt = new AlertBox();
				 alt.display("无订单！");
			 }
		 }
		 
		 if(stateFind.getValue().equals("异常订单")){
			 for(int i=0;i<orderlist.size();i++){
				 if(orderlist.get(i).getState().equals("异常")){
					 templist.add(orderlist.get(i));
				 }
			 }
			 if(templist!=null){
	    	 HotelOrderlist(templist); 
			 }else{
				 alt = new AlertBox();
				 alt.display("无订单！");
			 }
		 }
		 
		 if(stateFind.getValue().equals("已撤销订单")){
			 for(int i=0;i<orderlist.size();i++){
				 if(orderlist.get(i).getState().equals("已撤销")){
					 templist.add(orderlist.get(i));
				 }
			 }
			 if(templist!=null){
	    	 HotelOrderlist(templist); 
			 }else{
				 alt = new AlertBox();
				 alt.display("无订单！");
			 } 
		 }
	 
	 }
	 
	@Override//界面初始化方法
	public void initialize(URL location, ResourceBundle resources) {
		stateFind.setValue("所有订单"); 
		orderlist = am.findUserOrderListHotel(Name);
    	 if(orderlist!=null){
    	 HotelOrderlist(orderlist);
    	 }
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
	//表中项
	public void  HotelOrderlist(ArrayList<OrderVO> list){
    	ObservableList<SimpleHotelOrder> temp =FXCollections.observableArrayList();
    	for(int i=0;i<list.size();i++){
    	temp.add(new SimpleHotelOrder(String.valueOf(list.get(i).getId()), 
    			String.valueOf(list.get(i).getPeoplenum())+" "+list.get(i).isHavekids(), 
    			list.get(i).getState()
    			));
    	}
    	  OrderNum.setCellValueFactory(
		            new PropertyValueFactory<>("ordernum"));		 
		  OrderNum.setCellFactory(TextFieldTableCell.<SimpleHotelOrder>forTableColumn());
		  OrderNum.setOnEditCommit(
		            (CellEditEvent<SimpleHotelOrder, String> t) -> {
		                ((SimpleHotelOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setOrdernum(t.getNewValue());
		        });
		  OrderInfo.setCellValueFactory(
		            new PropertyValueFactory<>("orderinfo"));
		 
		  OrderInfo.setCellFactory(TextFieldTableCell.<SimpleHotelOrder>forTableColumn());
		  OrderInfo.setOnEditCommit(
		            (CellEditEvent<SimpleHotelOrder, String> t) -> {
		                ((SimpleHotelOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setOrderinfo(t.getNewValue());
		        });
		  State.setCellValueFactory(
		            new PropertyValueFactory<>("state"));
		 
		  State.setCellFactory(TextFieldTableCell.<SimpleHotelOrder>forTableColumn());
		  State.setOnEditCommit(
		            (CellEditEvent<SimpleHotelOrder, String> t) -> {
		                ((SimpleHotelOrder) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setState(t.getNewValue());
		        });
		  table.setItems(temp);
	}	
}
