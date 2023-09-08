
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {

    public static void main(String[] args) throws Exception {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection to the database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");

        // Create a statement to execute SQL queries
        Statement st = con.createStatement();
        String query = "select * from soumya"; // Assuming 'soumya' is a table in the 'student' database
        ResultSet rs = st.executeQuery(query);

        // Process the result set
        while (rs.next()) {
            int salary = rs.getInt("Salary");
            String name = rs.getString("name");

            System.out.println(name + " " + salary);
        }

        // Close the resources
//      rs.close();
        st.close();
        con.close();
    }
}
