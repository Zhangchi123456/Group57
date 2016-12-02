package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class roomInfoController implements Initializable{
    @FXML
    private Button ReturnButton;
    @FXML
    private TableColumn RoomId,RoomInfo,RoomStation,LastTime;//表项
    @FXML
    private TableView table;//房间表
    //界面跳转
    @FXML
    private void ReturnButtonClicked(ActionEvent event){
    	UiswitchHelper.getApplication().goto_HotelMainui();
    }
    //初始化方法
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
