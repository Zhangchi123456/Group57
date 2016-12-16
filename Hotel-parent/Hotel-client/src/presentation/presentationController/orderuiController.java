package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class orderuiController implements Initializable{
	//界面中的项
    @FXML
    private Button ReturnButton;
    @FXML
    private TableColumn OrderId,OrderInfo,OrderStation;//表中项
    @FXML
    private TableView table;//订单列表
    //界面跳转
    //返回按钮的监听
    @FXML
    private void ReturnClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_HotelMainui();//界面跳转
    }
    //check按钮的监听
    @FXML    
    private void CheckClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_ordeinfoui();
    }
    //初始化方法
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
