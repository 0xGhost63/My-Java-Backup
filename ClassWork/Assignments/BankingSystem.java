abstract class  Account 
{
    //Attributes
    protected int accountId;
    protected String accountHolderName;
    protected int age;
    protected double balance;
    protected boolean isZakatApplicable;
    protected boolean isFiler;

    //Construtor
    Account(int accountId,String accountHolderName,int age,double balance,boolean isZakatApplicable,boolean isFiler)
    {
        this.accountId=accountId;
        this.accountHolderName=accountHolderName;
        this.age=age;
        this.balance=balance;
        this.isZakatApplicable=isZakatApplicable;
        this.isFiler=isFiler;
    }

    //Methods !
    public void deposit(double amount)
    {
        this.balance+=amount;
        System.out.println("The balance after deposit is : "+this.balance);
    }

    public void withdraw(double amount) // to be overridden
    {
        if (amount<this.balance)
        {
            this.balance-=amount;
            System.out.printf("The balance after wihdrawing %f PKR is %f PKR\n",amount,this.balance);
        }
        else
        {
            System.out.printf("Error : Insufficient amount in account ! (%f)PKR\n",this.balance);
        }
    }
    
    public void deductZakat() //  Deducts 2.5% zakat if applicable.
    {
        if (isZakatApplicable)
        {
            double payable=this.balance*0.025;   
            System.out.printf("The payable amount of zakat is %f PKR on total %f PKR in account",payable,this.balance);
            this.balance-=payable;
            System.out.println("Account balance after Zakat deduction is : "+this.balance);
        }
        else
        {
            System.out.println("%s isn't applicable for Zakat ! "+this.accountHolderName);
        }
    }

    
    public void showInfo()
    {
        String filer,zakat;
        zakat=(isZakatApplicable) ? "applicable for Zakat" : "NOT applicable for Zakat";
        filer=(isFiler) ? "a Filer" : "NOT a Filer";
        System.out.println("The name of the Account Holder is : "+this.accountHolderName);
        System.out.println("The ID of the account is : "+this.accountId);
        System.out.printf("The age of Mr./Ms. %s is %hhd\n",this.accountHolderName,this.age);
        System.out.printf("The account balance is %f PKR",this.balance);
        System.out.printf("Mr./Ms.%s is ",this.accountHolderName,filer);
        System.out.printf("Mr./Ms.%s is ",this.accountHolderName,zakat);

    }

    public void showBalance()
    {
        System.out.printf("The balance of Mr./Ms %s is %f",this.accountHolderName,this.balance);
    }

    //Abstract method will be implemented in the savings and investment class 

    public abstract double getTotalEarnings();

}

// Current Account
class CurrentAccount extends Account 
{
    //All attributes are same as that of the parent class

    //Constructor
    CurrentAccount(int accountId,String accountHolderName,int age,double balance,boolean isZakatApplicable,boolean isFiler)
    {
        super(accountId,accountHolderName,age,balance,isZakatApplicable,isFiler);
    }

    //Methods
    public double getTotalEarnings()
    {
        System.out.println("Current account holders are'nt applicable for earnings !");
        return 0;
    }


}
//Enum
enum Category
    {
        YOUNG_SAVER(6),
        ADULT_SAVER(7),
        SENIOR_CITIZEN_SAVER(8);

        //Attribute
        private final double profitRate;

        //Private Constructor that implicitily prevents the creation of the objects outside of my choice
        Category(double profitRate)
        {
            this.profitRate = profitRate;
        }  

        public double getProfitRate()
        {
            return profitRate;
        }
    }

// Savings Account
class SavingsAccount extends Account 
{
    //Additionl Attributes
    Category ageCategory;

    //Constructor :
    SavingsAccount(int accountId,String accountHolderName,int age,double balance,boolean isZakatApplicable,boolean isFiler)
    {
        super(accountId,accountHolderName, age, balance, isZakatApplicable, isFiler);
        if (age<35)
        {
            this.ageCategory=ageCategory.YOUNG_SAVER;
        }
        else if(age<=50)
        {
            this.ageCategory=ageCategory.ADULT_SAVER;
        }
        else
        {
            this.ageCategory=ageCategory.SENIOR_CITIZEN_SAVER;
        }


    }

    @Override
    public double getTotalEarnings() 
    {
        double profit=this.balance*(ageCategory.getProfitRate()/100);
        if(isFiler)
        {
            //Profit after tax = profit - (profit * profit %)
            profit=profit-(profit*0.15);
        }
        else
        {
            profit=profit-(profit*0.25);
        }

        return profit;
    }    
}




// // Investment Account
// class InvestmentAccount extends Account {

// }

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        System.out.println("Hello World");
        SavingsAccount s1 = new SavingsAccount(0, "Sannan", 10, 100, false, false);
      
        s1.showData();
       

    }

}
