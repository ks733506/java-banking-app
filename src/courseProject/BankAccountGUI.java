package courseProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    // For this phase, each customer will have at most one account.
    private Map<String, Customer> customers = new HashMap<>();

    // --- Customer input fields ---
    private JTextField txtCustomerId;
    private JTextField txtSSN;
    private JTextField txtLastName;
    private JTextField txtFirstName;
    private JTextField txtStreet;
    private JTextField txtCity;
    private JComboBox<String> cboState;
    private JTextField txtZip;
    private JTextField txtPhone;

    // --- Account input fields ---
    private JTextField txtAccountNumber;
    private JRadioButton rdoChecking;
    private JRadioButton rdoSavings;
    private ButtonGroup grpAccountType;

    // --- Transaction input fields (separate Customer ID for transactions) ---
    private JTextField txtTransCustomerId;
    private JTextField txtTransactionDate;
    private JTextField txtTransactionAmount;
    private JRadioButton rdoDeposit;
    private JRadioButton rdoWithdrawal;
    private ButtonGroup grpTransactionType;

    // --- Buttons ---
    private JButton btnAddCustomerAccount;
    private JButton btnDisplayCustomerAccount;
    private JButton btnPerformTransaction;
    private JButton btnApplyInterest;   // NEW
    private JButton btnClear;

    // --- Status & Result labels ---
    private JLabel lblStatus;

    private JLabel lblResCustomerId;
    private JLabel lblResAccountNumber;
    private JLabel lblResAccountType;
    private JLabel lblResTransactionDate;
    private JLabel lblResTransactionType;
    private JLabel lblResTransactionAmount;
    private JLabel lblResFees;
    private JLabel lblResBalance;

    public BankAccountGUI() {
        setTitle("Bank Account Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createComponents();
        layoutComponents();
        registerHandlers();

        pack();
        setLocationRelativeTo(null); // center on screen
    }

    private void createComponents() {
        // --- Customer text fields ---
        txtCustomerId = new JTextField(10);
        txtSSN        = new JTextField(10);
        txtLastName   = new JTextField(15);
        txtFirstName  = new JTextField(15);
        txtStreet     = new JTextField(15);
        txtCity       = new JTextField(15);
        txtZip        = new JTextField(6);
        txtPhone      = new JTextField(12);

        // State dropdown with at least 5 abbreviations
        cboState = new JComboBox<>(new String[] { "PA", "NY", "NJ", "OH", "MD" });

        // --- Account fields ---
        txtAccountNumber = new JTextField(10);
        rdoChecking = new JRadioButton("Checking", true);
        rdoSavings  = new JRadioButton("Savings");
        grpAccountType = new ButtonGroup();
        grpAccountType.add(rdoChecking);
        grpAccountType.add(rdoSavings);

        // --- Transaction fields (with its own Customer ID field) ---
        txtTransCustomerId   = new JTextField(10);
        txtTransactionDate   = new JTextField(10);
        txtTransactionAmount = new JTextField(10);

        rdoDeposit    = new JRadioButton("Deposit", true);
        rdoWithdrawal = new JRadioButton("Withdrawal");
        grpTransactionType = new ButtonGroup();
        grpTransactionType.add(rdoDeposit);
        grpTransactionType.add(rdoWithdrawal);

        // --- Buttons ---
        btnAddCustomerAccount     = new JButton("Add New Customer and Account");
        btnDisplayCustomerAccount = new JButton("Display Customer and Account Data");
        btnPerformTransaction     = new JButton("Perform Transaction");
        btnApplyInterest          = new JButton("Apply Interest");   // NEW
        btnClear                  = new JButton("Clear");

        // --- Status label ---
        lblStatus = new JLabel("Ready.");
        lblStatus.setForeground(Color.BLUE);

        // --- Result labels ---
        lblResCustomerId        = new JLabel("Customer ID: ");
        lblResAccountNumber     = new JLabel("Account Number: ");
        lblResAccountType       = new JLabel("Account Type: ");
        lblResTransactionDate   = new JLabel("Transaction Date: ");
        lblResTransactionType   = new JLabel("Transaction Type: ");
        lblResTransactionAmount = new JLabel("Transaction Amount: ");
        lblResFees              = new JLabel("Fees/Charges: ");
        lblResBalance           = new JLabel("Balance: ");
    }

    private void layoutComponents() {
        // Header / welcome message (per instructions)
        JLabel titleLabel = new JLabel("Welcome to the Bank Account Application", SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18f));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ===== Customer & Account Panel =====
        JPanel customerPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        customerPanel.setBorder(BorderFactory.createTitledBorder("Customer and Account Data"));

        customerPanel.add(new JLabel("Customer ID (5 digits):"));
        customerPanel.add(txtCustomerId);

        customerPanel.add(new JLabel("SSN (9 digits):"));
        customerPanel.add(txtSSN);

        customerPanel.add(new JLabel("Last Name:"));
        customerPanel.add(txtLastName);

        customerPanel.add(new JLabel("First Name:"));
        customerPanel.add(txtFirstName);

        customerPanel.add(new JLabel("Street:"));
        customerPanel.add(txtStreet);

        customerPanel.add(new JLabel("City:"));
        customerPanel.add(txtCity);

        customerPanel.add(new JLabel("State:"));
        customerPanel.add(cboState);

        customerPanel.add(new JLabel("Zip Code (5 digits):"));
        customerPanel.add(txtZip);

        customerPanel.add(new JLabel("Phone (10 digits):"));
        customerPanel.add(txtPhone);

        customerPanel.add(new JLabel("Account Number (5 digits):"));
        customerPanel.add(txtAccountNumber);

        customerPanel.add(new JLabel("Account Type:"));
        JPanel acctTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        acctTypePanel.add(rdoChecking);
        acctTypePanel.add(rdoSavings);
        customerPanel.add(acctTypePanel);

        // ===== Transaction Panel (with its own Customer ID field) =====
        JPanel transactionPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        transactionPanel.setBorder(BorderFactory.createTitledBorder("Perform Transaction"));

        transactionPanel.add(new JLabel("Customer ID (5 digits):"));
        transactionPanel.add(txtTransCustomerId);

        transactionPanel.add(new JLabel("Transaction Date (YYYY-MM-DD):"));
        transactionPanel.add(txtTransactionDate);

        transactionPanel.add(new JLabel("Transaction Amount:"));
        transactionPanel.add(txtTransactionAmount);

        transactionPanel.add(new JLabel("Transaction Type:"));
        JPanel transTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        transTypePanel.add(rdoDeposit);
        transTypePanel.add(rdoWithdrawal);
        transactionPanel.add(transTypePanel);

        // ===== Buttons Panel =====
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(btnAddCustomerAccount);
        buttonPanel.add(btnDisplayCustomerAccount);
        buttonPanel.add(btnPerformTransaction);
        buttonPanel.add(btnApplyInterest);   // NEW
        buttonPanel.add(btnClear);

        // ===== Results Panel =====
        JPanel resultPanel = new JPanel(new GridLayout(0, 1, 2, 2));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Transaction Result"));

        resultPanel.add(lblResCustomerId);
        resultPanel.add(lblResAccountNumber);
        resultPanel.add(lblResAccountType);
        resultPanel.add(lblResTransactionDate);
        resultPanel.add(lblResTransactionType);
        resultPanel.add(lblResTransactionAmount);
        resultPanel.add(lblResFees);
        resultPanel.add(lblResBalance);

        // ===== Status Panel =====
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        statusPanel.add(lblStatus, BorderLayout.CENTER);

        // Center panel combining customer, transaction, buttons
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(customerPanel, BorderLayout.NORTH);
        centerPanel.add(transactionPanel, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.EAST);
        mainPanel.add(statusPanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    private void registerHandlers() {
        ButtonHandler handler = new ButtonHandler();
        btnAddCustomerAccount.addActionListener(handler);
        btnDisplayCustomerAccount.addActionListener(handler);
        btnPerformTransaction.addActionListener(handler);
        btnApplyInterest.addActionListener(handler);  // NEW
        btnClear.addActionListener(handler);
    }

    private void clearTextFields() {
        txtCustomerId.setText("");
        txtSSN.setText("");
        txtLastName.setText("");
        txtFirstName.setText("");
        txtStreet.setText("");
        txtCity.setText("");
        cboState.setSelectedIndex(0);
        txtZip.setText("");
        txtPhone.setText("");
        txtAccountNumber.setText("");
        txtTransCustomerId.setText("");
        txtTransactionDate.setText("");
        txtTransactionAmount.setText("");
    }

    private void updateStatus(String message, boolean isError) {
        lblStatus.setText(message);
        lblStatus.setForeground(isError ? Color.RED : Color.BLUE);
    }

    // Single handler for all buttons
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();

            if (src == btnAddCustomerAccount) {
                handleAddCustomerAccount();
            } else if (src == btnDisplayCustomerAccount) {
                handleDisplayCustomerAccount();
            } else if (src == btnPerformTransaction) {
                handlePerformTransaction();
            } else if (src == btnApplyInterest) {   // NEW
                handleApplyInterest();
            } else if (src == btnClear) {
                clearTextFields();
                updateStatus("Fields cleared.", false);
            }
        }
    }

    // === Button Logic ===

    // 1) Add New Customer and Account
    private void handleAddCustomerAccount() {
        try {
            String customerId = txtCustomerId.getText().trim();
            String ssn        = txtSSN.getText().trim();
            String lastName   = txtLastName.getText().trim();
            String firstName  = txtFirstName.getText().trim();
            String street     = txtStreet.getText().trim();
            String city       = txtCity.getText().trim();
            String state      = (String) cboState.getSelectedItem();
            String zip        = txtZip.getText().trim();
            String phone      = txtPhone.getText().trim();
            String accountNumber = txtAccountNumber.getText().trim();

            // Customer ID: exactly 5 numeric digits
            if (!DataEntry.checkNonBlankString(customerId) ||
                customerId.length() != 5 ||
                !DataEntry.checkNumericString(customerId)) {
                throw new IllegalArgumentException("Customer ID must be exactly 5 numeric digits.");
            }

            // SSN: 9 numeric digits
            if (!DataEntry.checkNonBlankString(ssn) ||
                ssn.length() != 9 ||
                !DataEntry.checkNumericString(ssn)) {
                throw new IllegalArgumentException("SSN must be 9 numeric digits.");
            }

            // Name, street, city
            if (!DataEntry.checkNonBlankString(lastName) ||
                !DataEntry.checkMaxStringLen(lastName, 20)) {
                throw new IllegalArgumentException("Last Name must be non-blank and max 20 characters.");
            }

            if (!DataEntry.checkNonBlankString(firstName) ||
                !DataEntry.checkMaxStringLen(firstName, 15)) {
                throw new IllegalArgumentException("First Name must be non-blank and max 15 characters.");
            }

            if (!DataEntry.checkNonBlankString(street) ||
                !DataEntry.checkMaxStringLen(street, 20)) {
                throw new IllegalArgumentException("Street must be non-blank and max 20 characters.");
            }

            if (!DataEntry.checkNonBlankString(city) ||
                !DataEntry.checkMaxStringLen(city, 20)) {
                throw new IllegalArgumentException("City must be non-blank and max 20 characters.");
            }

            // State: 2 characters (abbreviation)
            if (!DataEntry.checkNonBlankString(state) || state.length() != 2) {
                throw new IllegalArgumentException("State must be exactly 2 characters.");
            }

            // Zip: 5 numeric digits
            if (!DataEntry.checkNonBlankString(zip) ||
                zip.length() != 5 ||
                !DataEntry.checkNumericString(zip)) {
                throw new IllegalArgumentException("Zip Code must be 5 numeric digits.");
            }

            // Phone: 10 numeric digits
            if (!DataEntry.checkNonBlankString(phone) ||
                phone.length() != 10 ||
                !DataEntry.checkNumericString(phone)) {
                throw new IllegalArgumentException("Phone Number must be 10 numeric digits.");
            }

            // Account #: exactly 5 numeric digits
            if (!DataEntry.checkNonBlankString(accountNumber) ||
                accountNumber.length() != 5 ||
                !DataEntry.checkNumericString(accountNumber)) {
                throw new IllegalArgumentException("Account Number must be exactly 5 numeric digits.");
            }
            // Also enforce original max-length rule
            if (!DataEntry.checkMaxStringLen(accountNumber, 5)) {
                throw new IllegalArgumentException("Account Number must be max 5 characters.");
            }

            if (customers.containsKey(customerId)) {
                throw new IllegalArgumentException("Customer ID already exists. Try Again.");
            }

            // Create customer and account
            Customer cust = new Customer(customerId, ssn, lastName, firstName,
                                         street, city, state, zip, phone);

            Account acct;
            if (rdoChecking.isSelected()) {
                acct = new CheckingAccount(accountNumber);
            } else {
                acct = new SavingsAccount(accountNumber);
            }
            cust.addAccount(acct);

            customers.put(customerId, cust);

            updateStatus("Customer and " + acct.getAccountType() + " account added successfully.", false);

        } catch (IllegalArgumentException ex) {
            updateStatus("Error: " + ex.getMessage(), true);
        }
    }

    // 2) Display Customer and Account Data
    private void handleDisplayCustomerAccount() {
        String customerId = txtCustomerId.getText().trim();

        if (!DataEntry.checkNonBlankString(customerId)) {
            updateStatus("Enter a Customer ID to display.", true);
            return;
        }

        Customer cust = customers.get(customerId);
        if (cust == null) {
            updateStatus("No customer found for ID: " + customerId, true);
            return;
        }

        List<Account> accounts = cust.getAccounts();
        if (accounts.isEmpty()) {
            updateStatus("Customer has no accounts.", true);
            return;
        }

        Account acct = accounts.get(0); // one account per customer in this GUI

        // --- Fill ALL customer fields from the existing object ---
        txtCustomerId.setText(cust.getCustomerId());
        txtSSN.setText(cust.getSsn());
        txtLastName.setText(cust.getLastName());
        txtFirstName.setText(cust.getFirstName());
        txtStreet.setText(cust.getStreet());
        txtCity.setText(cust.getCity());
        cboState.setSelectedItem(cust.getState());
        txtZip.setText(cust.getZip());
        txtPhone.setText(cust.getPhone());

        // --- Fill account fields ---
        txtAccountNumber.setText(acct.getAccountNumber());
        if ("CHK".equals(acct.getAccountType())) {
            rdoChecking.setSelected(true);
        } else {
            rdoSavings.setSelected(true);
        }

        // --- Update result labels too ---
        lblResCustomerId.setText("Customer ID: " + cust.getCustomerId());
        lblResAccountNumber.setText("Account Number: " + acct.getAccountNumber());
        lblResAccountType.setText("Account Type: " + acct.getAccountType());
        lblResBalance.setText(String.format("Balance: $%.2f", acct.balance()));

        updateStatus("Customer and account data displayed.", false);
    }

    // 3) Perform Transaction (uses the Transaction Customer ID field)
    private void handlePerformTransaction() {
        try {
            String customerId = txtTransCustomerId.getText().trim();
            // Customer ID required (5 digits) for transaction
            if (!DataEntry.checkNonBlankString(customerId) ||
                customerId.length() != 5 ||
                !DataEntry.checkNumericString(customerId)) {
                throw new IllegalArgumentException("Transaction Customer ID must be exactly 5 numeric digits.");
            }

            Customer cust = customers.get(customerId);
            if (cust == null) {
                throw new IllegalArgumentException("No customer found for ID: " + customerId);
            }

            List<Account> accounts = cust.getAccounts();
            if (accounts.isEmpty()) {
                throw new IllegalArgumentException("Customer has no accounts for transactions.");
            }

            Account acct = accounts.get(0);

            // Validate date (YYYY-MM-DD) – matches DataEntry.checkDate
            String date = txtTransactionDate.getText().trim();
            DataEntry.checkDate(date);

            // Validate amount
            String amountStr = txtTransactionAmount.getText().trim();
            if (!DataEntry.checkNonBlankString(amountStr)) {
                throw new IllegalArgumentException("Transaction amount is required.");
            }

            double amount;
            try {
                amount = Double.parseDouble(amountStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Transaction amount must be numeric.");
            }
            DataEntry.checkAmount(amount);

            // Transaction type: DEP or WTH
            String transType = rdoDeposit.isSelected() ? "DEP" : "WTH";
            DataEntry.checkType(transType);

            // Store transaction fields on the underlying account (for completeness)
            if (acct instanceof CheckingAccount) {
                CheckingAccount ca = (CheckingAccount) acct;
                ca.setTransactionDate(date);
                ca.setTransactionType(transType);
                ca.setTransactionAmount(amount);
            } else if (acct instanceof SavingsAccount) {
                SavingsAccount sa = (SavingsAccount) acct;
                sa.setTransactionDate(date);
                sa.setTransactionType(transType);
                sa.setTransactionAmount(amount);
            }

            double before = acct.balance();
            double after;
            double fees;

            if ("DEP".equals(transType)) {
                // Deposit: use existing deposit logic in Account subclass
                acct.deposit(amount);
                after = acct.balance();
                // Fees = (before + amount) - after  (covers service fee)
                fees = (before + amount) - after;
            } else {
                // Withdrawal: use existing withdrawal logic in Account subclass
                acct.withdrawal(amount);
                after = acct.balance();
                // Fees = before - amount - after  (covers service + overdraft if any)
                fees = (before - amount) - after;
            }

            // Update labels with all required info
            lblResCustomerId.setText("Customer ID: " + cust.getCustomerId());
            lblResAccountNumber.setText("Account Number: " + acct.getAccountNumber());
            lblResAccountType.setText("Account Type: " + acct.getAccountType());
            lblResTransactionDate.setText("Transaction Date: " + date);
            lblResTransactionType.setText("Transaction Type: " + ("DEP".equals(transType) ? "Deposit" : "Withdrawal"));
            lblResTransactionAmount.setText(String.format("Transaction Amount: $%.2f", amount));
            lblResFees.setText(String.format("Fees/Charges: $%.2f", fees));
            lblResBalance.setText(String.format("Balance: $%.2f", after));

            updateStatus("Transaction completed successfully.", false);

        } catch (IllegalArgumentException ex) {
            updateStatus("Transaction error: " + ex.getMessage(), true);
        }
    }

    // 4) Apply Interest (for steps 5 and 10)
    private void handleApplyInterest() {
        try {
            // Use the SAME Customer ID field as for normal transactions
            String customerId = txtTransCustomerId.getText().trim();

            // Customer ID: 5 digits
            if (!DataEntry.checkNonBlankString(customerId) ||
                customerId.length() != 5 ||
                !DataEntry.checkNumericString(customerId)) {
                throw new IllegalArgumentException("Transaction Customer ID must be exactly 5 numeric digits.");
            }

            Customer cust = customers.get(customerId);
            if (cust == null) {
                throw new IllegalArgumentException("No customer found for ID: " + customerId);
            }

            List<Account> accounts = cust.getAccounts();
            if (accounts.isEmpty()) {
                throw new IllegalArgumentException("Customer has no accounts for interest.");
            }

            Account acct = accounts.get(0);  // one account per customer in this GUI

            String date = txtTransactionDate.getText().trim();
            DataEntry.checkDate(date);   // uses existing yyyy-mm-dd validation

            double beforeBalance = acct.balance();

            // THIS is the key: call the existing interest logic
            double interestAmount = acct.applyInterest();  // method already in Account

            double afterBalance = acct.balance();
            double fees = 0.0;

            // store transaction info on the account
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

            // Update labels to show the interest "transaction"
            lblResCustomerId.setText("Customer ID: " + cust.getCustomerId());
            lblResAccountNumber.setText("Account Number: " + acct.getAccountNumber());
            lblResAccountType.setText("Account Type: " + acct.getAccountType());
            lblResTransactionDate.setText("Transaction Date: " + date);
            lblResTransactionType.setText("Transaction Type: Interest");
            lblResTransactionAmount.setText(String.format("Transaction Amount: $%.2f", interestAmount));
            lblResFees.setText(String.format("Fees/Charges: $%.2f", fees));
            lblResBalance.setText(String.format("Balance: $%.2f", afterBalance));

            updateStatus("Interest applied successfully.", false);

        } catch (IllegalArgumentException ex) {
            updateStatus("Interest error: " + ex.getMessage(), true);
        }
    }
}
