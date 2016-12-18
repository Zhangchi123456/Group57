package presentation.presentationController;

import java.net.URL;
import java.util.ArrayList;
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
import vo.CircleVO;

public class businesscircleuiController implements Initializable{
	
	@FXML
	private Button button_webdiscountdate;
	
	@FXML
	private Button button_memberlevel;
	
	@FXML
	private ChoiceBox<String> city;
	
	@FXML
	private ChoiceBox<String> businesscircle;
	
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
	public void CityChoiceBoxClicked(ActionEvent event){
	//选择城市名	
		String city_name = city.getValue().toString();
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		ArrayList<CircleVO> voList = promotion.getCircle(city_name);
		ArrayList<String> circleList = new ArrayList<String>();
		for(int i=0; i<voList.size(); i++){
			circleList.add(voList.get(i).getName());
		}
		businesscircle.setItems(FXCollections.observableArrayList(circleList)); 
		
	}
	
	@FXML
	public void CircleChoiceBoxClicked(ActionEvent event){
	//选择商圈名	
		String city_name = city.getValue().toString();
		String circle = businesscircle.getValue().toString();
		PromotionLogicService promotion = new PromotionLogicServiceImpl();
		CircleVO vo = promotion.getCircle(city_name, circle);
		discount.setText(String.valueOf(vo.getDiscount()*100));
		
	}
	
	@FXML
	public void SureClicked(ActionEvent event){
	//确认更新	
		String city_name = city.getValue().toString();
		String circle = businesscircle.getValue().toString();
		if(!discount.getText().isEmpty()){
			double dis = Double.parseDouble(discount.getText());
			if(dis>0&&dis<100){
				CircleVO vo = new CircleVO(dis/100,city_name, circle);
				PromotionLogicService promotion = new PromotionLogicServiceImpl();
				promotion.updateCircle(vo);
				AlertBox alt = new AlertBox();
				alt.display("更新成功！");
			}else if(dis<0||dis>100){
				AlertBox alt = new AlertBox();
				alt.display("超出输入范围！");
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
		city.setItems(FXCollections.observableArrayList("北京","南京"));
	}
}
