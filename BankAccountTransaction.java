package A2_BaAO.Assign5;

import A2_BaAO.Account;
import A2_BaAO.Customer;
import A2_BaAO.Transaction;

import java.util.Date;

public class BankAccountTransaction {
    private int id;
    private Date datetime;
    private String type;
    private double amount;
    private String description;
    private Account sourceAccount;
    private Account destinationAccount;
    private boolean status;
    private Customer customer;

    public BankAccountTransaction(int id, Date datetime, String type, double amount, String description, Account sourceAccount, Account destinationAccount, boolean status, Customer customer) {
        this.id = id;
        this.datetime = datetime;
        if (isValidTransactionType(type)) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid transaction type");
        }
        this.amount = amount;
        this.description = description;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.status = status;
        this.customer = customer;
    }

    private boolean isValidTransactionType(String type) {
        return type.equals("Deposit") || type.equals("Withdrawal") || type.equals("Transfer");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void executeTransaction() {
        // Initialize the transaction for the source account
        Transaction sourceTransaction;

        // Switch based on the transaction type
        switch (type) {
            case "Deposit":
                // Create a deposit transaction for the source account
                sourceTransaction = new Transaction(id, sourceAccount.getAccountId(), amount, type, datetime);
                break;
            case "Withdrawal":
                // Create a withdrawal transaction for the source account
                sourceTransaction = new Transaction(id, sourceAccount.getAccountId(), amount, type, datetime);
                break;
            case "Transfer":
                // Ensure both source and destination accounts are specified
                if (sourceAccount != null && destinationAccount != null) {
                    // Create a withdrawal transaction for the source account
                    sourceTransaction = new Transaction(id, sourceAccount.getAccountId(), amount, "Withdrawal", datetime);
                    try {
                        // Process the withdrawal transaction on the source account
                        sourceAccount.processTransaction(customer, sourceTransaction);
                    } catch (Exception e) {
                        e.printStackTrace();
                        status = false; // Transaction failed
                        return;
                    }

                    // Create a deposit transaction for the destination account
                    Transaction destinationTransaction = new Transaction(id, destinationAccount.getAccountId(), amount, "Deposit", datetime);
                    try {
                        // Process the deposit transaction on the destination account
                        destinationAccount.processTransaction(customer, destinationTransaction);
                    } catch (Exception e) {
                        e.printStackTrace();
                        status = false; // Transaction failed
                        return;
                    }

                    status = true; // Transaction executed successfully
                    return;
                } else {
                    throw new IllegalArgumentException("Source and destination accounts must be specified for transfer transaction");
                }
            default:
                throw new IllegalArgumentException("Invalid transaction type");
        }
    }
}