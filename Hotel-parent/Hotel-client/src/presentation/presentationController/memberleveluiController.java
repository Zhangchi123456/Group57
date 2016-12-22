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
import presentation.userui.AlertBox;
import vo.MemberLevelVO;

public class memberleveluiController implements Initializable{
	
	@FXML
	private Button button_webdiscountdate;
	
	@FXML
	private Button button_businesscircle;
	
	@FXML
	private ChoiceBox<String> level;
	
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
	public void ChoiceBoxClicked(ActionEvent event){
	//选择会员等级	
		int lv = Integer.parseInt(level.getValue().toString());
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		MemberLevelVO vo = promotion.getMemberLevel(lv);
		credit.setText(String.valueOf(vo.getCredit()));
		discount.setText(String.valueOf(vo.getDiscount()*100));
		
	}
	
	@FXML
	public void SureClicked(ActionEvent event){
	//确认更新	
		if(!discount.getText().isEmpty() && !level.getValue().isEmpty() && 
				!credit.getText().isEmpty()){
			int lv = Integer.parseInt(level.getValue().toString());
			int cre = Integer.parseInt(credit.getText());
			double dis = Double.parseDouble(discount.getText());
			if(dis>0&&dis<=100){
				MemberLevelVO vo = new MemberLevelVO(lv,cre,dis/100);
				PromotionLogicService promotion = new PromotionLogicServiceImpl();
				boolean suitable = promotion.updateMemberLevel(vo);
				if(suitable==false){
					AlertBox alt = new AlertBox();
					alt.display("信用超出输入范围！");
				}else{
					AlertBox alt = new AlertBox();
					alt.display("更新成功！");
				}
			}else if(dis<0||dis>100){
				AlertBox alt = new AlertBox();
				alt.display("折扣超出输入范围！");
			}else if(dis==0){
				AlertBox alt = new AlertBox();
				alt.display("不可为0！");
			}
		}else{
			AlertBox alt = new AlertBox();
			alt.display("不可为空！");
		}
		
	}
	//返回网站营销人员主界面
	@FXML
	public void ReturnClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//初始化	
		level.setItems(FXCollections.observableArrayList("1","2","3","4","5","6"));
		
	}
}

