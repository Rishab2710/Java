/**
 * Programmer : Rishab Singh
 * Program    : Main.java
 * Date       : April 2021
 * @version 6.3 * @author risha
 */
package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


//Main Method to run program
public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Book.fxml"));
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Book Store Record");
	        stage.show();
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}