import java.util.Scanner;

class WaterConnecton
{
    String connectionID;
    double consumedUnits;

    WaterConnecton()
    {

    }
    WaterConnecton(String connectionID,double consumedUnits)
    {
        this.connectionID=connectionID;
        this.consumedUnits=consumedUnits;
    }


    // change data type as needed
    void showUsage()
    {
        System.out.println("Water Units Used : "+this.consumedUnits);
    }


}

class ResidentialConnection extends  WaterConnecton {
    double resTax;
    final int residentialTaxRate = 25;

    //Will be setted through setters and getters
    ResidentialConnection()
    {
        super();
        this.resTax=2000;
    }

    ResidentialConnection(String connectionID, double consumedUnits)
    {
        super(connectionID, consumedUnits);
        this.resTax=2000;

    }

    //Method to calculate the bill
    double calculateBill()
    {
        double bill = (this.consumedUnits *this.residentialTaxRate) + this.resTax;
        return bill;
    }

    void payBill(double amount) {
        double cashReturn;
        double bill = this.calculateBill();

        cashReturn = bill - amount;
        if (cashReturn > 0)
        {
            System.out.printf("Rs. %.2f PKR paid\n",this.calculateBill());
            System.out.println("Remaining Balance "+cashReturn);

        }

        else
        {
            System.out.println("Bill fully paid");
        }
    }


    public double getResTax()
    {
        return resTax;
    }

    //ID
    public void setConnectionID(String connectionID) {
        this.connectionID = connectionID;
    }

    public String getConnectionID() {
        return connectionID;
    }

    //Units
    public void setConsumedUnits(double consumedUnits) {
        this.consumedUnits = consumedUnits;
    }

    public double getConsumedUnits() {
        return consumedUnits;
    }

    void showData(double amount)
    {
        System.out.println("=== Residential Connection ===");
        System.out.printf("Connection ID : %s\n",getConnectionID());
        System.out.printf("Water Units Used : %.2f\n",getConsumedUnits());
        System.out.printf("Residential Tax : %.2f\n",getResTax());
        System.out.printf("Total Bill : %.2f\n",calculateBill());
        payBill(amount);


    }


}
class CommercialConnection extends WaterConnecton {
    double comTax;
    double commercalRate = 40;

    CommercialConnection() {
        super();
        this.comTax = 2000;
    }


    CommercialConnection(String connectionID, double consumedUnits) {
        super(connectionID, consumedUnits);
        this.comTax = 2000;
    }


    double calculateBill() {
        double bill = (this.consumedUnits * this.commercalRate) + this.comTax;
        return bill;
    }


    double payBill(double amount)
    {
        double cashReturn;
        double bill = calculateBill();

        cashReturn = bill - amount;
        if (cashReturn < 0) {
            return 0;
        } else {
            return cashReturn;
        }
    }

    //Com tax getter
    public double getComTax() {
        return this.comTax;
    }


    //ID
    public void setConnectionID(String connectionID)
    {
        this.connectionID = connectionID;
    }

    public String getConnectionID() {
        return connectionID;
    }

    //Units
    public void setConsumedUnits(double consumedUnits) {
        this.consumedUnits = consumedUnits;
    }

    public double getConsumedUnits() {
        return consumedUnits;
    }

    void showData(double amount)
    {
        System.out.println("=== Residential Connection ===");
        System.out.printf("Connection ID : %s\n",getConnectionID());
        System.out.printf("Water Units Used : %.2f\n",getConsumedUnits());
        System.out.printf("Residential Tax : %.2f\n",getComTax());
        System.out.printf("Total Bill : %.2f\n",calculateBill());
        payBill(amount);


    }




}

public class Sannan
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");

        //Scanner object cretion
        Scanner sc = new Scanner (System.in);
        //Residetial Input


        //Input for the residential
        String connectionID=null;
        double consumedUnits=0;
        double amount=0;

        System.out.print("Enter the Connection ID : ");
        connectionID=sc.nextLine();
        System.out.print("Enter the Consumed Units : ");
        consumedUnits=sc.nextDouble();

        ResidentialConnection r1 = new ResidentialConnection(connectionID,consumedUnits);
        r1.showData(5000);

        // Initialization

        ResidentialConnection r2 = new ResidentialConnection("R-63",56.8);
        r2.showData(5000);

        //Getters Setters

        ResidentialConnection r3 = new ResidentialConnection();
        r3.setConnectionID("R-53");
        r3.setConsumedUnits(56.8);
        r3.showData(4000);




    }
}