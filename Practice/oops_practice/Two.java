import java.util.Scanner;
public class Two 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int [][] array = new int[3][];
        


        // array [0][0]
        /* 1 2 3 4 
         * 1 2 3 4 
         * 1 2 3 4 
         * 1 2 3 4
         */
        array [0] = new int  [2];
        array [1] = new int  [3];
        array [2] = new int  [4];

        System.out.println("Input ");


        for (int row =0;row<array.length;row++)
        {
            for(int col =0;col<array[row].length;col++)
            {
                System.out.printf("Enter the element : ");
                array[row][col]=sc.nextInt();
            }

        }

        System.out.println("Output");

        for (int [] a : array)
        {
            for(int  b : a)
            {
                System.out.print(b+" ");
            }
            
            System.out.println();
        }



    }    
}
