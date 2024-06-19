package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

public class CustomerUtility {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Testing getAllCustomers method
        System.out.println("All Customers:");
        getAllCustomers();
        System.out.println();

        // Inserting new customer
        System.out.println("Inserting new customer:");
        Customer newCustomer = getCustomerDetailsFromUser();
        insertCustomer(newCustomer);
        System.out.println();

        // Updating existing customer
        System.out.println("Updating customer:");
        Customer existingCustomer = getCustomerToUpdate();
        updateCustomer(existingCustomer);
    }

    private static void getAllCustomers() {
        CustomerService customerService = new CustomerServiceImpl();
        ArrayList<Customer> customerList = customerService.getAllCustomers();
        for (Customer customer : customerList) {
            printCustomerDetails(customer);
        }
    }

    private static Customer getCustomerDetailsFromUser() {
        System.out.print("Enter Customer Code: ");
        int customerCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Age: ");
        long phoneNo = scanner.nextLong();

        System.out.print("Enter Aadhar Number: ");
        long aadhar = scanner.nextLong();

        return new Customer(customerCode, firstName, lastName, address, phoneNo, aadhar);
    }

    private static Customer getCustomerToUpdate() {
        System.out.print("Enter Customer Code of the customer to update: ");
        int customerCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Assuming you want to update all fields for simplicity
        return getCustomerDetailsFromUser();
    }

    private static void insertCustomer(Customer customer) {
        CustomerService customerService = new CustomerServiceImpl();
        int rowsAffected = customerService.insertIntoCustomer(customer);
        if (rowsAffected > 0) {
            System.out.println("Customer inserted successfully.");
        } else {
            System.out.println("Failed to insert customer.");
        }
    }

    private static void updateCustomer(Customer customer) {
        CustomerService customerService = new CustomerServiceImpl();
        int rowsAffected = customerService.updateCustomer(customer);
        if (rowsAffected > 0) {
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Failed to update customer.");
        }
    }

    private static void printCustomerDetails(Customer customer) {
        System.out.println("Customer Code: " + customer.getCustomerCode());
        System.out.println("First Name: " + customer.getCustomerFirstame());
        System.out.println("Last Name: " + customer.getCustomerLastname());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Age: " + customer.getPhoneNo());
        System.out.println("Aadhar: " + customer.getAadhar());
        System.out.println();
    }
}
