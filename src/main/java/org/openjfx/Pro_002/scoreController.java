package org.openjfx.Pro_002;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class scoreController implements Initializable{
	String jdbcurl = "Jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
    String user = "root";
    String pass = "123456789";
    @FXML
    private Label back1;
    @FXML
    private Button butb;
    @FXML
    private BarChart<user, Integer> bar;
	@Override
   	public void initialize(URL location, ResourceBundle resources) {
		butb.setCursor(Cursor.HAND); 
   		 Chart();
   	}
	
	 @FXML
	    private void switchToQry() throws IOException {
	        App.setRoot("employee");
	    }
	 private void Chart() {
		 try {
				
			 	System.out.println("Connectiong to database:" + jdbcurl);
	            Connection myConn = DriverManager.getConnection(jdbcurl,user,pass);
	            Statement stat = myConn.createStatement();
	            System.out.println("Connection succeful!!!");
	            ResultSet rs = stat.executeQuery("select * from student;"); 
	            while (rs.next()) {	
	                XYChart.Series set1 = new XYChart.Series<>();
					set1.getData().add(new XYChart.Data(rs.getString("first_name"),rs.getInt("Saraly")));
					bar.getData().addAll(set1);
					
	            }
	            rs.close();
	            myConn.close();
	             
	    
		}
	            catch(Exception exc) {
	            	exc.printStackTrace();
	            }
	    	
	    }

}
