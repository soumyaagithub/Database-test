import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import com.mysql.cj.jdbc.CallableStatement;

public class Procedure {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
		   CallableStatement cst=(CallableStatement) con.prepareCall("{call Add_sal(?,?,?)}");
		   cst.setInt(1, 50000);
		   cst.setInt(2, 50000);
		   cst.registerOutParameter(3,Types.NUMERIC);
		   cst.execute();
		   int result=cst.getInt(3);
		   System.out.println("result is:"+result);
		   
		   
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
