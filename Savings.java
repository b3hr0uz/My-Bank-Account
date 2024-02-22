public class Savings extends Account {
	// A data filed named annualInterestRate.
    private double annualInterestRate;

    public Savings(int id, String name, double balance, double annualInterestRate) {
        super(id, name, balance);
        this.annualInterestRate = annualInterestRate;
    }

    // The accessor and mutator functions for annualInterestRate.
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest() {
    	// A function named getMonthlyInterest() that adds the interest to the account balance. Add the
    	// transaction to Transactions. Return the monthly interest.
        double monthlyInterest = (balance * (annualInterestRate / 100.0)) / 12.0;
        balance += monthlyInterest;
        transactions.add(new Transaction('I', monthlyInterest, balance, "Monthly Interest"));
        return monthlyInterest;
    }

    @Override
    public void withdraw(double amount) {
    	/* An abstract method named withdraw that withdraws a specified amount from the 
         * account and add a transaction to the transactions array list.
         * */
        if (balance - amount >= 0) {
            balance -= amount;
            transactions.add(new Transaction('W', amount, balance, "Withdrawal"));
        } else {
        	transactions.add(new Transaction('W', amount, balance, "Overdrawn. Withdraw cancelled."));
            System.out.println("Insufficient funds for withdrawal.");
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
        return "Savings\nAccount ID: " + id + "\nCustomer Name: " + name + "\nAccount Opened: " + dateOpened +
                "\nBalance: $" + balance + "\nInterest Rate: " + annualInterestRate + 
                "\nTransaction List:\n" + transactions.toString();
    }
}
