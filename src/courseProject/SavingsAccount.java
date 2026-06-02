package courseProject;

public class SavingsAccount extends Account {

    // Transaction fields (validated in BankAcctApp)
    private String transactionDate;   // format yyyy-mm-dd
    private String transactionType;   // "DEP" or "WTH"
    private double transactionAmount; // positive decimal

    // Constructor
    public SavingsAccount(String accountNumber) {
        super(accountNumber, "SAV", 0.25, 5.0, 0.0);
        // Service Fee = $0.25, Interest Rate = 5%, Overdraft Fee = 0 (not used)
    }

    // Setters for transaction fields (called after validation in BankAcctApp)
    public void setTransactionDate(String date) { this.transactionDate = date; }
    public void setTransactionType(String type) { this.transactionType = type; }
    public void setTransactionAmount(double amount) { this.transactionAmount = amount; }

    public String getTransactionDate() { return transactionDate; }
    public String getTransactionType() { return transactionType; }
    public double getTransactionAmount() { return transactionAmount; }

    // Deposit logic: add amount, subtract $0.25 service fee
    @Override
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive.");
        balance += amount;
        balance -= getServiceFee(); // $0.25 fee
    }

    // Withdrawal logic: subtract amount + $0.25 fee, deny if balance would go negative
    @Override
    public void withdrawal(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive.");
        double newBalance = balance - amount - getServiceFee();
        if (newBalance < 0) {
            throw new IllegalArgumentException("Savings withdrawal denied: insufficient funds.");
        }
        balance = newBalance;
    }

    // Balance method already implemented in Account (returns balance)

    @Override
    public String toString() {
        return String.format(
            "Savings Account %s | Type: SAV | Balance: $%.2f",
            getAccountNumber(),
            balance()
        );
    }

}
