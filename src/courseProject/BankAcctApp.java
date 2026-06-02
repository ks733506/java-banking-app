package courseProject;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BankAcctApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        boolean addMore = true;

        // CUSTOMER & ACCOUNT CREATION
        while (addMore) {

            boolean valid_data;

            // CUSTOMER FIELDS
            String customerId = "";
            valid_data = false;
            while (!valid_data) {
                try {
                    System.out.print("Enter Customer ID (max 5 characters): ");
                    customerId = input.nextLine().trim();
                    if (!DataEntry.checkNonBlankString(customerId) || !DataEntry.checkMaxStringLen(customerId, 5)) {
                        throw new IllegalArgumentException("Customer ID must be non-blank and max 5 characters.");
                    }
                    valid_data = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String ssn = "";
            valid_data = false;
            while (!valid_data) {
                try {
                    System.out.print("Enter Customer Social Security Number (9 numeric digits): ");
                    ssn = input.nextLine().trim();
                    if (!DataEntry.checkNonBlankString(ssn) || ssn.length() != 9 || !DataEntry.checkNumericString(ssn)) {
                        throw new IllegalArgumentException("SSN must be 9 numeric digits.");
                    }
                    valid_data = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String lastName = "";
            valid_data = false;
            while (!valid_data) {
                try {
                    System.out.print("Enter Customer Last Name (20 chars max): ");
                    lastName = input.nextLine().trim();
                    if (!DataEntry.checkNonBlankString(lastName) || !DataEntry.checkMaxStringLen(lastName, 20)) {
                        throw new IllegalArgumentException("Last Name must be non-blank and max 20 characters.");
                    }
                    valid_data = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String firstName = "";
            valid_data = false;
            while (!valid_data) {
                try {
                    System.out.print("Enter Customer First Name (15 chars max): ");
                    firstName = input.nextLine().trim();
                    if (!DataEntry.checkNonBlankString(firstName) || !DataEntry.checkMaxStringLen(firstName, 15)) {
                        throw new IllegalArgumentException("First Name must be non-blank and max 15 characters.");
                    }
                    valid_data = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String street = "";
            valid_data = false;
            while (!valid_data) {
                try {
                    System.out.print("Enter Street (max 20 characters): ");
                    street = input.nextLine().trim();
                    if (!DataEntry.checkNonBlankString(street) || !DataEntry.checkMaxStringLen(street, 20)) {
                        throw new IllegalArgumentException("Street must be non-blank and max 20 characters.");
                    }
                    valid_data = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String city = "";
            valid_data = false;
            while (!valid_data) {
                try {
                    System.out.print("Enter City (max 20 characters): ");
                    city = input.nextLine().trim();
                    if (!DataEntry.checkNonBlankString(city) || !DataEntry.checkMaxStringLen(city, 20)) {
                        throw new IllegalArgumentException("City must be non-blank and max 20 characters.");
                    }
                    valid_data = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String state = "";
            valid_data = false;
            while (!valid_data) {
                try {
                    System.out.print("Enter State (2 characters): ");
                    state = input.nextLine().trim().toUpperCase();
                    if (!DataEntry.checkNonBlankString(state) || state.length() != 2) {
                        throw new IllegalArgumentException("State must be exactly 2 characters.");
                    }
                    valid_data = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String zip = "";
            valid_data = false;
            while (!valid_data) {
                try {
                    System.out.print("Enter Zip Code (5 digits): ");
                    zip = input.nextLine().trim();
                    if (!DataEntry.checkNonBlankString(zip) || zip.length() != 5 || !DataEntry.checkNumericString(zip)) {
                        throw new IllegalArgumentException("Zip Code must be 5 numeric digits.");
                    }
                    valid_data = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            String phone = "";
            valid_data = false;
            while (!valid_data) {
                try {
                    System.out.print("Enter Phone Number (10 digits): ");
                    phone = input.nextLine().trim();
                    if (!DataEntry.checkNonBlankString(phone) || phone.length() != 10 || !DataEntry.checkNumericString(phone)) {
                        throw new IllegalArgumentException("Phone Number must be 10 numeric digits.");
                    }
                    valid_data = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // Create and store customer
            Customer cust = new Customer(customerId, ssn, lastName, firstName, street, city, state, zip, phone);
            customers.add(cust);

            //Phase 3 ACCOUNT CREATION LOOP (no prompting for fees/rates)
            System.out.print("Add an account for this customer? (yes/no): ");
            String addAccountResponse = input.nextLine().trim();

            while (addAccountResponse.equalsIgnoreCase("yes")) {

                String accountNumber = "";
                valid_data = false;
                while (!valid_data) {
                    try {
                        System.out.print("Enter Account Number (max 5 characters): ");
                        accountNumber = input.nextLine().trim();
                        if (!DataEntry.checkNonBlankString(accountNumber) || !DataEntry.checkMaxStringLen(accountNumber, 5)) {
                            throw new IllegalArgumentException("Account Number must be non-blank and max 5 characters.");
                        }
                        valid_data = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                String accountType = "";
                valid_data = false;
                while (!valid_data) {
                    try {
                        System.out.print("Enter Account Type (CHK or SAV): ");
                        accountType = input.nextLine().trim().toUpperCase();
                        if (!accountType.equals("CHK") && !accountType.equals("SAV")) {
                            throw new IllegalArgumentException("Account Type must be 'CHK' or 'SAV'.");
                        }
                        valid_data = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                // Create and attach account using fixed values
                Account acct;
                if (accountType.equals("CHK")) {
                    acct = new CheckingAccount(accountNumber); // fee 0.50, rate 2%, overdraft 30
                } else {
                    acct = new SavingsAccount(accountNumber);  // fee 0.25, rate 5%, no overdraft
                }
                cust.addAccount(acct);

                System.out.print("Add another account for this customer? (yes/no): ");
                addAccountResponse = input.nextLine().trim();
            }

            // ASK TO ADD ANOTHER CUSTOMER
            System.out.print("Add another customer? (yes/no): ");
            String response = input.nextLine().trim();
            addMore = response.equalsIgnoreCase("yes");
        }

        // RUN STEP 5 SCENARIO
        if (customers.isEmpty()) {
            System.out.println("\nNo customers entered. Exiting.");
            input.close();
            return;
        }

        // Prompt ONCE for scenario date
        String scenarioDate = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("\nEnter transaction date to use for scenario (yyyy-mm-dd): ");
                String d = input.nextLine().trim();
                DataEntry.checkDate(d);   // throws if invalid
                scenarioDate = d;
                validDate = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Find first checking and first savings account
        CheckingAccount checking = null;
        SavingsAccount savings = null;
        Customer checkingCustomer = null;
        Customer savingsCustomer = null;

        for (Customer c : customers) {
            for (Account a : c.getAccounts()) {
                if (checking == null && a instanceof CheckingAccount) {
                    checking = (CheckingAccount) a;
                    checkingCustomer = c;
                } else if (savings == null && a instanceof SavingsAccount) {
                    savings = (SavingsAccount) a;
                    savingsCustomer = c;
                }
            }
        }

        if (checking == null || savings == null) {
            System.out.println("\nUnable to run scenario: need at least one checking and one savings account.");
            input.close();
            return;
        }

        System.out.println("\n---Running Scenario---");
        System.out.printf("%-10s %-8s %-5s %-12s %-6s %-10s %-12s %-10s%n",
                "CustID", "Acct#", "Type", "Date", "Tran", "Amount", "Fees", "Balance");

        // 1. Deposit $1000 into the checking account.
        doDeposit(checkingCustomer, checking, "CHK", scenarioDate, 1000.00);

        // 2. Withdraw $500 from the checking account.
        doWithdrawal(checkingCustomer, checking, "CHK", scenarioDate, 500.00);

        // 3. Withdraw $501 from the checking account (should trigger overdraft fee).
        doWithdrawal(checkingCustomer, checking, "CHK", scenarioDate, 501.00);

        // 4. Deposit $500 into the checking account.
        doDeposit(checkingCustomer, checking, "CHK", scenarioDate, 500.00);

        // 5. Add the interest earned to the checking account based on the rate.
        doInterest(checkingCustomer, checking, "CHK", scenarioDate);

        // 6. Deposit $1000 into the savings account.
        doDeposit(savingsCustomer, savings, "SAV", scenarioDate, 1000.00);

        // 7. Withdraw $500 from the savings account.
        doWithdrawal(savingsCustomer, savings, "SAV", scenarioDate, 500.00);

        // 8. Withdraw $501 from the savings account (should be denied).
        doWithdrawal(savingsCustomer, savings, "SAV", scenarioDate, 501.00);

        // 9. Deposit $500 into the savings account.
        doDeposit(savingsCustomer, savings, "SAV", scenarioDate, 500.00);

        // 10. Add the interest earned to the savings account based on the rate.
        doInterest(savingsCustomer, savings, "SAV", scenarioDate);
        
        // DISPLAY ALL CUSTOMERS/ACCOUNTS
        System.out.println("\n--- Final Customer / Account Summary ---");
        for (Customer c : customers) {
            System.out.println(c.toString());
            for (Account a : c.getAccounts()) {
                System.out.println("  → " + a.toString());
            }
        }

        input.close();
    }
    
    // HELPER METHODS FOR SCENARIO

    // Deposit with service fee, printing a row
    private static void doDeposit(Customer cust, Account acct, String acctTypeCode,
                                  String date, double amount) {

        // Set transaction fields if applicable
        if (acct instanceof CheckingAccount) {
            CheckingAccount ca = (CheckingAccount) acct;
            ca.setTransactionDate(date);
            ca.setTransactionType("DEP");
            ca.setTransactionAmount(amount);
        } else if (acct instanceof SavingsAccount) {
            SavingsAccount sa = (SavingsAccount) acct;
            sa.setTransactionDate(date);
            sa.setTransactionType("DEP");
            sa.setTransactionAmount(amount);
        }

        double serviceFee = acct.getServiceFee();
        double fees = serviceFee;

        try {
            acct.deposit(amount);
            System.out.printf("%-10s %-8s %-5s %-12s %-6s $%-9.2f $%-11.2f $%-9.2f%n",
                    cust.getCustomerId(),
                    acct.getAccountNumber(),
                    acctTypeCode,
                    date,
                    "DEP",
                    amount,
                    fees,
                    acct.balance());
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit error: " + e.getMessage());
        }
    }

    // Withdrawal with service fee and possible overdraft fee
    private static void doWithdrawal(Customer cust, Account acct, String acctTypeCode,
                                     String date, double amount) {

        if (acct instanceof CheckingAccount) {
            CheckingAccount ca = (CheckingAccount) acct;
            ca.setTransactionDate(date);
            ca.setTransactionType("WTH");
            ca.setTransactionAmount(amount);
        } else if (acct instanceof SavingsAccount) {
            SavingsAccount sa = (SavingsAccount) acct;
            sa.setTransactionDate(date);
            sa.setTransactionType("WTH");
            sa.setTransactionAmount(amount);
        }

        double before = acct.balance();
        double serviceFee = acct.getServiceFee();
        double overdraftCharge = 0.0;

        try {
            acct.withdrawal(amount);
            double expectedNoOverdraft = before - amount - serviceFee;

            if (acct instanceof CheckingAccount && acct.balance() < expectedNoOverdraft) {
                overdraftCharge = acct.getOverdraftFee();
            }

            double totalFees = serviceFee + overdraftCharge;

            System.out.printf("%-10s %-8s %-5s %-12s %-6s $%-9.2f $%-11.2f $%-9.2f%n",
                    cust.getCustomerId(),
                    acct.getAccountNumber(),
                    acctTypeCode,
                    date,
                    "WTH",
                    amount,
                    totalFees,
                    acct.balance());
        } catch (IllegalArgumentException e) {
            // For example, savings withdrawal denied if it would go negative
            System.out.printf("%-10s %-8s %-5s %-12s %-6s %-10s %-12s $%-9.2f%n",
                    cust.getCustomerId(),
                    acct.getAccountNumber(),
                    acctTypeCode,
                    date,
                    "WTH",
                    "DENIED",
                    "N/A",
                    acct.balance());
            System.out.println("Withdrawal error: " + e.getMessage());
        }
    }

    // Apply interest and print a row (no fees)
    private static void doInterest(Customer cust, Account acct, String acctTypeCode,
                                   String date) {

        double interestAmount = acct.applyInterest();

        if (acct instanceof CheckingAccount) {
            CheckingAccount ca = (CheckingAccount) acct;
            ca.setTransactionDate(date);
            ca.setTransactionType("INT");
            ca.setTransactionAmount(interestAmount);
        } else if (acct instanceof SavingsAccount) {
            SavingsAccount sa = (SavingsAccount) acct;
            sa.setTransactionDate(date);
            sa.setTransactionType("INT");
            sa.setTransactionAmount(interestAmount);
        }

        System.out.printf("%-10s %-8s %-5s %-12s %-6s $%-9.2f $%-11.2f $%-9.2f%n",
                cust.getCustomerId(),
                acct.getAccountNumber(),
                acctTypeCode,
                date,
                "INT",
                interestAmount,
                0.00,
                acct.balance());
    }
}
