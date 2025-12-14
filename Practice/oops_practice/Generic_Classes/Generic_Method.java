public class Generic_Method
{

    public static  <T> T showValue(T value)
    {       
        System.out.printf("Value : %s\n",value);
        return value; 
    }
    public static void main(String[] args) 
    {
        String value=showValue("Hehe");
        showValue(value);
        showValue(10);

    }    
}
