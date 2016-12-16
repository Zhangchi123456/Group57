package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import Controller.MemberActController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelVO;
import vo.OrderVO;

public class OrderEvaluateController  implements Initializable {
	//界面中的项目
	    @FXML
	    private Label OrderId;//订单号
	    @FXML
	    private Label HotelName;
	    @FXML
	    private TextField Score;	    
	    @FXML
	    private TextArea EvaluateInfo;
	    @FXML
	    private Button Sure;
	    @FXML
	    private Button Return;
	    
	//对象引用    
		OrderLogicService ser = new OrderLogicServiceImpl();   
	 //界面跳转
	  @FXML
	   private void  ReturnClicked(ActionEvent event){
		  UiswitchHelper.getApplication().goto_Usermainui();
		 
	  }
	  @FXML
	  private void  SureClicked(ActionEvent event){
		  if(Score.getText().toString().equals("")||EvaluateInfo.getText().toString().equals("")){
				AlertBox alt = new AlertBox();
				alt.display("信息填写不完整");
		}	  	  
		   else {  
			   if(Double.parseDouble(Score.getText())<0.0||Double.parseDouble(Score.getText())>5.0){
				   AlertBox alt = new AlertBox();
					alt.display("评分填写错误");
			   }
			   else{
		       boolean tem= ser.evaluate(OrderId.getText().toString(), Score.getText().toString(), EvaluateInfo.getText().toString());
				UiswitchHelper.getApplication().goto_Usermainui();
			   }
	  } 
	  }
	 
	 
	 //初始化界面   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub 
		OrderlistuiController a = new OrderlistuiController();		
		OrderId.setText(a.Orderid);
		HotelName.setText(a.Hotelname);
	}

}