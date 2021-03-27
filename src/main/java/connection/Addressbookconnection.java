package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Addressbookconnection {
	
	
	static Connection con;
	
	public static Connection create() throws SQLException {
		
		try {
			
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			String user="root";
			String passward="Sumit@123";
			String url ="jdbc:mysql://localhost:3306/address_book_service";
			
			con = DriverManager.getConnection(url, user, passward);
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		return con;
	}

}
