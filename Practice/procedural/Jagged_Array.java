import java.util.Scanner;
public class Jagged_Array 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Jagged array creation
        int [][] array = new int[3][];
        array[0] = new int[2];
        array[1] = new int[3];
        array[2] = new int[4];

        // Input handling
        System.out.println("Enter the elements: ");
        for (int row = 0; row < array.length; row++)  // single loop for all rows
        {
            for (int col = 0; col < array[row].length; col++)
            {
                array[row][col] = sc.nextInt();
            } 
        }

        // Print jagged array
        System.out.println("The jagged array is:");
        for (int row = 0; row < array.length; row++)
        {
            for (int col = 0; col < array[row].length; col++)
            {
                System.out.printf("%d   ", array[row][col]);
            }
            System.out.println();
        }
    }
}
