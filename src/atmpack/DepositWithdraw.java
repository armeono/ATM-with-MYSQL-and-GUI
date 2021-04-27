package atmpack;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DepositWithdraw extends LoginClass {

	String url = "jdbc:mysql://localhost:3306/atm";
	String username = "root";
	String passwordConnect = "<@pgLX3t-zRs=+xj";

	public void depowith(double databaseBalance, String databaseID) throws SQLException {

		Scanner scan = new Scanner(System.in);

		System.out.println("Press 1 to deposit money");
		System.out.println("Press 2 to withdraw money");

		String decision = scan.nextLine();

		java.sql.Connection connection = DriverManager.getConnection(url, username, passwordConnect);
		
		

		switch (decision) {
		case "1":
			Scanner depo = new Scanner(System.in);
			System.out.println("Enter the amount to deposit: ");
			double amount = (depo.nextDouble());

			String sql = "UPDATE users SET balance = '" + (databaseBalance += amount) + "' WHERE id = '" + databaseID + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.executeUpdate(sql);

			System.out.println("Balance: " + databaseBalance);

			break;

		case "2":
			Scanner depo2 = new Scanner(System.in);
			System.out.println("Enter the amount to withdraw: ");
			double amount2 = (depo2.nextDouble());

			String sql2 = "UPDATE users SET balance = '" + (databaseBalance -= amount2) + "' WHERE id = '" + databaseID + "'";
					
			PreparedStatement statement2 = connection.prepareStatement(sql2);
			
			statement2.executeUpdate(sql2);

			System.out.println("Balance: " + databaseBalance);
			break;
		default:
			break;
		}

	}

}
