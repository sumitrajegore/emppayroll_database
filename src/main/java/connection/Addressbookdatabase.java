package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Addressbookdatabase {

	
	public static boolean insertstudenttoDB(PersonData persondata) { 
		
		boolean f = false;
		try {
			
			//jdbc code
			Connection con = Addressbookconnection.create();
			String q = "insert into addressbook_system(firstName,lastName,address,city,state,email,zip,phoneNumber) values(?,?,?,?,?,?,?,?)";
			
			//prepared statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value parameter
			pstmt.setString(1, persondata.getFirstName());
			pstmt.setString(2, persondata.getLastName());
			pstmt.setString(3, persondata.getAddress());
			pstmt.setString(4, persondata.getCity());
			pstmt.setString(5, persondata.getState());
			pstmt.setString(6, persondata.getEmail());
			pstmt.setString(7, persondata.getZip());
			pstmt.setString(8, persondata.getPhone_no());

			//execute
			pstmt.executeUpdate();
			f=true;
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteperson(int userID) {
		
		boolean f = false;
		try {
			
			//jdbc code
			Connection con = Addressbookconnection.create();
			String q = "delete from addressbook_system where id =?";
			
			//prepared statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value parameter
			pstmt.setInt(1, userID);
			

			//execute
			pstmt.executeUpdate();
			f=true;
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return f;		
	}

	public static void showcontact() {

		try {
			
			//jdbc code
			Connection con = Addressbookconnection.create();
			String q = "select * from addressbook_system";
			
			//prepared statement
			Statement stmt = con.createStatement();			

			//execute
			ResultSet Set = stmt.executeQuery(q);
			
			while(Set.next()) {
				
				int id = Set.getInt(1);
				String fname= Set.getString(2);
				String lname= Set.getString(3);
				String adress= Set.getString(4);
				String city= Set.getString(5);
				String state= Set.getString(6);
				String email= Set.getString(7);
				String zip= Set.getString(8);
				String phone_no= Set.getString(9);
				
				System.out.println(" ID : "+id);
				System.out.println(" firstName : "+fname);
				System.out.println(" lastName : "+lname);
				System.out.println(" Address : "+adress);
				System.out.println(" City : "+city);
				System.out.println(" State : "+state);
				System.out.println(" Gmail : "+email);
				System.out.println(" Pin_Code : "+zip);
				System.out.println(" Mobile_Number : "+phone_no);
				System.out.println("-----------------------------------------------------------------");

			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static boolean updatedperson(int id, PersonData persondata) {
		
		boolean f = false;
		try {
			
			//jdbc code
			Connection con = Addressbookconnection.create();
			String q = "update addressbook_system set firstName=?,lastName=?,address=?,city=?,state=?,email=?,zip=?,phoneNumber=? where id=?";
			
			//prepared statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value parameter
			pstmt.setString(1, persondata.getFirstName());
			pstmt.setString(2, persondata.getLastName());
			pstmt.setString(3, persondata.getAddress());
			pstmt.setString(4, persondata.getCity());
			pstmt.setString(5, persondata.getState());
			pstmt.setString(6, persondata.getEmail());
			pstmt.setString(7, persondata.getZip());
			pstmt.setString(8, persondata.getPhone_no());
			pstmt.setInt(9, id);

			//execute
			pstmt.executeUpdate();
			f = true;			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return f;
	}
}
