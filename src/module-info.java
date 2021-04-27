module ATMFx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	
	opens atmfx to javafx.graphics, javafx.fxml;
}
