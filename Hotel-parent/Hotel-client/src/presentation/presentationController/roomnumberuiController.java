package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.impl.PromotionLogicServiceImpl;
import Controller.HotelmanageController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelPromotionVO;

public class roomnumberuiController implements Initializable{
	
	@FXML
	private Button button_birthday;
	
	@FXML
	private Button button_businesspartner;
	
	@FXML
	private Button button_hoteldiscountdate;
	
	@FXML
	private TextField roomnumberdiscount;
	
	@FXML
	private Button confirm;
	
	@FXML
	private Button back;
	
	private int id = 0;
	
	//界面跳转方法
	@FXML
	public void toBusinesspartner(ActionEvent event){
		UiswitchHelper.getApplication().goto_businesspartnerui();
	}
	
	@FXML
	public void toBirthday(ActionEvent event){
		UiswitchHelper.getApplication().goto_birthdayui();
	}
	
	@FXML
	public void toHoteldiscountdate(ActionEvent event){
		UiswitchHelper.getApplication().goto_hoteldiscountdateui();
	}
	

	@FXML
	public void toBack(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelMainui();
	}
	
	@FXML
	public void update(ActionEvent event){
	//确认更新
		if(!roomnumberdiscount.getText().isEmpty()){
			
			String input = roomnumberdiscount.getText();
			
			double discount = Double.parseDouble(input);
				if(discount<0||discount>100){
					AlertBox alt = new AlertBox();
					alt.display("超出输入范围！");
				}else if(discount==0){
					AlertBox alt = new AlertBox();
					alt.display("不可为0！");
				}else{
					String name = "多间折扣";
					String hotel_name = HotelmanageController.getHotelVO().getName();
					HotelPromotionVO vo = new HotelPromotionVO(hotel_name, name, 0, 0, discount/100, 0, null, null, id);
			
					PromotionLogicService promotion = new PromotionLogicServiceImpl();
					promotion.updateHotelPromotion(vo);
					
					AlertBox alt = new AlertBox();
					alt.display("更新成功！");
				}
				
		}else{
			AlertBox alt = new AlertBox();
			alt.display("不可为空！");
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//界面初始化
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		HotelPromotionVO vo;
		String hotelname = HotelmanageController.getHotelVO().getName();
		String name = "多间折扣";
		vo = promotion.getHotelPromotion(hotelname,name);
		id = vo.getId();
		double discount = vo.getMultiorderDiscount()*100;
		roomnumberdiscount.setText(String.valueOf(discount));
		
	}


}