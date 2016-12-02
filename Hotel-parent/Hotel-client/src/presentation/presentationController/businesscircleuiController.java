package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class businesscircleuiController implements Initializable{
	
	@FXML
	private Button button_webdiscountdate;
	
	@FXML
	private Button button_memberlevel;
	
	@FXML
	private ChoiceBox city;
	
	@FXML
	private ChoiceBox businesscircle;
	
	@FXML
	private TextField discount;
	
	@FXML
	private Button confirm;
	
	@FXML
	private Button back;
	//调到日期折扣界面
	@FXML
	public void DataClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_webdiscoutdatenui();
	}
	//跳到会员等级折扣
	@FXML
	public void MemberClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_memberlevelui();
	}
	
	@FXML
	public void SureClicked(ActionEvent event){
		
	}
	//返回网站营销人员主界面
		@FXML
		public void ReturnClicked(ActionEvent event){
			UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
		}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
