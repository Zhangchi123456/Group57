package presentation.presentationController;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.impl.PromotionLogicServiceImpl;
import Controller.HotelmanageController;
import Helper.UiswitchHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import presentation.presentationController.webdiscountdateuiController.DateInfo;
import presentation.userui.AlertBox;
import vo.HotelPromotionVO;
import vo.WebPromotionVO;

public class hoteldiscountdateuiController implements Initializable{
	
	@FXML
	private Button button_birthday;
	
	@FXML
	private Button button_businesspartner;
	
	@FXML
	private Button button_roomnumber;
	
	@FXML
	private TextField hoteldiscountdatediscount;
	
	@FXML
	private TableView<DateInfo> hoteldiscountdateTable;
	
	@FXML
	private TableColumn<DateInfo,String> hoteldiscountdateTable_start;
	
	@FXML
	private TableColumn<DateInfo,String> hoteldiscountdateTable_end;
	
	@FXML
	private TableColumn<DateInfo,String> hoteldiscountdateTable_discount;
	
	@FXML
	private TableColumn<DateInfo,String> id;
	
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
	
	private ObservableList<DateInfo> data;
	
	String hotel_name = HotelmanageController.getHotelVO().getName();
	String name = "日期折扣";
	
	@FXML
	public void toBusinesspartner(ActionEvent event){
		UiswitchHelper.getApplication().goto_businesspartnerui();
	}
	
	@FXML
	public void toRoomnumber(ActionEvent event){
		UiswitchHelper.getApplication().goto_roomnumberui();
	}
	
	@FXML
	public void toBirthday(ActionEvent event){
		UiswitchHelper.getApplication().goto_birthdayui();
	}
	
	@FXML
	public void delete(ActionEvent event){
		
		if(hoteldiscountdateTable.getSelectionModel()!=null){
			
			int selectnumber=hoteldiscountdateTable.getSelectionModel().getSelectedIndex();
			String start = data.get(selectnumber).getStart();
			String end = data.get(selectnumber).getEnd();
			double discount = Double.parseDouble(data.get(selectnumber).getDiscount());
			int id = Integer.parseInt(data.get(selectnumber).getID());
		
			PromotionLogicService promotion = new PromotionLogicServiceImpl();
		
			HotelPromotionVO vo = new HotelPromotionVO(hotel_name, name, 0, 0, 0, discount/100, start, end, id);
		
			promotion.deleteHotelPromotion(vo);
		
			this.showTable(name,hotel_name);
			
		}else{
			AlertBox alt = new AlertBox();
			alt.display("请先做出选择！");
		}

	}
	
	@FXML
	public void add(ActionEvent event){
	
		String start = TimeBegin.getValue().toString();
		String end = TimeEnd.getValue().toString();
		String input = newDiscount.getText();
		
		if(input!=null && start!=null && end!=null){
			
			double discount = Double.parseDouble(input);
			
			if(discount<0||discount>100){
				AlertBox alt = new AlertBox();
				alt.display("超出输入范围！");
			}else if(discount==0){
				AlertBox alt = new AlertBox();
				alt.display("不可为0！");
			}else{
		
				HotelPromotionVO vo = new HotelPromotionVO(hotel_name, name, 0, 0, 0, discount/100, start, end, 0);
				
				PromotionLogicService promotion = new PromotionLogicServiceImpl();
				promotion.addHotelPromotion(vo);
				
				this.showTable(name,hotel_name);
			
			}
		}else{
			AlertBox alt = new AlertBox();
			alt.display("信息填写不完整！");
		}
	}
	
	@FXML
	public void toBack(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelMainui();
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.showTable(name,hotel_name);
	
	}
	
	public void showTable(String name,String hotel_name){
		
		data = FXCollections.observableArrayList();
				
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		ArrayList<HotelPromotionVO> proList= promotion.getHotelPromotionList(name,hotel_name);

		
		for(int i=0;i<proList.size();i++){
			
			HotelPromotionVO vo = proList.get(i);
			String start = vo.getStartDate();
			String end = vo.getEndDate();
			String discount = String.valueOf(vo.getDateDiscount()*100);
			String ID = String.valueOf(vo.getId());
			
			DateInfo info = new DateInfo(start,end,discount,ID);
			
			data.add(info);
        }
		
		hoteldiscountdateTable_start.setCellValueFactory( new PropertyValueFactory<>("start") );
		hoteldiscountdateTable_start.setCellFactory(TextFieldTableCell.<DateInfo>forTableColumn());
		hoteldiscountdateTable_start.setOnEditCommit(
	            (CellEditEvent<DateInfo, String> t) -> {
	                ((DateInfo) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setStart(((t.getNewValue())));
	        });
		
		hoteldiscountdateTable_end.setCellValueFactory( new PropertyValueFactory<>("end") );
		hoteldiscountdateTable_end.setCellFactory(TextFieldTableCell.<DateInfo>forTableColumn());
		hoteldiscountdateTable_end.setOnEditCommit(
	            (CellEditEvent<DateInfo, String> t) -> {
	                ((DateInfo) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setStart(((t.getNewValue())));
	        });
		
		hoteldiscountdateTable_discount.setCellValueFactory( new PropertyValueFactory<>("discount") );
		hoteldiscountdateTable_discount.setCellFactory(TextFieldTableCell.<DateInfo>forTableColumn());
		hoteldiscountdateTable_discount.setOnEditCommit(
	            (CellEditEvent<DateInfo, String> t) -> {
	                ((DateInfo) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setStart(((t.getNewValue())));
	        });
		
		id.setCellValueFactory( new PropertyValueFactory<>("ID") );
		id.setCellFactory(TextFieldTableCell.<DateInfo>forTableColumn());
		id.setOnEditCommit(
	            (CellEditEvent<DateInfo, String> t) -> {
	                ((DateInfo) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setStart(((t.getNewValue())));
	        });
		
		hoteldiscountdateTable.setItems(data);
		
	}
	
	
	public static class DateInfo{
		
		private final SimpleStringProperty start;
        private final SimpleStringProperty end;
        private final SimpleStringProperty discount;
        private final SimpleStringProperty ID;
        
        DateInfo(String start, String end, String discount, String ID){
        	this.start = new SimpleStringProperty(start);
        	this.end = new SimpleStringProperty(end);
        	this.discount = new SimpleStringProperty(discount);
        	this.ID = new SimpleStringProperty(ID);
        }
        
        public void setStart(String start){
        	this.start.set(start);
        }
        
        public void setEnd(String end){
        	this.end.set(end);
        }
        
        public void setDiscount(String discount){
        	this.discount.set(discount);
        }
        
        public void setID(String ID){
        	this.ID.set(ID);
        }
        
        public String getStart(){
        	return start.get();
        }
        
        public String getEnd(){
        	return end.get();
        }
        
        public String getDiscount(){
        	return discount.get();
        }
        
        public String getID(){
        	return ID.get();
        }
	}


}


