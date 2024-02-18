package org.openjfx.Pro_002;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class SecondaryController implements Initializable {
	String jdbcurl = "Jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
    String user = "root";
    String pass = "123456789";
    @FXML
    private VBox pen;

	ObservableList<user> usereList = FXCollections.observableArrayList();
	 @FXML
	    private Button delete;

	    @FXML
	    private Button log;
	    @FXML
	    private Button update;
	 @FXML
	    private TableView<user> userTAbel;
	@FXML
    private TableColumn<user, String> coEmail;
	@FXML
    private Button add;

    @FXML
    private TableColumn<user, String> coFname;

    @FXML
    private TableColumn<user, Integer> coId;

    @FXML
    private TableColumn<user, String> coLname;

    @FXML
    private TableColumn<user, Integer > coSalary;
    public void initialize(URL location, ResourceBundle resources) {
    	update.setCursor(Cursor.HAND);
    	delete.setCursor(Cursor.HAND);
    	log.setCursor(Cursor.HAND);
    	add.setCursor(Cursor.HAND);
   		 setColumns();
   		 load();
   		 
   		 
   	}
    //สวิซหน้า
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("add");
    }
    @FXML
    private void switchToclass() throws IOException {
        App.setRoot("employee");
    }
    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void switchTode() throws IOException {
        App.setRoot("dalete");
    }
    @FXML
    private void switchToQry() throws IOException {
        App.setRoot("qry");
    }
    //เซ็ทคอลั่ม
    private void setColumns() {
    	this.coId.setCellValueFactory(new PropertyValueFactory<>("id") );
    	this.coFname.setCellValueFactory(new PropertyValueFactory<>("Fname"));
    	this.coLname.setCellValueFactory(new PropertyValueFactory<>("Lname"));
    	this.coEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
    	this.coSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
    	this.userTAbel.refresh();
    }
    private void load() {
    	try {
			 	System.out.println("Connectiong to database:" + jdbcurl);
	            Connection myConn = DriverManager.getConnection(jdbcurl,user,pass);
	            Statement stat = myConn.createStatement();
	            System.out.println("Connection succeful!!!");
	            ResultSet rs = stat.executeQuery("select * from student;");		
	            while (rs.next()) {	
	            								//ต้องตรงกับtypeที่เราตั้ง
	                System.out.println("first name =" + rs.getString("first_name"));     
	                System.out.println("last name = "+ rs.getString("last_name"));
	                										//ต้องตรงกับtypeที่เราตั้ง
	                usereList.addAll(new user(rs.getString("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getInt("Saraly"),rs.getString("email"))
				 );  
	            }
	            rs.close();
	            myConn.close();
		}
	            catch(Exception exc) {
	            	exc.printStackTrace();
	            }
		this.userTAbel.setItems(usereList);
		this.userTAbel.refresh();
		for(var e : this.userTAbel.getItems()) {
			 System.out.println(e.toString());
		}
	}
}