import java.util.Scanner;
public class W4T3
{
    public static void main(String[] args) 
    {
        // Scanner Object Creation !
        Scanner sc = new Scanner(System.in);
        // Variables Declaration 
        int days; // variable for declaring the primary array !
        int rotation;
        int threshold;
        int count = 0; // variable for counting above threshold

        System.out.println("\nWelcome :)");        
        System.out.print("Enter the number of days : ");
        days = sc.nextInt();

        int[] temps = new int[days]; // Array Creation
        System.out.print("Enter the temperatures : ");
        for(int i = 0; i < temps.length; i++)
        {
            temps[i] = sc.nextInt();
        }

        System.out.print("Enter the rotation count : ");
        rotation = sc.nextInt();
        System.out.print("Enter the threshold temperature : ");
        threshold = sc.nextInt();

        System.out.print("Original Array : ");
        for(int i = 0; i < temps.length; i++)
        {
            System.out.print(temps[i] + " ");
        }
        System.out.println();

        // Rotated Array
        int[] rotated = new int[days];
        for(int i = 0; i < temps.length; i++)
        {
            rotated[(i + rotation) % days] = temps[i];
        }

        System.out.print("Rotated Array : ");
        for(int i = 0; i < rotated.length; i++)
        {
            System.out.print(rotated[i] + " ");
        }
        System.out.println();

        System.out.println("Temperatures above threshold after rotation:");
        for(int i = 0; i < rotated.length; i++)
        {
            if(rotated[i] > threshold)
            {
                System.out.print(rotated[i] + " ");
                count++;
            }
        }
        System.out.println();

        System.out.println("Count above threshold = " + count);
    }
}
