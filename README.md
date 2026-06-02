# Java Banking App

A robust and feature-rich banking application built with Java, providing essential banking operations and account management functionality.

## Features

- **Account Management**: Create, view, and manage banking accounts
- **Transactions**: Deposit and withdrawal operations
- **Balance Inquiry**: Real-time account balance checking
- **Transaction History**: View detailed transaction logs
- **Secure Operations**: Built-in validation and error handling

## Prerequisites

- Java 8 or higher
- Maven (for dependency management)
- Git

## Installation

1. Clone the repository:
```bash
git clone https://github.com/ks733506/java-banking-app.git
cd java-banking-app
```

2. Build the project:
```bash
mvn clean build
```

3. Run the application:
```bash
mvn exec:java -Dexec.mainClass="com.banking.Main"
```

## Project Structure

```
java-banking-app/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/banking/
│   │           ├── Account.java
│   │           ├── Bank.java
│   │           ├── Transaction.java
│   │           └── Main.java
│   └── test/
│       └── java/
│           └── com/banking/
├── pom.xml
└── README.md
```

## Usage

### Basic Example

```java
// Create a banking instance
Bank bank = new Bank();

// Create an account
Account account = bank.createAccount("John Doe", "123456789");

// Perform transactions
account.deposit(1000);
account.withdraw(200);

// Check balance
System.out.println("Balance: " + account.getBalance());
```

## Core Classes

- **Account**: Represents a bank account with balance and transaction history
- **Bank**: Manages multiple accounts and banking operations
- **Transaction**: Represents individual transactions (deposits/withdrawals)
- **Main**: Entry point for the application

## API Documentation

### Account Class
- `deposit(double amount)`: Add funds to the account
- `withdraw(double amount)`: Remove funds from the account
- `getBalance()`: Retrieve current account balance
- `getTransactionHistory()`: View all transactions

### Bank Class
- `createAccount(String name, String accountNumber)`: Create a new account
- `getAccount(String accountNumber)`: Retrieve an existing account
- `deleteAccount(String accountNumber)`: Remove an account

## Testing

Run the test suite with:
```bash
mvn test
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

**ks733506** - [GitHub Profile](https://github.com/ks733506)

## Support

For support, please open an issue in the [GitHub Issues](https://github.com/ks733506/java-banking-app/issues) section.

## Roadmap

- [ ] Database integration
- [ ] REST API endpoints
- [ ] User authentication
- [ ] Multi-currency support
- [ ] Interest calculation
- [ ] Loan management
- [ ] Mobile app integration

## Changelog

### Version 1.0.0
- Initial release
- Basic account operations
- Transaction management

---

**Last Updated**: June 2, 2026
