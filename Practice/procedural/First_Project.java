import java.util.Scanner;

public class First_Project
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many subjects do you have? ");
        int subjects = sc.nextInt();

        int[] marks = new int[subjects]; 
        int sum = 0;

        for (int i = 0; i < subjects; i++)
        {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            sum += marks[i];

        }


        float avg_percentage = (float) sum / subjects;

        System.out.println("\n===== Results =====");
        System.out.println("Total Marks: " + sum);
        System.out.println("Average: " + avg_percentage);

        if (avg_percentage >= 90)
            System.out.println("Your grade is 'A'");
        else if (avg_percentage >= 75)
            System.out.println("Your grade is 'B'");
        else if (avg_percentage >= 60)
            System.out.println("Your grade is 'C'");
        else if (avg_percentage >= 40)
            System.out.println("Your grade is 'D'");
        else
            System.out.println("You are failed!");
        sc.close();
    }
    
}
