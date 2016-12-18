package presentation.userui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ComfirmBox {
	
	public static boolean result;
	
    public static boolean display(String message){
    	Stage window = new Stage();
		window.setTitle("系统提示");
		window.initModality(Modality.APPLICATION_MODAL);
	
		//modality要使用Modality.APPLICATION_MODEL   
		window.setMinWidth(300);
		window.setMinHeight(200);
		//yes button
		Button yesButton = new Button("确定");
		yesButton.setMinWidth(105);
		yesButton.setMinHeight(40);
		yesButton.setOnAction(e->
		{
			result=true;
			window.close();
		});
		//no button
		Button noButton = new Button("返回");
		noButton.setMinWidth(105);
		noButton.setMinHeight(40);
		noButton.setOnAction(e->result=false);
		noButton.setOnAction(e->
		{
			result=false;
			window.close();
		});
		//display message
		Label label = new Label();			
		label.setText(message);
		label.setFont(new Font(20));
		
		VBox layout = new VBox();
		layout.setSpacing(10);
		layout.getChildren().addAll(label,yesButton,noButton);
		layout.setSpacing(20);
		layout.setAlignment(Pos.CENTER);   
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();	
		
		return result;
    }
}