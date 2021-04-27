package atmpack;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		UserInput user = new UserInput();
		DepositWithdraw money = new DepositWithdraw();
		LoginClass login = new LoginClass();

		try {
			login.login();
			money.depowith(login.databaseBalance, login.databaseID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
