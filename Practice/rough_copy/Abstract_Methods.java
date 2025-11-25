class Parent

{
    int number;

    Parent(int number)
    {
        this.number=number;
    }

}
class Child extends Parent
{
    int second_number;
    Child(int number,int second_number)
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
        Parent a1 = new Child(63,21);
        // Parent t=new Child(63);
        // Child a1 = new Child(63);
        // t=a1;
    }
}