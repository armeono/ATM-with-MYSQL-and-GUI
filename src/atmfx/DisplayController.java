package atmfx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DisplayController {

	protected Stage stage;
	protected Scene scene;
	protected Parent root;

	@FXML
	private Label infoLabel;

	public void displayInfo(String id, String name, String lastName, String num, double balance, String password) {

		infoLabel.setText("ID: " + id + "\n" + "Name: " + name + "\n" + "Last name: " + lastName + " \n" + "Password: "
				+ password + "\n" + "Account number: " + num + "\n" + "Balance: " + balance);

	}

	public void switchMethod(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root = loader.load();

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

}
