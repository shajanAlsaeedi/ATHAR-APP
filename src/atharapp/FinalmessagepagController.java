/** 
 * #8 message page
  display the message to user when it end the booking.
 */
package atharapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FinalmessagepagController implements Initializable {

   
    @FXML
    private Label userName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    }    

    @FXML
    private void closeAction(ActionEvent event) {
        System.exit(0);
        // end the program.
    }
    
    public void SetUserName(String n ){
       // Modify the name in message.
       userName.setText(n);
       
    }
    
}
