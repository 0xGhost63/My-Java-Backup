import java.util.Scanner;
class GasConnection {
    String connectionID;
    double consumedUnits;

    void showUsage() {
        System.out.println("Units Consumed this month : " + consumedUnits);
    }
}

class ResidentialConnection extends GasConnection {
    double resTax;
    double bill;

    ResidentialConnection(String connectionID, double consumedUnits, int resTax) {
        System.out.println("==== Residential Connection ====");
        this.connectionID = connectionID;
        this.consumedUnits = consumedUnits;
        this.resTax = resTax;
    }

    double calculateBill() {
        bill = consumedUnits * 20 + resTax;
        System.out.println("Your Total bill is : " + bill);
        return bill;
    }

    void payBill(int amount) {
        if (amount > bill) {
            System.out.println("You entered amount greater than Bill. Paying amount should be less than bill");
        }
        if (amount < bill) {
            bill -= amount;
            System.out.println("Rs " + amount + " Paid");
            System.out.println("Remaining Amount of Bill :" + bill);
        }
        if (amount == bill) {
            System.out.println("Amount fully paid ThankYou");
        }
    }

    public String getConnectionID() {
        return connectionID;
    }
    public void setConnectionID(String connectionID) {
        this.connectionID = connectionID;
    }

    public double getConsumedUnits() {
        return consumedUnits;
    }
    public void setconsumedUnits(double consumedUnits) {
        this.consumedUnits = consumedUnits;
    }

    public double getresTax() {
        return resTax;
    }
    public void setResTax(double resTax) {
        this.resTax = resTax;
    }

    void showData(int amount) {
        System.out.println("Your Connection ID is : " + getConnectionID());
        System.out.println("Your Consumed Units are : " + getConsumedUnits());
        System.out.println("Your Residental Tax is " + getresTax());
        System.out.println("Your Total Bill is " + calculateBill());
        payBill(amount);
    }
}

class CommercialConnection extends GasConnection {
    int comTax;
    double amount1;
    double bill;

    CommercialConnection(String connectionID, double consumedUnits, int comTax) {
        System.out.println("==== Commercail Connection ====");
        this.connectionID = connectionID;
        this.consumedUnits = consumedUnits;
        this.comTax = comTax;
    }

    double calculateBill() {
        bill = consumedUnits * 35 + comTax;
        System.out.println("Bill is :" + bill);
        return bill;
    }

    public void payBill(int amount1) {
        if (amount1 > bill) {
            System.out.println("You entered amount greater than Bill. Paying amount should be less than bill");
        }
        if (amount1 < bill) {
            bill -= amount1;
            System.out.println("Rs " + amount1 + " Paid");
            System.out.println("Remaining Amount of Bill :" + bill);
        }
        if (amount1 == bill) {
            System.out.println("Amount fully paid ThankYou");
        }
    }

    public String getConnectionID() {
        return connectionID;
    }
    public void setConnectionID(String connectionID) {
        this.connectionID = connectionID;
    }

    public double getConsumedUnits() {
        return consumedUnits;
    }
    public void setconsumedUnits(double consumedUnits) {
        this.consumedUnits = consumedUnits;
    }

    public double getcomTax() {
        return comTax;
    }
    public void setComTax(int comTax) {
        this.comTax = comTax;
    }

    void showData(int amount) {
        System.out.println("Your Connection ID is : " + getConnectionID());
        System.out.println("Your Consumed Units are : " + getConsumedUnits());
        System.out.println("Your Residental Tax is " + getcomTax());
        System.out.println("Your Total Bill is " + calculateBill());
        payBill(amount);
    }
}

public class Sumama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ResidentialConnection r1 = new ResidentialConnection("R-121", 120, 1000);
        r1.showUsage();
        r1.calculateBill();
        System.out.println("Enter Amount you want to pay :");
        int paidAmount = input.nextInt();
        r1.payBill(paidAmount);

        CommercialConnection c1 = new CommercialConnection("C-242", 320, 6000);
        c1.showUsage();
        c1.calculateBill();
        System.out.println("Enter Amount you want to pay :");
        int paidAmount1 = input.nextInt();
        c1.payBill(paidAmount1);

        System.out.println("\n\n");
        System.out.println("Input of Commercial Connection");
        System.out.println("\n\n");
        System.out.println("Enter Your ID ");
        c1.connectionID = input.next();
        System.out.println("Enter Your Consumed Units :");
        c1.consumedUnits = input.nextDouble();
        c1.comTax = 3000;
        c1.showUsage();
        c1.calculateBill();
        System.out.println("Enter Amount you want to pay ");
        int payment = input.nextInt();
        c1.payBill(payment);

        System.out.println("\n\n");
        System.out.println("Input of Residential Connection");
        System.out.println("\n\n");
        System.out.println("Enter Your ID ");
        r1.connectionID = input.next();
        System.out.println("Enter Your Consumed Units :");
        r1.consumedUnits = input.nextDouble();
        r1.resTax = 3000;
        r1.showUsage();
        r1.calculateBill();
        System.out.println("Enter Amount you want to pay ");
        int payment1 = input.nextInt();
        r1.payBill(payment);

        System.out.println("\n\n");
        System.out.println("Getter and setter of Residential Connection ");
        System.out.println("Enter Amount you want to pay ");
        int payment2 = input.nextInt();
        r1.showData(payment1);

        System.out.println("\n\n");
        System.out.println("Getter and setter of Commercial Connection ");
        System.out.println("Enter Amount you want to pay ");
        int payment3 = input.nextInt();
        System.out.println(payment1);
        c1.showData(payment3);
    }
}
