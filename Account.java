/*************************************************
 File: Account.java
 By: Edward McDonald
 Date: March 11th, 2024
 Compile: -
 Description: Account Business object
 *************************************************/

package A2_BaAO;

public class Account implements Comparable<Account> {
    // Attributes
    private int accountId;
    private double balance;
    private String type;
    private Customer customer;

    public Account() {
        // Default Jackson constructor
    }

    // Constructors
    public Account(int accountId, double balance, String type, Customer customer) {
        // Validate input parameters
        if (accountId <= 0) {
            throw new IllegalArgumentException("Account ID must be a positive integer");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.accountId = accountId;
        this.balance = balance;
        this.type = type;
        this.customer = customer;
    }

    // Getters and setters
    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Process
    public void processTransaction(Customer customer, Transaction transaction) {
        // Validate
        if (customer == null || transaction == null) {
            throw new IllegalArgumentException("Customer and transaction cannot be null");
        }

        // Check transaction validity
        if (!transaction.getType().equals("Deposit") && !transaction.getType().equals("Withdrawal") && !transaction.getType().equals("Transfer")) {
            throw new IllegalArgumentException("Invalid transaction type");
        }

        // Validate transaction
        if (transaction.getType().equals("Withdrawal")) {
            double transactionAmount = transaction.getAmount();
            if (transactionAmount < 0) {
                throw new IllegalArgumentException("Withdrawal amount cannot be negative");
            }
            if (transactionAmount > this.balance) {
                throw new IllegalArgumentException("Insufficient funds");
            }
        }

        // Update account balance
        if (transaction.getType().equals("Deposit")) {
            this.balance += transaction.getAmount();
        } else if (transaction.getType().equals("Withdrawal")) {
            this.balance -= transaction.getAmount();
        } else if (transaction.getType().equals("Transfer")) {
            this.balance -= transaction.getAmount();
        }
    }

    //For assignment 5 functionality
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal");
        }
        balance -= amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    @Override
    public int compareTo(Account other) {

        return Double.compare(this.balance, other.balance);
    }
}