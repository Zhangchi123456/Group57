package presentation.presentationController;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.impl.PromotionLogicServiceImpl;
import Controller.HotelmanageController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelPromotionVO;

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
	private TableView hoteldiscountdateTable;
	
	@FXML
	private TableColumn hoteldiscountdateTable_start;
	
	@FXML
	private TableColumn hoteldiscountdateTable_end;
	
	@FXML
	private TableColumn hoteldiscountdateTable_discount;
	
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
		
	}
	
	@FXML
	public void add(ActionEvent event){
	
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
				
				String name = "日期折扣";
		
				String hotel_name = HotelmanageController.getHotelVO().getName();
				HotelPromotionVO vo = new HotelPromotionVO(hotel_name, name, 0, 0, 0, discount/100, start_date, end_date);
				
				PromotionLogicService promotion = new PromotionLogicServiceImpl();
				promotion.addHotelPromotion(vo);
			}
		}
	}
	
	@FXML
	public void toBack(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelMainui();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


}


