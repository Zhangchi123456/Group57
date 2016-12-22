package presentation.presentationController;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ResourceBundle;

import BusinessLogicService.Service.MemberLogicService;
import BusinessLogicService.impl.MemberLogicServiceImpl;
import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.MemberVO;

public class CreditChargeController implements Initializable{
	//界面所需要的引用和对象
	MemberLogicService memberlogic = new MemberLogicServiceImpl();
	private String Username,Chargenum;
	//列表项目
    @FXML
    private TextField UsernameText,ChargenumText;
    
    //事件监听
    //确认按钮的监听
    @FXML
    private void ConfirmClicked(ActionEvent event){
    	if(!AllIsfilled()){
    		AlertBox alt = new AlertBox();
			alt.display("请将用户名和金额填写完整");
    	}else if(!Ischargereasonable()){
    		AlertBox alt2 = new AlertBox();
			alt2.display("充值金额必须大于0元");
    	}else{
    		MemberVO vo = new MemberVO(0, 0, Chargenum, Chargenum, Chargenum);
    		Username=UsernameText.getText().toString();
    		Chargenum=ChargenumText.getText().toString();
            vo=memberlogic.Findmemberbyname(Username);
            vo.setMembercreditvalue(vo.getMembercreditvalue()+Integer.parseInt(Chargenum)*100);
			memberlogic.updateMemberinfo(vo);
			AlertBox alt = new AlertBox();
			alt.display("充值成功");
			
    	}    	
    }
    //返回按钮的监听
  	@FXML
  	private void ReturnButtonClicked(ActionEvent event){
  		UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
  	}
    //判断信息填写是否完整
    private boolean AllIsfilled(){
    	if(UsernameText.getText().toString().equals(null)||ChargenumText.getText().isEmpty()){
    		return false;
    	}
    	return true;
    }
    //判断输入的充值金额是否合法
    private boolean Ischargereasonable(){
    	if(Integer.parseInt(ChargenumText.getText().toString())<=0){
    		return false;
    	}
    	return true;
    }
    //初始化界面
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}