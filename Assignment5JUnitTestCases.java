import A2_BaAO.*;
import A2_BaAO.Assign5.*;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;

public class Assignment5JUnitTestCases {

    @Test
    public void CustomerBuilderTester() {
        // Instantiate a BankCustomerBuilder
        Customer.BankCustomerBuilder builder = new Customer.BankCustomerBuilder(1, "John Doe");

        // Set attributes using builder's setter methods
        builder.username("johndoe")
                .email("johndoe@example.com")
                .password("password123")
                .accounts(new ArrayList<>())
                .creationDate(new Date());

        // Call build() method to obtain the Customer object
        Customer customer = builder.build();

        // Verify the created Customer object
        assertEquals(1, customer.getCustomerId());
        assertEquals("John Doe", customer.getName());
        assertEquals("johndoe", customer.getUsername());
        assertEquals("johndoe@example.com", customer.getEmail());
        assertEquals("password123", customer.getPassword());
        assertEquals(new ArrayList<>(), customer.getAccounts());
        assertNotNull(customer.getCreationDate());
    }


    @Test
    public void BankAccountTransactionTester() {
        // Create customer using BankCustomerBuilder
        Customer.BankCustomerBuilder builder = new Customer.BankCustomerBuilder(1, "John Doe");
        Customer customer = builder
                .username("johndoe")
                .email("johndoe@example.com")
                .password("password123")
                .accounts(new ArrayList<>())
                .creationDate(new Date())
                .build();

        // Create source and destination accounts
        Account sourceAccount = new Account(101, 500.0, "Savings", customer);
        Account destinationAccount = new Account(102, 1000.0, "Checking", customer);

        // Create BankAccountTransaction
        BankAccountTransaction transaction = new BankAccountTransaction(1, new Date(), "Transfer", 200.0, "Transfer from Savings to Checking", sourceAccount, destinationAccount, false, customer);

        // Execute transaction
        transaction.executeTransaction();

        // Verify the status of the transaction
        assertEquals(true, transaction.getStatus());
        assertEquals(300.0, sourceAccount.getBalance(), 0.01); // Verify balance of source account
        assertEquals(1200.0, destinationAccount.getBalance(), 0.01); // Verify balance of destination account
    }

    @Test
    public void DepositTransactionTester() {
        // Create customer using BankCustomerBuilder
        Customer.BankCustomerBuilder builder = new Customer.BankCustomerBuilder(1, "John Doe");
        Customer customer = builder
                .username("johndoe")
                .email("johndoe@example.com")
                .password("password123")
                .accounts(new ArrayList<>())
                .creationDate(new Date())
                .build();

        // Create account
        Account account = new Account(101, 500.0, "Savings", customer);

        // Create DepositTransaction
        DepositTransaction depositTransaction = new DepositTransaction(account, 200.0);

        // Execute deposit transaction
        depositTransaction.execute();

        // Verify the balance after deposit
        assertEquals(700.0, account.getBalance(), 0.01);
    }

    @Test
    public void WithdrawTransactionTester() {
        // Create customer using BankCustomerBuilder
        Customer.BankCustomerBuilder builder = new Customer.BankCustomerBuilder(1, "John Doe");
        Customer customer = builder
                .username("johndoe")
                .email("johndoe@example.com")
                .password("password123")
                .accounts(new ArrayList<>())
                .creationDate(new Date())
                .build();

        // Create account
        Account account = new Account(101, 500.0, "Savings", customer);

        // Create WithdrawTransaction
        WithdrawTransaction withdrawTransaction = new WithdrawTransaction(account, 200.0);

        // Execute withdraw transaction
        withdrawTransaction.execute();

        // Verify the balance after withdrawal
        assertEquals(300.0, account.getBalance(), 0.01);
    }
}