class A 
{
    static 
    {
        System.out.println("Static");
    }   
    A(int x)
    {
        System.out.println("A-Constructor"+x);
    }
}
class B extends A
{

    B(int x)
    {
        super(x);
        System.out.println("B ");
    }
}


public class Question 
{
    public static void main(String[] args) 
    {
        A abc = new B (5);
    }    
}
