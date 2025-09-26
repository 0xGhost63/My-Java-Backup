//  SIMPLE METHOD TO CREATE 2-D ARRAY !
import java.util.Scanner;
public class Two_D
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int [][] array = new int[2][2];
        System.out.print("Enter the elements : ");
        for(int row=0;row<array.length;row++)
        {
            for (int col=0;col<array[row].length;col++)
            {
                array[row][col]=sc.nextInt();
            }
        }

        for(int row=0;row<array.length;row++)
        {
            for (int col=0;col<array[row].length;col++)
            {
                System.out.printf("%d  ",array[row][col]);
            }
            System.out.println("");
        }   
    }    
}
