import  java.lang.Exception;
import java.util.Scanner;

class MyException extends Exception
{

    public MyException()
    {
        // System.out.println("Exception Occured !");
    }

    public MyException(String msg)
    {
        super(msg);
    }

}
public class CustomException 
{
    public static void main(String[] args) 
    {
        String word= "Hello Sannan !";
        Scanner sc = new Scanner (System.in);
        
        try 
        {
            System.out.print("Enter a word leave it Blank ");
            sc.next();
            if(word.isBlank())
            {
                throw new MyException("Blank Word !");
            }
            else
            {
                System.out.println("You Entered a word :) ");
                System.out.println("Take this : ");
                throw new MyException();
            }
        }
        //InvalidArgumentException
        catch (MyException | IllegalArgumentException e) 
        {
            System.out.println("Error : "+e.getMessage());
        }
    }   
}
