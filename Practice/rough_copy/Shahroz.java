import java.util.Scanner;

class WaterConnection {
String connectionID;
double consumedUnits;

WaterConnection(String connectionID, double consumedUnits) {
this.connectionID = connectionID;
this.consumedUnits = consumedUnits;
}
void showUsage() {
System.out.println("Water Units Consumed: " + consumedUnits);
}

// Getters
String getConnectionID() {
return connectionID;

}

double getConsumedUnits() {
return consumedUnits;
}

// Setters
void setConnectionID(String connectionID) {
this.connectionID = connectionID;
}

void setConsumedUnits(double units) {
this.consumedUnits = units;
}
}
class ResidentialConnection extends WaterConnection {
double bill;
double remainingBalance;
final double tax = 2000;
double paidAmount;

// Constructor
ResidentialConnection(String connectionID, double consumedUnits) {
super(connectionID, consumedUnits);
}

// Calculate total bill
void calculateBill() {
bill = consumedUnits * 25 + tax;
}

// Handle payment and print summary
void finalBill() {
Scanner sc = new Scanner(System.in);
System.out.print("Enter the amount you have paid: ");
paidAmount = sc.nextDouble();

remainingBalance = bill - paidAmount;

System.out.println("Connection ID : " + connectionID);
System.out.println("Units Consumed : " + consumedUnits);
System.out.println("Tax Applied : Rs " + tax);
System.out.println("Total Bill : Rs " + bill);
System.out.println("Amount Paid : Rs " + paidAmount);
System.out.println("Remaining Balance : Rs " + remainingBalance);

}
}

// Main class
public class Shahroz {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Connection ID: ");
String ID = sc.nextLine();

System.out.print("Enter units consumed: ");
double units = sc.nextDouble();

// Create ResidentialConnection object
ResidentialConnection r1 = new ResidentialConnection(ID, units);

System.out.println("\nConnection ID: " + r1.getConnectionID());
r1.showUsage();
r1.calculateBill();
r1.finalBill();
}
}