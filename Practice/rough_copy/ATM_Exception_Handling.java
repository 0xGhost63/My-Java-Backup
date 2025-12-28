import java.util.InputMismatchException;
import java.util.Scanner;
class LowBalanceException extends Exception
{
    LowBalanceException (String msg)
    {
        super(msg);
    }
}
class ATM 
{
    int balance;
    
    ATM(int balance)
    {
        this.balance=balance;
    }

    public void deposit(int amount) 
    {
        if (amount<=0)
        {
            throw new IllegalArgumentException("Amount less than or equal to 0");
        }
        else
        {
            this.balance+=amount;
            System.out.println("Balance after deposit : "+this.balance+" PKR");
        }
    }

    public void withdrawl(int amount) throws LowBalanceException
    {
        if (amount<=0 || amount>this.balance)
        {
            throw new IllegalArgumentException("Illegal withdrawl amount");    
        }
        else
        {
            this.balance-=amount;
        }

        if (this.balance<1000) 
        {
            throw new LowBalanceException("Balance lower than 1000 PKR");
        }
        else
        {
            System.out.println("Balance after withdrawl : "+this.balance+" PKR");

        }
    }
}
public class ATM_Exception_Handling 
{

    public static Scanner sc = new Scanner(System.in);
  

    static void printArray (int [] arr) throws ArrayIndexOutOfBoundsException
    {
        for (int i =0;i<=arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    } 

    static void inputMethod() throws InputMismatchException
    {

        int age;
        System.out.print("Enter your age (String) : ");
        age=sc.nextInt();
        
    }
    public static void main(String[] args) 
    {


        ATM account = new ATM(1000);

        try
        {
            account.withdrawl(500);
        }
        catch (LowBalanceException e)
        {
            System.out.println("Caution : "+e.getMessage());
        }

        try
        {
            account.deposit(0);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Error : "+e.getMessage());
        }

        finally
        {
            System.out.println("Signing Out !");
        }

        //ARRAY OUT OF BOUND EXCEPTION HANDLING !
        try
        {
            int [] arr = {1,2,3};
            printArray(arr);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("\nError : "+e.getMessage());
        }

        // INPUT EXCEPTION : 
        try 
        {
            inputMethod();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Hehe got ya ! Error : "+e.getMessage());
        }
    }    
}
