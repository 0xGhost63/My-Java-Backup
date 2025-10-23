class WaterConnection {
    protected String connectionID;
    protected double consumedUnits;

    public WaterConnection(String connectionID, double consumedUnits) {
        this.connectionID = connectionID;
        this.consumedUnits = consumedUnits;
    }

    public void setConnectionID(String connectionID) {
        this.connectionID = connectionID;
    }

    public String getConnectionID() {
        return connectionID;
    }

    public void setConsumedUnits(double consumedUnits) {
        this.consumedUnits = consumedUnits;
    }

    public double getConsumedUnits() {
        return consumedUnits;
    }

    public void showUsage() {
        System.out.println("Connection ID: " + connectionID);
        System.out.println("Water Units Used: " + consumedUnits);
    }
}

class ResidentialConnection extends WaterConnection {
    private double resTax;
    private double totalBill;

    public ResidentialConnection(String connectionID, double consumedUnits, double resTax) {
        super(connectionID, consumedUnits);
        this.resTax = resTax;
    }

    public double calculateBill() {
        totalBill = (consumedUnits * 25) + resTax;
        return totalBill;
    }

    public void payBill(double amount) {
        System.out.println("Rs. " + amount + " paid.");
        if (amount < totalBill) {
            System.out.println("Remaining Balance: Rs. " + (totalBill - amount));
        } else {
            System.out.println("Bill fully paid. Thank you!");
        }
    }
}

class CommercialConnection extends WaterConnection {
    private double comTax;
    private double totalBill;

    public CommercialConnection(String connectionID, double consumedUnits, double comTax) {
        super(connectionID, consumedUnits);
        this.comTax = comTax;
    }

    public double calculateBill() {
        totalBill = (consumedUnits * 40) + comTax;
        return totalBill;
    }

    public void payBill(double amount) {
        System.out.println("Rs. " + amount + " paid.");
        if (amount < totalBill) {
            System.out.println("Remaining Balance: Rs. " + (totalBill - amount));
        } else {
            System.out.println("Bill fully paid. Thank you!");
        }
    }
}

public class Asad {
    public static void main(String[] args) {
        System.out.println("---- Residential Connection ----");
        ResidentialConnection rc = new ResidentialConnection("R-101", 120, 2000);
        rc.showUsage();
        System.out.println("Residential Tax = Rs. 2000.0");
        System.out.println("Total Bill: Rs. " + rc.calculateBill());
        rc.payBill(3000);

        System.out.println();

        System.out.println("---- Commercial Connection ----");
        CommercialConnection cc = new CommercialConnection("C-205", 250, 5000);
        cc.showUsage();
        System.out.println("Commercial Tax = Rs. 5000.0");
        System.out.println("Total Bill: Rs. " + cc.calculateBill());
        cc.payBill(15000);
    }
}