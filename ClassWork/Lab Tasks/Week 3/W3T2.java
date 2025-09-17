class Account
{
    int accountNumber; //Account Number
    String accountHolder;//Name of the holder
    double balance;//Account Balance
    static int accountCounter;//Counter that increases upon the creation of the account
    
    Account(int accountNumber,String accountHolder,double balance)// Constructor
    {
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
        accountCounter++;
    }

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
        System.out.print("\n===AFTER THE TRANSCATION===\n");
        System.out.print("Account Number : "+accountNumber);
        System.out.print(",\tAccount Holder : "+accountHolder);
        System.out.printf("\tBalance : %.2f%s ",balance,"PKR\n");
    }
}

public class W3T2
{
    public static void main(String[] args)
    {
        Account A1= new Account(101,"Ali",1000);
        Account A2=new Account(102,"Shahroz",5000);
        Account A3=new Account(103,"Khan",2000);

        // WITHDRAW
        double result1 = A1.withDraw(1000);  // single call
        A1.displayData(); // after transaction
        if(result1 != 0)
        {
            System.out.println("After Withdrawl of 1000 PKR : " + result1);
        }
        else
        {
            System.out.println("After Withdrawl of 1000 PKR : Transaction Failed!");
        }

        // DEPOSIT
        A2.displayData();
        double result2 = A2.deposit(2000);
        System.out.println("Balance after the Deposit is : " + result2);

        // NORMAL
        A3.displayData();

        // Number of accounts
        Account.displayAccounts();
    }
}
