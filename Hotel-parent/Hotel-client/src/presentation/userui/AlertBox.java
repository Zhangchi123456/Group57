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

public class AlertBox {

    public void display( String message){
    	Stage window = new Stage();
		 window.setTitle("系统提示");
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
		    Label label = new Label(message);			    
		    label.setFont(new Font(20));
		    VBox layout = new VBox(10);
		    layout.getChildren().addAll(label , button);
		    layout.setSpacing(20);
		    layout.setAlignment(Pos.CENTER);               
		    Scene scene = new Scene(layout);
		    window.setScene(scene);
		    window.show();		
    }
}