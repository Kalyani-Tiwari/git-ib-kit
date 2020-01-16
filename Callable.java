import java.sql.*;
import java.util.*;

class DbConnection {
	private static final String DB_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DB_USERNAME = "te3379";
	private static final String DB_PASSWORD = "teUser@3379";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			// load the Driver Class
			Class.forName(DB_DRIVER_CLASS);

			// create the connection now
			con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

public class Callable {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement stmt = null;
		
		//Read User Inputs
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two numbers : ");
		int x = input.nextInt();
		int y = input.nextInt();
		
		try{
			con = DbConnection.getConnection();
			stmt = con.prepareCall("{call add2(?,?)}");
			stmt.setInt(1, x);
			stmt.setInt(2, y);
			
			//register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(1, java.sql.Types.INTEGER);
			stmt.execute();
			
			//read the OUT parameter now
			int ans = stmt.getInt(1);
			
			System.out.println("Addition is : " + ans);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				con.close();
				input.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
