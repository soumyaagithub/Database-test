
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update{

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
            // Create a statement to execute SQL queries
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE soumya SET name='life' WHERE salary=1000");
            System.out.println("Data updated successfully");

            ResultSet rs = st.executeQuery("SELECT * FROM soumya");

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getInt("salary"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException ex) {
            System.out.println("SQL Exception occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
