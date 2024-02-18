package org.openjfx.Pro_002;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;

public class PrimaryController implements Initializable{
	String jdbcurl = "Jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
	@FXML
    private PasswordField pass;
	@FXML
    private Button Blog;
	@FXML
    private Button Bback;
    @FXML
    private Label mes;
	    @FXML
	    private Button primaryButton;

	    @FXML
	    private TextField   user;
	    
	    @FXML
	    private void switchToadmin() throws IOException, SQLException {
	    	loadData();
	    }
	   

	    @FXML
	    private void switchToUser() throws IOException {
	        App.setRoot("employee");
	    }
	    @FXML
	    private void switchToHome() throws IOException {
	        App.setRoot("Home");
	    }
    private void loadData() throws SQLException {
        if(user.getText() != "" || pass.getText() != "") {
        	try {
			 	System.out.println("Connectiong to database:" + jdbcurl);
	            Connection myConn = DriverManager.getConnection(jdbcurl, user.getText(), pass.getText());
	            Statement stat = myConn.createStatement();
	            System.out.println("Connection succeful!!!");
	            App.setRoot("secondary");	
	           
        	}catch(Exception exc) {
	            	//exc.printStackTrace();
	            	alertwong(null);
	            }

        }else {
        	alertnull(null);
        	
        }
       

    }
    private void alertnull(ActionEvent event) {
    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("EER!");
    	alert.setContentText("Username and password have no value.");
    	alert.setHeaderText("Username and password.");
    	alert.showAndWait();
    	
    }
    private void alertwong(ActionEvent event) {
    	Alert alert = new Alert(AlertType.WARNING);
    	alert.setTitle("EER!");
    	alert.setContentText("User or password is wrong.");
    	alert.setHeaderText("User or password.");
    	alert.showAndWait();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Blog.setCursor(Cursor.HAND);
		Bback.setCursor(Cursor.HAND);
		
	}
  
}
