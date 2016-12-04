



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
	    
	    
		OrderLogicService a = new OrderLogicServiceImpl();
	    
	    
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
		  else{ 
	     MemberActController.getOrdervo().setComment(EvaluateInfo.getText().toString());
		 boolean tem= a.evaluate(MemberActController.getOrdervo().getId(), Score.getText().toString(), EvaluateInfo.getText().toString());
		
		
				UiswitchHelper.getApplication().goto_Usermainui();
		
		 
		
		
		 
		  } 
	  }
	 
	 
	 //初始化界面   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		OrderId.setText(String.valueOf(MemberActController.getOrdervo().getId()));
        HotelName.setText(String.valueOf(MemberActController.getOrdervo().getHotelid()));	       
	}

}