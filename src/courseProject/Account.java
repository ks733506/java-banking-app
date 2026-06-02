package courseProject;

public abstract class Account implements AccountInterface {

    // Instance variables
    private final String accountNumber;   // max 5 chars, validated in BankAcctApp
    private String accountType;           // CHK or SAV, validated in BankAcctApp
    private double serviceFee;            // per instructions (0.50 or 0.25)
    private double interestRate;          // per instruction (2% or 5%)
    private double overdraftFee;          // per instruction (30.00 for checking, 0 for savings)
    protected double balance;             // starts at 0.00

    // Constructor
    public Account(String accountNumber, String accountType,
                   double serviceFee, double interestRate, double overdraftFee) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.serviceFee = serviceFee;
        this.interestRate = interestRate;
        this.overdraftFee = overdraftFee;
        this.balance = 0.00;
    }

    // Abstract methods required by Phase 3
    @Override
    public abstract void withdrawal(double amount);

    @Override
    public abstract void deposit(double amount);

    @Override
    public double balance() {
        return balance;
    }

    // Shared helper: apply interest and RETURN the interest amount
    public double applyInterest() {
        double interestEarned = balance * (interestRate / 100.0);
        balance += interestEarned;
        return interestEarned;
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    protected double getServiceFee() { return serviceFee; }
    protected double getInterestRate() { return interestRate; }
    protected double getOverdraftFee() { return overdraftFee; }

    @Override
    public String toString() {
        return String.format(
            "Account Number: %s, Type: %s, Service Fee: $%.2f, Interest Rate: %.2f%%, Overdraft Fee: $%.2f, Balance: $%.2f",
            accountNumber, accountType, serviceFee, interestRate, overdraftFee, balance
        );
    }
}
