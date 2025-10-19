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
import java.lang.classfile.instruction.ConstantInstruction.IntrinsicConstantInstruction;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
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
    //Only returns the total profit/returnings also fulfills the abstract class demand
    @Override
    public double getTotalEarnings() 
    {
        double interestRate = this.timeCategory.getProfitRate(); 
        double myMoney = this.balance;
        double totalProfit = 0;
        for(int year=0;year<this.years;year++)
        {
            double profitThisYear = myMoney * interestRate;
            totalProfit += profitThisYear;                      
            myMoney += profitThisYear;
            
        }
        return totalProfit; 
    }

    //Prints the projected profit for the number of years as well
    public double getTotalEarnings(boolean shouldPrint) 
    {
        double interestRate = this.timeCategory.getProfitRate(); 
        double myMoney = this.balance;
        double totalProfit = 0;
        if(shouldPrint)
        {
            System.out.println("==== PROJECTED PROFIT OVER " + this.years + " YEARS ====");
            for(int year = 0; year < this.years; year++)
            {
                double profitThisYear = myMoney * interestRate;
                totalProfit += profitThisYear;                      
                myMoney += profitThisYear;

                System.out.printf("Year %d: Profit: %.2f PKR Money for next year: %.2f PKR\n",(year + 1), profitThisYear, myMoney);
            }

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
    
    //nessary to implement this function as it is the part of the abstraction class
    public double realProfit() 
    {
        Map <String,Map<Integer,Double>> dataMap=InflationData.getInflationData();

        String country=null;
        int year=0;
        double result=0;

        //Iterating Over the HashMap
        System.out.print("\nAvailable options of countries are : ");
        for (String key : dataMap.keySet() )
        {
            System.out.print(key+"   ");
        }

        System.out.print("\nEnter the Country : ");
        country=BankingSystem.sc.next();
        while(!dataMap.containsKey(country))
        {
            System.out.print("Invalid Country...Try Again : ");
            country=BankingSystem.sc.next();
        }
        System.out.print("Enter an year : ");
        year=BankingSystem.sc.nextInt();
        while(year<2019 || year>2022)
        {
            System.out.print("Please enter a valid year (2019-2022) : ");
            year=BankingSystem.sc.nextInt();
        }
        result=realProfit(country,year);

        return result;
    }

    public double realProfit(String country, int year)
    {

        double realisticProfit=0;
        double nominal_profit=this.getTotalEarnings();
        double Zakat=(this.isZakatApplicable && this.balance>179689) ? this.balance*0.025 : 0;
        double tax=(this.isFiler) ? 0.15*nominal_profit : nominal_profit*0.35 ;
        // getting inflation from HashMap 
        Map<String, Map<Integer, Double>> inflationMap = InflationData.getInflationData();
        double inflationRate = 0;
        if (inflationMap.containsKey(country) && inflationMap.get(country).containsKey(year)) 
        {
            inflationRate = inflationMap.get(country).get(year);
        }
        double inflationLoss = nominal_profit * inflationRate;        
        realisticProfit=nominal_profit-(tax+Zakat+inflationLoss);
        return Math.round(realisticProfit * 100.0) / 100.0;
    }


    public void bestInvestment(boolean isComparison)
    {
        if(isComparison)
        {
            System.out.println("\n====  PROFIT COMPARISON   ====");

            //Retrieving the data from the Hashmap
            Map <String,Map<Integer,Double>> dataMap = InflationData.getInflationData();

            //Variables for comparison
            String country_1=null,country_2=null;
            int year_1=0,year_2=0,duration_1=0,duration_2=0;
            double profit_1=0,profit_2=0;

            //Iterating Over the HashMap
            System.out.print("\nAvailable options of countries are : ");
            for (String key : dataMap.keySet() )
            {
                System.out.print(key+"   ");
            }



            //Taking the Input
            System.out.print("\nEnter the first country : ");
            country_1=BankingSystem.sc.nextLine();
            while(!dataMap.containsKey(country_1))
            {
                System.out.printf("Invalid country ! Please try again : ");
                country_1=BankingSystem.sc.nextLine();
            }
            System.out.printf("Enter the year of investment in %s : ",country_1);
            year_1=BankingSystem.sc.nextInt();
            BankingSystem.sc.nextLine();

            System.out.printf("Enter the second country : ");
            country_2=BankingSystem.sc.nextLine();
            while(!dataMap.containsKey(country_2))
            {
                System.out.printf("Invalid country ! Please try again : ");
                country_2=BankingSystem.sc.nextLine();
            }
            System.out.printf("Enter the year of investment in %s : ",country_2);
            year_2=BankingSystem.sc.nextInt();

            //Calculations

            profit_1=realProfit(country_1,year_1);
            profit_2=realProfit(country_2,year_2);
            System.out.println("STATISTICS : ");
            System.out.printf("Profit in %s in %d is : %.2f PKR\n",country_1,year_1,profit_1);
            System.out.printf("Profit in %s in year %d is : %.2f PKR\n",country_2,year_2,profit_2);
            System.out.println("Hence : ");
            if(profit_1>profit_2) 
            {
                System.out.printf("%s Is a better option for investment in year %d than %s in %d\n",country_1,year_1,country_2,year_2 );
            }
            else
            {
                System.out.printf("%s Is a better option for investment in year %d than %s in %d \n",country_2,year_2,country_1,year_1 );
            }
        }
    }       

    public void bestInvestment()
    {
        // best year per country
        Map<String, Map<Integer, Double>> dataMap = InflationData.getInflationData();
        int sizeOfMap=dataMap.size();
        ArrayList <String> countriresArray = new ArrayList<>();
        ArrayList<Double> countriesProfit = new ArrayList<>();
        ArrayList<Integer>bestTime = new ArrayList<>();

        // overall best year
        double overallHighestProfit = Double.MIN_VALUE;
        String overallBestCountry = "";
        int overallBestYear = 0;


        //Which country is best for investment overall ??
        //Which year is specifically the best ?
        for(Map.Entry<String , Map <Integer,Double>> data : dataMap.entrySet())  
        {
            double sum=0;
            double highestProfit=Double.MIN_VALUE;
            int bestYear=0; // initialized
            countriresArray.add(data.getKey());


            Map<Integer, Double> innerMap = data.getValue();

            for(Map.Entry <Integer,Double> innerData: innerMap.entrySet())
            {
                double profit = 0;
                String country = data.getKey();
                int year = innerData.getKey();
                profit=realProfit(data.getKey(),innerData.getKey());

                if(profit>highestProfit)
                {
                    highestProfit=profit;
                    bestYear=innerData.getKey();
                }
                if (profit > overallHighestProfit)
                {
                    overallHighestProfit = profit;
                    overallBestCountry = country;
                    overallBestYear = year;
                }

                sum+=profit;
            }
            countriesProfit.add(sum);
            bestTime.add(bestYear); // keep it here
        }      

        double countriesMax=0;
        int countryNumber=0;
        for (int i =0;i<countriesProfit.size();i++)
        {
            if(countriesProfit.get(i)>countriesMax)
            {
                countriesMax=countriesProfit.get(i);
                countryNumber=i;

            }
        }

        // Print results
        System.out.println("\n===== BEST INVESTMENT REPORT =====");
        System.out.printf("Best Country: %s\n", countriresArray.get(countryNumber));
        System.out.printf("Total Potential Profit in %s: %.2f PKR\n", countriresArray.get(countryNumber), countriesProfit.get(countryNumber));
        System.out.printf("Best Year to Invest in %s: %d\n", countriresArray.get(countryNumber), bestTime.get(countryNumber));

        // Overall best year across all countries
        System.out.println("\n=== OVERALL BEST INVESTMENT YEAR ===");
        System.out.printf("Country: %s\n", overallBestCountry);
        System.out.printf("Year: %d\n", overallBestYear);
        System.out.printf("Profit in that year: %.2f PKR\n", overallHighestProfit);

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

// Main Class
public class BankingSystem 
{
    //Scanner Object Creation
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) 
    {

        System.out.println("Hello World");
        System.out.println("=====    WELCOME!    =====");
        // Sample accounts and summary

        InvestmentAccount i1 = new InvestmentAccount(3, 204, "Ali", 40, 100000.0, true, true);
        i1.bestInvestment();
        double realProfit=i1.realProfit();
        System.out.println("Real profit : "+realProfit);
        realProfit=i1.realProfit("Pakistan",2020);
        System.out.println("Real profit : "+realProfit);
        
        // i1.realProfit("Pakistan",2019);
        // InvestmentAccount.bestInvestment();


        sc.close();

        // FORMAT THE AMOUNTS !



        
        // // SavingsAc        Map<String , Map<String,Integer> Data = new HashMap<>();
        // Data=InflationData.getInflationData();
        // System.out.println(Data);count s1 = new SavingsAccount(0, "Sannan", 10, 100, false, false);
        // InvestmentAccount i1 = new InvestmentAccount(3, 1, "Ali", 40, 100000, true, true);

        // double temp=i1.getTotalEarnings();
        // System.out.println(temp);
        // // i1.withdraw(200);
        // 1-

        //If an earning account type account is created
        //store it in an array and pass it to the static 
        //Account.getTotalProfitPaid() to get all the accounts

        // 2-
        /*⚠️ Leftovers / Changes needed
            
        Capital gain tax fix
            
        Non-filer earnings tax for getTotalEarnings() should be 25% (currently 35%)
            
        Filer earnings tax remains 15% ✔
            
        Non-filer withdrawal tax → 4% (currently only InvestmentAccount implemented)
            
        Filer withdrawal tax → 2%
            
        Withdrawal tax for SavingsAccount
            
        Right now only InvestmentAccount applies it
            
        Needs to be implemented for SavingsAccount too
            
        Remove print statements from calculation methods
            
        getTotalEarnings() should return value only, no printing
            
        Move prints to main/test class
            
        Add 7 countries to inflation data
            
        Current: Pakistan, Japan, China
            
        Assignment wants: Pakistan, Japan, China, Lebanon + 3 others
            
        Inflation rates for 2018–2022 must be included
            
        Implement getRealProfitRatio()
            
        Returns actual profit percentage after tax, zakat, inflation
            
        Currently you return absolute realProfit amount
            
        Test class / main method updates
            
        Create 7 InvestmentAccount objects (2018, 5-year plan, different countries)
            
        Print each account’s earnings & real profit ratio
            
        Determine best country for long-term investment
            
        Consistency / minor fixes
            
        duration_1, duration_2 in bestInvestment(boolean) are unused → remove
            
        Variable naming (countriresArray typo) → fix
            
        Minor formatting issues in printf
            
        realProfit() in SavingsAccount doesn’t take country/year → optional to extend for uniformity
            
        Optional / bonus
            
        Ensure future inflation data can be added without code changes
            
        All earning accounts handle reinvestment via deposit(profit) (already works)*/

      
       

    }

}
