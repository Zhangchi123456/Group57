package org.Hotel.client.presentationController;


import java.net.URL;
import java.util.ResourceBundle;

import org.Hotel.client.Helper.UiswitchHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class OrderEvaluateController  implements Initializable{
	    @FXML
	    private Label OrderId;
	    @FXML
	    private Label Hotel;
	    @FXML
	    private TextField Score;
	    
	    @FXML
	    private TextField EvaluateInfo;
	    @FXML
	    private Button Sure;
	    @FXML
	    private Button Return;
	 
	  @FXML
	  private void  ReturnClicked(ActionEvent event){
		  UiswitchHelper.getApplication().goto_Usermainui();
		 
	  }
	  @FXML
	  private void  SureClicked(ActionEvent event){
		  UiswitchHelper.getApplication().goto_Usermainui();
		 
	  }
	 
	 
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
