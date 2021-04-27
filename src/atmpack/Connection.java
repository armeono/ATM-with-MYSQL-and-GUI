package atmpack;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Connection extends UserInput{
	
	public void connect(String _ID, String _name, String _lastName, String _accountNumber, double _balance, String _password) {
	
		String url = "jdbc:mysql://localhost:3306/atm";
		String username = "root";
		String passwordConnect = "<@pgLX3t-zRs=+xj";
		
		
		
	
		
		int count = 0;
		
		
		
		try {
			
			java.sql.Connection connection = DriverManager.getConnection(url, username, passwordConnect);
			String sql = "INSERT INTO users (id, name, lastname, accountnum, balance, password) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, _ID);
			statement.setString(2, _name);
			statement.setString(3, _lastName);
			statement.setString(4, _accountNumber);
			statement.setDouble(5, _balance);
			statement.setString(6, _password);
			
		    
			int rows = statement.executeUpdate();
			if(rows > 0) {
				System.out.println("User has been created!");
			}
			
			
			
		
			connection.close();
			
			
		} catch (SQLException e) {
			System.out.println("Could not connect!");
			e.printStackTrace();
		}
		
		
		
		
}
	
	public void delete() {
		
	}
	
}
