class BankAccount
{
    int accountID;
    double balance;

    BankAccount(int accountID,double balance)
    {
        this.accountID=accountID;
        this.balance=balance;
    }

    void balanceInquiry()
    {
        System.out.printf("The Balance of the user is : %.2f PKR\n",this.balance);

    }

    double depositAmount(double amount)
    {
        return this.balance+=amount;
    }

    double withdrawl(double withdrawlAmount)
    {
        if (withdrawlAmount>this.balance)
        {
            System.out.printf("The withdrawl amount  (%.2f)PKR increases the current balance (%.2f)PKR of the account\n",withdrawlAmount,this.balance);
            return this.balance;
        }
        else
        {
            this.balance-=withdrawlAmount;
            return balance;
        }
    }

    void showDetails()
    {
        System.out.println("The account ID of the account holder is : "+ this.accountID);
        System.out.printf("The Balance of the account is : %.2f PKR \n",this.balance);
    }
}
    
// CURRENT ACCOUNT !

class CurrentAccount extends BankAccount
{
    CurrentAccount (int accountID,double balance)
    {
        super(accountID, balance);
    }

    @Override
    double withdrawl(double withdrawlAmount)
    {
        if (withdrawlAmount>(this.balance-5000.0))
        {
            System.out.printf("The withdrawl amount (%.2f) PKR leaves less than 5000 PKR in the account ! \n",withdrawlAmount);
            return this.balance;
        }
        else
        {
            this.balance-=withdrawlAmount;
            return this.balance;
        }
    }

}

class SavingsAccount extends BankAccount
{
    SavingsAccount (int accountID,double balance)
    {
        super(accountID, balance);
    }
    @Override
    double withdrawl(double withdrawlAmount)
    {
        if (withdrawlAmount>(this.balance-10000.0))
        {
            System.out.printf("The withdrawl amount (%.2f) PKR leaves less than 10,000 PKR in the account ! \n",withdrawlAmount);
            return this.balance;
        }
        else
        {
            this.balance-=withdrawlAmount;
            return this.balance;
        }
    }

}
public class W6T1
{
    public static void main(String[] args) 
    {
        BankAccount person_1=new BankAccount(1,1000.0);
        CurrentAccount person_2=new CurrentAccount(2,1000.0);
        SavingsAccount person_3=new SavingsAccount(3, 1000.0);

        // PERSON 1 ---> DEFAULT ACCOUNT

        System.out.println("\n====DEFAULT ACCOUNT====");
        person_1.showDetails();
        System.out.println("Balance after deposit is : "+ person_1.depositAmount(50));
        System.out.println("The balance after withdrawl failed/successfull attempt is : "+person_1.withdrawl(2000));
        person_1.balanceInquiry();

        // Person 2 ---> CURRENT ACCOUNT
        System.out.println("\n====CURRENT ACCOUNT====");
        person_2.showDetails();
        System.out.println("Balance after deposit is : "+ person_2.depositAmount(50));
        System.out.println("The balance after withdrawl failed/successfull  is : "+person_2.withdrawl(2000));
        person_2.balanceInquiry();

        // Person 3 ---> SAVINGS ACCOUNT
        System.out.println("\n====SAVINGS ACCOUNT====");
        person_3.showDetails();
        System.out.println("Balance after deposit is : "+ person_3.depositAmount(50));
        System.out.println("The balance after withdrawl failed/successfull  is : "+person_3.withdrawl(2000));
        person_3.balanceInquiry();






        
    }
}


