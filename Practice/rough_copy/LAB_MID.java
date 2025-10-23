import java.util.Scanner;

class WaterConnection {
    // --- Instance variables
    protected String connectionID; 
    protected double consumedUnits;

    // --- Constructor for water connection
    WaterConnection(String id, double units) {
        connectionID = id;
        consumedUnits = units;
    }
    // ---  method to display current month unit usage
    void showUsage() {
        System.out.println("Connection ID: " + connectionID);
        System.out.println("Water Units Used: " + consumedUnits);
    }
}

// ===== Residential Connection ===== //
class ResidentialConnection extends WaterConnection {
    double resTax;

    ResidentialConnection(String id, double units, double tax) {
        super(id, units);
        resTax = tax;
    }

    double calculateBill() {
        return (consumedUnits * 25) + resTax;
    }

    // --- payiny Bill Logic for residential connection
    void payBill(double amount) {
        double total = calculateBill();
        double remaining = total - amount;

        if (remaining > 0)
            System.out.println("Remaining Balance: Rs. " + remaining);
        else
            System.out.println("Bill fully paid. Thank you!");
    }
}

// ===== Commercial Connection ===== //
class CommercialConnection extends WaterConnection {
    double comTax;

    CommercialConnection(String id, double units, double tax) {
        super(id, units);
        comTax = tax;
    }

    double calculateBill() {
        return (consumedUnits * 40) + comTax;
    }

    // --- paying bill Logic for Commercial Connection
    void payBill(double amount) {
        double total = calculateBill();
        double remaining = total - amount;

        if (remaining > 0)
            System.out.println("Remaining Balance: Rs. " + remaining);
        else
            System.out.println("Bill fully paid. Thank you!");
    }
}

// ==== main class ==== //
public class LAB_MID {
    public static void main(String[] args) {

        // ---- First output (given values) ---- //
        // --- residential connection given values
        ResidentialConnection r = new ResidentialConnection("R-101", 120, 2000);
        System.out.println("=== Residential Connection ===");
        r.showUsage();
        System.out.println("Residential Tax: Rs. " + r.resTax);
        System.out.println("Total Bill: Rs. " + r.calculateBill());
        System.out.println("Rs. 3000.0 paid.");
        r.payBill(3000);

        System.out.println();

        // --- commercial connection given values
        CommercialConnection c = new CommercialConnection("C-205", 250, 5000);
        System.out.println("=== Commercial Connection ===");
        c.showUsage();
        System.out.println("Commercial Tax: Rs. " + c.comTax);
        System.out.println("Total Bill: Rs. " + c.calculateBill());
        System.out.println("Rs. 15000.0 paid.");
        c.payBill(15000);

        // ---- Second output (Updates Values)
        System.out.println("\n---- User Input Section ----");
        Scanner sc = new Scanner(System.in);

        //---Residential connection updated values
        System.out.print("Enter Residential Connection ID: ");
        String rID = sc.nextLine();
        System.out.print("Enter Units Used: ");
        double rUnits = sc.nextDouble();
        System.out.print("Enter Residential Tax: ");
        double rTax = sc.nextDouble();

        ResidentialConnection r2 = new ResidentialConnection(rID, rUnits, rTax);
        System.out.println("Total Bill: Rs. " + r2.calculateBill());
        System.out.print("Enter Amount Paid: ");
        double rPaid = sc.nextDouble();
        r2.payBill(rPaid);

        System.out.println();

        // --- commercial connection updates values
        System.out.print("Enter Commercial Connection ID: ");
        String cID = sc.next();
        System.out.print("Enter Units Used: ");
        double cUnits = sc.nextDouble();
        System.out.print("Enter Commercial Tax: ");
        double cTax = sc.nextDouble();

        CommercialConnection c2 = new CommercialConnection(cID, cUnits, cTax);
        System.out.println("Total Bill: Rs. " + c2.calculateBill());
        System.out.print("Enter Amount Paid: ");
        double cPaid = sc.nextDouble();
        c2.payBill(cPaid);

        sc.close();
    }
}