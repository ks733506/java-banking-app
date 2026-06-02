package courseProject;

public class CheckingAccount extends Account {

    // Transaction fields (validated in BankAcctApp)
    private String transactionDate;   // format yyyy-mm-dd
    private String transactionType;   // "DEP" or "WTH"
    private double transactionAmount; // positive decimal

    // Constructor: only needs account number, inherits other values from Account class
    public CheckingAccount(String accountNumber) {
        super(accountNumber, "CHK", 0.50, 2.0, 30.0);
    }

    // Setters for transaction fields (called after validation in BankAcctApp)
    public void setTransactionDate(String date) { this.transactionDate = date; }
    public void setTransactionType(String type) { this.transactionType = type; }
    public void setTransactionAmount(double amount) { this.transactionAmount = amount; }

    public String getTransactionDate() { return transactionDate; }
    public String getTransactionType() { return transactionType; }
    public double getTransactionAmount() { return transactionAmount; }

    // Deposit logic: add amount, subtract $0.50 service fee
    @Override
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive.");
        balance += amount;
        balance -= getServiceFee(); // $0.50 fee
    }

    // Withdrawal logic: subtract amount + $0.50 fee, apply $30 overdraft if balance < 0
    @Override
    public void withdrawal(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive.");
        double newBalance = balance - amount - getServiceFee();
        if (newBalance < 0) {
            // overdraft allowed, apply $30 fee
            balance = newBalance - getOverdraftFee();
        } else {
            balance = newBalance;
        }
    }

    // Balance method already implemented in Account (returns balance)

    @Override
    public String toString() {
        return String.format(
            "Checking Account %s | Type: CHK | Balance: $%.2f",
            getAccountNumber(),
            balance()
        );
    }

}
