public class Exception_Handling 
{
    public static void main(String[] args) 
    {
        System.out.println("Hello World");    
        try 
        {
            int result;

            result=10/0;
            
        }
        catch (ArithmeticException  e)
        {
            System.err.println("Error : "+e.getMessage());
        }
        finally
        {
            System.out.println("Here we go again !");
        }
        System.out.println("Out of finally block ! ");
    }    
}
