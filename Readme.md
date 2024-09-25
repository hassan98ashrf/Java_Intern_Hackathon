# Bank Management System

## Project Overview

The **Bank Management System** is a Java-based application designed to help bank managers and customers manage accounts effectively. The system provides various banking functionalities such as deposit, withdrawal, balance enquiry, and transaction history. Additionally, administrators can manage customer accounts, generate reports, and view all customer balances. The frontend is implemented using Java Swing for a GUI interface, and data is stored in text files.

This project follows a systematic approach starting from case study analysis, through system design, development, and testing. The **Kanban** methodology was selected as the most suitable project management approach due to its flexibility and continuous delivery focus.

## Table of Contents
- [Case Study](#case-study)
- [Kanban Methodology](#kanban-methodology)
- [Requirements](#requirements)
- [System Analysis](#system-analysis)
  - [Use Case Diagram](#use-case-diagram)
  - [Activity Diagram](#activity-diagram)
  - [Sequence Diagram](#sequence-diagram)
- [Implementation](#implementation)
- [Manual Testing](#manual-testing)
- [How to Run](#how-to-run)
- [Contributors](#contributors)

## Case Study

The bank offers multiple types of accounts, including Checking, Savings, and Loan accounts. Each customer can open one or more accounts. They can perform various operations like depositing money, withdrawing funds, checking their balance, and viewing their transaction history. 

Bank administrators have access to more functionalities, such as adding or deleting customers, editing accounts, viewing all customer balances, and generating financial reports.

## Kanban Methodology

The **Kanban** method was chosen for this project as it supports continuous improvement, allows for flexible planning, and provides clarity on task status at all times. A Kanban board was set up to track all stages of development, from system analysis to implementation and testing. The following columns were defined in the Kanban board:
1. **To-Do**: Project planning, diagrams, system requirements, and code architecture.
2. **In Progress**: Implementing core features like deposit, withdrawal, and account management.
3. **Testing**: Verifying code functionality through manual and automated tests.
4. **Done**: Completed tasks and modules.

You can check Kanban table here :[Kanban](https://trello.com/b/yh2v3DZ4/hackathon)

## Requirements

The project has the following requirements:

- **User Types**:
  - **Customer**: Can deposit, withdraw, check balance, and view transactions.
  - **Administrator**: Can manage customer accounts, generate reports, and view balances.
  
- **Account Types**:
  - **Checking Account**: Allows overdraft with a credit limit.
  - **Savings Account**: Credits monthly interest based on the account balance.
  - **Loan Account**: Tracks the loan balance, principal, interest rate, and loan duration.

- **Data Storage**:
  - Customer data is stored in `customers.txt`.
  - Account details are stored in `accounts.txt`.
  - Transaction history is stored in `account_transaction.txt`.

## System Analysis

### Use Case Diagram
The **Use Case Diagram** defines the interactions between the customer and administrator with the system, specifying operations such as deposit, withdrawal, account management, and report generation.

![case1](https://github.com/user-attachments/assets/4c47f3ab-8af5-4571-9a82-8a666aa91cf2)


### Activity Diagram
The **Activity Diagram** illustrates the step-by-step flow of customer and administrator interactions, from logging in to performing transactions and generating reports.

![activity1](https://github.com/user-attachments/assets/ad44c52c-6c9f-4ae4-82e7-0e8c80ea1e4a)


### Sequence Diagram
The **Sequence Diagram** (not included) showcases the detailed flow of communication between the objects in the system, including how requests are processed during customer and administrator operations.

![seq1](https://github.com/user-attachments/assets/99f5a8ae-9c7c-48b0-9182-23eded3a4fc1)

![seq2](https://github.com/user-attachments/assets/77016735-e6a3-4abd-8261-2375f95a5e8d)



## Implementation

The project follows **object-oriented design principles** and adheres to the **SOLID** principles for clean, modular code. The following classes were implemented:

1. **Account.java**: A general account class for deposit, withdrawal, and balance enquiry.
2. **CheckingAccount.java**: A subclass of Account allowing overdraft withdrawals.
3. **SavingsAccount.java**: A subclass of Account that calculates interest.
4. **Loan.java**: A subclass of Account tracking loan balances and monthly interest.
5. **Customer.java**: Manages customer details and holds multiple accounts.
6. **Administrator.java**: Manages customer accounts and generates reports.

Additionally, the **GUI** is built using **Java Swing** to provide a user-friendly interface for both customers and administrators.

## Manual Testing

The application was tested manually to ensure that all features work as expected. Each feature was validated using various test cases, including:

1. **Deposit**: Verified correct balance updates after deposits.
2. **Withdraw**: Checked for overdraft limits in checking accounts and sufficient balance in savings and loan accounts.
3. **Balance Enquiry**: Ensured that accurate balances were displayed.
4. **View Transactions**: Checked the transaction history after operations.
5. **Administrator Operations**: Verified that the administrator can manage customers and generate reports accurately.

You can check test cases here : [Manual test ](https://docs.google.com/spreadsheets/d/1kSyavnK3LL2xU1uAcow6kbD7keFH2O3Zy111wen7giA/edit?gid=1623262623#gid=1623262623)

## How to Run

To run the project:

1. Clone the repository to your local machine.
   ```bash
   [git clone https://github.com/your-repo/bank-management-system.git](https://github.com/hassan98ashrf/Java_Intern_Hackathon/tree/main)
   
2. Change path of texts from "src\main\java\gui\Service\PathOfText.java"


## Contributors

- Hassan Ashraf
