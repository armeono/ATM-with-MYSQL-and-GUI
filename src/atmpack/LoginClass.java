package atmpack;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginClass{
	
	protected String databaseID = " ";
	protected String databaseName = " ";
	protected String databasePassword = " ";
	protected String databaseNumber = " ";
	protected double databaseBalance = 0;
	protected String databaseLastName = " ";
    
	
	
	public void login() throws SQLException{
		
		String url = "jdbc:mysql://localhost:3306/atm";
		String username = "root";
		String passwordConnect = "<@pgLX3t-zRs=+xj";
		
	
		
		System.out.println("Enter ID:");
		Scanner enterID = new Scanner(System.in);
		
		String loginID = (enterID.nextLine());
		
		System.out.println("Enter password:");
		Scanner enterPass = new Scanner(System.in);
		
		String loginPass = (enterPass.nextLine());
		
		java.sql.Connection connection = DriverManager.getConnection(url, username, passwordConnect);
		String sql = "SELECT * FROM users WHERE id=" + loginID;
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		
		
		if(rs.next())
		{			
			databaseID = rs.getString("id");
		    databaseName = rs.getString("name");
			databaseLastName = rs.getString("lastname");
			databaseNumber = rs.getString("accountnum");
			databaseBalance = rs.getDouble("balance");
			databasePassword = rs.getString("password");
			
			
			
	
		}
		
		
		if(loginPass.equals(databasePassword)){
			
			System.out.println("You have logged in! Hello " + databaseName);
			
			
			
		}else {
			System.out.println("Sorry, you did not login!");
		}
		
	
	    
	}
	
	
}
