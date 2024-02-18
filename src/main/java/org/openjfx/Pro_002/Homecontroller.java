package org.openjfx.Pro_002;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class Homecontroller implements Initializable{
	 @FXML
	    private Button Butmana;

	    @FXML
	    private Button BuyCheck;
	@FXML
    private void switchToMana() throws IOException {
        App.setRoot("primary");
    }
	@FXML
    private void switchToList() throws IOException {
        App.setRoot("employee");
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Butmana.setCursor(Cursor.HAND);
		BuyCheck.setCursor(Cursor.HAND);
		
	}

}
