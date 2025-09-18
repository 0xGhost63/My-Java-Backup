//DONE
class Account
{
    // Attributes

    int accountNumber; 
    String accountHolder;
    double balance;

    //Counter that increases upon the creation of the account
    static int accountCounter;
    
    //Constructor

    Account(int accountNumber,String accountHolder,double balance)// Constructor
    {
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
        accountCounter++;
    }

    // Methods :

    double deposit (double amount)
    {
        this.balance+=amount;
        return balance;
    }

    double withDraw(double amount)
    {
        if (amount > (this.balance-1000))
        {
            System.out.println("Invalid withdrawal! Amount exceeds balance limit or leaves less than 1000 PKR in the account.");
            return 0;
        }
        else
        {
            this.balance-=amount;
            return this.balance;
        }
    }

    static void displayAccounts()
    {
        System.out.println("The total number of accounts created are : "+ accountCounter);
    }

    void displayData()
    {
        System.out.print("Account Number : "+accountNumber);
        System.out.print(",\tAccount Holder : "+accountHolder);
        System.out.printf("\tBalance : %.2f%s",balance,"PKR\n");
    }
}

public class W3T2
{
    public static void main(String[] args)
    {
        Account A1= new Account(101,"Ali",10000);
        Account A2=new Account(102,"Shahroz",5000);
        Account A3=new Account(103,"Khan",1000);

        // WITHDRAW
        System.out.println("\n===WITHDRAWL OUTPUT===");
        A1.displayData();
        System.out.println("After withdrawing 2,000 PKR : ");
        A1.withDraw(2000);
        A1.displayData(); // after transaction


        // DEPOSIT
        System.out.println("\n===DEPOSIT OUTPUT===");
        A2.displayData();
        A2.deposit(1000);
        System.out.println("After depositing 1,0000 PKR");
        A2.displayData();

        // FAILED TRANSACTION
        System.out.println("\n===FAILED WITHDRAW OUTPUT===");
        A3.displayData();
        System.out.println("After withdrawal attempt : ");

        //Stored the return value in a variable to avoid double calling and Printing
        double withdrawResult = A3.withDraw(500);

        if (withdrawResult != 0)
        {
            System.out.println("The balance after withdrawl is : " + withdrawResult);
        }
        A3.displayData();

        // Number of accounts
        Account.displayAccounts();
    }
}
