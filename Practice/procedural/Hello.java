import java.util.Scanner;
public class Hello {

    public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your name ! ");
        String name = sc.nextLine();
        System.out.print("Tell your age as well ! ");
        int age = sc.nextInt();
        System.out.printf("Hello %s ! You are %d years old :)",name,age);
    }
}