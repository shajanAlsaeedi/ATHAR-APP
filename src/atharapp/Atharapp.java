/*  ## START PAGE ## ..
 */
package atharapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Atharapp extends Application {
    
    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file.
            Parent parent = FXMLLoader.load(getClass().getResource("atharapp.fxml"));

            // Build the scene graph.
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("FXML Loading Error");
        }

       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
