import java.util.Scanner;
public class ArrayInitizalization {
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);

        int [] array1=new int [3];

        int [] array2 = {1,2,3};

        System.out.print("Enter 3 elements : ");
        for(int i = 0;i<array1.length;i++)
        {
            array1[i]=sc.nextInt();
        }

        System.out.print("Array 1 (input method) : ");
        for (int element : array1)
        {
            System.out.print(element);
            System.out.print(" ");

            
        }

        System.out.print("\nArray 2(initialization method) : ");
        for (int element : array2)
        {
            System.out.print(element);
            System.out.print(" ");

            
        }
        
    }
}
