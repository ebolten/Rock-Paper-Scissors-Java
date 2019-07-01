import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Scanner;
import java.lang.String;

public class RockPaperScissors extends Application {

	public static void main(String[] args) {
		Application.launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label play = new Label("Play Rock, Paper, Scissors!"); //setting the title
		play.setPadding(new Insets(10,5,5,20));
		play.setPadding(new Insets(10,5,5,20));
		Label computer = new Label(); //setting the computer's choice
		computer.setPadding(new Insets(10,5,5,20));
		Label user = new Label(); //setting whether the user won or lost
		user.setPadding(new Insets(10,5,5,20));
		
		//creating textfield and submit button
		Button button = new Button("Submit");
		TextField textfield = new TextField();
		
		//creating a grid pane
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10,10,10,10));
		
		//adding nodes to pane and setting constraints
		pane.getChildren().add(play);
		pane.getChildren().add(textfield);
		GridPane.setConstraints(button, 1, 1);
		GridPane.setConstraints(textfield, 0, 1);
		pane.getChildren().add(button);
		
		//setting the OnAction event handler for the button
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				String userAns = textfield.getText(); //the user's answer
				
				int rock = 0; //0 beats 2
				int paper = 1; //1 beats 0
				int scissors = 2; //2 beats 1
				int compChoice = (int)(Math.random() * 3); //computer's pick
				
				if (compChoice == 0) {
					computer.setText("Computer got rock. . .");
				}
				else if (compChoice == 1) {
					computer.setText("Computer got paper. . .");
				}
				else if (compChoice == 2) {
					computer.setText("Computer got scissors. . .");
				}
				
				if (userAns.charAt(0) == 'r') { //if the user chose rock
						
					if (compChoice == 2) {
						user.setText("You won!");
					}
					else if (compChoice == 1) {
						user.setText("You lost.");
					}
					else {
						user.setText("You tied.");
					}
				}
				else if (userAns.charAt(0) == 'p') { //if the user chose paper
						
					if (compChoice == 0) {
						user.setText("You won!");
					}
					else if (compChoice == 2) {
						user.setText("You lost.");
					}
					else {
						user.setText("You tied.");
					}
				}
				else if (userAns.charAt(0) == 's') { //if the user chose scissors
					
					if (compChoice == 1) {
						user.setText("You won!");
					}
					
					else if (compChoice == 0) {
						user.setText("You lost.");
					}
					else {
						user.setText("You tied.");
					}
				}
				else { //if the user's choice was invalid
					user.setText("Invalid Entery");
				}
				
				//setting constraints and adding nodes to gridpane
				GridPane.setConstraints(computer,0,2);
				pane.getChildren().add(computer);
				GridPane.setConstraints(user,0,4);
				pane.getChildren().add(user);
			}
			
		});
		
		//setting scene
		Stage stage = new Stage();
		Scene scene = new Scene(pane,275,200);
		
		primaryStage.setTitle("Rock, Paper, Scissors");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
}

