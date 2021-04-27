package atmfx;

import java.io.IOException;
import java.sql.SQLException;

import atmpack.Connection;
import atmpack.UserInput;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController extends UserInput{
	
	protected Stage stage;
	protected Scene scene;
	protected Parent root;
	
	Connection connect = new Connection();
	
	@FXML
	private TextField nameFX;
	@FXML 
	private TextField lastNameFX;
	@FXML
	private TextField passwordFX;
	@FXML
	private Button createAccountButton;
	
	public void createUser(ActionEvent event) throws IOException, SQLException {
		
		String name = nameFX.getText();
		String lastName = lastNameFX.getText();
		String password = passwordFX.getText();
		
		String id = generateID();
		String num = generateNumber();
		
		connect.connect(id, name, lastName, num, balance, password);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayScene.fxml"));
		Parent root = loader.load();
		
		DisplayController controller = loader.getController();
		controller.displayInfo(id, name, lastName, num, balance, password);
		
		
		
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		
		
		
		
	}
	
	
	
	

}
