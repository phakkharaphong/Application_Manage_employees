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
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class addcontroller implements Initializable{
	  @FXML
	    private Button add;

	    @FXML
	    private Button bb;
	@FXML
    private TextField TxTFname;
	@FXML
    private AnchorPane back;

    @FXML
    private TextField TxTID;

    @FXML
    private TextField TxTLname;

    @FXML
    private TextField TxTSala;

    @FXML
    private TextField TxTemail;
    @FXML
    private Label wong;
    @FXML
    private void Lod() throws SQLException{
    	if(TxTID.getText() == "" || TxTFname.getText() == "" || TxTLname.getText() == "" ||TxTSala.getText() == "" || TxTemail.getText() == ""  ) {
    		Alert alert = new Alert(AlertType.WARNING);
        	alert.setTitle("EER!");
        	alert.setContentText("ID Frist name Last name Email Salary not value.");
        	alert.setHeaderText("WARNING.");
        	alert.showAndWait();
    	}else {
    		String id = TxTID.getText();
            String F_name = TxTFname.getText();
            String L_name = TxTLname.getText();
            String Email  = TxTemail.getText();
            String Salary = TxTSala.getText();
            JdbcDao jdbcDao = new JdbcDao();
            jdbcDao.insertRecord(id, F_name, L_name,Email, Salary);
            TxTID.setText("");
            TxTFname.setText("");
            TxTLname.setText("");
            TxTSala.setText("");
            TxTemail.setText("");
    	}
    }
    @FXML
    private void switchback() throws IOException {
        App.setRoot("secondary");
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		add.setCursor(Cursor.HAND);
		bb.setCursor(Cursor.HAND);
		
		
	}


}
