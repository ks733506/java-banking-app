package courseProject;

public class DataEntry {

    // Validation of max string length
    public static boolean checkMaxStringLen(String value, int maxLength) {
        if (value == null) return false;
        return value.trim().length() <= maxLength;
    }

    // Validation of string data with no limit
    public static boolean checkNonBlankString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // Validation of string data that must only have numeric values (digits only)
    public static boolean checkNumericString(String value) {
        if (value == null) return false;
        String s = value.trim();
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Validation of entry of integer data
    public static boolean checkInteger(String value) {
        if (value == null) return false;
        try {
            Integer.parseInt(value.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validation of integer data with a range limit
    public static boolean checkIntegerInRange(String value, int min, int max) {
        if (value == null) return false;
        try {
            int num = Integer.parseInt(value.trim());
            return num >= min && num <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validation of entry of decimal data
    public static boolean checkDecimal(String value) {
        if (value == null) return false;
        try {
            Double.parseDouble(value.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validation of entry of decimal data with a range limit
    public static boolean checkDecimalInRange(String value, double min, double max) {
        if (value == null) return false;
        try {
            double num = Double.parseDouble(value.trim());
            return num >= min && num <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // phase 3 data validation methods
    
    // Validate account number: 1–5 characters
    public static void checkAccountNumber(String acctNum) {
        if (acctNum == null || acctNum.trim().isEmpty() || acctNum.length() > 5) {
            throw new IllegalArgumentException("Account number must be 1–5 characters.");
        }
    }

    public static void checkDate(String date) {
        if (date == null || !date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Date must be in yyyy-mm-dd format.");
        }
    }

    // Validate transaction type: must be DEP or WTH
    public static void checkType(String type) {
        if (type == null || !(type.equals("DEP") || type.equals("WTH"))) {
            throw new IllegalArgumentException("Transaction type must be DEP or WTH.");
        }
    }

    // Validate amount: must be positive
    public static void checkAmount(double amt) {
        if (amt <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
    }
}
