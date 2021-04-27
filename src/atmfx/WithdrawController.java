package atmfx;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WithdrawController extends MainController {
	
	String url = "jdbc:mysql://localhost:3306/atm";
	String username = "root";
	String passwordConnect = "<@pgLX3t-zRs=+xj";

	@FXML
	private TextField withdrawTextField;

	@FXML
	private Button withdrawButton;

	public void withdraw(ActionEvent event) throws SQLException, IOException {

		String deposit = withdrawTextField.getText();

		double amount = Double.parseDouble(deposit);

		getData(loginID);

		java.sql.Connection connection = DriverManager.getConnection(url, username, passwordConnect);

		String sql2 = "UPDATE users SET balance = '" + (databaseBalance -= amount) + "' WHERE id = '" + databaseID
				+ "'";
		PreparedStatement statement = connection.prepareStatement(sql2);
		statement.executeUpdate(sql2);

	
		
		switchToUser(event);

	}

}
