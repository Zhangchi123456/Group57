package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class webdiscountdateuiController implements Initializable{
	
	@FXML
	private Button button_businesscircle;
	
	@FXML
	private Button button_memberlevel;
	
	@FXML
	private TextField webdiscountdatediscount;
	
	@FXML
	private TableView webdiscountdateTable;
	
	@FXML
	private TableColumn webdiscountdateTable_start;
	
	@FXML
	private TableColumn webdiscountdateTable_end;
	
	@FXML
	private TableColumn webdiscountdateTable_discount;
	
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
		
	}
	//删除策略按钮
	@FXML
	public void DeleteClicked(ActionEvent event){
		
	}

	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


}

