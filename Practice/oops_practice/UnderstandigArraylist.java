import java.util.ArrayList;
import java.util.Scanner;


public class UnderstandigArraylist
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // int [] arr = new int [2];

        ArrayList <Integer> al = new ArrayList<>();


        System.out.println("Inputs");

        int number =0;

        while (number>=0) 
        {
            number =0;

            System.out.print("Enter an element : ");
            number=sc.nextInt();
            al.add(number);

        }

        System.out.println("\nThe elements of the arraylist are :");

        for (int i=0;i<al.size();i++)
        {
            System.out.print(al.get(i)+" ");
        }

        int choice =0;
        System.out.println("\nWhich number would you like to remove ? ");
        choice=sc.nextInt();

        
        al.remove(choice);

        System.out.println("The arraylist after removing is :");


        for (int i=0;i<al.size();i++)
        {
            System.out.print(al.get(i)+" ");
        }

        System.out.println("\nWhich number would you like to add ? ");
        int add = sc.nextInt();
        System.out.println("At which index ?");
        int index=sc.nextInt();

        al.set(index,add); // change to set and add according to need


        System.out.println("The arraylist after setting a number is :");


        for (int i=0;i<al.size();i++)
        {
            System.out.print(al.get(i)+" ");
        }


        System.out.println();

        
    }    
}
