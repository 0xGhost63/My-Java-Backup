public class Date 
{

    private int day;
    private int month;
    private int year;

    // Default constructor
    public Date() {
        this(1, 1, 1970);
    }

    // Constructor with only day
    public Date(int day) {
        this(day, 0, 0);
    }

    // Constructor with day and month
    public Date(int day, int month) {
        this(day, month, 0);
    }

    // Constructor with all fields
    public Date(int day, int month, int year) {
        setDate(day, month, year);
    }

    // Copy constructor
    public Date(Date other) {
        this(other.day, other.month, other.year);
    }

    // Method to set the entire date
    public void setDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    // Day validation
    public void setDay(int day) {
        if (day < 1 || day > 28) {
            throw new IllegalArgumentException("Day must be between 1 and 28.");
        } else {
            this.day = day;
        }
    }

    // Month validation
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        } else {
            this.month = month;
        }
    }

    // Year validation
    public void setYear(int year) {
        if (year < 1970 || year > 2021) {
            throw new IllegalArgumentException("Year must be between 1970 and 2021.");
        } else {
            this.year = year;
        }
    }

    // Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return monthpublic class Date {
    
}
;
    }

    public int getYear() {
        return year;
    }

    // Display formatted date
    public String toDisplay() {
        return String.format("%02d:%02d:%02d", getDay(), getMonth(), getYear());
    }

    public static void main(String[] args) {

        try {
            Date validDate = new Date(15, 5, 2020);
            System.out.println("Valid Date: " + validDate.toDisplay());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught for valid date: " + e.getMessage());
        }

        try {
            Date invalidDate = new Date(30, 13, 2025);
            System.out.println("Invalid Date: " + invalidDate.toDisplay());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught for invalid date: " + e.getMessage());
        }
    }
}
