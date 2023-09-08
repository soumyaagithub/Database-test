import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
            
            // Create a statement to execute SQL queries
            Statement st = con.createStatement();

            // SQL query to delete data from the table
            String deleteQuery = "DELETE FROM soumya WHERE salary = 1000";

            // Execute the delete query
            int rowsAffected = st.executeUpdate(deleteQuery);
            System.out.println(rowsAffected + " row(s) deleted successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQL Exception occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
