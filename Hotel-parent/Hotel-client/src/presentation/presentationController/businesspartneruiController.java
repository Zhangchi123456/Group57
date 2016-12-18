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

public class businesspartneruiController implements Initializable{
	
	@FXML
	private Button button_birthday;
	
	@FXML
	private Button button_roomnumber;
	
	@FXML
	private Button button_hoteldiscountdate;
	
	@FXML
	private TextField businesspartnerdiscount;
	
	@FXML
	private Button confirm;
	
	@FXML
	private Button back;
	
	private int id = 0;
	
	@FXML
	public void toBirthday(ActionEvent event){
		UiswitchHelper.getApplication().goto_birthdayui();
	}
	
	@FXML
	public void toRoomnumber(ActionEvent event){
		UiswitchHelper.getApplication().goto_roomnumberui();
	}
	
	@FXML
	public void toHoteldiscountdate(ActionEvent event){
		UiswitchHelper.getApplication().goto_hoteldiscountdateui();
	}
	
	@FXML
	public void SureClicked(ActionEvent event){
	//确认更新
		if(!businesspartnerdiscount.getText().isEmpty()){
			
			String input = businesspartnerdiscount.getText();
			
			double discount = Double.parseDouble(input);
				if(discount<0||discount>100){
					AlertBox alt = new AlertBox();
					alt.display("超出输入范围！");
				}else if(discount==0){
					AlertBox alt = new AlertBox();
					alt.display("不可为0！");
				}else{
					String name = "企业折扣";
					String hotel_name = HotelmanageController.getHotelVO().getName();
					HotelPromotionVO vo = new HotelPromotionVO(hotel_name, name, 0, discount/100, 0, 0, null, null, id);
					
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

	
	@FXML
	public void toBack(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelMainui();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		HotelPromotionVO vo;
		String hotel_name = HotelmanageController.getHotelVO().getName();
		String name = "企业折扣";
		vo = promotion.getHotelPromotion(hotel_name,name);
		id = vo.getId();
		double discount = vo.getEnterpriceDiscount()*100;
		businesspartnerdiscount.setText(String.valueOf(discount));
		
	}


}
