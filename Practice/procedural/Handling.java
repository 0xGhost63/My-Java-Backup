public class Handling {
    public static void main(String[] args) {
        
        try 
        {
            int a = 10;
            int b = 0;
            int c = a / b;          // Risky line (exception)
            System.out.println(c);

        } 
        catch (Exception e) 
        {
            System.out.println("Division by zero is not allowed!");
        }

        System.out.println("My name is !!!");

    }
}
