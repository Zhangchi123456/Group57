package presentation.presentationController;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.impl.PromotionLogicServiceImpl;
import Controller.HotelmanageController;
import Helper.UiswitchHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import presentation.presentationController.HotelListuiController.SimpleHotel;
import presentation.presentationController.hoteldiscountdateuiController.DateInfo;
import presentation.userui.AlertBox;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public class webdiscountdateuiController implements Initializable{
	
	@FXML
	private Button button_businesscircle;
	
	@FXML
	private Button button_memberlevel;
	
	@FXML
	private TextField webdiscountdatediscount;
	
	@FXML
	private TableView<DateInfo> webdiscountdateTable;
	
	@FXML
	private TableColumn<DateInfo,String> webdiscountdateTable_start;
	
	@FXML
	private TableColumn<DateInfo,String> webdiscountdateTable_end;
	
	@FXML
	private TableColumn<DateInfo,String> webdiscountdateTable_discount;
	
	@FXML
	private Button delete;
	
	@FXML
	private DatePicker TimeBegin,TimeEnd;
	
	@FXML
	private TextField newDiscount;
	
	@FXML
	private Button confirm;
	
	@FXML
	private Button back;
	
	final static ObservableList<DateInfo> data = FXCollections.observableArrayList();
	
	//跳到会员等级折扣
	@FXML
	public void MemberClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_memberlevelui();
	}
	//调到商圈折扣
	@FXML
	public void BusinessClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_businesscircleui();
	}
	//返回网站营销人员主界面
	@FXML
	public void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
	}
	//添加策略确认按钮
	@FXML
	public void SureClicked(ActionEvent event){
		String start = TimeBegin.getValue().toString();
		String end = TimeEnd.getValue().toString();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Date start_date = null;
		Date end_date = null;
		try {
			start_date = sdf.parse(start);
			end_date = sdf.parse(end);
		} catch (ParseException e) {
			AlertBox alt = new AlertBox();
			alt.display("请指定日期！");
		}
		
		String input = newDiscount.getText();
		
		if(input!=null){
			
			double discount = Double.parseDouble(input);
			
			if(discount<0||discount>100){
				AlertBox alt = new AlertBox();
				alt.display("超出输入范围！");
			}else if(discount==0){
				AlertBox alt = new AlertBox();
				alt.display("不可为0！");
			}else{
		
				WebPromotionVO vo = new WebPromotionVO(discount/100, start_date, end_date);
				
				PromotionLogicService promotion = new PromotionLogicServiceImpl();
				promotion.addWebPromotion(vo);
				
				this.showTable();
			}
			
		}
	}
	
	//删除策略按钮
	@FXML
	public void DeleteClicked(ActionEvent event){
		
		int selectnumber=webdiscountdateTable.getSelectionModel().getSelectedIndex();
    	String start = data.get(selectnumber).getStart();
		String end = data.get(selectnumber).getEnd();
		double discount = data.get(selectnumber).getDiscount();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Date start_date = null;
		Date end_date = null;
		
		try {
			start_date = sdf.parse(start);
			end_date = sdf.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		
		WebPromotionVO vo = new WebPromotionVO(discount/100,start_date,end_date);
		
		promotion.deleteWebPromotion(vo);
		
		this.showTable();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.showTable();
		
	}
	
	public void showTable(){
		
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		ArrayList<WebPromotionVO> proList= promotion.getWebPromotionList();
		
		for(int i=0;i<proList.size();i++){
			
			WebPromotionVO vo = proList.get(i);
			String start = vo.getStartDate().toString();
			String end = vo.getEndDate().toString();
			double discount = vo.getDateDiscount();;
			
			DateInfo info = new DateInfo(start,end,discount*100);
			
			data.add(info);
        }
		
		webdiscountdateTable_start.setCellValueFactory( new PropertyValueFactory<>("start") );
		webdiscountdateTable_start.setCellFactory(TextFieldTableCell.<DateInfo>forTableColumn());
		webdiscountdateTable_start.setOnEditCommit(
	            (CellEditEvent<DateInfo, String> t) -> {
	                ((DateInfo) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setStart(((t.getNewValue())));
	        });
		
		webdiscountdateTable_end.setCellValueFactory( new PropertyValueFactory<>("end") );
		webdiscountdateTable_end.setCellFactory(TextFieldTableCell.<DateInfo>forTableColumn());
		webdiscountdateTable_end.setOnEditCommit(
	            (CellEditEvent<DateInfo, String> t) -> {
	                ((DateInfo) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setStart(((t.getNewValue())));
	        });
		
		webdiscountdateTable_discount.setCellValueFactory( new PropertyValueFactory<>("discount") );
		webdiscountdateTable_discount.setCellFactory(TextFieldTableCell.<DateInfo>forTableColumn());
		webdiscountdateTable_discount.setOnEditCommit(
	            (CellEditEvent<DateInfo, String> t) -> {
	                ((DateInfo) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setStart(((t.getNewValue())));
	        });
		
		webdiscountdateTable.setItems(data);
		
	}

	public static class DateInfo{
	
		private final SimpleStringProperty start;
		private final SimpleStringProperty end;
    	private final SimpleStringProperty discount;
    
    	private DateInfo(String start, String end, double discount){
    		this.start = new SimpleStringProperty(start);
    		this.end = new SimpleStringProperty(end);
    		this.discount = new SimpleStringProperty(String.valueOf(discount));
    	}
    
    	public void setStart(String start){
    		this.start.set(start);
    	}
    
    	public void setEnd(String end){
    		this.end.set(end);
    	}
    
    	public void setDiscount(double discount){
    		this.discount.set(String.valueOf(discount));
    	}
    
    	public String getStart(){
    		return start.get();
    	}
    
    	public String getEnd(){
    		return end.get();
    	}
    
    	public double getDiscount(){
    		return Double.parseDouble(discount.get());
    	}
	}




}

