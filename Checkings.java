
public class Checkings extends Account {
	// A constant double data field named OVERDRAFT_LIMIT.
	// A checking account has an overdraft limit ($500) and acquires no interest.
    private static final double OVERDRAFT_LIMIT = 500.0;

    public Checkings(int id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void withdraw(double amount) {
    	// Define and override withdraw() methods.
        /* An abstract method named withdraw that withdraws a specified amount from the 
         * account and add a transaction to the transactions array list.
         * */
        if (balance - amount >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            transactions.add(new Transaction('W', amount, balance, "Withdrawal"));
        } else {
        	transactions.add(new Transaction('W', amount, balance, "Overdrawn. Withdraw cancelled."));
            System.out.println("Overdrawn. Withdraw cancelled.");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('D', amount, balance, "Deposit"));
    }

    public void accOpenTransaction() {
    	transactions.add(new Transaction('D', balance, balance, "Account opened"));
    }
    
    @Override
    public String toString() {
    	// Define and override the toString() function to return a string.
        return "Checkings\nAccount ID: " + id + "\nCustomer Name: " + name + "\nAccount Opened: " + dateOpened +
                "\nBalance: $" + balance + "\n" + "\nTransaction list:\n" + transactions.toString();
    }
}
