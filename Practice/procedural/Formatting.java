
// Trying to format the Strings by using the Plus Sign (+)---> concardation
//By this method i can use both a variable and a statement in a single sout
import java.util.Scanner;

public class Formatting {
    public static void main(String args[]) 
    {
        System.out.println("Hi 👋...enter a random number (<0 to Exit)");
        int attempts_made=0;
        while (true) 
        {
            
            Scanner sc = new Scanner(System.in);
            int my_numb = (int) (Math.random() * 100);
            int numb = sc.nextInt();
            if (numb<0)
            {
                System.out.println("Ciao 👋");
                break;
            }
            System.out.println("The number i thought of was : " + my_numb);
            System.out.println("The number you picked is : " + numb);

            // System.out.println("\nBy another method...\n\n");
            // other Method
            // System.out.printf("The number i thought of was : %d The number you picked is
            // : %d", my_numb, numb);
            // Extending the program :
            ++attempts_made;
            System.out.println("Attempts made : "+ attempts_made);
            if (my_numb == numb) {
                System.out.println("Bingo ! You got it right 💥💥💥" );
            } else if (my_numb > numb) {
                System.out.println("I went a bit high this time 🚬 ");
            } else {
                System.out.println("You are lower than me 👎");
            }

        }

    }

}
