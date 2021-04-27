package atmfx;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import atmpack.LoginClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {

	static protected String databaseID = " ";
	static protected String databaseName = " ";
	static protected String databasePassword = " ";
	static protected String databaseNumber = " ";
	static protected double databaseBalance = 0;
	static protected String databaseLastName = " ";

	String url = "jdbc:mysql://localhost:3306/atm";
	String username = "root";
	String passwordConnect = "<@pgLX3t-zRs=+xj";

	protected Stage stage;
	protected Scene scene;
	protected Parent root;
	protected String loginID;

	@FXML
	private Button signinButton;
	@FXML
	private TextField passTextField;
	@FXML
	private TextField idTextField;
	@FXML
	private Button signupButton;
	

	public void signin(ActionEvent event) throws SQLException, IOException {

		loginID = idTextField.getText();

		String loginPass = passTextField.getText();

		getData(loginID);

		if (loginPass.equals(databasePassword)) {

			switchToUser(event);

		} else {
			System.out.println("Wrong password!");
		}

	}
	
    public void signup(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpScene.fxml"));
		Parent root = loader.load();
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    	
    	
    	
    }

	public void getData(String loginID) throws SQLException {

		java.sql.Connection connection = DriverManager.getConnection(url, username, passwordConnect);
		String sql = "SELECT * FROM users WHERE id=" + loginID;
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			databaseID = rs.getString("id");
			databaseName = rs.getString("name");
			databaseLastName = rs.getString("lastname");
			databaseNumber = rs.getString("accountnum");
			databaseBalance = rs.getDouble("balance");
			databasePassword = rs.getString("password");

		}
	}

	public void switchToUser(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("UserStage.fxml"));
		Parent root = loader.load();
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		UserController controller = loader.getController();
		controller.displayName(databaseName);

	}
}