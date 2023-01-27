/** 
 * ## Final ticket ##
  The page shows the user his data that he filled out to
  confirm it before confirming the reservation.
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class FinalticketController implements Initializable {

    @FXML
    private Label name;
    @FXML
    private Label phone;
    @FXML
    private Label email;
    @FXML
    private Label poeple;
    @FXML
    private Label museum;
    @FXML
    private Label date;
    @FXML
    private Label time;
    @FXML
    private Label price;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     public void setUserData(String n, String ph, String e,
            String poe, String muse, String d, String t1, String t2, String p){
        name.setText(n);
        phone.setText(ph);
        email.setText(e);
        poeple.setText(poe);
        museum.setText(muse);
        date.setText(d);
        time.setText(t1+" " +t2);
        price.setText(p+" SR");
        
    }
     
      public void setUserData1(String n){
        name.setText(n);
        
        
    }

    @FXML
    private void OkAction(ActionEvent event) {
        
     
 try {
      //hide the current window
      ((Node)event.getSource()).getScene().getWindow().hide();
      //load finalmessagepag window
      FXMLLoader loader = new FXMLLoader(getClass().getResource("finalmessagepag.fxml"));
      Parent root = loader.load();
      
      FinalmessagepagController m = loader.getController();
      m.SetUserName(name.getText());
      //show the finalmessagepag window
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.show();

    } catch (IOException e) {

      e.printStackTrace();

    }
    
}
}
