/*************************************************
 File: Driver.java
 By: Edward McDonald
 Date: April 19th, 2024
 Compile: -
 Description: Driver for assignment 5
 *************************************************/

package A2_BaAO.Assign5;

import A2_BaAO.Customer;

import java.util.ArrayList;
import java.util.Date;

public class Driver {
    public static void main(String[] args) {
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

        // Display the created Customer object
        System.out.println("Created Customer:");
        System.out.println("Customer ID: " + customer.getCustomerId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Username: " + customer.getUsername());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Password: " + customer.getPassword());
        System.out.println("Accounts: " + customer.getAccounts());
        System.out.println("Creation Date: " + customer.getCreationDate());
    }
}
