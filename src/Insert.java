import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.ResultSet;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			    // Establish the connection to the database
			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
			    System.out.println("data inserted successfully");
			    // Create a statement to execute SQL queries
			    Statement st = con.createStatement();
			   st.executeUpdate("insert into soumya values('shree',900899)"); 
			   System.out.println("data inserted succesfully");
			   String query = "select * from soumya"; // Assuming 'soumya' is a table in the 'student' database
			    ResultSet rs = st.executeQuery(query);

			    // Process the result set
			    while (rs.next()) {
			        int salary = rs.getInt("Salary");
			        String name = rs.getString("name");
                    System.out.println(name + " " + salary);
			    }
		           }catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		        	   e.printStackTrace();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}


