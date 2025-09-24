import java.util.Scanner;
public class W4T2
{
    public static void main(String[] args)
    {
        // Scanner object creation
        Scanner sc = new Scanner (System.in);

        // variables declaration
        int number_of_players;
        int highest_score=0;
        int second_highest=0;
        boolean isUnique=false;
        int counter =0;

        //Array Creation

        System.out.print("Enter the number of players : ");
        number_of_players=sc.nextInt();

        int [] scores = new int [number_of_players];

        System.out.print("Enter the scores : ");
        for (int i =0;i<scores.length;i++)
        {
            scores[i]=sc.nextInt();
        }

        // highest and second highest logic
        for (int score : scores) 
        {
            if (score > highest_score) 
            {
                second_highest = highest_score;
                highest_score = score;
            } 
            else if (score > second_highest && score < highest_score)
            {
                second_highest = score;
            }
        }

        // Validation Check !
        for (int i = 0; i < scores.length; i++) 
        {
            boolean duplicate = false;
            for (int j = 0; j < i; j++) 
            {
                if (scores[i] == scores[j]) 
                {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) 
            {
                counter++;
            }
        }

        if (counter >= 2)
        {
            isUnique = true;
        }
        else
        {
            isUnique = false;
        }

        if (isUnique)
        {
            System.out.printf("The second highest score is : %d\n" , second_highest);
        } 
        else
        {
            System.out.println("Not enough unique scores ! ");
        }

    }
}
