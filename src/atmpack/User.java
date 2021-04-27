package atmpack;
import java.util.Random;

public class User {

	protected String name, lastName;
	protected double balance, amount;
	protected String password;

	protected String accountNumber;

	protected String ID;

	User() {
		this.name = " ";
		this.lastName = " ";
		this.balance = 0;
		this.password = null;
	}

	User(String name, String lastName, String password, String accountNumber, String ID) {
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.accountNumber = accountNumber;
		this.ID = ID;
	}

	User(User obj) {
		this.name = obj.name;
		this.lastName = obj.lastName;
		this.password = obj.password;
	}

	@Override
	public String toString() {
		return "User [ Name = " + getName() + ", Last Name = " + getLastName() + ", Account number = "
				+ getAccountNumber() + ", Account balance= " + getBalance() + ", ID = " + getID() + ", Password = "
				+ getPassword() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String _accountNumber) {
		accountNumber = _accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
		
	}

	public String getID() {
		return ID;
	}

	public void setID(String _iD) {
		ID = _iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
