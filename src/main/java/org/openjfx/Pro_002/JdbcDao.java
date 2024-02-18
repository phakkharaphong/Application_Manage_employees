package org.openjfx.Pro_002;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class JdbcDao {
	 	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
	    private static final String DATABASE_USERNAME = "root";
	    private static final String DATABASE_PASSWORD = "123456789";
	    private static final String INSERT_QUERY = "INSERT INTO student (id, first_name, last_name, email , Saraly) VALUES (?, ?, ?, ?, ?)";
	    public void insertRecord(String id, String F_name, String L_name , String Email , String salary) throws SQLException {

	        //Connection กับmysql
	        try (Connection connection = DriverManager
	            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

	            // เป็นการเซ็ท id Fname Lname Email
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
	            preparedStatement.setString(1, id);
	            preparedStatement.setString(2, F_name);
	            preparedStatement.setString(3, L_name);
	            preparedStatement.setString(4, Email);
	            preparedStatement.setString(5, salary);
	            

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	         // เป็นการเพิ่ม id Fname Lname Email ลงในsql
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            // print SQL exception information
	            printSQLException(e);
	        }
	    }

	    public static void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
}
