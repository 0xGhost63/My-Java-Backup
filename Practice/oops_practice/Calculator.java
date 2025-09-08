import java.util.Scanner;
class cal 
{
    float n1,n2,result;

    cal(float n1,float n2)
    {
        this.n1=n1;
        this.n2=n2;   
    }

    float add()
    {
        result=this.n1+this.n2;
        return result;
    }

    float subtract()
    {
        result=this.n1-this.n2;
        return result;
    }

    float multiply()
    {
        result=this.n1*this.n2;
        return result;
    }
    float divide()
    {
        if (this.n2!=0)
        {
            result=this.n1/this.n2;
            return result;
        }
        else
        {
            System.out.println("Error: The denominator can't be zero !");
            return 0;
        }
    }

    
}
public class Calculator 
{
    public static void main(String[] args)
    {
        //Scanner
        Scanner sc= new Scanner(System.in);
    
        // Start 
        System.out.println("Welcome to the calculator :)");
        while (true)
        {
            float n1,n2,result=0;
            char operation;

            System.out.print("Enter the first number : ");
            n1=sc.nextFloat();
            System.out.print("Enter the second number : ");
            n2=sc.nextFloat();
            System.out.print("Which operation would you like to perform ? ");
            operation=sc.next().charAt(0);
            if (operation != '/' && operation != '*' && operation != '-' && operation != '+')

            {
                System.out.println("Invalid operation selected :(");
            }
            else
            {
                cal obj = new cal(n1, n2);
                if (operation =='-')
                {
                    result=obj.subtract();
                }
                if (operation =='+')
                {
                    result=obj.add();
                }
                if (operation =='*')
                {
                    result=obj.multiply();
                }
                if (operation =='/')
                {
                    result=obj.divide();
                }
        
            }
            System.out.printf("\n%10.2f %10c %10.2f %10s %10.2f\n", n1, operation, n2, "=", result);
            char choice;
            System.out.print("\nDo you wish to proceed ? (y/n)");
            choice=sc.next().charAt(0);
            if (choice == 'n' || choice=='N')
            {
                System.out.println("Have a nice day :)");
                break;
            }

            
            
        }
    }
    
}
