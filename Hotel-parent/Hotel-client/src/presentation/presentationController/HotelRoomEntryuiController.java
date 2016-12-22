package presentation.presentationController;

import java.net.URL;
import java.util.ResourceBundle;

import BusinessLogicService.Service.HotelStaffLogicService;
import BusinessLogicService.impl.HotelStaffLogicServiceImpl;
import Controller.HotelmanageController;
import Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import presentation.userui.AlertBox;
import vo.HotelVO;

public class HotelRoomEntryuiController implements Initializable {

	@FXML
	private TextField singleroomnum,singleroomprice,standardroomnum,standardroomprice,familyroomnum,familyroomprice,suiteroomnum,suiteroomprice;
	
	@FXML
	private Button save,back;
	
	HotelStaffLogicService hser = new HotelStaffLogicServiceImpl();
	HotelVO vo = HotelmanageController.getHotelVO();

	AlertBox alt;
	
	@FXML
	private void ReturnButtonClicked(ActionEvent event){
		
		UiswitchHelper.getApplication().goto_HotelMainui();
	}
	
	@FXML
	private void SaveButtonClicked(ActionEvent event){
		
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		singleroomnum.setText(null);
        singleroomprice.setText(null);
        standardroomnum.setText(null);
        standardroomprice.setText(null);
        familyroomnum.setText(null);
        familyroomprice.setText(null);
        suiteroomnum.setText(null);
        suiteroomprice.setText(null);
		
	}

}
