/*************************************************
 File: Customer.java
 By: Edward McDonald
 Date: April 19th, 2024
 Compile: -
 Description: Customer Business Object
 *************************************************/

package A2_BaAO; // UPDATED FOR ASSIGNMENT 5

import java.util.ArrayList;
import java.util.Date;

public class Customer implements Comparable<Customer> {
    // Attributes
    private int customerId;
    private String name;
    private String username;
    private String email;
    private String password;
    private ArrayList<Account> accounts;
    private Date creationDate;

    public Customer(BankCustomerBuilder builder) {
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.accounts = builder.accounts;
        this.creationDate = builder.creationDate;
    }

    // Builder class
    public static class BankCustomerBuilder {
        // Required parameters
        private final int customerId;
        private final String name;

        private String username = "";
        private String email = "";
        private String password = "";
        private ArrayList<Account> accounts = new ArrayList<>();
        private Date creationDate = new Date();

        public BankCustomerBuilder(int customerId, String name) {
            this.customerId = customerId;
            this.name = name;
        }

        public BankCustomerBuilder username(String username) {
            this.username = username;
            return this;
        }

        public BankCustomerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public BankCustomerBuilder password(String password) {
            this.password = password;
            return this;
        }

        public BankCustomerBuilder accounts(ArrayList<Account> accounts) {
            this.accounts = accounts;
            return this;
        }

        public BankCustomerBuilder creationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public int compareTo(Customer other) {
        // Compare based on creation date
        return this.creationDate.compareTo(other.creationDate);
    }
}