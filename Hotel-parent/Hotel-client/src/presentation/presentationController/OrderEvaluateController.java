package presentation.presentationController;


import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicService.Service.OrderLogicService;
import BusinessLogicService.impl.OrderLogicServiceImpl;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import vo.OrderVO;

public class OrderEvaluateController  implements Initializable {
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
	 //界面跳转
	  @FXML
	  private void  ReturnClicked(ActionEvent event){
		  UiswitchHelper.getApplication().goto_Usermainui();
		 
	  }
	  @FXML
	  private void  SureClicked(ActionEvent event){
		  
		  UiswitchHelper.getApplication().goto_Usermainui();
		 
	  }
	 
	 
	 //初始化界面   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		OrderLogicService a = new OrderLogicServiceImpl();
		OrderVO ordervo;
		ordervo=(a.findUserOrderinfo(null, 0));
		OrderId.setText(String.valueOf(ordervo.orderid));
        HotelName.setText(String.valueOf(ordervo.hotelname));
        
	}

}
