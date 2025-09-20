// Thats how GPT free code looks like ;)
import java.util.Scanner;

class Account 
{
    int accountNumber;
    private int pin;
    double balance = 1000;
    String accountHolderName;

    public int getPin() 
    {
        return pin;
    }

    public void setPin(int pin) 
    {
        this.pin = pin;
    }

    Account(String accountHolderName) 
    {
        this.accountHolderName = accountHolderName;
    }

    double withdrawal(double amount) 
    {
        if (amount > this.balance) 
        {
            System.out.println("Invalid Amount ! Can't Process ");
            return 0;
        } 
        else 
        {
            this.balance -= amount;
            System.out.printf("After the withdrawal your account balance is : %.2f PKR \n", this.balance);
            return this.balance;
        }
    }

    double deposit(double amount) 
    {
        this.balance += amount;
        System.out.printf("After the deposit your account balance is : %.2f PKR \n", this.balance);
        return balance;
    }

    void showBalance() 
    {
        System.out.printf("Your Current Account Balance is : %.2f PKR\n", this.balance);
    }

    void showHoldersInfo() 
    {
        System.out.printf("The Account Holder's Name is : Mr/Ms. %s\n", this.accountHolderName);
        System.out.println("Account Number : " + this.accountNumber);
        System.out.printf("Your Current Account Balance is : %.2f PKR\n", this.balance);
    }

    void changePin() 
    {
        int pin, confirmPin;
        do 
        {
            System.out.print("Create your new confidential pin : ");
            pin = ATM.sc.nextInt();
            System.out.print("Confirm Your Pin : ");
            confirmPin = ATM.sc.nextInt();
            if (pin != confirmPin) 
            {
                System.out.println("Both pins don't match ! ");
            }
        } while (pin != confirmPin);
        setPin(pin);
        System.out.println("Pin saved successfully ! ");
    }
}

public class ATM 
{
    static int numbOfAccounts;
    static Scanner sc = new Scanner(System.in);

    static void displayMenu() 
    {
        System.out.printf("\n%35s\n", "===MAIN MENU====");
        System.out.println("1-Open new accounts ");
        System.out.println("2-Access an account");
        System.out.println("3-Exit the Program");
    }

    static void accessMenu() 
    {
        System.out.printf("\n%35s\n", "===ACCESS MENU====");
        System.out.println("1-Withdraw Money.");
        System.out.println("2-Make a deposit.");
        System.out.println("3-Check Balance");
        System.out.println("4-Show account holders information ");
        System.out.println("5-Change pin ");
        System.out.println("6-Return to the main menu");
        System.out.printf("\n%35s\n", "================");
    }

    static Account[] createAccounts() 
    {
        int accountNumber = 1;
        System.out.print("How many accounts would you like to create? : ");
        numbOfAccounts = sc.nextInt();
        Account[] accounts = new Account[numbOfAccounts];

        for (int i = 0; i < numbOfAccounts; i++) 
        {
            sc.nextLine(); // consume leftover newline
            System.out.print("Enter the name of Account Holder: ");
            String accountHolderName = sc.nextLine();

            accounts[i] = new Account(accountHolderName);
            accounts[i].accountNumber = accountNumber;
            accounts[i].changePin();
            System.out.println("Congratulations ! You have got the welcome bonus of 1,000 PKR");
            System.out.printf("***Plz note that your account number is ------> %d***\n", accountNumber);
            accountNumber++;
            System.out.printf("%40s", "ACCOUNT CREATED SUCCESSFULLY\n");
        }

        return accounts;
    }

    public static void main(String[] args) 
    {
        Account[] dataArray = createAccounts();

        int main_choice = 0;
        while (main_choice != 3) 
        {
            displayMenu();
            System.out.println("Select the option number that you want to execute : ");
            main_choice = sc.nextInt();

            if (main_choice == 1) 
            {
                dataArray = createAccounts();
            } 
            else if (main_choice == 2) 
            {
                int accountNumber;
                System.out.print("Enter your account number (1 to " + numbOfAccounts + "): ");
                accountNumber = sc.nextInt();

                while (accountNumber < 1 || accountNumber > numbOfAccounts) 
                {
                    System.out.print("Invalid account number plz try again : ");
                    accountNumber = sc.nextInt();
                }

                accountNumber--;
                System.out.printf("Welcome Mr/Ms. %s :) !\n", dataArray[accountNumber].accountHolderName);
                int pin;
                int number_of_attempts = 3;
                boolean access = false;

                while (number_of_attempts > 0) 
                {
                    System.out.printf("Mr/Ms.%s Please enter your pin : ", dataArray[accountNumber].accountHolderName);
                    pin = sc.nextInt();

                    if (dataArray[accountNumber].getPin() == pin) 
                    {
                        System.out.println("Access Granted! ");
                        access = true;
                        break;
                    } 
                    else 
                    {
                        number_of_attempts--;
                        if (number_of_attempts == 0) 
                        {
                            System.out.println("Max number of attempts reached! Exiting...");
                        } 
                        else 
                        {
                            System.out.printf("Incorrect Pin! Plz try again. %d attempts left!\n", number_of_attempts);
                        }
                    }
                }

                if (access) 
                {
                    accessMenu();
                    int access_choice = 0;

                    do 
                    {
                        System.out.print("Select an option to execute : ");
                        access_choice = sc.nextInt();
                        if (access_choice == 1) 
                        {
                            double amount;
                            System.out.print("How much amount would you like to withdraw : ");
                            amount = sc.nextDouble();
                            dataArray[accountNumber].withdrawal(amount);
                        } 
                        else if (access_choice == 2) 
                        {
                            double amount;
                            System.out.print("How much amount would you like to deposit ? ");
                            amount = sc.nextDouble();
                            dataArray[accountNumber].deposit(amount);
                        } 
                        else if (access_choice == 3) 
                        {
                            dataArray[accountNumber].showBalance();
                        } 
                        else if (access_choice == 4) 
                        {
                            dataArray[accountNumber].showHoldersInfo();
                        } 
                        else if (access_choice == 5) 
                        {
                            dataArray[accountNumber].changePin();
                        } 
                        else if (access_choice == 6) 
                        {
                            break;
                        } 
                        else 
                        {
                            System.out.println("Please Select a valid choice : ");
                        }

                    } while (access_choice != 6);
                }
            } 
            else if (main_choice == 3) 
            {
                System.out.println("Thank you for using the program :) ");
                break;
            } 
            else 
            {
                System.out.println("Please select a valid option");
            }
        }
        sc.close();
    }
}
