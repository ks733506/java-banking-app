package courseProject;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    // Instance variables
    private String customerId;
    private String ssn;
    private String lastName;
    private String firstName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    // Account list
    private final List<Account> accounts;

    // Customer Constructor
    public Customer(String customerId, String ssn, String lastName, String firstName,
                    String street, String city, String state, String zip, String phone) {
        this.customerId = customerId;
        this.ssn = ssn;
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.accounts = new ArrayList<>(); // initialize account list
    }

    // Add an account to this customer (null-check)
    public void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }
        accounts.add(account);
    }

    // Get all accounts
    public List<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }

    // Getters and setters for customer fields
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getSsn() { return ssn; }
    public void setSsn(String ssn) { this.ssn = ssn; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return String.format("Customer ID: %s, SSN: %s, Last Name: %s, First Name: %s, Street: %s, City: %s, State: %s, Zip: %s, Phone: %s, Accounts: %d",
                customerId, ssn, lastName, firstName, street, city, state, zip, phone, accounts.size());
    }
}
