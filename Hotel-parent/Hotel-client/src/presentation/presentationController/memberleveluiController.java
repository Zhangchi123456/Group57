package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicService.Service.PromotionLogicService;
import BusinessLogicService.impl.PromotionLogicServiceImpl;
import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import vo.MemberLevelVO;

public class memberleveluiController implements Initializable{
	
	@FXML
	private Button button_webdiscountdate;
	
	@FXML
	private Button button_businesslevel;
	
	@FXML
	private ChoiceBox level;
	
	@FXML
	private TextField credit;
	
	@FXML
	private TextField discount;
	
	@FXML
	private Button confirm;
	
	@FXML
	private Button back;
	//调到商圈折扣
	@FXML
	public void BusinessClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_businesscircleui();
	}
	//调到日期折扣界面
	@FXML
	public void DataClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_webdiscoutdatenui();
	}
	
	@FXML
	public void levelChoose(MouseEvent event){
		
		int lv = Integer.parseInt(level.getValue().toString());
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		MemberLevelVO vo = promotion.getMemberLevel(lv);
		credit.setText(String.valueOf(vo.getCredit()));
		discount.setText(String.valueOf(vo.getDiscount()*100));
		
	}
	
	@FXML
	public void SureClicked(ActionEvent event){
		
		int lv = Integer.parseInt(level.getValue().toString());
		int cre = Integer.parseInt(credit.getText());
		double dis = Double.parseDouble(discount.getText());
		MemberLevelVO vo = new MemberLevelVO(lv,cre,dis/100);
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		promotion.updateMemberLevel(vo);
		
	}
	//返回网站营销人员主界面
	@FXML
	public void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		level.setItems(FXCollections.observableArrayList("1","2","3","4","5","6"));
		
	}
}

