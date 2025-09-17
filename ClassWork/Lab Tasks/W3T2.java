class Account
{
    int accountNumber;      //Account Number
    String accountHolder;   //Name of the holder
    double balance;         //Account Balance
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
            System.out.println("Invalid amount ! The withdraw amount can't be less than the Balance of the account");
            System.out.println("Or lower balance than 1000 remains after the withdrawl ERROR ");
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
        System.out.print("===AFTER THE TRANSCATION===\n");
        System.out.print("Account Number : "+accountNumber);
        System.out.print(",\tAccount Holder : "+accountHolder);
        System.out.printf("\tBalance : %.2f%s ",balance,"PKR");
    
        
    }

}
public class W3T2
{

    public static void main(String[] args)
    {
        Account A1= new Account(101,"Ali",1000);
        Account A2=new Account(102,"Shahroz",5000);
        Account A3=new Account(103,"Khan",2000);

        A1.withDraw(1000);//withdrawl
        A1.displayData();//after transcation printing...
        System.out.print("After Withdrawl of 1000 PKR");
        if(A1.withDraw(1000)!=0)
        {
            System.out.print(""+A1.withDraw(1000));
        }
        else
        {
            System.out.print(""+A1.withDraw(1000));
        }

        //DEPOSIT
        A2.displayData();
        System.out.print("Balance after the Deposit is :"+A2.deposit(2000));

        //Normal 
        A3.displayData();
        //Number of the accounts created are :
        Account.displayAccounts();

    }
}
