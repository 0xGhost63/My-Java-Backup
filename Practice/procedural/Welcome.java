public class Welcome
{
    public static void main(String[] args) throws InterruptedException
    {
        String[] symbol = {"__", "|", "/", "__|", "\\"};

        System.out.print("Welcome "); 

        for(int i = 0; i < 20; i++) 
        {
            System.out.print("\rWelcome " + symbol[i % symbol.length]); 
            Thread.sleep(500); 
        }

        System.out.println("\nHehe, Bye!");
    }
}
