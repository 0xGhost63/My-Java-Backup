enum Level 
{
    LOW, MEDIUM, HIGH
}
public class Test_Enum 
{
    public static void main(String[] args) 
    {

        for (Level l : Level.values()) 
        {
            System.out.print(l.ordinal()+ " ");
        }
    }
}
   
      
