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
    - Non-Filer: 25%  
    Source: TaxationPK Blog – “How to calculate tax on bank profits”  
    (https://blog.taxationpk.com/how-to-calculate-tax-on-bank-profits/)

  • Zakat Rate: 2.5% (0.025)  
    Standard religious deduction rate (Government of Pakistan / SBP)

  These values are used to make realProfit() reflect realistic economic data.
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


abstract class  Account 
{
    //Attributes
    protected int accountId;
    protected String accountHolderName;
    protected double balance;
    protected boolean isZakatApplicable;
    protected boolean isFiler;
    private int pin;

    //Construtor
    Account(int accountId,int pin,String accountHolderName,double balance,boolean isZakatApplicable,boolean isFiler)
    {
        this.accountId=accountId;
        setPin(this.pin);
        this.accountHolderName=accountHolderName;
        this.balance=balance;
        this.isZakatApplicable=isZakatApplicable;
        this.isFiler=isFiler;
    }

    //Methods !
    public void deposit(double amount)
    {
        if (amount>0)
        {
            this.balance+=amount;
            System.out.println("The balance after deposit is : "+this.balance);
        }
        else
        {
            System.out.println("Invalid Amount (Deposit amount can't be less thar 0 PKR)");
        }
    }

    public void withdraw(double amount) // to be overridden
    {

        double withdrawTax;
        withdrawTax=(isFiler) ? 0.02*amount : 0.04*amount;
        amount+=withdrawTax;
        if (amount<this.balance)
        {
            this.balance-=amount;
            System.out.printf("The account balance after wihdrawing %.2f PKR with %.2f PKR withdrawl tax is %.2f PKR\n",amount,withdrawTax,this.balance);
            System.out.println("Balance : "+this.balance);
            System.out.println("Amount withdrawn : "+amount);
            System.out.println("Withdrawl Tax : "+withdrawTax);
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
        System.out.printf("The account balance is %f PKR\n",this.balance);
        System.out.printf("Mr./Ms.%s is %s\n",this.accountHolderName,filer);
        System.out.printf("Mr./Ms.%s is %s\n",this.accountHolderName,zakat);

    }

    public void showBalance()
    {
        System.out.printf("The account balance of Mr./Ms %s is %.2f",this.accountHolderName,this.balance);
    }


    //No need of "instance of" since the method is overloaded
    public static double getTotalProfit(ArrayList<Account> accounts)
    {
        double totalProfits = 0;
        for (Account acc : accounts)
        {
            totalProfits += acc.getTotalEarning();
        }
        return totalProfits;
    }
   

    public static double getTotalRealProfit(ArrayList <Account> arr)
    {   
        double total = 0;
        for (Account a : arr)
        total += a.realProfit();

        return total;
    }   

    //getters setters for the pin

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    //Abstract methods will be implemented in the savings and investment class 

    public abstract double getTotalEarning();
    public abstract double realProfit();

}

// Current Account
class CurrentAccount extends Account 
{
    //All attributes are same as that of the parent class

    //Constructor
    CurrentAccount(int accountId,int pin,String accountHolderName,double balance,boolean isZakatApplicable,boolean isFiler)
    {
        super(accountId,pin,accountHolderName,balance,isZakatApplicable,isFiler);
    }

    //Methods
    public double getTotalEarning()
    {
        System.out.println("Current account holders are'nt applicable for earnings !");
        return 0;
    }
    public double realProfit()
    {
        System.out.println("Inapplicable for the Current Account Holders !");
        return 0;
    }

    @Override
    public void withdraw(double amount) 
    {

        //Special Withdrawl Tax for the Current 
        double withdrawTax=0.1*amount;
        amount+=withdrawTax;

        if (amount<this.balance)
        {
            this.balance-=amount;
            System.out.printf("The account balance after wihdrawing %.2f PKR with %.2f PKR withdrawl tax is %.2f PKR\n",amount,withdrawTax,this.balance);
            System.out.println("Balance : "+this.balance);
            System.out.println("Amount withdrawn : "+amount);
            System.out.println("Withdrawl Tax : "+withdrawTax);
        }
        else
        {
            System.out.printf("Error : Insufficient amount in account ! (%.2f)PKR\n",this.balance);
        }
    }

}

// Savings Account
class SavingsAccount extends Account 
{
    //Additionl Attributes
    Category ageCategory;
    int age;

    //Constructor :
    SavingsAccount(int accountId,int pin,String accountHolderName,int age,double balance,boolean isZakatApplicable,boolean isFiler)
    {

        super(accountId,pin,accountHolderName,balance, isZakatApplicable, isFiler);
        this.age=age;
        if (this.age<35)
        {
            this.ageCategory=ageCategory.YOUNG_SAVER;
        }
        else if(this.age<=50)
        {
            this.ageCategory=ageCategory.ADULT_SAVER;
        }
        else
        {
            this.ageCategory=ageCategory.SENIOR_CITIZEN_SAVER;
        }

    }

    @Override
    public double getTotalEarning() 
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
            profit=profit-(profit*0.25);
            System.out.println("Profit for the NON-FILER personnel (after tax)  is : "+profit);

        }
        return profit;
    }    

    @Override
    public double realProfit()
    {
        double realisticProfit=0;
        double nominal_profit=this.getTotalEarning();
        double Zakat=(this.isZakatApplicable && this.balance>179689) ? this.balance*0.025 : 0;
        double tax=(this.isFiler) ? 0.15*nominal_profit : nominal_profit*0.25 ;
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
    private static final double CAPITAL_GAIN_TAX = 0.15; 


    InvestmentAccount(int years,int pin,int accountId,String accountHolderName,double balance,boolean isZakatApplicable,boolean isFiler)
    {
        super(accountId,pin,accountHolderName,balance,isZakatApplicable,isFiler);
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

    // getter for the Capital gain TAx.

    public static double getCapitalGainTax() {
        return CAPITAL_GAIN_TAX;
    }
    //Only returns the total profit/returnings also fulfills the abstract class demand
    @Override
    public double getTotalEarning() 
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
        totalProfit = totalProfit-(totalProfit*getCapitalGainTax());
        return totalProfit; 
    }

    //Prints the projected profit for the number of years as well
    //..Extra function added by myself
    public void projectedgetTotalEarning() 
    {
        double interestRate = this.timeCategory.getProfitRate(); 
        double myMoney = this.balance;
        double totalProfit = 0;
        double CGT=getCapitalGainTax();

        System.out.println("==== PROJECTED PROFIT OVER " + this.years + " YEARS ====");
        for(int year = 0; year < this.years; year++)
        {
            double profitThisYear = myMoney * interestRate;
            totalProfit += profitThisYear;                      
            myMoney += profitThisYear;
            System.out.printf("Year %d: Profit: %.2f PKR Money for next year: %.2f PKR\n",(year + 1), profitThisYear, myMoney);
        }
        totalProfit=totalProfit-(totalProfit*CGT);
        System.out.println("===     TOTAL PROFIT     ===\n");
        System.out.printf("%.2f PKR",totalProfit);

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
    @Override
    public double realProfit() 
    {
        Map <String,Map<Integer,Double>> dataMap=InflationData.getInflationData();

        String country=null;
        int year=0;
        double result=0;

        //Iterating Over the HashMap
        System.out.println("For the calculation of real profit you have to give the country of residence & year...");
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
        double nominal_profit=this.getTotalEarning();
        double Zakat=(this.isZakatApplicable && this.balance>179689) ? this.balance*0.025 : 0;
        double tax=(this.isFiler) ? 0.15*nominal_profit : nominal_profit*0.25 ;
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
            while(!dataMap.containsKey(country_2) || country_2.equalsIgnoreCase(country_1))
            {
                System.out.printf("Invalid country ! Please try again : ");
                country_2=BankingSystem.sc.nextLine();
            }
            System.out.printf("Enter the year of investment in %s : ",country_2);
            year_2=BankingSystem.sc.nextInt();

            //Calculations

            profit_1=realProfit(country_1,year_1);
            profit_2=realProfit(country_2,year_2);
            System.out.printf("%60s\n","====      STATISTICS      ====");
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

        System.out.println("\n===== BEST INVESTMENT REPORT =====");
        System.out.printf("Best Country: %s\n", countriresArray.get(countryNumber));
        System.out.printf("Total Potential Profit in %s: %.2f PKR\n", countriresArray.get(countryNumber), countriesProfit.get(countryNumber));
        System.out.printf("Best Year to Invest in %s: %d\n", countriresArray.get(countryNumber), bestTime.get(countryNumber));

        System.out.println("\n=== OVERALL BEST INVESTMENT YEAR+Country ===");
        System.out.printf("Country: %s\n", overallBestCountry);
        System.out.printf("Year: %d\n", overallBestYear);
        System.out.printf("Profit in that year: %.2f PKR\n", overallHighestProfit);

    }

}
//HashMap


class InflationData 
{

    public static Map<String, Map<Integer, Double>> getInflationData() 
    {

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

        Map<Integer, Double> usa = new HashMap<>();
        usa.put(2018, 0.024);     
        usa.put(2019, 0.018); 
        usa.put(2020, 0.012); 
        usa.put(2021, 0.047); 
        usa.put(2022, 0.080); 


        Map <Integer,Double> india = new HashMap<>();
        india.put(2018,0.044);
        india.put(2019,0.057);
        india.put(2020, 0.066);  
        india.put(2021, 0.050);  
        india.put(2022, 0.070);  



        Map<Integer, Double> germany = new HashMap<>();
        germany.put(2018, 0.019);
        germany.put(2019, 0.014);   
        germany.put(2020, 0.004);   
        germany.put(2021, 0.032);   
        germany.put(2022, 0.087);   

        Map<Integer, Double> lebanon = new HashMap<>();
        lebanon.put(2018, 0.108);   
        lebanon.put(2019, 0.114);   
        lebanon.put(2020, 0.849);   
        lebanon.put(2021, 1.548);   
        lebanon.put(2022, 1.712);   


        // Addding to main Map
        inflationData.put("Pakistan", pakistan);
        inflationData.put("Japan", japan);
        inflationData.put("China", china);
        inflationData.put("USA",usa);
        inflationData.put("Germany", germany);
        inflationData.put("India", india);
        inflationData.put("Lebanon", lebanon);

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
        System.out.println("=====    SCNZ & SONS PVT. LTD.    =====");
        
        //array list for saving the earnings accounts that i will pass to the method
        //in Account class to calculate the total profits of all the earning accounts
        ArrayList <Account> earningAccounts = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();
        boolean exit = false;
        int accountCouter=1;

        while (!exit)
        {
            System.out.println("\n===== BANKING SYSTEM MENU =====");
            System.out.println("1- Create Account");
            System.out.println("2- Access Account");
            System.out.println("3- List Accounts");
            System.out.println("4- Total Nominal Profit (all accounts)");
            System.out.println("5- Total Real Profit (all accounts)");
            System.out.println("6- Exit");
            System.out.print("Enter an option: ");
            int choice;
            try 
            {
                choice = sc.nextInt();
            }
            catch (Exception e) 
            {
                sc.nextLine();
                System.out.println("Invalid input !! Try again.");
                continue;
            }
            sc.nextLine(); 

            switch (choice)
            {
                case 1: 
                {
                    System.out.println("Select account type:-");
                    System.out.println("1-Current");
                    System.out.println("2-Savings");
                    System.out.print("3-Investment\n");
                    System.out.print("> ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.printf("Account ID : %02d (system assigned)\n",accountCouter);
                    int id=accountCouter;
                    int pin, pinConfirm;                      
                    do
                    {
                        System.out.print("PIN (int) : ");
                        pin = sc.nextInt();
                        sc.nextLine();
                    
                        System.out.print("Re-enter PIN to confirm : ");
                        pinConfirm = sc.nextInt();
                        sc.nextLine();
                    
                        if (pin != pinConfirm)
                        {
                            System.out.println("Try again !");
                        }
                    
                    } while (pin != pinConfirm);


                    System.out.print("Enter Account Holder Name : ");
                    String name = sc.nextLine();
                    System.out.print("Initial balance : ");
                    double balance = sc.nextDouble(); sc.nextLine();
                    System.out.print("Is zakat applicable? (y/n) : ");
                    boolean zakat = sc.nextLine().trim().equalsIgnoreCase("y");
                    System.out.print("Is filer? (y/n): ");
                    boolean filer = sc.nextLine().trim().equalsIgnoreCase("y");

                    if (type == 1) 
                    {
                        accounts.add(new CurrentAccount(id, pin, name,balance, zakat, filer));
                        continue;
                    } 
                    else if (type == 2) 
                    {
                        System.out.print("Age : ");
                        int age = sc.nextInt(); 
                        sc.nextLine();
                        accounts.add(new SavingsAccount(id, pin, name, age, balance, zakat, filer));
                        earningAccounts.add(new SavingsAccount(id, pinConfirm, name, age, balance, zakat, filer));
                    } 
                    else if (type == 3) 
                    {
                        System.out.print("Investment duration in years : ");
                        int years = sc.nextInt(); 
                        sc.nextLine();
                        accounts.add(new InvestmentAccount(years, pin, id, name,balance, zakat, filer));
                        earningAccounts.add(new InvestmentAccount(years, pinConfirm, accountCouter, name, balance, zakat, filer));
                    } 
                    else 
                    {
                        System.out.println("Unknown account type ! Skipping creation....");
                    }
                    System.out.println("Account created successfully !");
                    accountCouter++;
                    break;
                }

                case 2: 
                {
                    if (accounts.isEmpty()) 
                    {
                        System.out.println("No accounts created yett !");
                        break;
                    }

                    System.out.print("Enter Account ID to access : ");
                    int accID = sc.nextInt(); sc.nextLine();

                    Account acc = null;

                    for (int i = 0;i<accounts.size();i++) 
                        if (accounts.get(i).accountId == accID) 
                        { 
                            acc = accounts.get(i); 
                            
                            break; 
                        }
                        if (acc == null) 
                        {
                            System.out.println("Account not found.");
                            break;
                        }

                        int accPin=0;
                        do 
                        {
                            System.out.print("Enter your pin : ");
                            sc.nextInt();
                            if (accPin!=acc.getPin())
                            {
                                System.out.printf("Invalid pin for account # %d ...Try Again !\n",acc.accountId);
                            }

                        } while (accPin!=acc.getPin());


                    boolean back = false;
                    while (!back) 
                    {
                        System.out.println("\nAccessing account : Mr./Ms." + acc.accountHolderName + " (ID " + acc.accountId + ")");
                        System.out.println("1-Deposit 2-Withdraw 3-Show Info 4-Show Balance 5-Deduct Zakat 6-Get Total Earning 7-Get Real Profit 8-Back");
                        System.out.print("Choose: ");
                        int achoice = sc.nextInt(); sc.nextLine();
                        switch (achoice) {
                            case 1:
                                System.out.print("Amount to deposit: ");
                                double damt = sc.nextDouble(); sc.nextLine();
                                acc.deposit(damt);
                                break;
                            case 2:
                                System.out.print("Amount to withdraw: ");
                                double wamt = sc.nextDouble(); sc.nextLine();
                                acc.withdraw(wamt);
                                break;
                            case 3:
                                acc.showInfo();
                                break;
                            case 4:
                                acc.showBalance();
                                System.out.println();
                                break;
                            case 5:
                                acc.deductZakat();
                                System.out.println();
                                break;
                            case 6:
                                System.out.printf("Total earning: %.2f\n", acc.getTotalEarning());
                                break;
                            case 7:
                                System.out.printf("Real profit: %.2f\n", acc.realProfit());
                                break;
                            case 8:
                                back = true;
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                    break;
                }

                case 3: {
                    if (accounts.isEmpty()) 
                    {
                        System.out.println("No accounts to list.");
                    } 
                    else 
                    {
                        System.out.println("Existing accounts:");
                        for (Account a : accounts) 
                        {
                            System.out.printf("ID: %d | Name: %s | Type: %s | Balance: %.2f\n",
                            a.accountId, a.accountHolderName, a.getClass().getSimpleName(), a.balance);
                        }
                    }
                    break;
                }

                case 4: 
                {
                    System.out.printf("Total nominal profit (all accounts): %.2f\n", Account.getTotalProfit(accounts));
                    break;
                }

                case 5: 
                {
                    System.out.println("Calculating total REAL profit for all accounts. Investment accounts may prompt for country/year.");
                    System.out.printf("Total real profit (all accounts): %.2f\n", Account.getTotalRealProfit(accounts));
                    break;
                }

                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }


        System.out.println("Thank You :)");
        System.out.printf("%60s\n","FIN !");




        sc.close();


      
       

    }

}
