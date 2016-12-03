package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.impl.PromotionLogicServiceImpl;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelPromotionVO;

public class birthdayuiController implements Initializable{
	
	@FXML
	private Button button_businesspartner;
	
	@FXML
	private Button button_roomnumber;
	
	@FXML
	private Button button_hoteldiscountdate;
	
	@FXML
	private TextField birthdaydiscount;
	
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
	public void toHoteldiscountdate(ActionEvent event){
		UiswitchHelper.getApplication().goto_hoteldiscountdateui();
	}
	
	@FXML
	public void SureClicked(ActionEvent event){
		
		String input = birthdaydiscount.getText();
		
		if(input!=null){
			
			double discount = Double.parseDouble(input);
			
			if(discount<0||discount>100){
				AlertBox alt = new AlertBox();
				alt.display("超出输入范围！");
			}else if(discount==0){
				AlertBox alt = new AlertBox();
				alt.display("不可为0！");
			}else{
				String name = "生日折扣";
				int id;
				HotelPromotionVO vo = new HotelPromotionVO(id, name, discount/100, 0, 0, 0, null, null);
			
				PromotionLogicService promotion = new PromotionLogicServiceImpl();
				promotion.updateHotelPromotion(vo);
			}
		}
		
	}
	
	@FXML
	public void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_HotelMainui();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		HotelPromotionVO vo;
		int id ;
		String name = "生日折扣";
		vo = promotion.getHotelPromotion(id,name);
		double discount = vo.getBirthdayDiscount()*100;
		birthdaydiscount.setText(String.valueOf(discount));
	}

}
