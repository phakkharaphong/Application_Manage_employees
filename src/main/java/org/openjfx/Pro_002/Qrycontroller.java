package org.openjfx.Pro_002;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;


public class Qrycontroller implements Initializable{
	ObservableList<user> usereList = FXCollections.observableArrayList();
	String jdbcurl = "Jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
    String user = "root";
    String pass = "123456789";
	@FXML
    private TableColumn<user, String> CoFname;

    @FXML
    private TableColumn<user, String> CoLname;

    @FXML
    private TableColumn<user, String> Coemail;

    @FXML
    private TableColumn<user, Integer> Coid;

    @FXML
    private TableColumn<user, Integer> Cosalary;

    @FXML
    private TableView<user> TableUp;
	@FXML
    private TextField TxTFname;

    @FXML
    private TextField TxTID;

    @FXML
    private TextField TxTLname;

    @FXML
    private TextField TxTSalary;

    @FXML
    private TextField TxTemail;
    @FXML
    private Label wong;

    @FXML
    private Button butback;

    @FXML
    private Button butre;

    @FXML
    private Button butup;
    public void initialize(URL location, ResourceBundle resources) {
    	butback.setCursor(Cursor.HAND);
    	butre.setCursor(Cursor.HAND);
    	butup.setCursor(Cursor.HAND);
  		 setColumns();
  		 load();
  		 
  	}

	@FXML 
    private void re() throws SQLException{
    	if(TxTID.getText() == "" || TxTFname.getText() == "" || TxTLname.getText() == "" ||TxTSalary.getText() == "" || TxTemail.getText() == ""  ) {
    		Alert alert = new Alert(AlertType.WARNING);
        	alert.setTitle("EER!");
        	alert.setContentText("ID Frist name Last name Email Salary not value.");
        	alert.setHeaderText("WARNING.");
        	alert.showAndWait();
    	}else {
    	String id = TxTID.getText();
        String F_name = TxTFname.getText();
        String L_name = TxTLname.getText();
        String Salary = TxTSalary.getText();
        String Email  = TxTemail.getText();
        Qry up = new Qry();
        up.insertRecord(id, F_name, L_name, Email,Salary);
        TxTID.setText("");
        TxTFname.setText("");
        TxTLname.setText("");
        TxTSalary.setText("");
        TxTemail.setText("");
        usereList.clear();
        load();
    	}
    }
	@FXML
    private void switchTode() throws IOException {
        App.setRoot("secondary");
    }
	@FXML
	private void Retset() throws IOException{
		TxTID.setText("");
        TxTFname.setText("");
        TxTLname.setText("");
        TxTSalary.setText("");
        TxTemail.setText("");
	}
	 private void setColumns() {
	    	//idColumn.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
	    	this.Coid.setCellValueFactory(new PropertyValueFactory<>("id") );
	    	this.CoFname.setCellValueFactory(new PropertyValueFactory<>("Fname"));
	    	this.CoLname.setCellValueFactory(new PropertyValueFactory<>("Lname"));
	    	this.Coemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
	    	this.Cosalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
	    	this.TableUp.refresh();
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
			
			 
	    	this.TableUp.setItems(usereList);
			this.TableUp.refresh();
			for(var e : this.TableUp.getItems()) {
				 System.out.println(e.toString());
			}
		}

}
