/** 
 * ## Ticket page ##
  The page shows the user his data that he filled out to
  confirm it before confirming the reservation.
 */
package atharapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class TicketController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private TextField poeple;
    @FXML
    private TextField Museum;
    @FXML
    private TextField date;
    @FXML
    private TextField time;
    @FXML
    private TextField totalprice;
    @FXML
    private Button cancel;
    @FXML
    private Button confirm;
    
    private UserInfo user;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
//////////////////////////////////////////////////////////
    @FXML
    private void cancelAction(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Booking.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        
    }   catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    private void confirmAction(ActionEvent event) {
        
        // Write info to the file.
        writeToFile(user);
        
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("areas.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        
  } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }
    
    //get data from Booking window
    
    public void setUserData(String n, String ph, String e,
            String poe, String muse, String d, String t1, String t2, int p){
        
        int numpoe = Integer.parseInt(poe);
        int totPrice = numpoe * p;
        String totaPrice = String.valueOf(totPrice);
       
        user = new UserInfo(n, ph, e, poe, muse, d, t1, t2, totaPrice);
        
        name.setText(n);
        phone.setText(ph);
        email.setText(e);
        poeple.setText(poe);
        Museum.setText(muse);
        date.setText(d);
        time.setText(t1+" " +t2);
        totalprice.setText(totaPrice+" SR");
        
    }
    
    private void writeToFile(Object o) {
        
         // Create the stream objects.
        ObjectOutputStream objectOutputFile = null;
        FileOutputStream outStream = null;
        try {
           
            outStream = new FileOutputStream("userInfo.txt");
            objectOutputFile = new ObjectOutputStream(outStream);
            // Write the serialized objects to the file.
            objectOutputFile.writeObject(o);
            //show confirmation message
            JOptionPane.showMessageDialog(null, 
            "your ticket ready now, enjoy to journey!");
            objectOutputFile.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error wrting to file");
        } catch (IOException ex) {
            System.out.println("Error!");
        }
        

    }
    
   
    
}
