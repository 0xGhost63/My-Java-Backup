import java.util.Scanner;
public class Array 
{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Hello world");

        // 1-d Array

        int [] Unintialized= new int [4];

        int [] one_d = {1,2,3,4,5};

        // for ( int a : one_d)
        // {
        //     System.out.print(a+" ");
        // }

        // System.out.println();
        // for (int i =0;i<one_d.length;i++)
        // {
        //     System.out.print(one_d[i]+" ");

        //     //1 2 3 4 5
        // }

        for (int i =0;i<Unintialized.length;i++)
        {
            System.out.printf("Enter the element : %d ",i+1);
            Unintialized[i]=sc.nextInt();
        }

        System.out.println("/nThe values you enteres are : ");
        for (int a : Unintialized)
        {
            System.out.print(a+" ");
        }
        System.out.println();


    }    
}
