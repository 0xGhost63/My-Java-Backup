import java.util.Random;
public class RandomNumbers 
{
    public static void main(String[] args)
    {
        Random randomNumbers = new Random();    

        System.out.print("Ten random numbers are : ");
        for (int i = 0;i<10;i++)
        {
            System.out.printf("%d   ",(1+randomNumbers.nextInt(10))); //1-10 random numbers
        }
        System.out.println();
    }
}