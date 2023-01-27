/** 
 * ## Booking page ##
  This page enables the user to book a ticket for one of the museums.
 */
package atharapp;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class BookingController implements Initializable {

    @FXML
    private Button clear;
    @FXML
    private Button submit;
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private TextField poeple;
    @FXML
    private DatePicker date;
    @FXML
    private ComboBox<String> museum;
    @FXML
    private RadioButton rad6_8;
    @FXML
    private ToggleGroup group1;
    @FXML
    private RadioButton rad8_10;
    @FXML
    private RadioButton rad10_12;
    @FXML
    private RadioButton radam;
    @FXML
    private ToggleGroup group2;
    @FXML
    private RadioButton pm;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        museum.getItems().addAll(
                "The Two Holy Mosques Museum (32 SR)",
                "Abdul Raouf Khalil Museum (20 SR)",
                "Masmak Palace (22 SR)",
                "Saudi National Museum (25 SR)",
                "Dammam Museum (13 SR)",
                "Al-Ahsa Museum (15 SR)",
                "Al-Maqar village (33 SR)",
                "Doss Heritage Museum (20 SR)",
                "Al Fajr Heritage Museum (33 SR)",
                "Al-Naif Palace Archaeological Museum (20 SR)");
        
        Date date1 = new Date();
    }    

    


    @FXML
    private void cancelAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("areas.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    private void clearAction(ActionEvent event) {
        name.setText("");
        phone.setText("");
        email.setText("");
        poeple.setText("");
        museum.getSelectionModel().clearSelection();
        date.setValue(null);
        rad6_8.setSelected(false);
        rad8_10.setSelected(false);
        rad10_12.setSelected(false);
        radam.setSelected(false);
        pm.setSelected(false);
    }

    @FXML
    private void submitAction(ActionEvent event) throws Exception {
        
        String time1 = null;
        String time2 = null;
        String sdate;
        
        inputValidation();
        
        int price =  ticketPrice();
        
        //Step2: send the data to the ticket window
        try {
            //hide the current window
           ((Node)event.getSource()).getScene().getWindow().hide();
          
           //load ticket window
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Ticket.fxml"));
           Parent root = loader.load();
           
           TicketController controller3 = loader.getController();
           
           if(rad6_8.isSelected())
               time1 = "6:00 - 8:00";
           else if (rad8_10.isSelected())
               time1 = "8:00 - 10:00";
           else if (rad10_12.isSelected())
               time1 = "10:00 - 12:00";
           
           if(radam.isSelected())
               time2 = "AM";
           else if (pm.isSelected())
               time2 = "PM";
           
           sdate = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
       
           controller3.setUserData(name.getText(),phone.getText(), email.getText(),
                   poeple.getText(),museum.getValue(),sdate,time1,time2, price);
   
           //show the ticket window
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.show();
   
       } catch (IOException e) {
           e.printStackTrace();
       }
           
    }
    
    private int ticketPrice(){
       String check;
       int price = 0;
       check = museum.getValue();
       
       if (check.equalsIgnoreCase("The Two Holy Mosques Museum (32 SR)")){
           price = 32;
       }
       else if(check.equalsIgnoreCase("Abdul Raouf Khalil Museum (20 SR)")){
           price = 20;
       }
       else if(check.equalsIgnoreCase("Masmak Palace (22 SR)") ){
           price = 22;
       }
       else if(check.equalsIgnoreCase("Saudi National Museum (25 SR)")){
           price = 25;
       }
       else if(check.equalsIgnoreCase("Dammam Museum (13 SR)")){
           price = 13;
       }
       else if(check.equalsIgnoreCase("Al-Ahsa Museum (15 SR)")){
           price = 15;
       }
       else if(check.equalsIgnoreCase("Al-Maqar village (33 SR)")){
           price = 33;
       }
       else if(check.equalsIgnoreCase("Doss Heritage Museum (20 SR)")){
           price = 20;
       }
       else if(check.equalsIgnoreCase("Al Fajr Heritage Museum (33 SR)")){
           price = 33;
       }
       else if(check.equalsIgnoreCase("Al-Naif Palace Archaeological Museum (20 SR)")){
           price = 20;
       } 
    
    return price;
    }
  
    
    private void inputValidation() throws Exception {

        //First: check that all fields are valid
        if (!validateName()) {
            //only letters
            JOptionPane.showMessageDialog(null, "Invalid Name !",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        if (!validateMobile()) {
            //only numbers
            JOptionPane.showMessageDialog(null, "Invalid Mobile number !",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        if (!validateEmail()) {

            JOptionPane.showMessageDialog(null, "Invalid Email !",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if (!validatePoeple()) {
            //only numbers
            JOptionPane.showMessageDialog(null, "Invalid Number of Poeple !",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if (museum.getValue() == null || museum.getValue().equals("")) {
            JOptionPane.showMessageDialog(null, "Select Museum!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if (date.getValue() == null ) {
            JOptionPane.showMessageDialog(null, "Select Date!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if (!rad6_8.isSelected() && !rad8_10.isSelected() &&
                !rad10_12.isSelected())   {
            JOptionPane.showMessageDialog(null, "Select the Time !",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
        
        if ( !radam.isSelected() && !pm.isSelected()){
        JOptionPane.showMessageDialog(null, "Select the Morning or Evening Period !",
                "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        } 
   
    
    }

    private boolean validateName() {

        return name.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }  
    
    private boolean validateMobile() {

        return phone.getText().matches("(05)[0-9]{8}");

    }
     private boolean validatePoeple() {

        return poeple.getText().matches("[1-9]{1}");

    }
    
    private boolean validateEmail() {

        return email.getText().matches("^(.+)@(.+)$");
    }

   
    
}
