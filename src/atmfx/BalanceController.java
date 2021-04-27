package atmfx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BalanceController extends MainController{

	@FXML
	private Label balanceLabel;

	public void displayBalance(double balance) {

		balanceLabel.setText("Your balance is: " + balance);

	}
	
	public void switchMethod(ActionEvent event) throws IOException {
		
		switchToUser(event);
		
		
		
	}

}
