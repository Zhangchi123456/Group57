package org.Hotel.client.presentation.userui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.shape.Circle;
import javafx.animation.Timeline;

public class AStage {
	Stage myStage=new Stage();
	Scene scene;
	public AStage(){
		
		StackPane stackPane=new StackPane();
		
		Label click=new Label("Click Me!");
		stackPane.getChildren().addAll(click);
		
		scene=new Scene(stackPane,300,300);
		
		myStage.setScene(scene);
		
	}
	public Scene getScene(){
		return scene;
		
	}

}
