package atmpack;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class UserInput extends User {
	
	static String url = "jdbc:mysql://localhost:3306/atm";
	static String username = "root";
	static String passwordConnect = "<@pgLX3t-zRs=+xj";

	static ArrayList<User> listOfUsers = new ArrayList<>();

	public void createUser() throws SQLException {

		Connection connect = new Connection();

		Scanner scan = new Scanner(System.in);

		String answer;

		System.out.println("Do you want to create a new account?");

		answer = scan.next();

		do {

			System.out.println("First name: ");
			Scanner addName = new Scanner(System.in);

			String name = (addName.nextLine());
			
			System.out.println("Last name: ");

			Scanner addLastName = new Scanner(System.in);

			String lastName = (addLastName.nextLine());

			System.out.println("Password: ");
			Scanner addPassword = new Scanner(System.in);

			String password = (addPassword.nextLine());

			String number = generateNumber();
			String ID = generateID();
			
			double balance = 0;

			listOfUsers.add(new User(name, lastName, password, number, ID));
			
			connect.connect(ID, name, lastName, number, balance, password);


			System.out.println("Do you want to create a new account?");

			answer = scan.next();

			
		} while (answer.equalsIgnoreCase("yes"));

	}

	public static String generateNumber() throws SQLException {
		
		List<String> accNums = new ArrayList<>();
		
		java.sql.Connection connection = DriverManager.getConnection(url, username, passwordConnect);
		String sql = "SELECT * FROM users";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			
			String dbNumber = rs.getString("accountnum");
			
			accNums.add(dbNumber);
		
		}
		System.out.println(accNums);
		

		Random rand = new Random();

		String newNumber = " ";
		
		boolean condition = false;
		
		while(condition != true) {
			
			for (int i = 0; i < 16; i++) {

				int n = rand.nextInt(10) + 0;

				newNumber += Integer.toString(n);

			}
			
			if(accNums.contains(newNumber)) {
				condition = false;
			}else {
				condition = true;
			}
			
		}

	

		return newNumber;

	}

	public static String generateID() throws SQLException {
		
		List<String> idNums = new ArrayList<>();
		
		java.sql.Connection connection = DriverManager.getConnection(url, username, passwordConnect);
		String sql = "SELECT * FROM users";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			
			String dbID = rs.getString("id");
			
			idNums.add(dbID);
		
		}
	

	    boolean condition = false;

		Random rand = new Random();

		String newID = " ";
		
		while(condition != true) {
			
			for (int i = 0; i < 4; i++) {

				int n = rand.nextInt(9) + 0;

				newID += Integer.toString(n);

			}
			
			
			
			
			
			if(idNums.contains(newID)) {
				condition = false;
			}else {
				condition = true;
				
			}
			
		}
		
		

		

		return newID;

	}
	
	

}
