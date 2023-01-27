/** 
 * #2 Area page
   This page contains all regions of the Kingdom,
   and takes you to the region that was clicked.
 */
package atharapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AreasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backaction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("atharapp.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    private void center(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Central.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    private void east(ActionEvent event) {
        //Eastern
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Eastern.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    private void south(ActionEvent event) {
       
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Southern.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    private void north(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Northern.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    private void west(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Western.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    private void homepagAction(ActionEvent event) {
    
    JOptionPane.showMessageDialog(null,"you are in home page!");
    }

    @FXML
    private void aboutusAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Aboutuspag.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    private UserInfo user;
    @FXML
    private void diaplayUserInfoAction(ActionEvent event) throws ClassNotFoundException {
        
        // read from file*
        readFromFile();
        
        try {
        //hide the current window

      ((Node)event.getSource()).getScene().getWindow().hide();
      //load Finalticket window
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Finalticket.fxml"));
      Parent root = loader.load();
      
      FinalticketController fn = loader.getController();
      fn.setUserData(user.getName(),user.getPhone(),user.getEmail(),user.getPoeple(),user.getMuseum(),
      user.getDate(),user.getTime1(),user.getTime2(),user.getPrice());
      
      //show the Finalticket window
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.show();

    } catch (IOException e) {

      e.printStackTrace();

    }
     
   }
            
        private UserInfo readFromFile() throws ClassNotFoundException {
        
        FileInputStream inStream = null;
        ObjectInputStream in = null;
        
        try{
            inStream = new FileInputStream("userInfo.txt");
            in = new ObjectInputStream(inStream);
            user = (UserInfo) in.readObject();
            //JOptionPane.showMessageDialog(null,"Read from file Successfully :)");
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading to file");
             JOptionPane.showMessageDialog(null,"You don't have a ticket!");
            
        } catch (IOException ex) {
            System.out.println("Error try again!");
            try {
              //load areas window
              FXMLLoader loader = new FXMLLoader(getClass().getResource("areas.fxml"));
              Parent root = loader.load();
              JOptionPane.showMessageDialog(null,"You don't have a ticket!");
              Stage stage = new Stage();
              stage.setScene(new Scene(root));
              stage.show();
           
            }catch (IOException e) {
            
                  e.printStackTrace();
               }
        }
        
         return user;
    }
}

    

