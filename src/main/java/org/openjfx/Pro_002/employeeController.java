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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class employeeController implements Initializable{
	String jdbcurl = "Jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
    String user = "root";
    String pass = "123456789";
	ObservableList<user> usereList = FXCollections.observableArrayList();
	private FilteredList<user> filteredList;
	@FXML
    private Button back;
	 @FXML
	    private Button gg;

	    @FXML
	    private Button sen;

	 @FXML
	    private TableView<user> TableUser;

	    @FXML
	    private TableColumn<user, String> coemail;

	    @FXML
	    private TableColumn<user, String> cofname;

	    @FXML
	    private TableColumn<user, Integer> coid;

	    @FXML
	    private TableColumn<user, String> colname;

	    @FXML
	    private TableColumn<user, Integer> cosalary;

	    @FXML
	    private TextField txtID;

	 @FXML
	    private void switchToHome() throws IOException {
	        App.setRoot("Home");
	    }
	 @FXML
	    private void switchToG() throws IOException {
	        App.setRoot("score");
	    }
	 public void initialize(URL location, ResourceBundle resources) {
		 back.setCursor(Cursor.HAND);
		 gg.setCursor(Cursor.HAND);
		 sen.setCursor(Cursor.HAND);
   		 setColumns();
   		 load();
   		 
   	}
	 //ค้นหา
	 @FXML
	    void findByName() {
	    	String s = this.txtID.getText().toLowerCase();
	    	filteredList=usereList.filtered(e->e.getFname().toLowerCase().contains(s)==true);
	    	//employeeList = filteredList;
	    	this.TableUser.setItems(filteredList);

	    	
	    } 
	 private void setColumns() {
	    	//idColumn.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
	    	this.coid.setCellValueFactory(new PropertyValueFactory<>("id") );
	    	this.cofname.setCellValueFactory(new PropertyValueFactory<>("Fname"));
	    	this.colname.setCellValueFactory(new PropertyValueFactory<>("Lname"));
	    	this.coemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
	    	this.cosalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
	    	this.TableUser.refresh();
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
			
			 
	    	this.TableUser.setItems(usereList);
			this.TableUser.refresh();
			for(var e : this.TableUser.getItems()) {
				 System.out.println(e.toString());
			}
			filteredList = new FilteredList<>(usereList, t -> true);
		}
}
