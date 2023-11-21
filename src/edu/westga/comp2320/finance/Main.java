package edu.westga.comp2320.finance;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * This is the main class for the application
 * 
 * @author Deeksha Namani
 * @version 11/21/2023
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = this.loadGui();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Finance");
			primaryStage.show();
		} catch (IllegalStateException | IOException anException) {
			anException.printStackTrace();
		}
	}

	private Pane loadGui() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("view/FinanceGUI.fxml"));
		return (Pane) loader.load();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
