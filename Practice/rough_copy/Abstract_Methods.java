class Test 

{
    int number;

    Test(int number)
    {
        this.number=number;
    }

}
class abu extends Test
{
    int second_number;
    abu(int number,int second_number)
    {
        super(number);
        this.second_number=second_number;
        System.out.println("Chal gya");
    }

}
public class Abstract_Methods
{
    public static void main(String [] args)
    {
        abu a1 = new Test(63);
        // Test t=new abu(63);
        // abu a1 = new abu(63);
        // t=a1;
    }
}