package org.openjfx.Pro_002;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class Decontroller implements Initializable{
	   @FXML
	    private Button butbak;

	    @FXML
	    private Button butok;
	 @FXML
	    private Label wong;

	 @FXML
	    private TextField TxTID;
	 @FXML
	    private void switchTotabel() throws IOException {
	        App.setRoot("secondary");
	    }
	 
	 @FXML
	 private void delete() throws SQLException{
		 if(TxTID.getText() == "" ) {
	    		Alert alert = new Alert(AlertType.WARNING);
	        	alert.setTitle("EER!");
	        	alert.setContentText("ID not value.");
	        	alert.setHeaderText("WARNING.");
	        	alert.showAndWait();
	    	}else {
	    		String id = TxTID.getText();
	            delet delet = new delet();
	            delet.insertRecord(id);
	            TxTID.setText("");
	         
	            
	    	}
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		butbak.setCursor(Cursor.HAND);
		butok.setCursor(Cursor.HAND);
		
	}
}
