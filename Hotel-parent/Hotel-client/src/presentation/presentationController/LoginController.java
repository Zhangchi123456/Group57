package presentation.presentationController;
import java.net.URL;

import java.util.ResourceBundle;

import Helper.UiswitchHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presentation.userui.AlertBox;


public class LoginController implements Initializable{
    
	@FXML
	private TextField UserId;
	@FXML
	private TextField PassWord;
	@FXML
	private void RegisterClicked(ActionEvent event){
		UiswitchHelper.getApplication().goto_Registerui();
	}
	@FXML
	private void SureClicked(ActionEvent event)throws Exception{
	
		if(UserId.getText().toString().equals("")){
			Stage window = new Stage();
			 window.setTitle("错误提示");
			    //modality要使用Modality.APPLICATION_MODEL
			   
			    window.setMinWidth(300);
			    window.setMinHeight(200);

			    Button button = new Button("确认");
			    button.setMinWidth(105);
			    button.setMinHeight(40);
			    button.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						window.close();
						
					}
	        		
	        	});

			    Label label = new Label("用户名为空");
			    
                label.setFont(new Font(20));
			    VBox layout = new VBox(10);
			    layout.getChildren().addAll(label , button);
			    layout.setSpacing(20);
			    layout.setAlignment(Pos.CENTER);
                
			    Scene scene = new Scene(layout);
			    window.setScene(scene);
			    window.show();
			
		}
		else	if(UserId.getText().trim().substring(0, 1).equals("1"))
		UiswitchHelper.getApplication().goto_Usermainui();
		else    if(UserId.getText().trim().substring(0, 1).equals("2"))
			UiswitchHelper.getApplication().goto_HotelMainui();
		else	if(UserId.getText().trim().substring(0, 1).equals("3"))
			UiswitchHelper.getApplication().goto_UserWebManagementui();
		else if(UserId.getText().trim().substring(0, 1).equals("4"))
			UiswitchHelper.getApplication().goto_UserWebPromotionMainui();
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
