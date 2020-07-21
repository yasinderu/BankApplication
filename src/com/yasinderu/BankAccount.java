package com.yasinderu;

import java.util.Scanner;

public class BankAccount {
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    private void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        } else {
            System.out.println("Amount of deposit must greater than zero");
        }
    }

    private void withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Balance is not enough for withdraw");
        }
    }

    private void showPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited : " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn : " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome "  + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("===================================================");
            System.out.print("Enter Option : ");
            option = scanner.next().charAt(0);
            System.out.println("===================================================");

            switch(option) {
                case 'A':
                    System.out.println("----------------------------");
                    System.out.println("Your Balance : " + balance);
                    System.out.println("----------------------------");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("-----------------------------");
                    System.out.println("Enter amount of deposit : ");
                    System.out.println("-----------------------------");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("-----------------------------");
                    System.out.println("Enter amount of withdraw : ");
                    System.out.println("-----------------------------");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("-----------------------------");
                    showPreviousTransaction();
                    System.out.println("-----------------------------");
                    System.out.println();
                    break;
            }
        } while (option != 'E');
        System.out.println("Thank you for using our service");
    }
}
