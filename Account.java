import java.util.ArrayList;
import java.util.Date;

public abstract class Account {
	
	/*
	 * A protected data field id of the int type to store the account number (default 0).
	 * A protected data field name of the String type to store the name of the customer.
	 * A protected data field balance of type double to store the account balance (default 0).
	 * A protected Date data field named dateOpened that stores the date when the account was created.
	 * A protected data field transactions of type ArrayList that stores the transactions for the accounts.
	 * Each transaction is an instance of the Transaction class.
	 * */
    protected int id;
    protected String name;
    protected double balance;
    protected Date dateOpened;
    protected ArrayList<Transaction> transactions;

    public Account(int id, String name, double balance) {
    	/*
    	 * Add a new constructor that constructs an account with the specified name, id, balance, 
    	   and sets the dateOpened to current date.
    	 */
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.dateOpened = new Date();
        this.transactions = new ArrayList<>();
    }
    
    public Account() {
    	// A no-arg constructor that creates a default account.
        this.id = 0;
        this.name= "Default Customer";
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    // The accessor and mutator functions for name, id, and balance.
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // A accessor method to return dateOpened.
    public Date getDateOpened() {
        return dateOpened;
    }

    // Base methods for withdraw and deposit.
    // Both method fully override implemented in checkings and savings class.
    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
    

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account ID: ").append(id)
          .append("Customer Name: ").append(name)
          .append("Account Opened On: ").append(dateOpened)
          .append("Balance: $").append(balance).append("\n");

        for (Transaction transaction : transactions) {
            sb.append(transaction).append("\n");
        }

        return sb.toString();
    }
}
