import java.util.Scanner;
public class Luck
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name : ");
        String name = sc.nextLine();
        try
        {          
            Thread.sleep(1000);
            System.out.printf("Hi %s !\n",name);
            Thread.sleep(2000);
            System.out.println("Hope you are doing good !");
            Thread.sleep(1000);
            System.out.println("Best of Luck for your Exam !");
        }
        catch(InterruptedException e)
        {
            System.out.println("Exception !");
        }
    }
}