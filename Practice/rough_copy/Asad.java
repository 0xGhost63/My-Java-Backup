import java.util.Scanner;

class GasConnection 
{
    String connectionID;
    double consumedUnits;


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


    GasConnection()
    {

    }
    GasConnection(String connectionID, double consumedUnits) 
    {
        setConnectionID(connectionID);
        setConsumedUnits(consumedUnits);
    }


    public void showUsage() 
    {
        System.out.println("Connection ID: " + connectionID);
        System.out.println("Water Units Used: " + consumedUnits);
    }
}

class ResidentialConnection extends GasConnection 
{
    double resTax;
    double totalBill;
    final int residentialTaxRate=20;

    public void setResTax(double resTax) 
    {
        this.resTax = resTax;
    }

    public double getResTax() 
    {
        return resTax;
    }

    ResidentialConnection()
    {
        super();
    }

    ResidentialConnection(String connectionID, double consumedUnits, double resTax) 
    {
        super(connectionID,consumedUnits);
        setResTax(resTax);
        
    }


    public double calculateBill() 
    {
        totalBill = (consumedUnits*residentialTaxRate) + resTax;
        return totalBill;
    }

    public void payBill(double amount) 
    {
        System.out.println("Rs. " + amount + " paid.");
        if (amount < totalBill) {
            System.out.println("Remaining Balance: Rs. " + (totalBill - amount));
        } else {
            System.out.println("Bill fully paid. Thank you!");
        }
    }

    void showData(double amount)
    {
        System.out.println("--------Residential Connection--------");
        System.out.println("Connection ID : "+getConnectionID());
        System.out.println("Gas Units Used : "+getConsumedUnits());
        System.out.println("Residential Tax : "+getResTax());
        System.out.println("Total Bill : "+calculateBill());
        payBill(amount);
    }
}

class CommercialConnection extends GasConnection
{
    double comTax;
    double totalBill;
    final int commercialTaxRate=35;

    public void setComTax(double comTax) {
        this.comTax = comTax;
    }

    public double getComTax() {
        return comTax;
    }

    CommercialConnection()
    {
        super();
    }

    CommercialConnection(String connectionID, double consumedUnits, double comTax) 
    {
        super(connectionID,consumedUnits);
        setComTax(comTax);
        
    }


    public double calculateBill() 
    {
        totalBill = (consumedUnits*commercialTaxRate) +comTax;
        return totalBill;
    }

    public void payBill(double amount) 
    {
        System.out.println("Rs. " + amount + " paid.");
        if (amount < totalBill) {
            System.out.println("Remaining Balance: Rs. " + (totalBill - amount));
        } else {
            System.out.println("Bill fully paid. Thank you!");
        }
    }

    void showData(double amount)
    {
        System.out.println("--------Commercial Connection--------");
        System.out.println("Connection ID : "+getConnectionID());
        System.out.println("Gas Units Used : "+getConsumedUnits());
        System.out.println("Commercial Tax : "+getComTax());
        System.out.println("Total Bill : "+calculateBill());
        payBill(amount);
    }

}

public class Asad {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        //Through Input
        String consumerId;
        double consumedUnits;
        double resTax;
        double amount;


        System.out.print("Enter the consumer ID : ");
        consumerId=sc.nextLine();
        System.out.print("Enter the consumed units : ");
        consumedUnits=sc.nextDouble();
        System.out.print("Enter the residential tax : ");
        resTax=sc.nextDouble();
        System.out.print("Enter the amount of bill that you want to pay : ");
        amount=sc.nextDouble();

        ResidentialConnection r2 = new ResidentialConnection(consumerId, consumedUnits, resTax);
        r2.showData(amount);
        System.out.println();

        // Through Initialization
        ResidentialConnection r1 = new ResidentialConnection("R-101", 120, 2000);
        r1.showData(3000);
        System.out.println();

        // Through getter setters
        String consumerId3="Asad-420";
        double consumedUnits3=420;
        double resTax3=2000;
        double amount3=5000;

        ResidentialConnection r3 = new ResidentialConnection();
        r3.setConnectionID(consumerId3);
        r3.setConsumedUnits(consumedUnits3);
        r3.setResTax(resTax3);
        r3.showData(amount3);
        System.out.println();

        //COMMERCIAL CONNECTIONS 

        //Through Input
        String comConsumerId;
        double comConsumedUnits;
        double comTax;
        double comAmount;


        
        System.out.print("Enter the consumer ID : ");
        sc.next();
        comConsumerId=sc.nextLine();
        System.out.print("Enter the consumed units : ");
        comConsumedUnits=sc.nextDouble();
        System.out.print("Enter the residential tax : ");
        comTax=sc.nextDouble();
        System.out.print("Enter the amount of bill that you want to pay : ");
        comAmount=sc.nextDouble();

        CommercialConnection c2 = new CommercialConnection(comConsumerId,comConsumedUnits,comTax);
        c2.showData(comAmount);

        // Through Initialization
        CommercialConnection c1 = new CommercialConnection("R-101", 120, 2000);
        c1.showData(3000);
        System.out.println();

        // Through getter setters
        String consumerId1="Asad-420";
        double consumedUnits1=420;
        double comTax1=2000;
        double amount1=5000;

        CommercialConnection c3 = new CommercialConnection();
        c3.setConnectionID(consumerId1);
        c3.setConsumedUnits(consumedUnits1);
        c3.setComTax(comTax1);
        c3.showData(amount1);


 
    }
}