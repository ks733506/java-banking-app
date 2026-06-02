# Java Banking App

A feature-rich banking application built with Java that demonstrates object-oriented programming principles including interfaces, inheritance, and encapsulation. The application provides comprehensive account management with support for multiple account types (Checking and Savings).

## Features

- **Multiple Account Types**: Support for Checking and Savings accounts with different characteristics
- **Account Management**: Create and manage customer banking accounts
- **Deposit & Withdrawal**: Perform transactions on accounts
- **Balance Inquiry**: Check real-time account balance
- **GUI Interface**: User-friendly graphical interface for account operations
- **Command-Line Interface**: Alternative CLI for account management
- **Object-Oriented Design**: Clean architecture using interfaces and inheritance

## Project Structure

```
java-banking-app/
├── src/
│   ├── module-info.java            # Java module configuration
│   └── courseProject/              # Main package
│       ├── Account.java            # Abstract base class for accounts
│       ├── AccountInterface.java    # Account contract interface
│       ├── CheckingAccount.java     # Checking account implementation
│       ├── SavingsAccount.java      # Savings account implementation
│       ├── Customer.java            # Customer information class
│       ├── DataEntry.java           # User input utilities
│       ├── BankAcctApp.java         # Command-line application
│       ├── BankAccountGUI.java      # GUI implementation
│       └── BankAccountGUIApp.java   # GUI entry point
└── bin/                            # Compiled class files
```

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Eclipse IDE (recommended) or any Java compiler

## Installation & Setup

### Using Eclipse IDE

1. Import the project into Eclipse as an existing project
2. The project will automatically compile
3. Run as Java Application (select main class when prompted)

### Using Command Line

**Compilation:**
```bash
javac -d bin src/courseProject/*.java src/module-info.java
```

**Running the CLI Application:**
```bash
java -cp bin courseProject.BankAcctApp
```

**Running the GUI Application:**
```bash
java -cp bin courseProject.BankAccountGUIApp
```

## Core Classes

### Account (Abstract Base Class)
- Represents a generic bank account with common properties
- Implements `AccountInterface`
- Methods:
  - `getAccountNumber()` - Returns account number
  - `getBalance()` - Returns current balance
  - `getCustomer()` - Returns associated customer
  - `deposit(double amount)` - Add funds to account
  - `withdraw(double amount)` - Remove funds from account

### CheckingAccount
- Extends `Account` for checking account functionality
- Typically has overdraft protection
- May include check writing capabilities

### SavingsAccount
- Extends `Account` for savings account functionality
- May include interest calculation
- Typically has withdrawal restrictions

### Customer
- Represents a customer entity
- Stores customer information (name, ID, contact details)
- Manages associated accounts

### AccountInterface
- Defines the contract for all account types
- Ensures consistent behavior across different account implementations

### DataEntry
- Utility class for user input validation
- Handles numeric and string input with error checking

## Usage Examples

### Command-Line Application (BankAcctApp)

The CLI application provides an interactive menu for:
- Creating new customers
- Opening accounts (Checking or Savings)
- Depositing funds
- Withdrawing funds
- Viewing account balances
- Managing multiple accounts

### GUI Application (BankAccountGUI)

The GUI provides a user-friendly interface with:
- Forms for account creation
- Transaction input fields
- Real-time balance updates
- Account selection dropdown
- Error message display
- Professional layout

## Application Workflow

1. **Customer Creation**: Enter customer information
2. **Account Opening**: Create Checking or Savings account
3. **Transaction Entry**: Perform deposits/withdrawals
4. **Account Management**: View balances and account details
5. **Reporting**: Generate account summaries

## Key Design Patterns

- **Inheritance**: Account types extend base Account class
- **Interface Implementation**: AccountInterface defines standard operations
- **Encapsulation**: Private fields with public accessor methods
- **Polymorphism**: Different account types with specialized behaviors

## Method Reference

### Account Class Methods
- `deposit(double amount)` - Add funds; typically validates positive amount
- `withdraw(double amount)` - Remove funds; checks for sufficient balance
- `getBalance()` - Returns current account balance
- `getAccountNumber()` - Returns unique account identifier
- `getCustomer()` - Returns associated Customer object

### Customer Class Methods
- `getCustomerID()` - Returns customer ID
- `getCustomerName()` - Returns customer name
- `addAccount(Account account)` - Associates account with customer
- `getAccounts()` - Returns list of customer's accounts

## Compilation & Execution

### One-Step Compilation and Run

```bash
# Compile
javac -d bin src/courseProject/*.java src/module-info.java

# Run CLI
java -cp bin courseProject.BankAcctApp

# Run GUI
java -cp bin courseProject.BankAccountGUIApp
```

## Error Handling

- Validates account numbers are unique
- Prevents negative deposits
- Checks for sufficient funds before withdrawal
- Validates customer information input
- GUI provides user-friendly error messages

## Learning Objectives

This project demonstrates:
- Abstract classes and inheritance hierarchy
- Interface-based design
- Encapsulation principles
- GUI development with Java Swing
- Data validation and error handling
- Object-oriented programming best practices
- Multi-window GUI applications

## Testing

The application can be tested by:
1. Creating multiple customers
2. Opening different account types for each customer
3. Performing various transactions
4. Verifying balance updates
5. Testing invalid input scenarios

## Author

Created by: ks733506

## License

This project is open source and available for educational purposes.

## Additional Notes

- The module system (`module-info.java`) requires JDK 9+
- Account numbers are typically generated automatically
- All monetary values use double precision
- Both GUI and CLI interfaces manage the same underlying data structures
- The application is single-user (in-memory data storage)

---

**Last Updated**: June 2, 2026
