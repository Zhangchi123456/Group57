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
	MemberLogicService memberlogic = new MemberLogicServiceImpl();
	private String Username,Chargenum;
	
    @FXML
    private TextField UsernameText,ChargenumText;
    
    
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
    		try {
				vo=memberlogic.Findmemberbyname(Username);
				vo.setMembercreditvalue(vo.getMembercreditvalue()+Integer.parseInt(Chargenum)*100);
				memberlogic.updateMemberinfo(vo);
				AlertBox alt = new AlertBox();
				alt.display("充值成功");
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    }
    
    private boolean AllIsfilled(){
    	if(UsernameText.getText().toString().equals(null)||ChargenumText.getText().isEmpty()){
    		return false;
    	}
    	return true;
    }
    
    private boolean Ischargereasonable(){
    	if(Integer.parseInt(ChargenumText.getText().toString())<=0){
    		return false;
    	}
    	return true;
    }
	@FXML
	private void ReturnButtonClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}