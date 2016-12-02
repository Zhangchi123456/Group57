package presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HotelListuiController implements Initializable{
	@FXML
	private ChoiceBox SortChoicebox;//酒店列表排序
	
	@FXML
	private CheckBox ReservationCheckbox;//是否预定过该酒店
	@FXML
	private TableView HotelTable;//酒店列表
	@FXML
	private TableColumn HotelName,HotelStar,HotelScore,HotelPrice;//表中项目
	@FXML
	private Button ReturnButton;
	
    //界面跳转
    
    @FXML
    private void ReturnButtonClicked(ActionEvent event){
        UiswitchHelper.getApplication().goto_Usermainui();
    }
    @FXML
    private void ObservedHotel(ActionEvent event){
        UiswitchHelper.getApplication().goto_Usermainui();
    }
    @FXML
    private void CheckButtonClicked(ActionEvent event){
        UiswitchHelper.getApplication().goto_hotelInfoBrowseui();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
