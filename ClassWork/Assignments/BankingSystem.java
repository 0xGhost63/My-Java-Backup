/*  
  References for realProfit() Calculations – SavingsAccount & Investment Accounts (Pakistan 2025)
  ---------------------------------------------------------------------------
  • Inflation Rate (2024–2025): ~12.6%  
    Source: World Bank Data (https://data.worldbank.org/indicator/FP.CPI.TOTL.ZG?locations=PK)

  • Zakat Nisab (1445–46 AH / 2025): Rs. 179,689 minimum balance  
    Source: Business Recorder – “Minimum Nisab fixed at Rs179,689 for Zakat”  
    (https://www.brecorder.com/news/40350378)

  • Zakat Deduction Policy: Applies only if balance ≥ Nisab; 
    not applicable on Current Accounts  
    Source: The Express Tribune – “Zakat deduction on bank accounts for Ramadan 2025”  
    (https://tribune.com.pk/story/2531282/zakat-deduction-on-bank-accounts-for-ramadan-2025-announced)

  • Withholding Tax on Profit (Savings / Investment Accounts):  
    - Filer: 15%  
    - Non-Filer: 35%  
    Source: TaxationPK Blog – “How to calculate tax on bank profits”  
    (https://blog.taxationpk.com/how-to-calculate-tax-on-bank-profits/)

  • Zakat Rate: 2.5% (0.025)  
    Standard religious deduction rate (Government of Pakistan / SBP)

  These values are used to make realProfit() reflect realistic economic data.
*/
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


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
            System.out.printf("The account balance after wihdrawing %.2f PKR is %.2f PKR\n",amount,this.balance);
        }
        else
        {
            System.out.printf("Error : Insufficient amount in account ! (%.2f)PKR\n",this.balance);
        }
    }
    
    public void deductZakat() //  Deducts 2.5% zakat if applicable.
    {
        if (isZakatApplicable)
        {
            double payable=this.balance*0.025;   
            System.out.printf("The payable amount of zakat is %.2f PKR on total %.2f PKR in account",payable,this.balance);
            this.balance-=payable;
            System.out.println("Account balance after Zakat deduction is : "+this.balance);
        }
        else
        {
            System.out.printf("%s isn't applicable for Zakat ! ",this.accountHolderName);
        }
    }

    
    public void showInfo()
    {
        String filer,zakat;
        zakat=(isZakatApplicable) ? "applicable for Zakat" : "NOT applicable for Zakat";
        filer=(isFiler) ? "a Filer" : "NOT a Filer";
        System.out.println("The name of the Account Holder is : "+this.accountHolderName);
        System.out.println("The ID of the account is : "+this.accountId);
        System.out.printf("The age of Mr./Ms. %s is %d\n",this.accountHolderName,this.age);
        System.out.printf("The account balance is %f PKR\n",this.balance);
        System.out.printf("Mr./Ms.%s is %s\n",this.accountHolderName,filer);
        System.out.printf("Mr./Ms.%s is %s\n",this.accountHolderName,zakat);

    }

    public void showBalance()
    {
        System.out.printf("The account balance of Mr./Ms %s is %.2f",this.accountHolderName,this.balance);
    }

    public static double getTotalProfit(Account [] objArray)
    {
        //No need of "instance of" since the method is overloaded
        double total_profits=0;

        for(int i =0;i<objArray.length;i++)
        {
            total_profits+=objArray[i].getTotalEarnings();
        }
        return total_profits;
    }

    public static double getTotalRealProfit(Account[] arr)
    {   
        double total = 0;
        for (Account a : arr)
        total += a.realProfit();
        return total;
    }   


    //Abstract methods will be implemented in the savings and investment class 

    public abstract double getTotalEarnings();
    public abstract double realProfit();

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
    public double realProfit()
    {
        System.out.println("Inapplicable for the Current Account Holders !");
        return 0;
    }



}
//Enum
enum Category
    {
        //Savings Class
        YOUNG_SAVER(6),
        ADULT_SAVER(7),
        SENIOR_CITIZEN_SAVER(8),
        
        //Investment Class
        ONE_YEAR(0.10),
        THREE_YEAR(0.12),
        FIVE_YEAR(0.14);


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

    public double getTotalEarnings() 
    {
        double profit=this.balance*(ageCategory.getProfitRate()/100);
        if(isFiler)
        {
            //Profit after tax = profit - (profit * profit %)
            profit=profit-(profit*0.15);
            System.out.println("Profit for the FILER personnel (after tax) is : "+profit);
        }
        else
        {
            profit=profit-(profit*0.35);
            System.out.println("Profit for the NON-FILER personnel (after tax)  is : "+profit);

        }
        return profit;

    }    

    public double realProfit()
    {
        // Here 179689 is Nisab
        //0.126 is the Inflation-Rate
        double realisticProfit=0;
        double nominal_profit=this.getTotalEarnings();
        double Zakat=(this.isZakatApplicable && this.balance>179689) ? this.balance*0.025 : 0;
        double tax=(this.isFiler) ? 0.15*nominal_profit : nominal_profit*0.35 ;
        double inflationLoss=nominal_profit*0.126;
        //Calculation Formula
        realisticProfit=nominal_profit-(tax+Zakat+inflationLoss);
        return Math.round(realisticProfit * 100.0) / 100.0;
    }
}




// Investment Account
class InvestmentAccount extends Account 
{

    Category timeCategory;
    int years;

