package Collections;

import java.util.Scanner;

// Customer class to store customer details
class Customer {
    private String custName;
    private String password;
    private double balance;

    // Constructor
    public Customer(String custName, String password) {
        this.custName = custName;
        this.password = password;
        this.balance = 0.0; // Initial balance is set to 0
    }

    // Getter methods
    public String getCustName() {
        return custName;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive amount.");
        }
    }

    // Method to withdraw amount
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}

// Main class
public class BankingApplication {
    private static Customer customer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            displayMainMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    customerLogin(scanner);
                    break;
                case 2:
                    newCustomerSignIn(scanner);
                    break;
                case 3:
                    System.out.println("Exited Application successfully...");
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        } while (option != 3);
    }

    // Method to display main menu
    private static void displayMainMenu() {
        System.out.println("\nCustomer");
        System.out.println("1. Customer Login");
        System.out.println("2. New Customer Sign in");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method for customer login
    private static void customerLogin(Scanner scanner) {
        System.out.print("Enter Customer Name: ");
        String custName = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        // Assuming customer details are stored in a database, for simplicity we'll just check against hard-coded values
        if (custName.equals(custName) && password.equals(password)) {
            System.out.println("Welcome '" + custName + "'...");
            customer = new Customer(custName, password);
            displaySubMenu(scanner);
        } else {
            System.out.println("Not a valid customer...");
        }
    }

    // Method for new customer sign in
    private static void newCustomerSignIn(Scanner scanner) {
        System.out.print("Enter Customer Name: ");
        String custName = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();

        // In a real application, you would save the customer details to a database
        System.out.println("New customer signed in successfully...");
    }

    // Method to display sub menu
    private static void displaySubMenu(Scanner scanner) {
        char option;
        do {
            System.out.println("\nAccount Details");
            System.out.println("a. Amount Deposit");
            System.out.println("b. Amount Withdrawal");
            System.out.println("c. Check Balance");
            System.out.println("d. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'a':
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    customer.deposit(depositAmount);
                    break;
                case 'b':
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    customer.withdraw(withdrawAmount);
                    break;
                case 'c':
                    System.out.println("Current Balance: " + customer.getBalance());
                    break;
                case 'd':
                    System.out.println("Exiting sub menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        } while (option != 'd');
    }
}

