import java.util.Scanner;
public class W4T5
{
    public static void main(String[] args) 
    {
        // Scanner object Creation
        Scanner sc = new Scanner(System.in);

        //Variables
        int no_of_payments;
        int target_sum;
        int counter=0;
        int index=0;

        System.out.print("Enter the number of Payments ");
        no_of_payments=sc.nextInt();

        //Array Creation 
        int [] payments = new int [no_of_payments];

        System.out.print("Enter the payment amounts : ");
        for (int i =0; i<payments.length;i++)
        {
            payments[i]=sc.nextInt();
        }
        System.out.print("Enter the target sum : ");
        target_sum=sc.nextInt();

        for (int i : payments)
        {
           for (int j : payments)
            {
                if ((i+j)==target_sum)
                {
                    counter++;
                }
            }
        }
        counter*=2;

        int [] pairs = new int [counter];


        for(int i=0;i<payments.length;i++)
        {
            for(int j=0;j<payments.length;j++)
            {
                if ((payments[i]+payments[j])==target_sum)
                {
                    pairs[index]=payments[i];
                    index++;
                    pairs[index]=payments[j];
                    index++;
                }
            }
        }
        System.out.print("Valid Pairs : ");
        for (int i =0 ; i<(pairs.length-1);i++)
        {
            System.out.printf("(%d , %d), ",pairs[i],pairs[i+1]);
            i++;
        }

    }
    
}