    InvestmentAccount(int years,int accountId,String accountHolderName,int age,double balance,boolean isZakatApplicable,boolean isFiler)
    {
        super(accountId,accountHolderName,age,balance,isZakatApplicable,isFiler);
        this.years=years;
        if(this.years>0 && this.years <3)
        {
            this.timeCategory=timeCategory.ONE_YEAR;
        }
        else if (this.years>=3 && this.years<5)
        {
            this.timeCategory=timeCategory.THREE_YEAR;
        }
        else
        {
            this.timeCategory=timeCategory.FIVE_YEAR;
        }
    }
    public double getTotalEarnings() 
    {
        double interestRate = this.timeCategory.getProfitRate(); 
        double myMoney = this.balance;
        double totalProfit = 0;
        System.out.println("==== PROJECTED PROFIT OVER " + this.years + " YEARS ====");
        for(int year = 0; year < this.years; year++)
        {
            double profitThisYear = myMoney * interestRate;
            totalProfit += profitThisYear;                      
            myMoney += profitThisYear;

            System.out.printf("Year %d: Profit: %.2f PKR Money for next year: %.2f PKR\n",(year + 1), profitThisYear, myMoney);
        }

        return totalProfit; 
    }

    @Override
    public void  withdraw(double amount) 
    {
        double withdrawlTax, totalWithdrawlCost = 0;
        double surchargeRate = 0.04;
        double taxRate = this.isFiler ? 0.02 : 0.04;
        double surcharge = surchargeRate * amount;
        withdrawlTax = taxRate * amount;
        totalWithdrawlCost = withdrawlTax+surcharge+amount;

        if (totalWithdrawlCost > this.balance) 
        {
            System.out.printf("Error : Insufficient amount in account ! (%.2f)PKR\n", this.balance);
        }
        else
        {
            this.balance -= totalWithdrawlCost;
            System.out.printf("%-25s :       %.2f PKR\n%-25s :       %.2f PKR\n%-25s :       %.2f PKR\n%-25s :       %.2f PKR\n",
            "Tax", withdrawlTax,"Surcharges", surcharge,"Withdrawl Amount", amount,"Total Amount Deducted", totalWithdrawlCost);
            System.out.printf("The account balance after withdrawing %.2f PKR is : %.2f PKR\n",totalWithdrawlCost, this.balance);
        }
    }
    public double realProfit(String country, int year)
    {
        // Here 179689 is Nisab
        //0.126 is the Inflation-Rate
        //Applies to all years
        double realisticProfit=0;
        double nominal_profit=this.getTotalEarnings();
        double Zakat=(this.isZakatApplicable && this.balance>179689) ? this.balance*0.025 : 0;
        double tax=(this.isFiler) ? 0.15*nominal_profit : nominal_profit*0.35 ;
        // get inflation from HashMap instead of hardcoding
        Map<String, Map<Integer, Double>> inflationMap = InflationData.getInflationData();
        double inflationRate = 0;
        if (inflationMap.containsKey(country) && inflationMap.get(country).containsKey(year)) 
        {
            inflationRate = inflationMap.get(country).get(year);
        }
        double inflationLoss = nominal_profit * inflationRate;        realisticProfit=nominal_profit-(tax+Zakat+inflationLoss);
        return Math.round(realisticProfit * 100.0) / 100.0;
    }

    public void bestInvestment()
    {
        
    }



}
//HashMap


class InflationData 
{

    public static Map<String, Map<Integer, Double>> getInflationData() {

        Map<String, Map<Integer, Double>> inflationData = new HashMap<>();

        Map<Integer, Double> pakistan = new HashMap<>();
        pakistan.put(2018, 0.05);
        pakistan.put(2019, 0.06);
        pakistan.put(2020, 0.07);
        pakistan.put(2021, 0.126);
        pakistan.put(2022, 0.12);

        Map<Integer, Double> japan = new HashMap<>();
        japan.put(2018, 0.01);
        japan.put(2019, 0.005);
        japan.put(2020, 0.002);
        japan.put(2021, 0.004);
        japan.put(2022, 0.01);

        Map<Integer, Double> china = new HashMap<>();
        china.put(2018, 0.025);
        china.put(2019, 0.026);
        china.put(2020, 0.02);
        china.put(2021, 0.015);
        china.put(2022, 0.02);

        // Addding to main Map
        inflationData.put("Pakistan", pakistan);
        inflationData.put("Japan", japan);
        inflationData.put("China", china);

        return inflationData;
    }


}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("=====    WELCOME!    =====");


        
        // // SavingsAccount s1 = new SavingsAccount(0, "Sannan", 10, 100, false, false);
        // InvestmentAccount i1 = new InvestmentAccount(3, 1, "Ali", 40, 100000, true, true);

        // double temp=i1.getTotalEarnings();
        // System.out.println(temp);
        // // i1.withdraw(200);
        // 1-

        //If an earning account type account is created
        //store it in an array and pass it to the static 
        //Account.getTotalProfitPaid() to get all the accounts

        // 2-
        /*Capital Gain Tax: Your filer/non-filer tax logic is mostly correct; just make non-filer tax consistent between getTotalEarnings() and realProfit().

        InvestmentAccount Profit: Right now it’s simple multiplication; needs compounding for multi-year plans.

        Withdraw Tax: Surcharge & tax are fine; optional: could return boolean/exception instead of just printing.

        deductZakat(): Works, just fix the printf formatting.

        Category Enum: Works, but consider separating SavingsCategory vs InvestmentCategory for clarity.

        getTotalProfit(): Works, can rename to getTotalProfitPaid for clarity.

        Real Profit / Inflation: Use a Map<String, Map<Integer, Double>> for country/year inflation to make it flexible instead of hard-coded Pakistan.

        Main/Test Class: Create 5–7 accounts of all types, print individual earnings & total profit.

        Code Hygiene: Keep indentation clean, avoid printing inside getTotalEarnings() in production, and use meaningful variable names in loops./*

      
       

    }

}
