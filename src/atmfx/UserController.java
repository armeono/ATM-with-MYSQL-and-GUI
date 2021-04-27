package atmfx;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import atmpack.LoginClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UserController extends MainController {

	@FXML
	private Label nameLabel;

	@FXML
	private Button depositButton;
	@FXML
	private Button withdrawButton;
	@FXML
	private Button balanceButton;

	public void displayName(String username) {

		nameLabel.setText("Hello " + username);

	}

	public void depositPressed(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("DepositScene.fxml"));
		Parent root = loader.load();
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void balancePressed(ActionEvent event) throws IOException, SQLException {

		getData(loginID);

		System.out.println(databaseBalance);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("BalanceScene.fxml"));
		Parent root = loader.load();
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		BalanceController controller = loader.getController();
		controller.displayBalance(databaseBalance);

	}
	
	public void withdrawPressed(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WithdrawScene.fxml"));
		Parent root = loader.load();
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

}
